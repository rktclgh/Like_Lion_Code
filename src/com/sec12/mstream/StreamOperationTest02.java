package com.sec12.mstream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamOperationTest02 {
    public static void main(String[] args) {
        //Q1. 1~100까지 정수를 출력하자.
        IntStream.range(1,101).forEach(e-> System.out.printf("%5d", e));


        System.out.println();


        //Q2. 짝수만 출력
        IntStream.range(1,101).filter(e->e%2==0).forEach(e-> System.out.printf("%5d", e));


        System.out.println();
        //Q3. 합을 구하자
        int sum = IntStream.range(1, 101).sum();

        System.out.printf("%5d", sum);


        System.out.println();
        //Q4. str을 문자열 리스트로 공백 기준으로 만들어서 5글자 이상인 단어만 필터링 한 후 모두 대문자로 출력

        String str = "Returns a composed Consumer that performs, in sequece";
        Arrays.stream(str.split("\\s+"))// 공백 기준으로 문자열 나누기
                .filter(word->word.length()>5)
                .map(String::toUpperCase)//대문자로 변환
                .forEach(word->System.out.printf("%5d", word));



//        Arrays.stream(input.split("\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }



}
