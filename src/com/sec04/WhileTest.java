package com.sec04;

public class WhileTest {



	public static void test01()
	{
		int i=1;
		System.out.println("Countdown start!");
		while(i<=5)
		{
			System.out.printf("%5d", i);
			i++;
		}
		System.out.println(" end i ="+ i);

	}


	public static void test02() {
		int i= 1; // 지역변수 조기회
		while (i <= 5) {
			i++;
			System.out.println(i);
		}
	}


	/*
	*
	* 1~ 100까지 숫자를 출력해보자 while로 작성하자
	* 조건 1: 짝수만 출력하자.
	* 조건 2: 짝수의 개수를 출력하자
	*
	* */
	public static void test03()
	{
		int i=1;
		int cnt =0;
		while(i<100)
			{
				if(i%2 ==0)
				{
				System.out.printf("%5d", i);
				cnt++;
				}
				i++;
			}
		System.out.println(" end i ="+ i);
	}

	public static void test04()
	{
		int i=1;
		int cnt =0;
		while(i<=100)
		{
			if(i%5 ==0)
			{
				System.out.printf("%5c\n", '❤');
				cnt++;
			}
			else
			{
				System.out.printf("%5d",i);
			}
			i++;
		}
		System.out.println(" cnt	: ="+ cnt);
	}









	public static void main(String[] args) {
		test01();
		System.out.println("\n=====================\n");
		test02();
		System.out.println("\n=====================\n");
		test04();
		}// WhileTest end
//
 }




