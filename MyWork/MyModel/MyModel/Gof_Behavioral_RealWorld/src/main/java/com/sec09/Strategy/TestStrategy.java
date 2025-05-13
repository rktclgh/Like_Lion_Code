package com.sec09.Strategy;

interface Strategy {
    int operate(int a, int b);
}

class AddStrategy implements Strategy {
    public int operate(int a, int b) { return a + b; }
}

class Context {
    private Strategy strategy;
    public Context(Strategy strategy) { this.strategy = strategy; }
    public int execute(int a, int b) { return strategy.operate(a, b); }
}

public class TestStrategy {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println("Result: " + context.execute(3, 4));
    }
}
