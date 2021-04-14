package Solution2;

import java.util.Scanner;

public class Vector2D extends Vector {

    Vector2D(double x, double y) {
        super(new double[]{x, y});
    }

    Vector2D(Vector v){
        super(v,2);
    }

    double getX() {
        return this.getComponent(0);
    }


    double getY() {
        return this.getComponent(1);
    }


    Vector2D prIsVector2D(Vector2D b) {
        Vector vec = b.multiply(this.pr(b) / b.len());
        return new Vector2D(vec.getComponent(0), vec.getComponent(1));
    }


    boolean pcollin(Vector2D v) {
        double det = this.getX() * v.getY() - this.getY() * v.getX();
        if (det == 0) {
            return true;
        } else {
            return false;
        }
    }


    Vector2D decomposition(Vector2D a, Vector2D b) throws VcollinearException {
        if (a.pcollin(b)) {
            throw new VcollinearException();
        } else {
            double a11 = a.getX();
            double a12 = b.getX();
            double a21 = a.getY();
            double a22 = b.getY();
            double pX = this.getX();
            double pY = this.getY();
            double det = a11 * a22 - a12 * a21;
            double x = (a22 * pX - a12 * pY) / det;
            double y = (- a21 * pX + a11 * pY) / det;
            return new Vector2D(x, y);
        }
    }


    public Vector2D symmetricalPoint(Vector2D p, Vector2D n) {
        // S is this
        //pointP.sub(this).getComponent(0);
        //Vector SPisVector = pointP.sub(this);
        //Vector2D SPisVector2D = new Vector2D(SPisVector.getComponent(0), SPisVector.getComponent(1));
        Vector2D SP = new Vector2D(p.sub(this));
        Vector2D pr = new Vector2D(SP.prIsVector2D(n).multiply(2));
        Vector2D symmetricalPoint = new Vector2D(this.add(pr));
        return symmetricalPoint;
    }

    public static Vector2D SearchX(Vector2D P, Vector2D n, Vector2D A, Vector2D B)
            throws PointsLieOnOneSideOfAStraightLineException, VcollinearException {

        Vector2D A1 = A.symmetricalPoint(P, n);
        Vector2D A1B = new Vector2D(B.sub(A1));
        Vector2D PA =  new Vector2D(A.sub(P));
        Vector2D PB =  new Vector2D(B.sub(P));
        if(Math.signum(n.scalar(PA)) == Math.signum(n.scalar(PB))){
            throw new PointsLieOnOneSideOfAStraightLineException();
        }
        else if(n.scalar(A1B) == 0){
           // System.out.println(n.scalar(A1B));
           // System.out.println(n.getX() * A1B.getX() + n.getY() * A1B.getY()) ;
           // System.out.println(n.getX() + ", " + n.getY());
          //  System.out.println(A1B.getX() + ", " + A1B.getY());
            throw new VcollinearException();
        }
        else{
            Vector2D AA1 = new Vector2D(A1.sub(A));
            double lenAA1 = AA1.len();
            double lenA1B = A1B.len();

            double cosAlpha = Math.abs(AA1.scalar(A1B)) / (lenAA1 * lenA1B);
           // System.out.println(AA1.scalar(A1B));
            //System.out.println(cosAlpha);
            double lenXA1 = lenAA1 / (2 * cosAlpha);
            Vector2D X1 = new Vector2D(A1.add(A1B.multiply(lenXA1 / lenA1B)));
            Vector2D X2 = new Vector2D(A1.add(A1B.multiply(- lenXA1 / lenA1B)));
            if(X1.sub(P).scalar(n) == 0){
                return X1;
            }
            else return X2;
        }
    }

    @Override
    public boolean equals(Object o) {
        Vector2D vector2D = (Vector2D) o;
        double epsilon = 0.000000000000000001;
        return Math.abs(this.getX() - vector2D.getX()) < epsilon &&
                Math.abs(this.getY() - vector2D.getY()) < epsilon;
    }
}
