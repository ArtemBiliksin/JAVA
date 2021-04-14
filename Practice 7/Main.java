import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void suggestСolors(){
        System.out.println("Choose a color:");
        String[] nameColors = new String[]{"black", "blue", "red", "green"};
        for (int i = 0; i < nameColors.length; i++){
            System.out.println(""+ (i+1) + ":" + nameColors[i]);
        }
    }

    public static void main(String[] args) {
        try{
            /*
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the coordinates of the center of the circle:");
            System.out.print("xCenter = ");
            double xCenter = sc.nextDouble();
            System.out.print("yCenter = ");
            double yCenter = sc.nextDouble();
            System.out.println("Enter the radius of the circle:");
            System.out.print("r = ");
            double r = sc.nextDouble();
            suggestСolors();
            Color[] colors = new Color[]{Color.black, Color.blue, Color.red, Color.green};
            int i = sc.nextInt();



            System.out.println("Enter the coordinates of the point from the circle:");
            System.out.print("x_1 = ");
            double x_1 = sc.nextDouble();
            System.out.print("y_1 = ");
            double y_1 = sc.nextDouble();
         */
            double xCenter = 1;
            double yCenter = 0;
            double r = 5;
            double x_1 = 4;
            double y_1 = 4;
            //Circle circle = new Circle(xCenter, yCenter, r, colors[i-1], x_1, y_1);

            Circle circle = new Circle(xCenter, yCenter, r, Color.red, x_1, y_1);
            new GraphicsCoord(circle);

        }catch (RadiusValueException|PointPositionException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
