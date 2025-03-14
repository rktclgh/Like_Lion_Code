package com.sec12.labmbda;

public class LambdaTest02 {
    @FunctionalInterface
    interface Func{
        public int Calc(int a, int b);
    }

    public static void main(String[] args) {
        Func add = (int a, int b) ->
        {return a + b;};



        Func sub = (a,b) -> a - b;

        System.out.println(add.Calc(100,50));
        System.out.println(sub.Calc(100,50));
    }
}
