package com.sec01.exam;


// 각 리터럴에 맞는 값을 주면서 [자동형변환] 메소드 호출을 해보자
// 리터럴이 대입된 타입을 알려면 자바에서 어떻게 사용해?
// -래퍼클래스의 객체로 형변환 후 object 클래스가 가진 .getClass().getSimpleName()
public class g_exam {

	
	
	
	
	public static void prn01(long res) { //메소드 호출할 때 정수값을 받으면서 지역변수 생성해서 값대입 된다.
	
		System.out.println("정수 res = " + res);
		
	}
	public static void prn02(char res) { //메소드 호출할 때 정수값을 받으면서 지역변수 생성해서 값대입 된다.

		System.out.println("한문자 res = " + res);

	}
	public static void prn03(double res, int a) { //메소드 호출할 때 실수,정수값을 받으면서 지역변수 생성해서 값대입 된다.

		System.out.println("실수 res = " + res+ "정수 res = " + res);

	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prn01(100);//정수, int
		prn02('a');//한문자, char
		prn03(90.1, 100); // 실수, double 과 int 의 값을 전달하면서 호출
		prn03(100, 100);
		prn03(100, 'a'); //메소드 호출할 때 전달하는 값을 자동형변환 후 대입 및 실해
		//캐스팅 -> 변수에 값대입, 메스도의 값전달, 상속 객체 전달(자식의 객체를 주면 부모가 대입받는다 = i/o 클래스)
		// ex) public static void prn03(object c) {}

	}

}
