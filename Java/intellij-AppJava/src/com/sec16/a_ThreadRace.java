package com.sec16;
//  case01 확장: Thread 상속 기반 경주 게임
//https://emojipedia.org/ 
//https://getemoji.com/
//  이모지 팝업창 윈도우 Windows + . (마침표) 또는 Windows + ; (세미콜론)
//             맥 Control + Command + Space


class RacerThread extends Thread {
    private static int finishOrder = 1; // 도착 순위 (공유 변수)

    public RacerThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + "🏃‍♂️: " + i + "미터");
            try {
                Thread.sleep((int)(Math.random() * 400 + 100)); // 100~500ms 랜덤 지연
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (RacerThread.class) {
            System.out.println("🎉 " + getName() + " 도착! 순위: " + finishOrder++);
        }
    }
}

public class a_ThreadRace {
    public static void main(String[] args) {
        RacerThread thread1 = new RacerThread("🐢 느린이");
        RacerThread thread2 = new RacerThread("🐇 빠른이");

        thread1.start();
        thread2.start();



        /*
        *   Thread.start(0 -> jvm은 os에 커널 스레드 요청
        *   -> Os는 해당 쓰레드를 스케쥴링을 한다 (시간 할당, 우선순위 고려)
        *   ->jvm은 각 thread 객체에 thread Stack을 할당
        *   -> 각 스레드는 독립적으로 call stack 을 갖는다
        *
        *   JConsole: 프로세스와 스레드 메모리 상태 확인
        *   overview: cpu 사용량, heap 메모리, 클래스 수, 스레드 수
        *   Memory : Gc ( 전체 Heap의 15% 이상 차지하게 되면 application 메모리 조정)
        *   Threads: 클래스 로딩 수, 메모리 점유량 확인
        *   vm Summary : jvm 기본 설정값 (힙 크기, Gc 설정, 명령줄 옵션)
        *   Mbeans : User가 등록한 프로세스를 관리하는 목적 -> 고급 모니터링 관리
        *
        *
        * */
    }
}