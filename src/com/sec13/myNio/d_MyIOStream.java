package com.sec13.myNio;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class d_MyIOStream implements FileVisitor<Path> {
//
//    FileInputStream은 파일을 읽기 위한 스트림이며, 버퍼링이 없어 느릴 수 있음.
//    BufferedOutputStream은 파일을 쓰기 위한 스트림이며, 버퍼링을 사용하여 성능을 향상시킴.
//    대량의 데이터를 처리할 때는 BufferedInputStream과 BufferedOutputStream을 함께 사용하는 것이 좋음.

    public static void main(String[] args) {
        String filename = "./e.txt";
//        File filename = new File("d.txt");
//        System.out.println(filename.getPath());
//        System.out.println(filename.getAbsolutePath());

        try{
            MyWrite(filename);
            MyReader(filename);
         }catch (Exception e)
        {
            System.out.println(e);
        }//try end
    }// main end


    public static void MyWrite(String filename) throws IOException
    {
        BufferedOutputStream bo =new BufferedOutputStream(new FileOutputStream(filename));
        for (byte i = 'A'; i <= 'Z'; i++) {
            bo.write(i);
        }
//        fo.write(100);
        bo.close();
        System.out.println("파일에 A~Z 저장했어!!");
    }
    public static void MyReader(String filename) throws IOException
    {
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(filename));
        int data = 0;
        System.out.println(" 파일에서 읽은 데이터 ");
        while( (data = bi.read()) != -1)//한 바이트씩 읽어서 data에 대입하자 -1이 될때까지(break)
        {
            System.out.print(data+"\t");
        }
        bi.close();
    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return null;
    }
}
