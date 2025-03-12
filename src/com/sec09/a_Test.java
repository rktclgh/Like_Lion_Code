package com.sec09;

public class a_Test {
    public static void main(String[] args) {
        int a = 100;
        int b = 0;
        int res = 0;
        try{
            res = a/b;
        }catch(ArithmeticException e){
            System.out.println("예외처리 했어");
        }

        System.out.printf("a = %5d b = %5d res = %5d \n", a,b,res);
    }
}
