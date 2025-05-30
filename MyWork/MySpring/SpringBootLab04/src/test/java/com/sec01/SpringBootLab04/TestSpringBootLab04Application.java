package com.sec01.SpringBootLab04;

import com.sec01.SpringBootLab04Application;
import org.springframework.boot.SpringApplication;

public class TestSpringBootLab04Application {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootLab04Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
