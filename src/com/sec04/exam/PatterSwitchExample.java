package com.sec04.exam;

public class PatterSwitchExample {


    public static void main(String[] args) {

        Object obj = 98.1;
        switch (obj)
        {
            case Double d -> System.out.println("실수: "+ d);
            case Integer i -> System.out.println("정수: "+i);
//            case Integer i when i>10 -> System.out.println("10보다 큰 정수: "+i);
            case String s -> System.out.println("문자열: "+s);
            case null -> System.out.println("null값이 입력됐습니다.");
            default -> System.out.println("기타 값: "+obj);
        }
    }
}
