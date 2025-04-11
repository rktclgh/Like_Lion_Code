package com.sec16;

// [7. 동기화 기초] - synchronized 메서드 사용
public class e_SynchronizationBasic01 {
    public static void main(String[] args) throws InterruptedException {
        //람다식에서 외부 변수를 참조할 때 final 이어야 한다.


        final int[] count = {0};  //배열 상수 : 배열은 참조값이 변하지 않는다.

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (count) { // 하나의 스레드만 접근 가능하도록 만들어 준다.

                    count[0]++;
                }
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        //만일 조인을 주지 않으면 메인스레드가 thread1, thread2가 끝나기 전에 출력을 실행한다.
        //조인을 줘야 동기화 출력 결과를 정확하게 리턴 받을 수 있다.
        thread1.join(); //스레드가 종료 할 때 까지 기다린다.
        thread2.join(); //스레드가 종료 할 때 까지 기다린다.

        System.out.println("Final Count: " + count[0]);

        //실행결과 테스트
        //1. synchronized o, join o -> Final Count: 2000
        //2. synchronized x, join o -> Final Count: 2000보다 낮게 나옴
        //3. synchronized o, join x -> Final Count: 0, 1000. 1500 등이 랜덤으로 나온다( 스레드 종료 시점)
        //멀티 스레드는 항상 synchronized(공유자원 LOCK), join(대기)를 고려해서 프로그램을 작성한다. !!!!
    }
}