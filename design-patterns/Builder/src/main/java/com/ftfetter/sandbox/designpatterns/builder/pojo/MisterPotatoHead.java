package com.ftfetter.sandbox.designpatterns.builder.pojo;

import com.ftfetter.sandbox.designpatterns.builder.builder.PotatoBuilder;
import com.ftfetter.sandbox.designpatterns.builder.parts.Eye;
import com.ftfetter.sandbox.designpatterns.builder.parts.Head;
import com.ftfetter.sandbox.designpatterns.builder.parts.Nose;

public class MisterPotatoHead {

    private String name;
    private Head head;
    private Eye eyes;
    private Nose nose;

    public MisterPotatoHead(PotatoBuilder builder) {
        this.name = builder.getName();
        this.head = builder.getHead();
        this.eyes = builder.getEyes();
        this.nose = builder.getNose();
    }

    public String getName() {
        return name;
    }

    public Head getHead() {
        return head;
    }

    public Eye getEyes() {
        return eyes;
    }

    public Nose getNose() {
        return nose;
    }

    @Override
    public String toString() {
        String story = "There is a Mr. PotatoHead called " + name + ".\n";
        if (head != null) story += "He's wearing a beutiful " + head.getHead() + ".\nHe woke up and";
        else story += "He has a rounded bald head.\nHe woke up and";
        if (eyes != null) story += " put his favorite " + eyes.getEye() + " eyes.\nThat's a wonderful sunny day outside and he decides to go to the park.\n";
        else story += ".. Oh, how silly! HE FORGOT TO PUT HIS EYES ON!\nFeeling so stupid, he wants to kill himself.\n";
        if (nose != null) story += "He's smelling flowers with his " + nose.getNose() + " nose and this makes he feels good.";
        else story += "He can't smell nothing around because he FORGOT HIS NOSE! OMG how stupid!\nHe wants to die.";

        return story;
    }
}
