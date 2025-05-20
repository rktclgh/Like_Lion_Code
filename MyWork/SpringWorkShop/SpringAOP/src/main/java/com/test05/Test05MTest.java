package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05MTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans05.xml");


		System.out.println("====================================");

		Student student = ctx.getBean("mystudent", Student.class);
		System.out.println("학생 수업 시작");
		student.classWork();
		student.homework();
	}

}
