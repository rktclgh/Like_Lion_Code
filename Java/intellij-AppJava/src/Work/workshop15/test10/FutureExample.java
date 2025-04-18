package Work.workshop15.test10;

import java.util.concurrent.CompletableFuture;

public class FutureExample {
    public static void main(String[] args) {
        System.out.println("비동기 계산 시작");
        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() ->// 핵심!
                {
                    // ① supplyAsync 로 비동기 계산 (200 + 100)

                    return 200 + 100;
                });

        CompletableFuture<Integer> afterFirst = future.thenApply(result -> {
            System.out.println("최초 계산 결과: " + result);  // 여기에 출력!
            return result;
        });
// ② 후속 작업: 결과에 2 를 곱함
        CompletableFuture<Integer> resultFuture = future.thenApply(result -> result*2);
// ③ 최종 결과 출력

        resultFuture.thenAccept(result -> System.out.println("최종 계산 결과 (x2): " + result));
        resultFuture.join();
// ④ 모든 작업 완료까지 대기
        System.out.println("main 종료");
    }
}
