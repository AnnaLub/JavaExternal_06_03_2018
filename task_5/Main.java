package task_5;

public class Main {
    public static void main(String[] args) {
      Polygon polygon = new Polygon(new Point(1,1), new Point(2,2),new Point(3,3),new Point(4,4));
      Polygon poly = new Polygon();
  /*    polygon.addPoint(new Point(2,2));
      polygon.addPoint(new Point(1,1));
      polygon.addPoint(new Point(3,3));
      polygon.addPoint(new Point(4,4));*/
        System.out.println(polygon.toString());
        polygon.addPoint(new Point(5,5));
        System.out.println(polygon.toString());
        System.out.println(poly.toString());
    }
}
