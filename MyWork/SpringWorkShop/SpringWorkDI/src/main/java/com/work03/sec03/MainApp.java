package com.work03.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("application.groovy");

        OrderService orderService = ctx.getBean(OrderService.class);
        String result = orderService.order(1, 10000);
        System.out.println(result);
    }
}
