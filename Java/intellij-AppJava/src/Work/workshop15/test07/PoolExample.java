package Work.workshop15.test07;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolExample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3); // 핵심


        for (int i = 1; i <= 5; i++) {
            final int taskNum = i;
            pool.execute(()-> {
                System.out.println("작업 " + taskNum + " 처리 중");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        });
        }
        // ➌ 더 이상 작업을 추가하지 못하도록 종료
        pool.shutdown();
    }
}
