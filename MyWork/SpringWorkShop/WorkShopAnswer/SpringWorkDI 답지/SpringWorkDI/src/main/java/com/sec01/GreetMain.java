package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext01.xml");
        Greet greet = (Greet) ctx.getBean("morningGreet");
        System.out.println(greet.greeting());
    }
}