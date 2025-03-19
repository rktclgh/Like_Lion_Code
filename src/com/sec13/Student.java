package com.sec13;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {


    private String name;
    private static int age; //직렬화 대상 아님
    private int height;
    private int weight;

    public Student(String name, int age, int height, int weight) {
        this.name = name;
        Student.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Student() {
    }

    public String studentInfo()
    {
        return "Name: " + name + ", Age: " + age + ", Height: " + height + ", Weight: " + weight;
    }
    @Override
    public String toString()
    {
        return
                String.format("%10s %5d %5d %5d\n", this.getName(),Student.age,this.getHeight(),this.getWeight());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
