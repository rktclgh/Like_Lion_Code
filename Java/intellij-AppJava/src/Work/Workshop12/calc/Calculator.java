package Work.Workshop12.calc;

public class Calculator {
    public double plus(int a, int b) {
        return a + b;
    }
    public double minus(int a, int b) {
        return a - b;
    }
    public double multiplication(int a, int b){
        return a * b;
    }
    public double divide(int a, int b) {

        if(a ==0 ||b ==0)
            throw new ArithmeticException();
        return a / b;

    }
}
