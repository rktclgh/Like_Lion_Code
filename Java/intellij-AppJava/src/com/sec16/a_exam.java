package com.sec16;

public class a_exam implements Runnable{
    @Override
    public void run() {
        System.out.println("나 스레드야!!!! 💁");
    }

    public static void main(String[] args) {


//        new Thread(new a_exam()).start();

        Thread t1 = new Thread(new a_exam(),"야옹이");
        Thread t2 = new Thread(new a_exam(),"멍멍이");
        t1.start();
        t2.start();

    }


}
