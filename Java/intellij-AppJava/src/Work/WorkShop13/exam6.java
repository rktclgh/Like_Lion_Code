package Work.WorkShop13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class exam6 {
    public static void main(String[] args) {

        System.out.println("10~20 숫자 입력");
//    int size = Integer.parseInt(args[0]);
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();

    ArrayList<Integer> list = new ArrayList<Integer>();
    HashSet<Integer> set = new HashSet<Integer>();
        Random random = new Random();

// ArrayList에 size만큼의 개수 만큼 랜덤한 숫자를 넣는다.
        for (int i = 0; i <size; i++) {
            int num = random.nextInt(10)+1;
            list.add(num);
        }


        for (int num : list) {
            System.out.print(num+ " ");
        }
// ArrayList에 정보를 HashSet에 넣는다.
        for (int num : list) {
            set.add(num);
        }


        System.out.println("hashset 출력: ");
        System.out.println(set);
}
}
