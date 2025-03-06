package com.sec02;

public class ArithOperator {


		static int result = 0;
		static int value01 = 50;
		static int value02 = 20;


		public void prn()
		{


			result = value01 + value02;
			System.out.println(value01 + "+ " + value02 + " =" + result);

			result = value01 - value02;
			System.out.println(value01 + "- " + value02 + " =" + result);

			result = value01 * value02;
			System.out.println(value01 + "* " + value02 + " =" + result);

			result = value01 / value02;
			System.out.println(value01 + "/ " + value02 + " =" + result);

			result = value01 % value02;
			System.out.println(value01 + "% " + value02 + " =" + result);

		}


	public static void main(String[] args) {
		new ArithOperator().prn();
		System.out.println("===============");
		new ArithOperator().prn();
		System.out.println("===============");
		System.out.println(ArithOperator.result);
	}
}