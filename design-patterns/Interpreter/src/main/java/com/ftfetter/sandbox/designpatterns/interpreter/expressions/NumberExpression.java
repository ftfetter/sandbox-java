package com.ftfetter.sandbox.designpatterns.interpreter.expressions;

public class NumberExpression implements Expression{

    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public NumberExpression(String numberString) {
        this.number = Integer.parseInt(numberString);
    }

    @Override
    public int interpret() {
        return number;
    }

    @Override
    public String toString() {
        return "number";
    }
}
