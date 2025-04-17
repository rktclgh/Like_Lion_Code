package com.sec17.tcpexam;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        // 1.serversocket (9999)을 생성하여 특정 포트에서 클라이언트의 접속을 대기한다.
                System.out.println(" 나 서버야");
        try (
                ServerSocket serversocket = new ServerSocket(9999); // 1. 포트 9999에서 대기
                 Socket socket= serversocket.accept(); // 2. 클라이언트의 접속 요청 대기
                OutputStream os = socket.getOutputStream(); // 4. OutputStream $5
        ) {
// 3. 클라이언트가 접속하면 Socket 객체 생성됨
            System.out.println("클라이언트 접속했어");
// 5. OutputStream을 이용하여 클라이언트에게 메시지 전송
            os.write("서버가 클라이언트에게".getBytes("UTF-8")); // 인코딩 명시 추가
        } catch (IOException e) {
            e.printStackTrace();
        }}}