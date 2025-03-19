package com.sec13;

import java.io.*;

//char 단위를 BUfferedWriter로 읽고 쓰자
public class g_MyIO {

    public static void main(String[] args) {
        String filename = "./g.txt";
//        File filename = new File("d.txt");
//        System.out.println(filename.getPath());
//        System.out.println(filename.getAbsolutePath());

        try{
//            MyWrite(filename);
            MyReader02(filename);
         }catch (Exception e)
        {
            System.out.println(e);
        }//try end
    }// main end
    public static void MyReader02(String filename) throws IOException
    {
        BufferedReader bi = new BufferedReader(new FileReader(filename));
        String data = null;//한줄씩 읽어서 대입한 객체 변수 null로 지역변수 초기화
        System.out.println(" 파일에서 읽은 데이터 ");
        while( (data = bi.readLine()) != null)//0~65535 코드 값으로 data에 대입하자 -1이 될때까지
        {
            System.out.println(data);
        }
        bi.close();
    }

    public static void MyWrite(String filename) throws IOException
    {
        BufferedWriter bo =new BufferedWriter(new FileWriter(filename));
        for (char i = 'A'; i <= 'Z'; i++) {
            bo.append(i);
        }
//        fw.write(100);
        bo.close();
        System.out.println("파일에 A~Z 저장했어!!");
    }
    public static void MyReader(String filename) throws IOException
    {
        BufferedReader fr = new BufferedReader(new FileReader(filename));
        int data = 0;
        System.out.println(" 파일에서 읽은 데이터 ");
        while( (data = fr.read()) != -1)//한 바이트씩 읽어서 data에 대입하자 -1이 될때까지(break)
        {
            System.out.print((char)data+"\t");//타입캐스팅 필요
        }
        fr.close();
    }
}
