package com.sec03;

import java.util.Random;

public class MTest02 {


    public static void main(String[] args) {
//        Integer i = new Integer(100);
        Integer i = 100;
        System.out.println(i.doubleValue());
        Integer i2 = new Integer(100);
        System.out.println(i2.doubleValue());


        String str = "abcdefg";// String str = new String("abcdefg)l// str 이라는 객체를 생성했다.


        System.out.println("길이 = "+ str.length());
        System.out.println("전체 대문자 = "+str.toUpperCase());


        String res =str.toUpperCase();
        System.out.println(" 출력: "+res +" -> 소문자로: "+ res.toLowerCase());

        //java.util.Random 클래스가 있다. 빈 객체를 생성하고 0~100까지 난수 생성하는 메소드 호출해서 출력 해보자
        //1. 생성자 확인 -> 2. nextInt(int)를 활용해 보자.
        Random r = new Random();
        int rand = r.nextInt( 101);
        System.out.println(rand);

        Random r2 = new Random();
        System.out.println(r2.nextInt(101));

        int r3 = (int)(Math.random()*101);
        System.out.println(r3);


    }
}
