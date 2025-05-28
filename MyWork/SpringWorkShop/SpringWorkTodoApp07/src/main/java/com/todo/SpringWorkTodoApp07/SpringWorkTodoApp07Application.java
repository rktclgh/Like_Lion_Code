package com.todo.SpringWorkTodoApp07;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.todo.app.mapper")
@SpringBootApplication(scanBasePackages = "com.todo")

public class SpringWorkTodoApp07Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWorkTodoApp07Application.class, args);
	}



}
