package com.sec01;


import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {



    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application01.xml");
        MyAddress res =(MyAddress) context.getBean ("myaddress"); // context. getBean ("mya
        System.out. println(res);
        System.out.println(res.toString());


        res = context.getBean ("myaddress02", MyAddress.class); // context. getBean ("myaddres
        System.out.println(res);
        System.out.println(res.toString());

    }
}