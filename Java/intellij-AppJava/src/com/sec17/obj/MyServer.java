package com.sec17.obj;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Double.NaN;

public class MyServer {
    public static void main(String[] args) throws ClassNotFoundException {


        try ( ServerSocket server  = new ServerSocket(7777);
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();)
        {
        System.out.println(".....서버 대기중 ....");


        while(true){
        Socket client = server.accept();
        System.out.println("클라이언트 접속");
        executor.submit(()-> {
            try {
                handleClient(client);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static double MyCalculate(double a, double b, String op) {
        return switch (op)
        {
            case "+" -> a+b;
            case "-" -> a+b;
            case "*" -> a+b;
            case "/" -> b!=0? a/b : NaN;
            default -> 0;
        };
    }


    public static void handleClient(Socket client) throws IOException, ClassNotFoundException {
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());


                SendData response = (SendData)ois.readObject();
                double res = MyCalculate(response.getNum1(), response.getNum2(), response.getOp());
                response.setResult(res);

                //클라이언트로 계산된 결과를 보내자
                oos.writeObject(response);
                oos.flush();

    }
}