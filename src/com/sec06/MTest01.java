package com.sec06;

record Person(String name, int age) {}
public class MTest01 {


    public static void main(String[] args) {


        Person[] people = {
                new Person("Alice", 30), new Person("Bob", 30)
        };

        prn(people);
//        prn(people02);
    }

    private static void prn(Person[] people) {
        for (Person person : people) {
            System.out.println(person); // person.toString
        }
        System.out.println();
    }

}
