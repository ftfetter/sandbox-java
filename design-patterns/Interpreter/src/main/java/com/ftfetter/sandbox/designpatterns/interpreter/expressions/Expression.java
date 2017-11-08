package com.ftfetter.sandbox.designpatterns.interpreter.expressions;

public interface Expression {

    int interpret();

    @Override
    String toString();
}
