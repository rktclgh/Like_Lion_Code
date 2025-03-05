package com.sec01.exam;
/*
 * 
 * 사칙연산을 하고싶다.
 * 조건 1: 단 div 결과는 double로 하고 싶다.
 * 조건 2: 수행결과를 calc()로 구현해서 호출하자 e_exam.calc()
 * 
 *   100 + 200 = hap
 *   200 - 100 = sub
 *   100 * 200 = mul
 *   200 / 100 = div
 *  선업, 값대입, 연산, 출
 * 
 * 
 * 
 * */
public class e_exam {

	public static void calc() {

		
		int a, b, hap, sub, mul;
		double div;
		//값대입
		a =100;
		b= 200;
		hap = sub = mul = 0;
		div = 0.0;
		//연산
		hap = a+b;
		sub = b-a;
		mul = a*b;
		div = b/a;
		
		//출력 100 +200 = hap
		System.out.println(a +"+ "+b+" ="+hap);
		System.out.println(a +"- "+b+" ="+sub);
		System.out.println(a +"* "+b+" ="+mul);
		System.out.println(a +"/ "+b+" ="+div);
		System.out.println("e_exam");
		
		
	}
	
	
public static void calc02() {

		
		int a, b, hap, sub, mul;
		double div;
		//값대입
		a =100;
		b= 200;
		hap = sub = mul = 0;
		div = 0.0;
		//연산
		hap = a+b;
		sub = b-a;
		mul = a*b;
		div = b/a;
		
		//출력 100 +200 = hap
	System.out.printf("%5d + %5d = %5d \n",a,b,hap);
	System.out.printf("%5d - %5d = %5d \n",a,b,sub);
	System.out.printf("%5d * %5d = %5d \n",a,b,mul);
	System.out.printf("%5d / %5d = %.2f \n",b,a,div);

		
		
	}
	
	
	public static void main(String[] args) {
//		calc();
		calc02();
	}
	

}
