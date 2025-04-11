package Work.WorkShop13.exam8.shape;

public class Rectangle extends Shape implements Movable {

    private int width;
    private Point point; // 필드 선언

    public Rectangle() {
        this.point = new Point(0, 0);  // 기본 생성자에서 초기화
    }

    public Rectangle(int width, int x, int y) {
        this.width = width;
        this.point = new Point(x, y);  // 필드에 값을 할당해야 함
    }

    public Rectangle(int width) {
        this.width = width;
        this.point = new Point(0, 0);  // 기본 값 설정
    }

    @Override
    public double getCircumference() {
        return 4 * width;
    }

    @Override
    public double getArea() {
        return width * width;
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
        return "Rectangle{" +
                "width=" + width +
                ", point=(" + point.getX() + ", " + point.getY() + ")" +
                '}';
    }
}
