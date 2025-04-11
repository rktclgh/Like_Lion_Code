package Work.WorkShop07.elite.test04;

public class Calc {
    public static double getSum(int data) throws InvalidException {

        if (data < 2 || data > 5) {
            throw new InvalidException("입력값에 오류가 있습니다.");
        }
        double sum = 0;

        for (int i = 1; i <= data; i++) {
            sum += (double) i;
        }

        return sum;
    }
}
