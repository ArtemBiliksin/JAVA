import java.awt.*;

public class Circle extends Figure implements IShape{
    private double xCenter;
    private double yCenter;
    private double r;

    Circle(double xCenter, double yCenter, double r, Color color, double x, double y) throws RadiusValueException, PointPositionException {
        super("It is circle", color, x , y);
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        setR(r);

        if (this.pointOnCircle() != true) {
            throw new PointPositionException();
        }
    }

    private boolean pointOnCircle(){
        double d = (this.getXCenter() - this.getX()) *  (this.getXCenter() - this.getX()) + (this.getYCenter() - this.getY()) * (this.getYCenter() - this.getY());
        double error = d - this.getR() * this.getR();
        System.out.println(error);
        return Math.abs(error) < 0.001;
    }

    private void setR(double r) throws RadiusValueException{
        if (r > 0){
            this.r = r;
        }
        else{
            throw new RadiusValueException();
        }
    }

    public double square() {
        return Math.PI * this.getR() * this.getR();
    }

    public Color getColor(){
        return this.color;
    }

    public Vector2D tangent(){
        double x0 = this.getXCenter();
        double y0 = this.getYCenter();
        double x1 = this.getX();
        double y1 = this.getY();
        return new Vector2D(y0 - y1,x1 - x0);
    }

    public double perimeter() {
        return 2 * Math.PI * this.getR();
    }

    public String nameFigure(){
        return this.nameFigure;
    }

    public double getXCenter(){
        return this.xCenter;
    }

    public double getYCenter(){
        return this.yCenter;
    }

    public double getR(){
        return this.r;
    }
}
