import java.awt.*;

abstract class Figure {
    protected String nameFigure;
    private double x;
    private double y;
    protected Color color;

    Figure(String nameFigure, Color color, double x, double y) {
        this.nameFigure = nameFigure;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    protected double getX(){
        return this.x;
    }

    protected double getY(){
        return this.y;
    }
}