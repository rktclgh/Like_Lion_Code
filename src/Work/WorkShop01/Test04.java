package Work.WorkShop01;

public class Test04 {

	public static void main(String[] args) {
		char ch = 'a'; // 다른 문자로 변경하여 테스트 가능
		// 삼항 연산자를 사용하여 영문자인지 판별
		String result = (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')
		? "입력한 문자 '" + ch + "'는 영문자입니다."
		:  "입력한 문자 '" + ch + "'는 영문자가 아닙니다."  ;
		// 결과 출력
		System.out.println(result);
		}
		}


