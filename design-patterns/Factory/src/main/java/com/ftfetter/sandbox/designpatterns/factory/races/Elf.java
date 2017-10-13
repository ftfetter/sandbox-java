package com.ftfetter.sandbox.designpatterns.factory.races;

import com.ftfetter.sandbox.designpatterns.factory.classes.*;
import com.ftfetter.sandbox.designpatterns.factory.classes.Class;

public class Elf implements Race {
    String race = "Elf";

    @Override
    public Class getClass(String className) {
        switch (className) {
            case "Mage":
                return  new Mage(this.race);
            case "Ranger":
                return new Ranger(this.race);
            default:
                return new Peasant(this.race);
        }
    }
}
