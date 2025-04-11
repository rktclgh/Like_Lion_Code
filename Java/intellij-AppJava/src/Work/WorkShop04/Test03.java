package Work.WorkShop04;

public class Test03 {

    public static void main(String[] args) {
        int[][] arr2 = {
                { 5, 5, 5, 5, 5},
                {10,10,10,10,10},
                {20,20,20,20,20},
                {30,30,30,30,30}
        };

        int tot = 0;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                tot+=arr2[i][j];
            }
        }

        double totLength = 0;
        for(int j = 0;j<arr2.length;j++)
        {
            totLength+=arr2[j].length;
        }

        double avg = tot/totLength;



        System.out.println("total = "+ tot);
        System.out.println("avg = "+ avg);
//        System.out.printf("avg = %.2f", avg);

    }
}
