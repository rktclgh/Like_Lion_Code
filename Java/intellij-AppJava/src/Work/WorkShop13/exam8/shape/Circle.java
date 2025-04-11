package Work.WorkShop13.exam8.shape;

public class Circle extends Shape implements Movable {

    private int radius;
    private Point point; // 필드 선언

    public Circle() {
        this.point = new Point(0, 0); // 기본 생성자에서 초기화
    }

    public Circle(int radius, int x, int y) {
        this.radius = radius;
        this.point = new Point(x, y); // 필드 초기화
    }

    public Circle(int radius) {
        this.radius = radius;
        this.point = new Point(0, 0); // 기본 값 설정
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void move(int x, int y) {
        if (this.point == null) {
            throw new IllegalStateException("point가 초기화되지 않았습니다.");
        }
        point.setX(point.getX() + x + 2);
        point.setY(point.getY() + y + 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", point=(" + point.getX() + ", " + point.getY() + ")" +
                '}';
    }
}
