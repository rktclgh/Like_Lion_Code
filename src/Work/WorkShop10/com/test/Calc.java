package Work.WorkShop10.com.test;

import java.util.stream.IntStream;

public class Calc {

public int calculate(int data)
{
    return IntStream.rangeClosed(1,data)
            .filter(n->n%2==0)
            .sum();
}
}
