package com.sec13.myNio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class a_NIO2 {


    public static void main(String[] args) throws IOException {

        // Q1 .d: Test 폴더 생성
        Path test = Paths.get("/Users/songchiho/Desktop/부트캠프/intellij-AppJava/src/com/sec13/myNio/test");
        Files.createDirectory(test);
        //Q2. test\\AA 폴더 생성
        Path aadir = test.resolve("AA");
        Files.createDirectory(aadir);

        //Q3 test\\BB폴더 생성
        Path bbdir = test.resolve("BB");
        Files.createDirectory(bbdir);

        //Q4 test\bb\a.txt 생성
        Path atxt = bbdir.resolve("a.txt");
        Files.createFile(atxt);
        System.out.println("다 만들었어!");
        //Q5 a.txt 삭제
        Files.delete(atxt);
        System.out.println("삭제 했어!");
    }
}
