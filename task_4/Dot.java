package task_4;

public class Dot extends Figure{

    public Dot(Point one) {
        super(one);
    }
    @Override
    public String toString() {
        return "Dot{" +
                this.getOne() +
                '}';
    }
}
