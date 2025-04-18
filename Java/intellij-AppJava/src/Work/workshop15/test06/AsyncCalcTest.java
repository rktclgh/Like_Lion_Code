package Work.workshop15.test06;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncCalcTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ① 비동기 계산 시작 (200 + 100)
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->// 핵심!
        {
            try {
                Thread.sleep(500);//         ② 0.5초간 연산 대기

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 200+100;
        });
        int result = future.get();

//         ③ 결과 출력 (계산 결과: 300)
        System.out.println("result: " + result);
//         ④ main 종료 메시지
        System.out.println("end");
    }
}

/*
*
*
* 생성
CompletableFuture
. supplyAsync(Suppiler) 결과를 반환하는 비동기 작업 시작
• runAsync (Runnable)
결과 없이 실행하는 비동기 작업
결과 후 처리
thenAccept(Consumer): CompletableFuturesVoid>
thenApply(Function‹T,R› ): CompletableFuture‹R›
thenRun (Runnable): CompletableFuture‹Void>
thenCombine(future2, (a,b) -> ..•) : 두 개의 결과조합 thenAcceptBoth(future2, (a,b) -> ...) : 두 결과 실행 후 종료
runAfterBoth(f1, f2)
: 결과 없이 둘 다 끝난 후 작업
코드 예 ) 10 값을 받아서 * 2한 결과를 비동기 스레드로 연산하고 싶다.
CompletableFuture. supplyAsync (() -> 10).
.thenApply （n->n*2）<T, R>
.thenAccept (System out:: printLn);//20    void    accept(T t)
*
*
* 1) Spring Boot : Rest 비동기 응답, 외부 API 호출 조합 처리
* 2) WebClient + Reactor 연동 : .toFuture() 변환 시 CompletableFuture 사용
* 3) 백엔드 계산 분리 AI, 이미지 처리 등 비동기 CPU 작업
* 4) 테스트/ 모의 비동기 시나리오: COmpletableFuture.completedFuture(...) 자주 사용
*
*
*
*
* */