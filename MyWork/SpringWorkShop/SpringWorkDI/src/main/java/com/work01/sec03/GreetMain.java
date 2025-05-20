package com.work01.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        GreetService service = context.getBean("greetService", GreetService.class);
        service.sayHello();
    }
}
