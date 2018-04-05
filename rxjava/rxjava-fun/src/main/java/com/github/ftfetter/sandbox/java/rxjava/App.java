package com.github.ftfetter.sandbox.java.rxjava;

import com.github.ftfetter.sandbox.java.rxjava.pojo.Pagination;
import com.github.ftfetter.sandbox.java.rxjava.pojo.Something;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        getAllSomething(1).subscribe(
                (something) -> System.out.println("A cada sucesso, executa essa linha: " + something.toString()),
                (error) -> System.out.println("Em caso de exceção, executa essa linha: " + error.getMessage()),
                () -> System.out.println("Essa sempre será executada no final do processo em caso de sucesso."));

        System.out.println(getAllSomething2(1).toString());
    }

    private static Observable<Something> getAllSomething(int page) {
        Pagination pagination = getPagination(page);
        if (pagination.isHasNextPage())
            return Observable.from(pagination.getContent()).concatWith(getAllSomething(pagination.getNextPage()));
        else
            return Observable.from(pagination.getContent());
    }

    private static List<Something> getAllSomething2(int page) {
        List<Something> somethingList = new ArrayList<>();
        Observable.just(getPagination(page))
                .subscribe(
                        (pagination) -> {
                            somethingList.addAll(pagination.getContent());
                            if (pagination.isHasNextPage())
                                somethingList.addAll(getAllSomething2(pagination.getNextPage()));},
                        (error) -> System.out.println(error.toString()));
        return somethingList;
    }

    private static Pagination<Something> getPagination(int page) {
        Pagination<Something> pagination = new Pagination(3);
        if (page == 1) {
            pagination.setContent(getContentByPage(page));
            pagination.setNextPage(2);
            pagination.setHasNextPage(true);
        }
        if (page == 2) {
            pagination.setContent(getContentByPage(page));
            pagination.setNextPage(3);
            pagination.setHasNextPage(true);
        }
        if (page == 3) {
            pagination.setContent(getContentByPage(page));
            pagination.setNextPage(null);
            pagination.setHasNextPage(false);
        }
        return pagination;
    }

    private static List<Something> getContentByPage(int page) {
        List<Something> content = new ArrayList<>();
        if (page == 1) {
            content.add(new Something(1, "one"));
            content.add(new Something(2, "two"));
            content.add(new Something(3, "three"));
            content.add(new Something(4, "four"));
        }
        if (page == 2) {
            content.add(new Something(5, "five"));
            content.add(new Something(6, "six"));
            content.add(new Something(7, "seven"));
            content.add(new Something(8, "eight"));
        }
        if (page == 3) {
            content.add(new Something(9, "nine"));
            content.add(new Something(10, "ten"));
        }
        return content;
    }
}
