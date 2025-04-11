package com.sec01.exam;
// 각 리터럴에 맞는걸 출력한다.
public class f_exam {




	public static void prn01(long res) { //메소드 호출할 때 정수값을 받으면서 지역변수 생성해서 값대입 된다.

		System.out.println("정수 res = " + res);

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prn01(100);//정수, 
		prn01('a');//한문자, char
		prn01((long)90.1); // 실수, double 는 [명시형변환] 후 호출한다/


	}
	

}
