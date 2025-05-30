package com.sec01.SprinWorkShop09;

import com.sec01.SprinWorkShop09Application;
import org.springframework.boot.SpringApplication;

public class TestSprinWorkShop09Application {

	public static void main(String[] args) {
		SpringApplication.from(SprinWorkShop09Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
