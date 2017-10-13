package com.ftfetter.sandbox.designpatterns.factory.classes;

public class Ranger implements Class {
    String race;

    public Ranger(String race) {
        this.race = race;
    }

    @Override
    public void attack() {
        System.out.println("Shooting arrows");
    }

    @Override
    public void whoAmI() {
        System.out.println(String.format("I am a %s Ranger", this.race));
    }
}
