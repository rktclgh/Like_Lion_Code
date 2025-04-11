package com.sec04.exam;

public class c_while {
    public static void main(String[] args) {
//        while (true) {
//            System.out.println("명령수행");
//        }
        String str = "Hello\\nWorld";  // 이스케이프 문자 '\n'이 아닌, '\'와 'n'이 포함된 문자열
        System.out.println("Before: " + str);

        str = str.translateEscapes(); // 변환된 값을 다시 저장
        System.out.println("After: " + str);

    }
}
