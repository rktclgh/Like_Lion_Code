package Work.WorkShop09.com.test;

import java.util.Scanner;

public class CharTest {

    public static void main(String[] args) {


//        Scanner scanner = new Scanner(System.in);
//        String sr = scanner.nextLine();
//        char[] ch = sr.toUpperCase().toCharArray();
//
//
//
//        String res = new StringBuilder(new String(ch)).reverse().toString();
//        System.out.println(res);

        if (args == null || args.length == 0 || args[0] == null) {
            System.out.println("Err: args is null or empty!");
            return;
        }

        int argsL = args[0].length();

        char[] charArray = new char[argsL];

        for (char e : args[0].toCharArray()) {

        }

        for (int i = 0; i < argsL ; i++) {
            char c = args[0].charAt(i);
            charArray[i] = Character.toUpperCase(c);
        }




        for (int i = argsL - 1; i >= 0; i--) {
            System.out.print(charArray[i]);
        }
    }
    }



