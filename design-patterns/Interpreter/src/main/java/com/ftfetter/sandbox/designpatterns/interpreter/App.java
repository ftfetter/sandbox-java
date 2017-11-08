package com.ftfetter.sandbox.designpatterns.interpreter;

import com.ftfetter.sandbox.designpatterns.interpreter.expressions.*;

import java.util.Arrays;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        String tokenString = "4 7 + 4 * 2 -";
        Stack<Expression> stack = new Stack<>();

        String[] tokenList = tokenString.split(" ");
        Arrays.stream(tokenList).forEach(stringExpression -> {
            if (isOperator(stringExpression)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = getOperator(stringExpression, leftExpression, rightExpression);
                Expression resultExpression = new NumberExpression(operator.interpret());
                stack.push(resultExpression);
            } else {
                Expression numberExpression = new NumberExpression(stringExpression);
                stack.push(numberExpression);
            }
        });

        System.out.println("The expression is " + tokenString);
        System.out.println("The result of expression is " + stack.pop().interpret());
    }

    private static boolean isOperator(String expression) {
        return expression.equals("+") || expression.equals("-") || expression.equals("*");
    }

    private static Expression getOperator(String operator, Expression leftExpression, Expression rightExpression) {
        switch (operator) {
            case "+": return new PlusExpression(leftExpression, rightExpression);
            case "-": return new MinusExpression(leftExpression, rightExpression);
            case "*": return new MultiplyExpression(leftExpression, rightExpression);
            default: return new PlusExpression(leftExpression, rightExpression);
        }
    }
}
