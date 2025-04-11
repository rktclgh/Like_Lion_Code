package com.sec13;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class b_nio {
    public static void myread() {
        try (FileChannel channel = FileChannel.open(Paths.get("a.txt"), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024); // 버퍼 크기 생성
            while (channel.read(buffer) > 0) { //1024 데이터를 채널(비동기 병렬할 대상인 a.txt)로 읽어들인다.
                buffer.flip();//읽기 상태 전환
                System.out.print(new String(buffer.array(), 0, buffer.limit()));
                buffer.clear(); // 초기화
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mywrite(String content) {
        try (FileChannel channel = FileChannel.open(Paths.get("./a.txt"), StandardOpenOption.APPEND)) {
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            channel.write(buffer);
            buffer = ByteBuffer.wrap(System.lineSeparator().getBytes());
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("NIO Read:");
        myread();
        System.out.println("\nNIO Write:");
        mywrite("Appended using NIO.");
        myread();
    }
}