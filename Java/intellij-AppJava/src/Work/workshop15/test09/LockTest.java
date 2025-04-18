package Work.workshop15.test09;

public class LockTest {
    public static void main(String[] args) {
// ① 공유 자원 객체 생성
        SharedResource res = new SharedResource();
// ② 두 개의 스레드 정의 및 실행
        Thread t1 = new Thread(res::safeAccess);
        Thread t2 = new Thread(res::safeAccess);
// ③ 스레드 실행
        t1.start();
        t2.start();
    }
}
