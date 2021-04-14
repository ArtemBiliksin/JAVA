public class PointPositionException extends Exception{
    @SuppressWarnings("serial")
    PointPositionException(){
        super("Point does not belong to the circle.");
    }
}
