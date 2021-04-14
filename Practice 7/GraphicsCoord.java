import java.awt.*;
import javax.swing.JFrame;

public class GraphicsCoord extends JFrame {
    private Circle circle;
    private Vector2D point;
    private Vector2D vectorOfDerivative;
    private Graphics2D gr2d;
    private final int scale = 20;

    public GraphicsCoord(Circle circle) {
        super("simpleApp");
        this.circle = circle;
        this.point =  new Vector2D(circle.getX(), circle.getY());
        this.vectorOfDerivative = circle.tangent();
        setSize(700, 600);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        gr2d = (Graphics2D) g;
        drowAxis();
        drowCircle();
        drowPoint();
        drowDerivative();
    }

    public void drowAxis(){
        // Рисуем оси координат
        gr2d.setPaint(Color.BLUE);
        gr2d.drawLine(0, 300, 700, 300);
        gr2d.drawLine(350, 0, 350, 600);
        //Рисуем метки на осях координат

        gr2d.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        for (int i = 1; i < 17; i++) {
            gr2d.drawLine(350 + i * scale, 295, 350 + i * scale, 305);
            gr2d.drawString(i + "", 351 + i * scale, 310);
            gr2d.drawLine(350 - i * scale, 295, 350 - i * scale, 305);
            gr2d.drawLine(345, 300 + i * scale, 355, 300 + i * scale);
            gr2d.drawLine(345, 300 - i * scale, 355, 300 - i * scale);
            gr2d.drawString(i + "", 352, 300 - i * scale);
        }
    }

    public void drowDerivative(){
        int t = 8;
        Vector2D p1 = point.add(vectorOfDerivative.mul(t));
        Vector2D p2 = point.add(vectorOfDerivative.mul(-t));
        gr2d.drawLine((int)(350 + p1.getX() * scale), (int)(300 - p1.getY() * scale),
                (int)(350 + p2.getX() * scale), (int)(300 - p2.getY() * scale));
    }

    public void drowPoint(){
        int xCenter = 350-2;
        int yCenter = 300-2;
        gr2d.setPaint(Color.black);
        gr2d.drawString("(" + point.getX() + "," + point.getY() + ")",
                xCenter + (int)(point.getX() * scale), yCenter - (int)(point.getY() * scale));
        gr2d.drawOval(xCenter + (int)(point.getX() * scale), yCenter - (int)(point.getY() * scale),
                4, 4);
    }

    public void drowCircle(){

        gr2d.setPaint(circle.getColor());
        gr2d.drawOval(350 + (int)(circle.getXCenter() * scale) - (int)(circle.getR() * scale),
                      300 - (int)(circle.getYCenter() * scale) - (int)(circle.getR() * scale),
                (int) (circle.getR() * scale * 2), (int)(circle.getR() * scale * 2));
    }

}
