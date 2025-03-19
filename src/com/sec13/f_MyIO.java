package com.sec13;

import java.io.*;
//char 단위로 읽고 쓰자
public class f_MyIO {

    public static void main(String[] args) {
        String filename = "./f.txt";
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
        FileWriter fw =new FileWriter(filename);
        for (byte i = 'A'; i <= 'Z'; i++) {
            fw.write(i);
        }
//        fw.write(100);
        fw.close();
        System.out.println("파일에 A~Z 저장했어!!");
    }
    public static void MyReader(String filename) throws IOException
    {
        FileReader fr = new FileReader(filename);
        int data = 0;
        System.out.println(" 파일에서 읽은 데이터 ");
        while( (data = fr.read()) != -1)//한 바이트씩 읽어서 data에 대입하자 -1이 될때까지(break)
        {
            System.out.print((char)data+"\t");
        }
        fr.close();
    }
}
