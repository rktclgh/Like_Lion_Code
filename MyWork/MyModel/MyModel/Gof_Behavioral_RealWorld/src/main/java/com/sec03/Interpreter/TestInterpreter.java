package com.sec03.Interpreter;

interface Expression {
    boolean interpret(String context);
}

class TerminalExpression implements Expression {
    private String data;
    public TerminalExpression(String data) { this.data = data; }
    public boolean interpret(String context) {
        return context.contains(data);
    }
}

public class TestInterpreter {
    public static void main(String[] args) {
        Expression isJava = new TerminalExpression("Java");
        System.out.println("Is Java? " + isJava.interpret("Java Developer"));
    }
}
