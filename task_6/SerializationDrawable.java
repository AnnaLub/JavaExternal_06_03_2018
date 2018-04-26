package task_6;

import javax.swing.*;
import java.awt.*;
import java.io.InvalidObjectException;

public class SerializationDrawable {

    public static void main(String[] args) {

        Polygon figure1 = new Polygon(new Point(100,300),new Point(100,200),new Point(200,200),new Point(200,300));
        /*System.out.println(figure1.toString());*/
        Polygon figure2 = new Polygon(new Point(100,200),new Point(150,150),new Point(200,200));
        /*System.out.println(figure2.toString());*/
        Polygon figure3 = new Polygon(new Point(150,300),new Point(150,250),new Point(175,250),new Point(175,300));
        /*System.out.println(figure3.toString());*/
        String file1 = "figure1.txt";
        String file2 = "figure2.txt";
        String file3 = "figure3.txt";
        Polygon [] result = new Polygon[3];

        Serializator sz = new Serializator();
        boolean b1 = sz.serialization(figure1,file1);
        boolean b2 = sz.serialization(figure2,file2);
        boolean b3 = sz.serialization(figure3,file3);

        try{
            result[0]=sz.deserialization(file1);
            System.out.println(result[0].toString());
            result[1]=sz.deserialization(file2);
            System.out.println(result[1].toString());
            result[2]=sz.deserialization(file3);
            System.out.println(result[2].toString());
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
        Frame frame = new JFrame();
        Panel panel = new Panel(result);
        frame.add(panel);
        frame.setTitle("This is POLYGON!!!");
        frame.setSize(400,400);
        frame.setLocation(100,100);
        frame.setBackground(Color.CYAN);
        frame.setVisible(true);

    }
}
