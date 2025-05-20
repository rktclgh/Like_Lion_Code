package com.work01.sec05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sec05")  // 이거 없으면 아무 것도 주입 안 됨
public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(GreetMain.class);
        GreetManager manager = context.getBean(GreetManager.class);
        manager.execute();
    }
}
