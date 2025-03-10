package Work.WorkShop04.calculator;

import java.util.ArrayList;
import java.util.List;

public class Test04 {

    public static void main(String[] args) {

//        List<int[]> list = new ArrayList<>();

        int [] scores = new int[4];
//        for (int score : scores) {
//            score+=Integer.parseInt(args[score]);
//        }

        for (int i = 0; i < args.length; i++) {
            scores[i] = Integer.parseInt(args[i]);
        }

        for (int score : scores) {
            System.out.println(score);
        }

    }
}
