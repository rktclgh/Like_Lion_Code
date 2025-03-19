package com.sec13.myNio;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class g_NIOByte {
    //byte 단위 : Files.newOutputStream() Files.newInputStream(0
    public static void main(String[] args) throws IOException {
        Path path =  Paths.get("./a.txt");

                //byte A~Z까지 입출력 하자. var (jdk 10) = 지역변수 선언, 컴파일시 타입이 결정난다, 람다식에는 사용할 수 없다.

        try(var out = Files.newOutputStream(path, StandardOpenOption.APPEND,StandardOpenOption.WRITE))
        {
            for(byte i = 'A'; i<='Z';i++)
            {
                out.write(i);
            }
        }
        System.out.println("저장 완료!!!");


        System.out.println("데이터 결과: ");
        try(var in  = Files.newInputStream(path))
        {
            int data = 0;
            while((data = in.read())!=-1)
            {
                System.out.print((char)data);
            }
            System.out.println();
        }
    }
}
