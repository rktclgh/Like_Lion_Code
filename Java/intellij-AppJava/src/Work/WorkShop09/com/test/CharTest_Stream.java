package Work.WorkShop09.com.test;

import java.util.Optional;

public class CharTest_Stream {
    public static void main(String[] args) {


        Optional.ofNullable(args[0])
                .map(str -> new StringBuilder(str).reverse().toString().toUpperCase())
                .ifPresent(reversed -> System.out.print(reversed));
    }
}
