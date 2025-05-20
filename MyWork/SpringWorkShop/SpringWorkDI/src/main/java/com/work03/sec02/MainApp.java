package com.work03.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);


        OrderService orderService = ctx.getBean(OrderService.class);
        String result = orderService.order(1, 20000);

        System.out.println(result);

    }
}
