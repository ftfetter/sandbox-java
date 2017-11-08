package com.ftfetter.sandbox.designpatterns.interpreter.expressions;

public class MultiplyExpression implements Expression{

    private Expression leftExpression;
    private Expression rightExpression;

    public MultiplyExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }

    @Override
    public String toString() {
        return "*";
    }
}
