package Work.WorkShop04.book;

public class BookTest {

    public static void main(String[] args) {

// 3개의 Book 객체를 생성한다
// 각각의 Book 객체의 정보를 실행 결과 예와 같이 출력 한다.


        Book a = new Book("SQL Plus", 50000,5.0);
        Book b = new Book("Java 2.0", 40000,3.0);
        Book c = new Book("JSP Servlet", 60000,6.0);

//        System.out.printf("%14s %14s %14s %14s","책 이름", "가격", "할인율", "할인후금액\n");
//        System.out.println("------------------------------------------------------------------");
//        System.out.printf("%15s %15d %15.1f %15.1f\n",a.getBookName(),a.getBookPrice(), a.getDiscountRate(), a.getDiscountBookPrice());
//        System.out.printf("%15s %15d %15.1f %15.1f\n",b.getBookName(),b.getBookPrice(), b.getDiscountRate(), b.getDiscountBookPrice());
//        System.out.printf("%15s %15d %15.1f %15.1f\n",c.getBookName(),c.getBookPrice(), c.getDiscountRate(), c.getDiscountBookPrice());


        // 헤더 출력
        System.out.printf("%-20s %-15s %-10s %-20s\n", "책 이름", "가격", "할인율", "할인후금액");
        System.out.println("------------------------------------------------------------");

        // 각 책 정보 출력
        System.out.printf("%-20s %-15d %-10.1f %-20.1f\n", a.getBookName(), a.getBookPrice(), a.getDiscountRate(), a.getDiscountBookPrice());
        System.out.printf("%-20s %-15d %-10.1f %-20.1f\n", b.getBookName(), b.getBookPrice(), b.getDiscountRate(), b.getDiscountBookPrice());
        System.out.printf("%-20s %-15d %-10.1f %-20.1f\n", c.getBookName(), c.getBookPrice(), c.getDiscountRate(), c.getDiscountBookPrice());
    }
    }

