package Work.WorkShop04;

public class Test02 {
    public static void main(String[] args) {

        int [] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        //case1
        int sum = 0;
//        for(int i=0;i<arr.length;i++){
//            if(!(i%2==0)){
//                sum+=arr[i];
//            }
//
            for(int i=0;i<arr.length;i++){
            if((i&1)==1){
                sum+=arr[i];
            }
        }
        System.out.println("sum = "+ sum);
    }
}
