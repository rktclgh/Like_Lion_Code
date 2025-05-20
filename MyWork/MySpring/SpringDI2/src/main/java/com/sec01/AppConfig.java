//package com.sec01;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//
//	@Bean
//	public MyAddress myaddress() {
//		return new MyAddress("박길동");
//	}
//
//	@Bean
//	public MyAddress myaddress02() {
//		return new MyAddress("정길동", "제주도");
//	}
//
//	@Bean
//	public MyAddress myaddress03() {
//		return new MyAddress("최길동", "부산", "051-000-0000");
//	}
//
//	@Bean
//	AddressInfo info() {
//		AddressInfo info = new AddressInfo();
//		info.setAddress(myaddress03()); // 의존성 주입
//		info.setAge(100);
//		return info;
//	}
//}
