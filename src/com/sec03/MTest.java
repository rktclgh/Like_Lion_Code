package com.sec03;


class Test{
    private int a;
    private int b;
    
    //setter -void
    public void setA(int a)
    {
    	this.a = a;
    }
    public void setB(int b)
    {
    	this.b = b;
    }
    //getter
    public int getA()
    {
    	return a;
    }
    public int getB()
    {
        return b;
    }
}




public class MTest {
	
	
	
	public static void main(String[] args) {
		
		Test t1 = new Test();
		t1.setA(100);
		t1.setB(200);
		
		System.out.println(t1.getA());
		System.out.println(t1.getB());

		
	}

}
