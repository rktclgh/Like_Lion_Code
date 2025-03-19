package com.sec13.myNio;

import java.nio.ByteBuffer;

public class i_bufferedTest {

    public static void main(String[] args) {
        System.out.println("=====ByteBuffer 확인=====");
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        byteBuffer.put((byte) 'A');
        byteBuffer.put((byte) 'B');
        byteBuffer.put((byte) 'C');

        System.out.println("데이터 저장 후 : "+byteBuffer.position()+" "+ byteBuffer.limit());

        System.out.println("읽기");
        byteBuffer.flip();
        System.out.println("플립 이후 : "+byteBuffer.position()+ " "+ byteBuffer.limit());

        while(byteBuffer.hasRemaining()) {
            System.out.println((char) byteBuffer.get());
        }


    }
}
