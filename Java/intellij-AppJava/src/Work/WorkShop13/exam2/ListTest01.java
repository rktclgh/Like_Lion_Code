package Work.WorkShop13.exam2;

import java.util.ArrayList;
import java.util.Scanner;



public class ListTest01 {
    public static void main(String[] args) {
// argument로 정수를 받는다.
        System.out.println("5-10 숫자 입력");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

// MakeList 객체 생성
        MakeList makeList = new MakeList();

// 무작위의 번호 발생 후 저장
        makeList.makeArrayList(size);
        ArrayList<Integer> list = makeList.getList();
// for문을 이용하여 ArrayList의 정보 출력하고 평균을 출력 한다.
        System.out.println("랜덤 생성 숫자 리스트:");
        for (int num : list) {
            System.out.println(num+ " ");
        }
// 평균 출력

        System.out.printf("\n평균: %.2f", makeList.getAverage());
    }
}
