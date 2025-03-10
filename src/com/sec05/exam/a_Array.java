package com.sec05.exam;

public class a_Array {

    public static void main(String[] args) {
        Test();
    }


    private static void Test()
    {
        int [] ar = {10,20,30,40,50};
        int ar02[] = {10, 20, 30, 40,50,60,70,80,90,100};
//        System.out.println("=== case 01 ar 직접 출력 ===");
//        System.out.println(ar[0]);
//        System.out.println(ar[1]);
//        System.out.println(ar[2]);
//        System.out.println(ar[3]);
//        System.out.println(ar[4]);
        System.out.println("=== ar출력 ===");
        Prn(ar);

        iter(ar);


    }
    private static void Prn(int[] ar) {
        System.out.println("===  반복 for 문  출력 ===");
        for(int i = 0; i< ar.length; i++)
        {
            System.out.println(ar[i]);
        }
    }

    private static void iter(int[] ar) {
        System.out.println("===  for each 출력 ===");

        for (int i : ar) {
            System.out.println(i);
        }
    }



}
