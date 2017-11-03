package com.ftfetter.sandbox.designpatterns.builder;

import com.ftfetter.sandbox.designpatterns.builder.builder.PotatoBuilder;
import com.ftfetter.sandbox.designpatterns.builder.parts.Eye;
import com.ftfetter.sandbox.designpatterns.builder.parts.Head;
import com.ftfetter.sandbox.designpatterns.builder.parts.Nose;
import com.ftfetter.sandbox.designpatterns.builder.pojo.MisterPotatoHead;

public class App {

    public static void main(String[] args) {

        MisterPotatoHead misterPotatoHead = new PotatoBuilder("Xablau")
                                                    .withHead(Head.FEDORA_HAT)
                                                    .withEyes(Eye.CYCLOPS)
                                                    .withNose(Nose.ROUNDED)
                                                    .build();
        System.out.println(misterPotatoHead.toString());
    }
}
