package task_4;

public class Main {
    public static void main(String[] args) {
       DynamicArray array = new DynamicArray();
       Dot dot = new Dot(new Point(1,1));
       Line line1 = new Line(new Point(2,2),new Point(3,3));
       Line line2 = new Line(new Point(4,2),new Point(2,4));
       Triangle triangle = new Triangle(new Point(1,1),new Point(2,2),new Point(3,3));
       Rectangle rect1 = new Rectangle(new Point(1,1),new Point(2,2),new Point(3,3),new Point(4,4));
       Rectangle rect2 = new Rectangle(new Point(5,5),new Point(6,6),new Point(7,7),new Point(8,8));
       array.addElement(dot);
       array.addElement(line1);
       array.addElement(line2);
       array.addElement(triangle);
       array.addElement(rect1);
       array.addElement(rect2);

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.getElement(i));
        }






    }
}
