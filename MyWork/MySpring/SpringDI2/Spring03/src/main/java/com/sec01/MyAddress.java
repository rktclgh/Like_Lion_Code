package com.sec01;

public class MyAddress {
    private String name;
    private String addr;
    private String tel;

    public MyAddress() {}

    public MyAddress(String name) {
        this.name = name;
    }

    public MyAddress(String name, String addr, String tel) {
        this.name = name;
        this.addr = addr;
        this.tel = tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return String.format("이름: %s, 주소: %s, 전화번호: %s", name, addr, tel);
    }
}
