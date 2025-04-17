package com.sec16.appletree;

import java.util.concurrent.CompletableFuture;

//case 3:  CompletableFuture 사용 -> 자바의 비동기 병렬처리의 핵심 클래스
// [Future 과 Callable 결과 반환 -> Future, Callable<T>, get() -> 리턴값 있는 비동기]의 개선된 확장형
/*
* Future 의 단점: 예외처리 어려워 /get() 결과를 기다릴때 블록 / 후 작업을 할 수 없다. -> 웬만하면 사용하지 않는다, 레거시코드
*
* CompletableFuture.supplyAsync().thenApplu().thenAccept(System.out::println) -> 최신판
*                       비동기 시작 .   연산       , 출력
*
* 동기화: 작업이 끝날때 까지 기다렸다가 다음 작업으로 넘어감 -> 전화 받을 때까지
*
* 비동기화: 작업을 요청한 다음, 결과를 기다리지 않고 바로 다음 작업으로 넘어감 -> 문자메세지
*
* */

public class AppleTreeCase4_Async extends AppleTreeCompetition {
    protected boolean pickApple(String who) {
        CompletableFuture.runAsync(() -> {
            synchronized (this) {
                if (apples <= 0) return;
                apples--;
                if (who.equals("Cat")) catCount++;
                else dogCount++;
                System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
            }
        });
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}