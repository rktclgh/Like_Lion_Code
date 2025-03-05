package com.sec01.exam;

public class i_exam {

	public static int getA() {
		return 100;
	}

	public static char getCh() {
		return 'A';
	}

	public static double getDouble() {
		return 98.1;
	}

	public static void main(String[] args) {
		int a = getA(); // getA()라는 static 메소드는 100을 리턴했다
		System.out.println("a = " + a);
		System.out.println("a = " + getA());

		/// 'A'
		System.out.println(getCh());
		/// 98.1
		System.out.println(getDouble());

	}

}
