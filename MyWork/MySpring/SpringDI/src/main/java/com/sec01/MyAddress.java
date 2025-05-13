package com.sec01;

public class MyAddress {
    private String name;
    private String addr;
    private String tel;

    public MyAddress(String name, String addr, String tel) {
        this.name = name;
        this.addr = addr;
        this.tel = tel;
    }

    public MyAddress() {
        this.name = "홍길동";
        this.addr = "서울시";
        this.tel = "00-00-0000";
    }

    public MyAddress(String name) {
        this.name = name;
        this.addr = "부산시";
        this.tel = "00-00-0000";
    }

    @Override
    public String toString() {
        return "MyAddress{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}



