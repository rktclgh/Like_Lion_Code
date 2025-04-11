package Work.WorkShop13.exam2;

import java.util.ArrayList;
import java.util.Random;

public class MakeList {
ArrayList<Integer> list;
    public MakeList() {
        // ArrayList 생성
        list = new ArrayList<>();
    }

    public void makeArrayList(int size) {// ArrayList 생성
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(10) + 10;  // 10 ~ 19
            list.add(num);
        }
    }

    public double getAverage()
    {
        // ArrayList의 모든 값의 평균을 계산 하여 리턴
        if (list == null || list.isEmpty())
            return 0.0;

        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return (double) sum / list.size();


    }

    public ArrayList<Integer> getList()
    {
        // ArrayList를 리턴

        return list;
    }

}

