package com.sec03;

public class MyClass {

    private int a;

    public MyClass()
    {
        System.out.println("나 기본 생성자야   "+ this.a);
    }
    public MyClass(int a)
    {
        this.a = a;
        System.out.println("오버로드 생성자   "+this.a);
    }


    public static void main(String[] args) {
//        System.out.println(new b_MyClass());

        MyClass m = new MyClass();
        MyClass m1 = new MyClass(1);




    }
}
