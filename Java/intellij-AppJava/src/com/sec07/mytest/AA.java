package com.sec07.mytest;

public class AA {

    public AA() {
        System.out.println("A기본생성자");
    }

    public AA(int a, int b) {
        this.a = a;
        this.b = b;
    }

    private int a;
    private int b;


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getHap(int a, int b)
    {
        return a+b;
    }
    public int getHap()
    {
        return a+b;
    }
}
