package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application02.xml");
        MessagePrinter res = context.getBean(MessagePrinter.class);

    }
}
