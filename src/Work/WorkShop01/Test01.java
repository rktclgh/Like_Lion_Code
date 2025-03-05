package Work.WorkShop01;

public class Test01 {
    public static void main(String[] args) {


        int a =100;
        double b = 3.14;
        char c = 'A';
        boolean d = true ;


        System.out.println("정수형 변수의 값은 "+ a + "이며, 자료형은 "+((Object)a).getClass().getSimpleName()+" 입니다");
        System.out.println("문자형 변수의 값은 "+ c + "이며, 자료형은 "+((Object)c).getClass().getSimpleName()+" 입니다");
        System.out.println("실수형 변수의 값은 "+ b + "이며, 자료형은 "+((Object)b).getClass().getSimpleName()+" 입니다");
        System.out.println("논리형 변수의 값은 "+ d + "이며, 자료형은 "+((Object)d).getClass().getSimpleName()+" 입니다");
    }
    //dd
}
