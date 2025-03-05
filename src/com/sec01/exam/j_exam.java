package com.sec01.exam;
/*
 * 
 * 사칙연산을 하고싶다.
 *   100 + 200 = hap
 *   200 - 100 = 
 *   100 * 200 =
 *   200 / 100 = 
 * 
 * 
 * 
 * 
 * */
public class j_exam {

	public static void main(String[] args) {
		
		int a, b, hap, sub, mul;
		double div;
		//값대입
		a =100;
		b= 200;
		hap = sub = mul = 0;
		div = 0.0;
		//연산을 메소드로 하겠다.
		hap = Calc.getHap(a, b);
		sub = Calc.getSub(b,a);
		mul = Calc.getMul(a, b);
		div = Calc.getDiv(a,b);

		
		//출력 100 +200 = hap
		System.out.println(a +"+ "+b+" ="+hap);
		System.out.println(a +" - "+b+" ="+sub);
		System.out.println(a +"* "+b+" ="+mul);
		System.out.println(a +"/ "+b+" ="+div);
		
		
	}

}
