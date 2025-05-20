package workshop.test05;

import org.springframework.stereotype.Component;

@Component("student05")
public class Student implements Person {

    public Student() {
        System.out.println("기본 생성자");
    }

    @Override
    public void classWork() {
        System.out.println("[학생] classwork");
    }

    @Override
    public void homework() {
        System.out.println("[학생] 과제 수행 중");
    }

    @Override
    public void meeting(String topic) {
        System.out.println("[학생] meeting"+ topic);
    }

    @Override
    public void study()
    {
        System.out.println("[학생] 공부하는 중입니다.");
    }


    public void relax()
    {
        System.out.println("[학생] relax");
    }


    @Override
    public void eat(String food)
    {
        System.out.println("[학생]"+food+"먹는 중..");
    }

    @Override
    public int getScore()
    {

        System.out.println("[학생] 점수 조회 중...");
        return 100;
    }

}
