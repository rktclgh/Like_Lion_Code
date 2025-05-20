package com.person.controller;

import com.person.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;


public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonController controller = ctx.getBean(PersonController.class);

		controller.run();
		((AbstractApplicationContext)ctx).close();
	}

}
