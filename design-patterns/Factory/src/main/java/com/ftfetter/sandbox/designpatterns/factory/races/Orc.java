package com.ftfetter.sandbox.designpatterns.factory.races;

import com.ftfetter.sandbox.designpatterns.factory.classes.*;
import com.ftfetter.sandbox.designpatterns.factory.classes.Class;

public class Orc implements Race {
    String race = "Orcish";

    @Override
    public Class getClass(String className) {
        switch (className) {
            case "Ranger":
                return new Ranger(this.race);
            case "Warrior":
                return new Warrior(this.race);
            default:
                return new Peasant(this.race);
        }
    }
}
