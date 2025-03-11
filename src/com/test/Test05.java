package com.test;

// class Person
//{
//    String name;
//    int age;
//
//    public Person(String name, int age)
//    {
//        this.name = name;
//        this.age = age;
//    }
//
//    void display()
//    {
//        System.out.println("이름: "+name+ ", 나이: "+age);
//
//    }
//
//
//}

record Person(String name, int age)
{
    void display()
    {
        System.out.println("이름: "+name+"  나이: "+age);
    }

}




public class Test05 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("홍길동", 25);
        people[1] = new Person("이순신" , 30);
        people[2] = new Person("강감찬" , 35);
        System.out.println("people의 주소 :"+ people );
        for (Person person : people) {
            person.display();
        }
    }

}
