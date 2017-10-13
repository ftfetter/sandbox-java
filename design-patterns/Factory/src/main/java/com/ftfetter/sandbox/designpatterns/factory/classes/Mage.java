package com.ftfetter.sandbox.designpatterns.factory.classes;

public class Mage implements Class {
    String race;

    public Mage(String race) {
        this.race = race;
    }

    @Override
    public void attack() {
        System.out.println("Casting spells");
    }

    @Override
    public void whoAmI() {
        System.out.println(String.format("I am a %s Mage", this.race));
    }
}
