package com.sec09;

public class b_Test {

    public static void prn()
    {
        throw new ArithmeticException();
    }
    public static void prn01()
    {
        prn();
    }
    public static void prn02()
    {
        prn01();
    }

    public static void main(String[] args) {
        prn02();
    }

}
