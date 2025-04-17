package com.sec17.tcpexam02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        // 1.serversocket (9999)을 생성하여 특정 포트에서 클라이언트의 접속을 대기한다.
        System.out.println(" 나 서버야");
        try (ServerSocket serversocket = new ServerSocket(9999)) { // 1. 포트 9999에서 대기

            while (true) {

                Socket client_socket = serversocket.accept();// 2. 클라이언트 접속 요청대기
                System.out.println("클라이언트 접속했어");// 3. 클라이언트가 접속하면 Socket 객체 생성됨
                //4 . 클라이언트 별로 가상 스레드로 처리
                Thread.startVirtualThread(() -> handleClient(client_socket));
            }
// 5. OutputStream을 이용하여 클라이언트에게 메시지 전송
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket client_socket) {
            try(client_socket;
                OutputStream os = client_socket.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            ) {
                writer.write("가상 스레드 서버에서 응답한다 ");
                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}