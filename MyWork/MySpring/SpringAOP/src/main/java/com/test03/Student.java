package com.test03;

import org.springframework.stereotype.Component;

@Component
public class Student implements Person {
	public void classWork() {
		System.out.println("[학생] 큐알입실 완료, 수업 참여 중입니다.");
		System.out.println("[학생] 집중하여 학습합니다.");
	}


}
