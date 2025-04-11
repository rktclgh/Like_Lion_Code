package com.sec03;
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

    @Override
    public String toString() {
        return "U_Address{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public static void main(String[] args) {
        U_Address a1 = new U_Address();
        U_Address b1 = new U_Address();
//        a1.prn();
//        b1.prn();


        System.out.println(a1);
        System.out.println(b1);
    }


}





