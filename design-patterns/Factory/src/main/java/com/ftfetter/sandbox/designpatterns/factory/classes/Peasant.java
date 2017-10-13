package com.ftfetter.sandbox.designpatterns.factory.classes;

public class Peasant implements Class {
    String race;

    public Peasant(String race) {
        this.race = race;
    }

    @Override
    public void attack() {
        System.out.println("Bending the knees");
    }

    @Override
    public void whoAmI() {
        System.out.println(String.format("I am a %s Peasant", this.race));
    }
}
