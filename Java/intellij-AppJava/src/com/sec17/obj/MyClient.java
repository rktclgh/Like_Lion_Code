package com.sec17.obj;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos;
        ObjectInputStream ois;
        try (Socket sc = new Socket("localhost",7777)) {
            oos = new ObjectOutputStream(sc.getOutputStream());
            ois = new ObjectInputStream(sc.getInputStream());


            Scanner sc_input = new Scanner(System.in);
            System.out.print("첫번째 숫자 : ");
            double a = sc_input.nextDouble();
            System.out.print("연산자: ");
            String op = sc_input.next();
            System.out.print("두번째 숫자 : ");
            double b = sc_input.nextDouble();

            //객체 담고
            //서버로 보냄
            SendData sd = new SendData(a, b, op);
            oos.writeObject(sd);
            oos.flush();
            //사바로결과값 리턴

            SendData response = (SendData) ois.readObject();
            System.out.println("서버로부터 받은 연산 결과 : " + response.getResult());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}