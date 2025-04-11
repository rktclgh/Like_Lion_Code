package Work.WorkShop13.exam8.shape;

public abstract class Shape implements Movable{

    protected Point point;
    public Shape(Point point) {}

    public Shape() {
    }
    public double getArea(){
        return 0;
    }

    public double getCircumference()
    {
        return 0;
    }

    public Point getPoint(int x, int y) {
        return this.getPoint(x,y);
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    public void move(int x, int y) {}


    @Override
    public String toString() {
        return "Shape{" +
                "point=" + point +
                '}';
    }
}
