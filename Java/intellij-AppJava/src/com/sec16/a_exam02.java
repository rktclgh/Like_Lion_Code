package com.sec16;

public class a_exam02 extends Thread{

    public a_exam02(String thread_Name){
        super(thread_Name);
    }


    @Override
    public void run() {
        for (int i = 1; i < 50; i++) {
            System.out.println("나 스레드야!!!! 💁 -> : "+getName()+i);
        }
    }

    public static void main(String[] args) {


//        new Thread(new a_exam()).start();

//        Thread t1 = new Thread(new a_exam02(),"야옹이");
//        Thread t2 = new Thread(new a_exam02(),"멍멍이");

        a_exam02 t1 = new a_exam02("야옹이");
        a_exam02 t2 = new a_exam02("멍멍이");
        t1.setPriority(9);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        t1.start();
        t2.start();

    }


}
