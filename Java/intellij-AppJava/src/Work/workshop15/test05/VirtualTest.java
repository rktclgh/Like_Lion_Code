package Work.workshop15.test05;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualTest {
    public static void main(String[] args) throws InterruptedException {
        //1.virtual Thread용 Executor 생성
        ExecutorService executor  = Executors.newVirtualThreadPerTaskExecutor(); // 핵심!


        //2. 5개의 virtual Thread
        for (int i = 1; i <=5 ; i++) {
            final int threadNum = i;
            executor.submit(()->{
                try {
                    //3. 스레드 시작 전 0.5초 대기
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //4. 대기 후 메시지 출력
                System.out.println("가상 스레드 "+ threadNum+ "번 실행 중");
            });

        }

        //5. 종료 요청
        executor.shutdown();
        //6. 모든 작업이 종료될 떄까지 대기
        while(!executor.isTerminated()){
            Thread.sleep(500);
        }

        //7, 모든 가상 스레드 종료 후 메시지 출력
        System.out.println("끝!");

    }
    /*
    *
    * shutdown(): 새로우 ㄴ스레드 상관ㅇ벗이 기존 작업을 마무리
    * shutdownNOw() : 지금 모든 작업을 중단해!!!
    * isTerminated() : 위 두개 메소드가 호출되면 모든 작업이 끝났는지 true 로 확인
    * awaitTermination(long timeout, TimeUnit unit): 일정 시간 대기 하면서 종료를 기다린다.
    * */
}
