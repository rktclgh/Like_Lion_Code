package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03MTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans03.xml");


		Person g7 = (Person)ctx.getBean("g7");
		System.out.println("**** 강사 수업 시작 ****");
		g7.classWork();

		Person student = (Person)ctx.getBean("student");
		System.out.println("======================================");
		System.out.println("**** 학생 수업 시작 ****");
		student.classWork();
	}

}
