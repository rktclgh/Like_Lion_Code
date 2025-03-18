package Work.WorkShop09.com.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentTest {
    public static void main(String[] args) {
// Student 객체를 3개 생성하여 배열에 넣는다 List<Student> students 로 받 는 다.

        Student a = new Student("홍길동",15,170,80);
        Student b = new Student("한사람",13,180,70);
        Student c = new Student("이순신",16,175,65);

        List<Student> students = new ArrayList<>();

        students.add(a);
        students.add(b);
        students.add(c);


// 배열에 있는 객체 정보를 모두 출력 한다 – for문을 이용할 것 , studentInfo 함수 사용
        for (Student student : students) {
            student.studentInfo();
        }

// Student 객체들의 나이의 평균 출력
        double avgAge = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
        System.out.printf("avgAge = %.3f" , avgAge);
        System.out.println();
// Student 객체들의 신장의 평균 출력

        double avgHeight = students.stream()
                .mapToInt(Student::getHeight)
                .average()
                .orElse(0.0);
        System.out.printf("avgHeight = %.3f" , avgHeight);
        System.out.println();
// Student 객체들의 몸무게의 평균 출력
        double avgWeight = students.stream()
                .mapToInt(Student::getWeight)
                .average()
                .orElse(0.0);
        System.out.printf("avgWeight = %.3f" , avgWeight);
        System.out.println();
// 학생들 중 나이가 가장 적은 학생과 많은 학생 출력
        Optional<Student> oldest = students.stream().reduce((i, k) -> i.getAge() > k.getAge() ? i : k);
        oldest.ifPresent(s->System.out.println("제일 늙은 사람: "+s.getName()));

        Optional<Student> youngest = students.stream().reduce((i, k) -> i.getAge() < k.getAge() ? i : k);
        youngest.ifPresent(s->System.out.println("제일 어린 사람: "+s.getName()));
// 학생들 중 신장이 가장 적은 학생과 큰 학생 출력
        Optional<Student> tallest = students.stream().reduce((i, k) -> i.getHeight() > k.getHeight() ? i : k);
        tallest.ifPresent(s->System.out.println("제일 큰 사람: "+s.getName()));

        Optional<Student> shortest = students.stream().reduce((i, k) -> i.getHeight() < k.getHeight() ? i : k);
        shortest.ifPresent(s->System.out.println("제일 작은 사람: "+s.getName()));
// 학생들 중 몸무게가 가장 적은 학생과 많이 나가는 학생 출력
        Optional<Student> heavy = students.stream().reduce((i, k) -> i.getWeight() > k.getWeight() ? i : k);
        heavy.ifPresent(s->System.out.println("제일 무거운 사람: "+s.getName()));

        Optional<Student> light = students.stream().reduce((i, k) -> i.getWeight() < k.getWeight() ? i : k);
        light.ifPresent(s->System.out.println("제일 가벼운 사람: "+s.getName()));


    }


}
