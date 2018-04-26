package task_6;

import java.io.Serializable;

public class Line implements Serializable{
    private static final long serialVersionUID = 1451403401495183808L;
    private Point begin;
    private Point end;


    public Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }
    public boolean contains(Point point){
        double maxX = begin.getX()>end.getX()? begin.getX() : end.getX();
        double minX = begin.getX()<end.getX()? begin.getX() : end.getX();
        double maxY = begin.getY()>end.getY()? begin.getY() : end.getY();
        double minY = begin.getY()<end.getY()? begin.getY() : end.getY();
        if((point.getX()<=maxX&&point.getX()>=minX)&&(point.getY()<=maxY&&point.getY()>=minY)){
            return true;
        }
        return false;
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }


    @Override
    public String toString() {
        return "Line{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
