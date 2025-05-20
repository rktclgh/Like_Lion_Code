package com.work01.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Greet greet = context.getBean("morningGreet", Greet.class);
        System.out.println(greet.greeting());

    }
}
