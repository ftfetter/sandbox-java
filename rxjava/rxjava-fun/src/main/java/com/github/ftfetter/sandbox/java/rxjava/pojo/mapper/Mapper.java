package com.github.ftfetter.sandbox.java.rxjava.pojo.mapper;

import com.github.ftfetter.sandbox.java.rxjava.pojo.Client;
import com.github.ftfetter.sandbox.java.rxjava.pojo.Item;
import com.github.ftfetter.sandbox.java.rxjava.pojo.FileInfo;

import java.util.List;

public class Mapper {

    public static Item mapToItem(FileInfo fileInfo) {
        return new Item(Long.valueOf(fileInfo.getId()), fileInfo.getName(), Double.valueOf(fileInfo.getValue()), Long.valueOf(fileInfo.getIdOwner()));
    }

    public static Client mapToCliente(FileInfo fileInfo, List<Item> compras) {
        return new Client(Long.valueOf(fileInfo.getId()), fileInfo.getName(), compras);
    }
}
