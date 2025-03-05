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
class MyAddress
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


    public void prn()
    {



        System.out.printf("%10s %10s %10s\n", this.getName(), this.getAddr(), this.getTel());
    }
}





public class MTest01 {

    public static void main(String[] args) {



        MyAddress a1 = new MyAddress();
        MyAddress b1 = new MyAddress();
        MyAddress c1 = new MyAddress();

        a1.setName("홍길동");
        a1.setAddr("서울");
        a1.setTel("02-000-0000");

        b1.setName("정길동");
        b1.setAddr("인천");
        b1.setTel("032-000-0000");

        c1.setName("최길동");
        c1.setAddr("부산");
        c1.setTel("052-000-0000");

        System.out.println("=========주소록=========");
        a1.prn();
        b1.prn();
        c1.prn();

        /////
        System.out.println("Q1. 홍길동을 이길동으로 변경 후 a1을 출력해보자.  ");
        a1.setName("이길동");
        System.out.println(a1.getName());

        System.out.println("\nQ2. 인천을 제주도로 변경 후 정길동과 인천만 출력해보자.  ");

        b1.setAddr("제주도");
        System.out.printf(a1.getName(), a1.getAddr());

        System.out.println("\nQ3. 부산을 대구로 변경 후 이름과 대구를 출력해보자.  ");
        c1.setAddr("대구");
        System.out.printf(c1.getName(), c1.getAddr());

        System.out.println("\nQ4. 최길동의 전화번호를 000으로 변경 후 전체 c1의 레코드를 출력해보자  ");
        c1.setTel("000");
        c1.prn();
        System.out.println("\nQ5. 레코드의 3명의 이름만 출력해보자.  ");
        System.out.printf(a1.getName(), b1.getName(), c1.getName());


    }
}
