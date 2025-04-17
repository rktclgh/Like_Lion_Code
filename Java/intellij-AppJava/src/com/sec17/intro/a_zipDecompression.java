package com.sec17.intro;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.*;

public class a_zipDecompression {
    public static void main(String[] args) throws IOException {
        File gzipFile = new File("output02.zip");
        try (FileInputStream fis = new FileInputStream(gzipFile);
             ZipInputStream gzipIn = new ZipInputStream(fis)) {// 4
            ZipEntry entry = null; // 파일
            while ((entry = gzipIn.getNextEntry()) != null) {
                System.out.println(" 압축 해제 중:" + entry.getName());
                InputStreamReader reader = new InputStreamReader(gzipIn, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(reader);


                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                gzipIn.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
