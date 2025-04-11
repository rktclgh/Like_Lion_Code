package com.test;


//static final = 상수, abstract 메소드, default. static 메소드
//interface -> 생성자 없다,. new 할 수 없다, 다중 구현한다.
public interface IAA {
    int a= 10; //반드시 초기값 -> public static final int a  =10;
    public static final int b =20;
    void prn();
    public abstract void disp();

    default void view()
    {
        //재정의 가능
        System.out.println(a);
    }

    static void view02()
    {
        System.out.println(a);
    }


}
