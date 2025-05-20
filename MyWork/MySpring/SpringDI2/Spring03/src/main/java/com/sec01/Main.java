package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("app01.groovy");
        AddressInfo info = ctx.getBean("info", AddressInfo.class);
        info.printInfo();
    }
}
