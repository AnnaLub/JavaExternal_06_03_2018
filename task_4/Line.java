package task_4;

public class Line extends Dot {
    Point two;

    public Line(Point one, Point two) {
        super(one);
        this.two = two;
    }

    public Point getTwo() {
        return two;
    }

    @Override
    public String toString() {
        return "Line{"
                + this.getOne()+ two +
                '}';
    }
}
