package Work.WorkShop10.com.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요(5~10): ");
        int num = scanner.nextInt();
        if (num < 5 || num > 10) {
            System.out.println("다시 입력하세요");
            return;
        }

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        //1부터 ~까지의 숫자 배열에 넣기
        int []arr = new int[num];
        for (int i = 0; i <num; i++)
            arr[i] = i+1;
        System.out.printf("1부터 %d까지의 숫자", num);
        for (int i : arr) {
            System.out.print(i+" ");
        }

        System.out.println();

        //짝수판별 시작

        for (int i : arr) {
            if(i%2==0) {
                System.out.print(i + "(찍수) ");
                even.add(i);
            }
            else
                System.out.print(i+"(홀수) ");
                odd.add(i);

        }

        //입력값
        System.out.println("입력값: "+num);

        //짝수 리스트
        even.forEach(System.out::print);
        //짝수 개수
        System.out.println("짝수 개수: "+even.size());
        //짝수 중 가장 큰 값
        int max=0;
        int min=0;
        for (Integer i : even) {
            if(i>max)
                max=i;
            else if(i<min)
                min=i;
        }

        //짝수의 합

        int sum=0;
        for (Integer i : even) {
            sum+=i;
        }

        System.out.println("짝수 중 가장 큰 값: "+max);
        System.out.println("짝수 중 가장 작은 값: "+min);
        System.out.println("짝수의 합: "+sum);


    }









    }

