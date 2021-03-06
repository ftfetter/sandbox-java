package com.github.ftfetter.sandbox.java.rxjava;

import com.github.ftfetter.sandbox.java.rxjava.pojo.Client;
import com.github.ftfetter.sandbox.java.rxjava.pojo.FileInfo;
import com.github.ftfetter.sandbox.java.rxjava.pojo.Invoice;
import com.github.ftfetter.sandbox.java.rxjava.pojo.Item;
import com.github.ftfetter.sandbox.java.rxjava.pojo.mapper.Mapper;
import io.reactivex.Flowable;
import io.reactivex.Observable;

import java.io.BufferedReader;
import java.util.List;

public class RxJavaFileReader {

    public static void main(String[] args) {
        Observable<Flowable<Client>> observable = convertFileToClients("src/main/resources/test.txt");

        System.out.println("All information translated from file:");
        observable.subscribe(clients -> clients.forEach(client -> System.out.println(client.toString())));

        System.out.println("\nCart value for each Cliente:");
        observable.flatMap(clients -> Observable.just(getInvoice(clients)))
                .subscribe(invoices -> invoices.forEach(invoice -> System.out.println(invoice.toString())));
    }

    private static Observable<Flowable<Client>> convertFileToClients(String filePath) {
        return Observable.just(fileStream(filePath))
                .flatMap(flowable -> Observable.just(splitToValues(flowable)))
                .flatMap(flowable -> Observable.just(convertToFileInfo(flowable)))
                .flatMap(flowable -> Observable.just(mapToClient(flowable)));
    }

    private static Flowable<String> fileStream(String filePath) {
        return Flowable.using(
                () -> new BufferedReader(new java.io.FileReader(filePath)),
                reader -> Flowable.fromIterable(() -> reader.lines().iterator()),
                BufferedReader::close);
    }

    private static Flowable<String[]> splitToValues(Flowable<String> flowable) {
        return flowable.map(line -> line.split("\\|"));
    }

    private static Flowable<FileInfo> convertToFileInfo(Flowable<String[]> flowable) {
        return flowable.map(lineValues -> (lineValues.length > 3)
                ? new FileInfo(lineValues[0], lineValues[1], lineValues[2], lineValues[3], lineValues[4])
                : new FileInfo(lineValues[0], lineValues[1], lineValues[2], null, null));
    }

    private static Flowable<Client> mapToClient(Flowable<FileInfo> flowable) {
        return flowable.filter(fileInfo -> fileInfo.getType().equalsIgnoreCase("CLIENTE"))
                .map(cliente -> Mapper.mapToClient(cliente, mapToCart(flowable, cliente.getId())));
    }

    private static List<Item> mapToCart(Flowable<FileInfo> flowable, String clientId) {
        return mapToItem(flowable).filter(item -> item.getIdOwner().equals(Long.valueOf(clientId)))
                .toList().blockingGet();
    }

    private static Flowable<Item> mapToItem(Flowable<FileInfo> flowable) {
        return flowable.filter(fileInfo -> fileInfo.getType().equalsIgnoreCase("ITEM"))
                .map(Mapper::mapToItem);
    }

    private static Flowable<Invoice> getInvoice(Flowable<Client> clients) {
        return clients.map(client -> new Invoice(client.getName(), getCartValue(client)));
    }

    private static Double getCartValue(Client client) {
        return client.getCompras().stream()
                .mapToDouble(Item::getValue)
                .reduce((val1, val2) -> val1 + val2)
                .orElse(0D);
    }
}
