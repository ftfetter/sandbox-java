package com.github.ftfetter.sandbox.java.rxjava.pojo;

import java.util.List;

public class Client {
    private Long id;
    private String name;
    private List<Item> cart;

    public Client(Long id, String name, List<Item> cart) {
        this.id = id;
        this.name = name;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getCompras() {
        return cart;
    }

    public void setCompras(List<Item> compras) {
        this.cart = compras;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cart=" + cart +
                '}';
    }
}
