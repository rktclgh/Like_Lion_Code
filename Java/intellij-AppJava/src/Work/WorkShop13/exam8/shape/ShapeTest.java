package Work.WorkShop13.exam8.shape;

import java.util.ArrayList;

public class ShapeTest {
    public static void main(String[] args) {

        // ArrayList를 만들어 [1.사용데이터 ]의 객체의 순서대로 Circle 객체 와 Rectangle객체 를 생성 하여 넣는다
        ArrayList<Shape> shapes = new ArrayList<>();
        Rectangle r1 = new Rectangle(4,7,5);
        Rectangle r2 = new Rectangle(5,4,6);
        Circle c1 = new Circle(6,6,7);
        Circle c2 = new Circle(7,8,3);
        shapes.add(r1);
        shapes.add(r2);
        shapes.add(c1);
        shapes.add(c2);


        // 모든 객체의 넓이 정보와 둘레 정보를 화면에 출력 한다.– for 문 이용
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            System.out.println(shape.getArea());
            System.out.println(shape.getCircumference());
        }


        // 모든 객체들에 move()함수를 이용하여 x가 10증가 , y가 10증가 되도록 변경 한 후 객체 정보를 화면에 출력 한다.– for 문 이용


        for (Shape shape : shapes) {
            shape.move(10,10);
            shape.toString();
        }
    }
}
