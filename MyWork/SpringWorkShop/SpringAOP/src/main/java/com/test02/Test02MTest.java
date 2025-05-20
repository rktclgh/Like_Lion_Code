package com.test02;

import com.test01.G7_Class;
import com.test01.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02MTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans02.xml");


		Person g7 = (Person)ctx.getBean("g7");
		System.out.println("**** 강사 출석 ****");
		g7.classWork();

		Person student = (Person)ctx.getBean("student");
		System.out.println("======================================");
		System.out.println("**** 학생 출석 ****");
		student.classWork();
	}

}
