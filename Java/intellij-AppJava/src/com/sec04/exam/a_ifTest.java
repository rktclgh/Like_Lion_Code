package com.sec04.exam;

public class a_ifTest {


    public static void main(String[] args) {


        System.out.println("만약 a가 0보다 크면 \"양수\" 출력");
        var a =100;
        if(a>0){
            //결과가 true 명령을 수행한다.
            System.out.println(a);
        }


        System.out.println("만일에 a가 0보다 크면 \"양수\" 출력, 그렇지 않으면 \"아니잖아!\"");

        if(a>0) {
            System.out.println(a);

        }
        else
        {
            System.out.println("아니잖아!");
        }




    }
}
