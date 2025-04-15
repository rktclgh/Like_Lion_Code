package com.sec16;

//  Virtual Threads (JDK 21) - 람다 표현식 사용
public class g_VirtualThread2 {
    public static void main(String[] args) throws InterruptedException {

        testBuilder(Thread.ofVirtual().name("vt-",1));
        testBuilder(Thread.ofPlatform().name("pf-",1));


//
//        Thread.sleep(10000); // 메인 스레드가 가상 스레드 종료를 기다림 -> 메인 스레드는 10초간 대기 후 종료
//        //visualVm 실행  -> Threads 탭 -> 스레드가 실행할 때 일시적으로 Thread 수가 늘었다 줄었다.
    }


    public static void testBuilder(Thread.Builder builder){
        System.out.println("\n  [Test]실험 대상 "+ builder.getClass().getSimpleName());
        long start = System.currentTimeMillis();



        switch (builder)
        {
            case Thread.Builder.OfVirtual v ->
            {
                System.out.println(" 가상 스레드 실횅 ");
                Thread thread = v.start(()-> {
                    System.out.println("실행중(Virtual)    "+ Thread.currentThread());
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException i){
                        i.printStackTrace();
                    }
                } );
                myjoin(thread);
            }
            case Thread.Builder.OfPlatform p ->  {
                System.out.println("플랫폼 스레드 생성했다. ");
                Thread thread = p.start(()-> {
                    System.out.println("실행중(Platform)    "+ Thread.currentThread());
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException i){
                        i.printStackTrace();
                    }
                } );
                myjoin(thread);
            }
        }
        long duration  = System.currentTimeMillis() - start;
        System.out.println("실행시간  "+ duration + "ms");



    }

    private static void myjoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
