public class PointsLieOnOneSideOfAStraightLineException extends Exception {
    public PointsLieOnOneSideOfAStraightLineException(){
        super("Points lie on one side of a straight line.");
    }

    public void message(){
        System.out.println("Points A and B in one half-plane.");
    }
}
