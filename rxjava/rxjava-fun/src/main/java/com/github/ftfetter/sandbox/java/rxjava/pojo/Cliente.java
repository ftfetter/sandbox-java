package com.github.ftfetter.sandbox.java.rxjava.pojo;

import java.util.List;

public class Cliente {
    private Long id;
    private String name;
    private List<Item> compras;

    public Cliente(Long id, String name, List<Item> compras) {
        this.id = id;
        this.name = name;
        this.compras = compras;
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
        return compras;
    }

    public void setCompras(List<Item> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", compras=" + compras +
                '}';
    }
}
