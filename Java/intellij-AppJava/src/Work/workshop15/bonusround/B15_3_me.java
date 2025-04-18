//package Work.workshop15.bonusround;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class B15_3_me {
//    public static void main(String[] args) {
//        BoundedBuffer buffer  = new BoundedBuffer();
//        //생산자 스레드
//        Thread producer = new Thread(()->{
//            int item = 1;
//            try{
//                while(true)
//                {
//                    buffer.put(item++);
//                    Thread.sleep(500);
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        });
//
//
//        //소비자 스레드
//        Thread consumer = new Thread(()->{
//
//            try{
//                while(true)
//                {
//                    Object item = buffer.take();
//                    Thread.sleep(1000);
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        });
//
//        producer.start();
//        consumer.start();
//    }
//
//
//}
//
//class BoundedBuffer {
//    final Lock lock = new ReentrantLock();
//    final Condition notFull  = lock.newCondition();
//    final Condition notEmpty = lock.newCondition();
//
//    final Object[] items = new Object[5];
//    int putptr, takeptr, count;
//
//    public void put(Object x) throws InterruptedException {
//        lock.lock();
//        try {
//            while (count == items.length) {
//                System.out.println("버퍼 가득 참 - 생산자 대기");
//                notFull.await();
//            }
//
//            items[putptr] = x;
//            System.out.printf("생산 -> [%s] (버퍼: %d %d)\n", x, count+1, items.length);
//
//            putptr = (putptr + 1)%items.length;
////            if (++putptr == items.length) putptr = 0;
//            count++;
//            notEmpty.signal();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public Object take() throws InterruptedException {
//        lock.lock();
//        try {
//            while (count == 0) {
//                System.out.println("버퍼 빈 상태야! 소비자 대기");
//                notEmpty.await();
//            }
//            Object x = items[takeptr];
//            System.out.printf("소비 -> [%s] (버퍼: %d %d)\n", x, count+1, items.length);
//
//            takeptr = (takeptr + 1)%items.length;
//            count--;
//            notFull.signal();
//            return x;
//        } finally {
//            lock.unlock();
//        }
//    }
//}
