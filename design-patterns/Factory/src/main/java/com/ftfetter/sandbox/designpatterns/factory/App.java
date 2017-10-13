package com.ftfetter.sandbox.designpatterns.factory;

import com.ftfetter.sandbox.designpatterns.factory.classes.Class;
import com.ftfetter.sandbox.designpatterns.factory.races.*;

public class App {

    public static void main(String[] args) {
        Race human = new Human();
        Race elf = new Elf();
        Race orc = new Orc();

        Class humanMage = human.getClass("Mage");
        Class elfRanger = elf.getClass("Ranger");
        Class orcishWarrior = orc.getClass("Warrior");

        humanMage.whoAmI();
        humanMage.attack();
        elfRanger.whoAmI();
        elfRanger.attack();
        orcishWarrior.whoAmI();
        orcishWarrior.attack();
    }
}
