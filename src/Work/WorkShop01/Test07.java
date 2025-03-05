package Work.WorkShop01;

class Test07 {
	public static void main(String[] args) {
		// 테스트할 문자 변수 선언
		char ch = 'G'; // 다른 문자로 변경하여 테스트 가능
		// 결과 출력
		printResult(ch);
		}
		// 문자가 영문자인지 판별하는 static 메소드
		public static boolean isAlphabet(char ch) {
			return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
		}
		// 결과를 출력하는 static 메소드
		public static void printResult(char ch) {
		String result = isAlphabet(ch)
		? "입력한 문자 '" + ch + "'는 영문자입니다."
		: "입력한 문자 '" + ch + "'는 영문자가 아니다.";
		System.out.println(result);
	
		}
	}
