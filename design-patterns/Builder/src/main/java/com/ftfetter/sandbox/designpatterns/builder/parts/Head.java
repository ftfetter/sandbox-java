package com.ftfetter.sandbox.designpatterns.builder.parts;

public enum Head {
    HAIR, COWBOY_HAT, BANDANA, FEDORA_HAT;

    public String getHead(){
        return name().toLowerCase();
    }
}
