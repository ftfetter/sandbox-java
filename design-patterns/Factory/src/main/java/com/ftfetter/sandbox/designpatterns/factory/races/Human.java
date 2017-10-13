package com.ftfetter.sandbox.designpatterns.factory.races;

import com.ftfetter.sandbox.designpatterns.factory.classes.*;
import com.ftfetter.sandbox.designpatterns.factory.classes.Class;

public class Human implements Race {
    String race = "Human";

    @Override
    public Class getClass(String className) {
        switch (className) {
            case "Mage":
                return  new Mage(this.race);
            case "Warrior":
                return new Warrior(this.race);
            default:
                return new Peasant(this.race);
        }
    }
}
