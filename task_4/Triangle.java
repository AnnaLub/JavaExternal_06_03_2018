package task_4;

public class Triangle extends Line {
    Point three;

    public Triangle(Point one, Point two, Point three) {
        super(one, two);
        this.three = three;
    }

    public Point getThree() {
        return three;
    }

    @Override
    public String toString() {
        return "Triangle{" + this.getOne()
                +this.getTwo()+ three +
                '}';
    }

}
