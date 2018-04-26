package task_4;

public class Rectangle extends Triangle {
    Point four;

    public Rectangle(Point one, Point two, Point three, Point four) {
        super(one, two, three);
        this.four = four;
    }

    @Override
    public String toString() {
        return "Rectangle{" + this.getOne()+this.getTwo()+
                this.getThree()+ four +
                '}';
    }
}
