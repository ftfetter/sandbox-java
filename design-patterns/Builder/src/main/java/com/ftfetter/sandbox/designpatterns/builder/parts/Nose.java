package com.ftfetter.sandbox.designpatterns.builder.parts;

public enum Nose {
    BIG, SMALL, ROUNDED, LARGE;

    public String getNose() {
        return name().toLowerCase();
    }
}
