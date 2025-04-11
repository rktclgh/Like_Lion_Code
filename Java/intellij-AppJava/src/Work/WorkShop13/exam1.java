package Work.WorkShop13;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class exam1 {


    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));

        }

        System.out.println(set);
    }
}
