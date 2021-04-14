import java.util.Scanner;


public class SegmentTest {

	public static Vector3D parser(String str){
		String[] strArray = str.split(" ");
		double x = Double.parseDouble(strArray[0]);
		double y = Double.parseDouble(strArray[1]);
		double z = Double.parseDouble(strArray[2]);
		return new Vector3D(x,y,z);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1, s2, s3;
		System.out.print("startPoint: ");
		s1 = sc.nextLine();
		System.out.print("endPoint: ");
		s2 = sc.nextLine();
		System.out.print("point: ");
		s3 = sc.nextLine();

		Vector3D startPoint = parser(s1);
		Vector3D endPoint = parser(s2);
		Vector3D point = parser(s3);
		System.out.println(startPoint.getX() + " " + startPoint.getY() + " " + startPoint.getZ());
		System.out.println(endPoint.getX() + " " + endPoint.getY() + " " + endPoint.getZ());

		Segment segment = new Segment(startPoint, endPoint);

		System.out.println("len = " + segment.len());
		System.out.println("distance = " + segment.distanceTo(point));
	}
}
