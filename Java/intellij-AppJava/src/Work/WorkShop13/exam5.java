package Work.WorkShop13;
import java.util.ArrayList;
import java.util.Random;
public class exam5 {
    public static void main(String[] args) {


        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            list1.add(rand.nextInt(10));
            list2.add(rand.nextInt(10));
        }

        for(int i = 0; i < 10; i++){
        // 두 개의 ArrayList에 랜덤하게 0~9까지의 정수를 입력 한다
            int a = list1.get(i);
            int b = list2.get(i);

            try
            {
                int res = a/b;
                System.out.println(a+"/"+b+"="+res);
            }catch (ArithmeticException e)
            {
                System.out.println(a+"/"+b+" 분모가 0입니다");
            }
        }
    }
}
