package Work.WorkShop04.student;

public class Test05 {

    public static void main(String[] args) {
        // Student 객체를 3개 생성 한다.
// 각각의 객체의 평균과 학점을 화면에 출력 한다.

        Student a = new Student("kim",100,90,95,89);
        Student b = new Student("Lee", 60, 70, 99, 98);
        Student c = new Student("Park", 68,86,60,40);
        System.out.printf("%s 평균: %.2f 학점: %s학점\n", a.getName(),a.getAvg(), a.getGrade());
        System.out.printf("%s 평균: %.2f 학점: %s학점\n", b.getName(),b.getAvg(), b.getGrade());
        System.out.printf("%s 평균: %.2f 학점: %s학점\n", c.getName(),c.getAvg(), c.getGrade());
    }

}
