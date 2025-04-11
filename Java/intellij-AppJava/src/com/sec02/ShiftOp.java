package com.sec02;


//데이터 압축 및 메모리 최적화 : shift 연산을 사용하면 여러개의 작은 값을 하나의 정수형 변수에 저장 후 사용

public class ShiftOp {

	public static void main(String[] args) {

		// Q1. RGB 색상 값을 하나의 int로 저장
		int r = 255, g = 128, b = 64;
		int rgb = (r<<16) | (g<<8) | b;
		System.out.println(Integer.toBinaryString(rgb)); //rgb 값이 32bit 정수로 변환 문자열리턴

		//Q2. XOR -> 간단한 암호화 복호화
		////////




		///////

		int x = 100;
		// x를 5비트 오른쪽으로 시프트 , 왼쪽 비트를 0으로 채움
		System.out.println(" x >> 5 value  = " + (x >> 5));

		int x1 = -100;

		// x를 5비트 오른쪽으로 시프트 , 왼쪽 비트를 1로 채움
		System.out.println(" x1 >> 5   value  = " + (x1 >> 5));

		// x를 5비트 오른쪽으로 시프트 ,왼쪽 비트를 0으로 채움
		System.out.println(" x1 >>> 5 value  = " + (x1 >>> 5));

	}

}
