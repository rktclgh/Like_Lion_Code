package com.sec17.tcpexam03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import static java.nio.charset.StandardCharsets.*;

public class MyServer {

    private static final AtomicInteger clientCounter = new AtomicInteger(1);// 고유 클라이언트 ID를 위한 카운트 체크
    private static final File logFile = new File("clientLog.txt");
    public static void main(String[] args) {
        // 1.serversocket (9999)을 생성하여 특정 포트에서 클라이언트의 접속을 대기한다.

        System.out.println(" 나 서버야");

        try (ServerSocket serversocket = new ServerSocket(9999)) { // 1. 포트 9999에서 대기

            while (true) {

                Socket client_socket = serversocket.accept();// 2. 클라이언트 접속 요청대기

                int ClientId = clientCounter.incrementAndGet();
                String c_IP = client_socket.getInetAddress().getHostAddress();
                int c_PORT = client_socket.getPort();
                LocalDateTime c_TIME = LocalDateTime.now();


                System.out.printf("[클라이언트 %d 접속했어] IP:%s   Port: %d  Time: %s \n",
                        ClientId, c_IP, c_PORT, c_TIME);// 3. 클라이언트가 접속하면 Socket 객체 생성됨
                logFileClient(ClientId, c_IP, c_PORT,c_TIME);

                //4 . 클라이언트 별로 가상 스레드로 처리
                Thread.startVirtualThread(() -> handleClient(client_socket,ClientId));
            }
// 5. OutputStream을 이용하여 클라이언트에게 메시지 전송
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void logFileClient(int clientid, String c_IP, int c_PORT, LocalDateTime c_time) {
        try( BufferedWriter  logwriter  =
                     new BufferedWriter(
                             new  OutputStreamWriter(
                                     new FileOutputStream(logFile, true), StandardCharsets.UTF_8))){

            String  str  = String.format("🎶 [클라이언트  %d ]   IP:%s   PORT:%d   TIME: %s \n " ,
                    clientid, c_IP, c_PORT, c_time);

            logwriter.write(str);

        }catch(IOException  e) {
            e.printStackTrace();
        }

    }




    private static void handleClient(Socket client_socket, int ClientId) {
            try(client_socket;
                OutputStream os = client_socket.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            ) {
                writer.write("[서버 응답 ]클라이언트      "+ ClientId+"님, 안녕하세요!");
                writer.flush();
                System.out.printf("[클라이언트 %d] 응답완료!! - 연결종료 \n", ClientId);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}