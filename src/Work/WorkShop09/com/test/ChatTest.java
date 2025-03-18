package Work.WorkShop09.com.test;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChatTest {

    public static void main(String[] args) {
//        String a = args[0];//문자 받아오기
//        char []b = a.toCharArray();//char 배열로 전환
//        String res = IntStream.range(0,b.length)
//                .map(e ->b[b.length-1-e]) //배열 뒤에서 부터 읽음
//                .mapToObj(c->String.valueOf((char)c)) //int 값을 문자로 변환
//                .map(String::toUpperCase)//대문자로!
//                .collect(Collectors.joining());//큰형님 도움(하나로 합침)
//
//        System.out.println(res);

//        Optional.ofNullable(args[0])
//                .map(str -> new StringBuilder(str).reverse().toString().toUpperCase())  // Reverse the string using StringBuilder
//                .ifPresent(reversed -> System.out.print(reversed));  // Print the reversed string

        Scanner scanner = new Scanner(System.in);
        String sr = scanner.nextLine();
        char[] ch = sr.toUpperCase().toCharArray();



        String res = new StringBuilder(new String(ch)).reverse().toString();
        System.out.println(res); }
    }


