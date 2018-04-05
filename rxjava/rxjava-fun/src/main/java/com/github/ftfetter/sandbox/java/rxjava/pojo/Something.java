package com.github.ftfetter.sandbox.java.rxjava.pojo;

public class Something {
    private long id;
    private String name;

    public Something(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Something{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
