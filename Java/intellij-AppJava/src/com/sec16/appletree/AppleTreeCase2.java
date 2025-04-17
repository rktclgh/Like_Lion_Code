package com.sec16.appletree;


//case1: synchronized -> 임계영역 Critical Section)을 보호하기 위한 자바 코드 지정
//임계영역(두개 이상의 스레드가 동시에 접근하면 안되는 코드블럭
public class AppleTreeCase2 extends AppleTreeCompetition {
    protected synchronized boolean pickApple(String who) {
        if (apples <= 0) return false;
        apples--;
        if (who.equals("Cat")) catCount++;
        else dogCount++;
        System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}