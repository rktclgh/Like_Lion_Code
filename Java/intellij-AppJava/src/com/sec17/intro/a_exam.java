package com.sec17.intro;

import java.net.*;
public class a_exam {
    public static void main(String[] args) {
        try {
            InetAddress[] res = InetAddress.getAllByName("kshit.link");

            for (InetAddress re : res) {
                System.out.println(re.getHostAddress());
                System.out.println(re.getHostName());

            }
        } catch (UnknownHostException e) {


        }
    }
}
