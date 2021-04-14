package Solution2;

public class VcollinearException extends Exception {
    public VcollinearException(){
        super("Vectors are collinear");
    }

    public void messege(){
        System.out.println("Vectors are collinear");
    }
}


