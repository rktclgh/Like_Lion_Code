package com.sec12.mstream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest04 {

    public static void main(String[] args) {
        //Q1. 1~10까지 정수형 값을 스트림 생성 후 출력 map(): 요소 변환 -> 정수를 문자열로 변환 String.valueof()


        Stream<String> streamFromValues = IntStream.rangeClosed(1,10).mapToObj(String::valueOf);

        StreamTest.printStream("Q1. 1~10까지 정수형 값을 스트림 생성 후 출력", streamFromValues);




        //Q2. 10 ~ 1까지 정수형 값을 스트림 생성 후 출력 -> iterate 방법
        Stream<String> streamFromValues03 = IntStream.iterate(10, i->i-1).limit(10).mapToObj(String::valueOf);
        StreamTest.printStream("Q2. 10 ~ 1까지 정수형 값을 스트림 생성 후 출력 -> iterate 방법",streamFromValues03);



        //Q3. 10 ~ 1까지 정수형 값을 스트림 생성 후 출력 -> rangeClosed 방법
        streamFromValues03 = IntStream.rangeClosed(1,10)// 1~10까지 정수 스트림
                .map(i->11-i) //역순으로 리턴 하겠다.
                .mapToObj(String::valueOf); //문자열 변환 후 스트림 생성 후 리턴

        ///Q4. Stream<Integer>boxed() + sorted(Comparator.reverseOrder()) 사용
        streamFromValues03 = IntStream.rangeClosed(1,10)
                .boxed()
                .sorted((a,b)->b-a)
                .map(String::valueOf);
        StreamTest.printStream("Q4. 10~1까지 정수형 값을 스트림 생성 후 출력",streamFromValues03);

    }
}
