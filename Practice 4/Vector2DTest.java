import java.util.Scanner;


public class Vector2DTest {

    public static Vector2D stringToVector2D(String str){
        String[] strArray = str.split(" ");
        double x = Double.parseDouble(strArray[0]);
        double y = Double.parseDouble(strArray[1]);
        return new Vector2D(x,y);
    }

    public static void task1(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter point P coordinates: ");
        Vector2D pointP = stringToVector2D(sc.nextLine());

        System.out.println("Enter vector n coordinates: ");
        Vector2D vectorN = stringToVector2D(sc.nextLine());

        System.out.println("Enter point S coordinates: ");
        Vector2D pointS  = stringToVector2D(sc.nextLine());

        Vector2D searchPoint  = pointS.symmetricalPoint(pointP, vectorN);
        System.out.println("Symmetrical point for point S is point (x,y) = (" + searchPoint.getX() + ", " +
                searchPoint.getY() + ")");
    }

    public static void task2(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter point P coordinates: ");
        Vector2D pointP = stringToVector2D(sc.nextLine());

        System.out.println("Enter vector n coordinates: ");
        Vector2D vectorN = stringToVector2D(sc.nextLine());

        System.out.println("Enter point A coordinates: ");
        Vector2D pointA  = stringToVector2D(sc.nextLine());

        System.out.println("Enter point B coordinates: ");
        Vector2D pointB  = stringToVector2D(sc.nextLine());

        try{
            Vector2D searchPointX  = Vector2D.SearchX(pointP, vectorN, pointA, pointB);
            System.out.println("Point X = (" + searchPointX.getX() + ", " +
                    searchPointX.getY() + ")");
        }
        catch (PointsLieOnOneSideOfAStraightLineException e){
            e.message();
        }
        catch (VcollinearException e){
            e.messege();
        }
    }

    public static void task3(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter vector P coordinates: ");
        Vector2D vecP = stringToVector2D(sc.nextLine());

        System.out.println("Enter vector e1 coordinates: ");
        Vector2D vecE1 = stringToVector2D(sc.nextLine());

        System.out.println("Enter point e2 coordinates: ");
        Vector2D vecE2  = stringToVector2D(sc.nextLine());

        try{
            Vector2D XY = vecP.decomposition(vecE1, vecE2);
            System.out.println("x = " + XY.getX() + ", y = " + XY.getY());
        }
        catch (VcollinearException e){
            e.messege();
        }
    }



    public static void main(String[] args){
       //task1();
       //task2();
       //task3();
    }
}
