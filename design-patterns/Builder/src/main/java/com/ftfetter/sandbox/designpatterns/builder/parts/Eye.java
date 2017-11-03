package com.ftfetter.sandbox.designpatterns.builder.parts;

public enum Eye {
    BIG, ANGER, LAZY, CYCLOPS;

    public String getEye() {
        return name().toLowerCase();
    }
}
