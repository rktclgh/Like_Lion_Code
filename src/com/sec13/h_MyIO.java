package com.sec13;
import java.io.*;

//object 단위로 읽고 쓰자
public class h_MyIO {

    public static void main(String[] args) {
        String filename = "./h.txt";
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
        ObjectOutputStream bo =new ObjectOutputStream(new FileOutputStream(filename));
        for (char i = 'A'; i <= 'Z'; i++) {
            bo.writeByte(i);
        }
//        fw.write(100);
        bo.close();
        System.out.println("파일에 A~Z 저장했어!!");
    }
    public static void MyReader(String filename) throws IOException
    {
        ObjectInputStream fr = new ObjectInputStream(new FileInputStream(filename));
        int data = 0;
        System.out.println(" 파일에서 읽은 데이터 ");
        while( (data = fr.readByte()) != -1)//한 바이트씩 읽어서 data에 대입하자 -1이 될때까지(break)
        {
            System.out.print((char)data+"\t");//타입캐스팅 필요
        }
        fr.close();
    }
}
