package com.sec17.intro;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.*;

public class a_zipCompression {
    public static void main(String[] args) {
        String data = """
                Hello, this is compressed content.
                Java ZIP is easy to use!
                Virtual Thread도 문제 없이 동작합니다 
                """;

        File gzipFile = new File("output02.zip");// $4
        try (FileOutputStream fos = new FileOutputStream(gzipFile);
             ZipOutputStream gzipOut = new ZipOutputStream(fos)) {
        OutputStreamWriter writer = new OutputStreamWriter(gzipOut, StandardCharsets.UTF_8);
// 압축항목을 정의 하자.
        ZipEntry ze = new ZipEntry("a.txt");
        gzipOut.putNextEntry(ze);
        writer.write(data);
        writer.flush();
        System.out.println(" 압축 완료: " + gzipFile.getAbsolutePath());
    } catch (IOException e) {
        e. printStackTrace();
    }
    }
}
