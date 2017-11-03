package com.ftfetter.sandbox.designpatterns.builder.builder;

import com.ftfetter.sandbox.designpatterns.builder.pojo.MisterPotatoHead;
import com.ftfetter.sandbox.designpatterns.builder.parts.Eye;
import com.ftfetter.sandbox.designpatterns.builder.parts.Head;
import com.ftfetter.sandbox.designpatterns.builder.parts.Nose;

public class PotatoBuilder {

    private String name;
    private Head head;
    private Eye eyes;
    private Nose nose;

    public PotatoBuilder(String name) {
        this.name = name;
    }

    public PotatoBuilder withHead(Head head) {
        this.head = head;
        return this;
    }

    public PotatoBuilder withEyes(Eye eyes) {
        this.eyes = eyes;
        return this;
    }

    public PotatoBuilder withNose(Nose nose) {
        this.nose = nose;
        return this;
    }

    public MisterPotatoHead build() {
        return new MisterPotatoHead(this);
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
}
