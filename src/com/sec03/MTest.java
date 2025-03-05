package com.sec03;
//두개의 정수를 관리하는 클래스

class Test{
    //은닉된 멤버변수
    private int a;
    private int b;
    
    //setter -void
    public void setA(int a)
    {
    	this.a = a;
    }// 전달 및 변경 지역변수 a를 통해서 값을 전달 받아 this.a로 대입해서 값 전달 변경
    public void setB(int b)
    {
    	this.b = b;
    }
    //getter
    public int getA()
    {
    	return a;
    } //this.a 현재 멤버변수 값을 리턴
    public int getB()
    {
        return b;
    } //this.b
}




public class MTest {
	
	
	
	public static void main(String[] args) {
		
//		Test t1 = new Test();
//		t1.setA(100);
//		t1.setB(200);
//
//		System.out.println(t1.getA());
//		System.out.println(t1.getB());
//
//        t1.setA(1000);
//        System.out.println(t1.getA());


        Test m =  new Test();
        Test m1 = new Test();
        Test m2 = new Test();

        System.out.println("각 주소를 출력해보자");
        System.out.println(m.toString() +"\t"+m);
        System.out.println(m1.toString() +"\t"+m1);
        System.out.println(m2.toString() +"\t"+m2);

		///////할당된 초기값을 확인 -> 멤버 변수는 객체가 생성될 때 생성자에 의해서 초기값을 대입 후 메모리 할당된다.
        System.out.printf("m a = %5d m b = %5d\n ", m.getA(), m.getB());
        System.out.printf("m a = %5d m b = %5d\n ", m1.getA(), m1.getB());
        System.out.printf("m a = %5d m b = %5d\n ", m2.getA(), m2.getB());
	}

}
