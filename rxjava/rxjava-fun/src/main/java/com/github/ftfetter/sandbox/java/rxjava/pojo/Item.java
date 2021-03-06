package com.github.ftfetter.sandbox.java.rxjava.pojo;

public class Item {

    private Long id;
    private String name;
    private Double value;
    private Long idOwner;

    public Item(Long id, String name, Double value, Long idOwner) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.idOwner = idOwner;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Long idOwner) {
        this.idOwner = idOwner;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", idOwner=" + idOwner +
                '}';
    }
}
