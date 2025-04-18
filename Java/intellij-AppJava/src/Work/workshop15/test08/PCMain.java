package Work.workshop15.test08;

public class PCMain {
    public static void main(String[] args) {
// ① 공유 자원 생성
        Buffer buffer = new Buffer();
// ② 생산자 스레드 정의
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++)
                buffer.produce(i);
        });
// ③ 소비자 스레드 정의
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++)
                buffer.consume();
        });
// ④ 스레드 시작
        producer.start();
        consumer.start();
    }
}
