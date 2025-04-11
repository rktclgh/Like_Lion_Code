package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest01 {

    public static void main(String[] args) {
        transformToUpperCase(); // 모든 문자열을 대문자로 변환하는 메서드 실행
        checkIntermediateValues(); // 중간 연산을 확인하면서 문자열을 변환하는 메서드 실행
        transformFlatMap(); // 문자열을 분석하여 여러 개의 요소로 변환하는 메서드 실행
    }

    // 1. 모든 문자열을 대문자로 변환
    private static void transformToUpperCase() {
        Stream.of("Java", "jsp", "spring", "jquery") // 문자열 스트림 생성
                .map(String::toUpperCase) // 각 문자열을 대문자로 변환
                .forEach(System.out::println); // 변환된 문자열을 출력
        System.out.println("========================"); // 구분선 출력
    }

    // 2. 중간 연산 체크 + 문자열 변환
    private static void checkIntermediateValues() {
        Stream.of("루리", "루세", "루오", "폴리") // 문자열 스트림 생성
                .peek(t -> System.out.printf("체크값=%s%n", t)) // 중간 단계에서 각 요소 출력
                .map(t -> t + "\n") // 각 문자열 끝에 개행 문자("\n") 추가
                .forEach(System.out::println); // 최종적으로 변환된 값 출력
    }

    // 3. flatMap()을 사용한 문자열 변환
    private static void transformFlatMap() {
        // 주어진 리스트에서 과일명과 개수를 추출하여 변환
        List<String> list = Arrays.asList("사과3팩", "멜론2팩", "딸기3팩");

        List<String> result = list.stream()
                .flatMap(s -> {
                    String fruit = s.replaceAll("[0-9팩]", ""); // 숫자와 "팩"을 제거하여 과일명만 추출
                    int count = Character.getNumericValue(s.charAt(2)); // 세 번째 문자(숫자)를 추출하여 개수로 사용
                    return Stream.generate(() -> fruit).limit(count); // 해당 과일을 숫자만큼 반복 생성하는 스트림 반환
                })
                .collect(Collectors.toList()); // 리스트로 변환

        System.out.println(result); // 최종 변환된 리스트 출력
    }
}
