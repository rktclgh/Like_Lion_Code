package com.work02.sec01;

import java.util.List;

public class StudentService {

    private List<Student> students;

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public void printAllInfo()
    {
        for (Student student : students) {
            System.out.printf("이름: %s, 나이: %d, 키: %d, 몸무게: %d\n",
                    student.getName(),student.getAge(),student.getHeight(),student.getWeight() );
        }
    }

    public void printStats()
    {
        double avgHeight = students.stream().mapToInt(Student::getHeight).average().orElse(0);
        double avgWeight = students.stream().mapToInt(Student::getWeight).average().orElse(0);

        System.out.printf("평균 키: %.1fcm, 평균 몸무게: %.1fkg\n", avgHeight, avgWeight);
    }


}
