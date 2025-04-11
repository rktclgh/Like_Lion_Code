package com.sec04;
import java.util.Scanner;

public class IfTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int su = sc.nextInt();
		if ((su % 2) == 0) {//입력한 수를 2로 나눈 나머지가 0이라면 짝수, 그러지 않으면 홀수 라고 출력하자.
			System.out.println(su + " 는 짝수입니다. ");
		} else {
			System.out.println(su + " 는  홀수입니다. ");
		}
	}
}
