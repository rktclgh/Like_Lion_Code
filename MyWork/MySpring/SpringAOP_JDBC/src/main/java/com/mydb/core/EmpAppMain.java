package com.mydb.core;

import java.util.List;
import java.awt.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpAppMain {
	public static void main(String[] args) {
		var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EmpService service = ctx.getBean(EmpService.class);
		//service.getAll().forEach(System.out::println);

//		List<Emp> emps = service.getAll();
//		// AOP 종료됨 → 여기서 After 출력 끝
//
//		// 이제 결과 출력 (AOP와 무관한 일반 출력)
//		for (Emp e : emps) {
//			System.out.println(e);
//		}

		try {
			Emp newEmp = new Emp(0000, "Test", "test", 10);
			service.insertEmpwithFail(newEmp);

		} catch (Exception e) {
			System.out.println("예외발생!: "+ e.getMessage());
		}

		System.out.println("===========================");
		service.getAll().forEach(System.out::println);
	}
}
