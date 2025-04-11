package com.sec12.labmbda;

public class LambdaTest {


    @FunctionalInterface //함수형 인터페이스 체크
    interface Fun01
    {
        public String prn(String name); //매개인자 메소드\
    }


    interface Fun02
    {
        public String prn02();
    }

    interface Fun03
    {
        public void say(String name);
    }


    public static void main(String[] args) {
        Fun01 m_name = name ->"hello!" +name; //(name)을 생략
        System.out.println("n_name: " +m_name.prn("홍길동"));

        Fun02 m_test = () -> "테스트 ";//{}과 return 키워드 생략 return "테스트";
        System.out.println(m_test.prn02());

        Fun03 m_test03 = (name) -> System.out.println("hello! " +name);
        m_test03.say("정길동");
    }




}
