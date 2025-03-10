package com.sec03;

public class MScore {

    public static void main(String[] args) {
//        U_Score a1 = new U_Score ("홍길동", 100, 100, 100)   ;
//        U_Score b1 = new U_Score ("정길동", 90, 90, 90)   ;
//        U_Score c1 = new U_Score ("박길동", 80, 80, 80)   ;

    U_Score [] score = new U_Score[]{
          new U_Score("홍길동", 100, 100, 100),
          new U_Score("정길동", 90, 90, 90),
          new U_Score("박길동", 80, 80, 80)
    };

        for (U_Score uScore : score) {
            System.out.println(uScore);
        }

        System.out.println("박길동 찾아서 전체 점수를 100으로 세팅 후 출력하자.");
        for (U_Score uScore : score) {
            if(uScore.getName().trim().equals("박길동"))
            {
                uScore.setKor(100);
                uScore.setEng(100);
                uScore.setMat(100);
                System.out.println(uScore);
            }
        }
}}
