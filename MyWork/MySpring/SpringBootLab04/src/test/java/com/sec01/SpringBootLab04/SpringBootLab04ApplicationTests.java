package com.sec01.SpringBootLab04;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SpringBootLab04ApplicationTests {

	@Test
	void contextLoads() {
	}

}
