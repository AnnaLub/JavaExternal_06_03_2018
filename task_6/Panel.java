package task_6;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
   private task_6.Polygon[] polygon;


    public Panel(Polygon[] polygons) {
        this.polygon = polygons;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        for (int i = 0; i <polygon.length; i++) {
            for (int j = 0; j <polygon[i].size(); j++) {
                g.drawLine(this.polygon[i].getLine(j).getBegin().getX(),this.polygon[i].getLine(j).getBegin().getY(),
                        this.polygon[i].getLine(j).getEnd().getX(),this.polygon[i].getLine(j).getEnd().getY());
            }
        }
    }
}
