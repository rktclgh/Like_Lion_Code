package Work.WorkShop07.elite.test02;

public class StudentTest {
    public static void main(String[] args) {
        Student arrays [] = new Student[3];
        // Student 객체를 3개 생성하여 배열에 넣 는다.
        // 배열에 있는 객체 정보를 모두 출력한다.– for 문을 이용 할 것

        arrays[0] = new Student("홍길동",15,171,81,"201101","영문");
        arrays[1] = new Student("한사람",13,183,72,"201102","건축");
        arrays[2] = new Student("임걱정",16,175,65,"201103","무용");

        for (Student array : arrays) {
            System.out.println(array.printInformation());
        }

    }
}
