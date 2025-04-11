package com.sec02;
	public class BitOperator {
		
		public  static void prn(){
			
			int a=51;
			int b=240;
			
			 System.out.println("AND ="+( a&b));
			 System.out.println("OR=" +(a|b));
			 System.out.println("XOR="+(a^b));
		}


		public static void main(String[] args) {
			//정수를 이진 문자열로 변경해보자.

			int a = 51;
			int b = 240;

			System.out.println(("a의 51을 2진 문자열로 ="+ Integer.toBinaryString(a)));
			System.out.println("b의 240을 2진 문자열로 ="+ Integer.toBinaryString(b));

			//전체 8자리를 표시하고
			// 리턴받아서 String.format로 지정한 다음 출력해야 한다.
//			System.out.printf("%16s", Integer.toBinaryString(a).replace(' ', '0'));

			String str = BinaryStringPadding(a);
			System.out.println(str);

			String str2 =  BinaryStringPadding(b);
//			System.out.printf("%16s", Integer.toBinaryString(a).replace(' ', '0'));
			System.out.println(str2);

			String str3 = BinaryStringPadding(-20);
			System.out.println(str3);

			int res_a = 2;

			float res_af = 7.2f;
			System.out.println(BinaryStringPadding_float(res_af));
			//실수 타입을 구현할 때 -> 실수클래스의 비트로 변환한 다음 정수 클래스의 toBinaryString()으로 작성한다.
			// Double 클래스의 bits로 변환하는 메소드를 찾아보자!
			double doubleValue = 3.14159265359;//8byte
			long bits = Double.doubleToLongBits(doubleValue);//메소드 찾기
			String binaryString = Long.toBinaryString(bits);// 변환하기
			System.out.println(doubleValue+"\n"+bits+"\n"+binaryString);//출력


			System.out.println("================NaN================");
			double non_value = Double.NaN;
			long res03 = Double.doubleToLongBits(non_value);//변환하기
			long res04 = Double.doubleToRawLongBits(non_value);//변환하기
			//////////Long.toBinaryString()로 변환해서 출력

			System.out.println(non_value+"\n"+res03+"\n"+res04);
			System.out.println(Long.toBinaryString(res03)+"\n"+Long.toBinaryString(res04));



		}

		public static String BinaryStringPadding(int res)
		{
			String result = String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
			return result;
		}
		public static String BinaryStringPadding_float(float res)
		{
			String result = String.format("%32s", Float.toHexString(res)).replace(' ', '0');
			return result;
		}
	}




	
	
