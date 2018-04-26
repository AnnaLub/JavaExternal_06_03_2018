package task_4;

public class Figure {
    private Point one;

    public Figure(Point one) {
        this.one = one;
    }

    public Point getOne() {
        return one;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "one=" + one +
                '}';
    }


}
