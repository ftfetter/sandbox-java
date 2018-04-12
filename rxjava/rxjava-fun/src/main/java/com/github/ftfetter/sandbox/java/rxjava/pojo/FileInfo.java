package com.github.ftfetter.sandbox.java.rxjava.pojo;

public class FileInfo {
    private String id;
    private String type;
    private String name;
    private String value;
    private String idOwner;

    public FileInfo(String id, String type, String name, String value, String idOwner) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.value = value;
        this.idOwner = idOwner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(String idOwner) {
        this.idOwner = idOwner;
    }

    @Override
    public String toString() {
        return "Something{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", idOwner='" + idOwner + '\'' +
                '}';
    }
}
