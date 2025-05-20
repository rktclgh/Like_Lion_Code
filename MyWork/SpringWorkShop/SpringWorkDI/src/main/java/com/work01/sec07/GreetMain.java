package com.work01.sec07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Greet greet = (Greet) context.getBean("morningGreet7");
        System.out.println(greet.greeting());
    }
}
