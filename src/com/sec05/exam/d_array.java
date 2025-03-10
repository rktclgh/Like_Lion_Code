package com.sec05.exam;

public class d_array {
    public static void main(String[] args) {
        Test();
    }


    private static void Test()
    {
        //동적할당
        int ar02[] = new int[10];
        //배열의 주소를 넘겨서 메소드에서 출력 해보자.
        Prn(ar02);

        //값을 채우자
        for(int i=0; i<ar02.length;i++)
        {
            ar02[i]=i+1;
        }
        //값채우고 출력
        Prn(ar02);
        //역순으로 출력
        reversePrn(ar02);

    }

    private static void Prn(int[] ar) {
        System.out.println("===  반복 for 문  출력 ===");
        for(int i = 0; i< ar.length; i++)
        {
            System.out.println(ar[i]);
        }
    }

    private static void reversePrn(int [] ar)
    {
        System.out.println("=== 역순 출력 ===");
       for(int i= ar.length-1; i>=0; i--)
           System.out.println(ar[i]);
    }



}
