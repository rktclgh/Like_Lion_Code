package com.sec12.mstream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest02 {

    public static void main(String[] args) {
        //Q1. 1~10까지 정수형 값을 스트림 생성 후 출력  map(): 요소 변환 -> 정수를 문자열로 변환 String.valureOf();

        Integer[] arr = {1,2,3,4,5,6,7,8,9,10};



        Stream<String> streamFromValues = Arrays.stream(arr).map(String::valueOf);

        StreamTest.printStream("Q1. 1~10까지 정수형 값을 스트림 생성 후 출력", streamFromValues);



        //Q2. "import java.util.stream.Steam"는 문자열을 잘라서 배열 후 만든 후 스트림 생성 후 출력

        String str = "import java.util.stream.Steam";
        String array[] = str.split(" ");
        Stream<String> q2 = Stream.of(array);


        StreamTest.printStream("Q2. \"import java.util.stream.Steam\"는 문자열을 잘라서 배열 후 만든 후 스트림 생성 후 출력", q2);


        //Q3. 10~ 1까지 정수형 값을 스트림 생성 후 출력

        Integer[] arr1 = {10,9,8,7,6,5,4,3,2,1};

        Stream<String> q3 =Arrays.stream(arr1).map(String::valueOf);


        StreamTest.printStream("Q3. 10~ 1까지 정수형 값을 스트림 생성 후 출력", q3);


    }
}
