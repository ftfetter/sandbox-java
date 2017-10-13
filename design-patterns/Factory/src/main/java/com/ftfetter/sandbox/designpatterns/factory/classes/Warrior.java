package com.ftfetter.sandbox.designpatterns.factory.classes;

public class Warrior implements Class {
    String race;

    public Warrior(String race) {
        this.race = race;
    }

    @Override
    public void attack() {
        System.out.println("Swinging a sword");
    }

    @Override
    public void whoAmI() {
        System.out.println(String.format("I am a %s Warrior", this.race));
    }
}
