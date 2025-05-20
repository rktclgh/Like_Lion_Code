package com.work01.sec06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sec06")
public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(GreetMain.class);
        GreetService service = context.getBean(GreetService.class);
        service.sayHello();
    }
}