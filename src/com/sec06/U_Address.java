package com.sec06;

import java.util.Objects;

/*
*   MyAddress
* name, addr, tel
*   이름  주소  전번
* -----------------
* 홍길동   서울  02-000-0000  a1
* 정길동   인천  031-000-0000  b1
* 최길동   부산  052-000-0000  c1
*
* */
class U_Address
{
    //멤버변수 은닉화
    private String name;
    private String addr;
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public U_Address(String name, String addr, String tel) {
        this.name = name;
        this.addr = addr;
        this.tel = tel;
    }
    public U_Address()
    {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        U_Address uAddress = (U_Address) o;
        return Objects.equals(name, uAddress.name) && Objects.equals(addr, uAddress.addr) && Objects.equals(tel, uAddress.tel);
    }

//    @Override
//    public boolean equals(Object o) {
//        U_Address other  = (U_Address) o;
//        return Objects.equals(this.name, other.name);
//        // 이름만 비교
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, addr, tel);
    }

    @Override
    public String toString() {
        return "U_Address{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public static void main(String[] args) {
        U_Address a1 = new U_Address("홍길동", "111","111");
        U_Address a2 = new U_Address("홍길동", "22","22");

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1.equals(a2));

    }


}





