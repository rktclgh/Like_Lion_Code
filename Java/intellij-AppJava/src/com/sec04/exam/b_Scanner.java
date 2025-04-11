package com.sec04.exam;


import java.util.Scanner;

/*
콘솔로 값을 입력 받는 방법
java.util.scanner -> 타입의 입력이 메소드로 정해져 있다.
java,io.BufferReader -> 문자열 입력 특화/ 예외처리
java.lang.System.in.read() -> 한글자 특화
 */
public class b_Scanner {
    public static void main(String[] args) {
//        System.out.print("input i : ");
//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();
//        System.out.println("입력 받은 값: "+ i);

        //이름 주소 전화번호 입력받아 출력 해보자.
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 입력: ");
        String name = sc.nextLine();
        System.out.print("주소 입력: ");
        String addr = sc.nextLine();
        System.out.print("번호 입력: ");
        String tel = sc.nextLine();

        System.out.printf("%10s %10s %10s\n", name, addr, tel);
        sc.close();


    }
}
