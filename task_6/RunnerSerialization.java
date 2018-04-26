package task_6;

import java.io.File;
import java.io.InvalidObjectException;

public class RunnerSerialization {
    public static void main(String[] args) {
        Polygon polygon = new Polygon(new Point(1,1),new Point(2,2),new Point(3,3));
        System.out.println(polygon);
        String file = "polygon.txt";
        Serializator sz = new Serializator();
        boolean b = sz.serialization(polygon, file);
        Polygon res = null;
        try{
            res = sz.deserialization(file);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
}
