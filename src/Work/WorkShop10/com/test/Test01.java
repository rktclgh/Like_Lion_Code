package Work.WorkShop10.com.test;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test01 {

    public static void main(String[] args) {

        int num = Integer.parseInt(args[0]);
        System.out.printf("정수를 입력하세요(5~10): "+num);
        try
        {
            num = Integer.parseInt(args[0]);
        }catch (NumberFormatException e)
        {
            System.out.println("다시 입력하세요");
            return;
        }

        if(num>10||num<5)
        {
            System.out.println("다시 입력하세요");
            return;
        }
        System.out.println();
        System.out.println("1부터 "+num+"까지의 숫자:");
        String numbers = IntStream.rangeClosed(1,num)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
        System.out.println(numbers);

        System.out.println("찍수 판별");
        IntStream.rangeClosed(1,num)
                .mapToObj(n->n+(n%2==0?"짝수 ":"홀수 "))
                .forEach(s->System.out.print(s+" "));
        System.out.println();

        System.out.println("입력 값: "+num);









    }
}
