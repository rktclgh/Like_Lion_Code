package com.sec01;

public class AddressInfo {
    private MyAddress address;
    private int age;

    public void setAddress(MyAddress address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printInfo() {
        System.out.println("[주소 정보]");
        System.out.println(address);
        System.out.println("나이: " + age);
    }
}
