package com.sec07.mytest;

//생성자 확인, 상속시 주소 영역 확인
public class MTest {
    public static void main(String[] args) {

       AA a1 =  new DD();// AA(), BB(), DD()
        BB b1 =  new DD();
        BB b2 =  new BB();
        AA c1 =  new BB();

        System.out.println("============================");
    check_instance(b2);

    }

    public static void check_instance(AA obj)
    {
        if(obj instanceof DD)
        {
            System.out.println("객체는 DD클래스의 인스턴스이다. ");
        } else if (obj instanceof BB) {
            System.out.println("객체는 BB 클래스의 인스턴스이다");

        }
        else
        {
            System.out.println("객체는 AA 클래스의 인스턴스이다.");
        }
    }

}
