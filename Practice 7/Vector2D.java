public class Vector2D {

    private double x;

    private double y;

    Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public Vector2D add(Vector2D other){
        return new Vector2D(this.getX() + other.getX(), this.getY() + other.getY());
    }

    public Vector2D mul(double k){
        return new Vector2D(this.getX() * k, this.getY() * k);
    }

    public Vector2D sub(Vector2D other){
        return this.add(other.mul(-1));
    }
}
