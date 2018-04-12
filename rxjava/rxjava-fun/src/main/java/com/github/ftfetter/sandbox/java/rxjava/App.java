package com.github.ftfetter.sandbox.java.rxjava;

import com.github.ftfetter.sandbox.java.rxjava.pojo.Something;
import io.reactivex.Flowable;
import io.reactivex.Observable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {

    //TODO mapear os objetos de acordo com o seu tipo (Cliente/Item) e gerar uma lista de Cliente com os seus itens
    public static void main(String[] args) throws FileNotFoundException {

        Observable.just(fileStream("src/main/resources/test.txt"))
                .flatMap(flowable -> Observable.just(splitToValues(flowable)))
                .flatMap(flowable -> Observable.just(convertToSomething(flowable)))
                .flatMap(flowable -> Observable.just(flowable.toList().blockingGet()))
                .subscribe(somethings -> somethings.forEach(something -> System.out.println(something.toString())));
    }

    private static Flowable<String> fileStream(String filePath) throws FileNotFoundException {
        return Flowable.using(
                () -> new BufferedReader(new FileReader(filePath)),
                reader -> Flowable.fromIterable(() -> reader.lines().iterator()),
                BufferedReader::close);
    }

    private static Flowable<String[]> splitToValues(Flowable<String> flowable) {
        return flowable.map(line -> line.split("\\|"));
    }

    private static Flowable<Something> convertToSomething(Flowable<String[]> flowable) {
        return flowable.map(lineValues -> {
            if (lineValues.length > 3) return new Something(lineValues[0], lineValues[1], lineValues[2], lineValues[3]);
            return new Something(lineValues[0], lineValues[1], lineValues[2], null);
        });
    }

//    private static List<Cliente> mapToListOfCliente(Flowable<Something> flowable) {
//        flowable.
//    }

//    private static List<Item> getCompras(Flowable<Something> flowable) {
//        List<Item> compras = new ArrayList<>();
//        flowable.map()
//    }
}
