package task_5;

import java.util.Arrays;

/* создать класс Polygon для описания фигур разной размерности */
public class Polygon {

   private Point[] points;
   private Line [] lines;
   private int index;


    public Polygon(Point...po) {
        this.index = -1;
        points = new Point[1];
        lines = new Line[1];
        for (Point point : po) {
            if (index < points.length - 1) {
                points[++index] = point;
            } else {
                int newSize = points.length + 1;
                Point[] temporaryArray = new Point[newSize];
                System.arraycopy(points, 0, temporaryArray, 0, points.length);
                points = temporaryArray;
                points[++index] = point;
            }
        }
        addLine();
    }


    public int size(){
        return points.length;
    }


    /*Добавляет указанные координаты к этому Polygon*/
    public void addPoint(Point point){
        if(index<points.length-1){
            points[++index]=point;
        }else {
            int newSize = points.length + 1;
            Point[] temporaryArray = new Point[newSize];
            System.arraycopy(points, 0, temporaryArray, 0, points.length);
            points = temporaryArray;
            points[++index]=point;
            addLine();
        }
    }

    public void addLine() {
        int indx = 0;
        lines = new Line[points.length];
        for (int i = 0; i <points.length-1; i++) {
            lines[++indx]=new Line(points[i],points[i+1]);
        }
        lines[0]=new Line(points[0],points[points.length-1]);
    }


    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + Arrays.toString(points) +
                ", lines=" + Arrays.toString(lines) +
                '}';
    }
}
