package Work.workshop15.test09;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
private final ReentrantLock lock = new ReentrantLock();


public void safeAccess()
{
    lock.lock(); // 잠금

    try{
        System.out.println("잠금 획득");

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }finally {
        System.out.println("잠금 해제");
        lock.unlock(); // 해제
    }
}

}
