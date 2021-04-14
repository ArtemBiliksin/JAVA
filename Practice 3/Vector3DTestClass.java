import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class Vector3DTestClass{

	@Test
	public void scalar() {
		double epsilon = 0.00000000001;
		Vector3D v1 = new Vector3D(1,2,3);
		Vector3D v2 = new Vector3D(-1,4, 7);
		double actual = v1.scalar(v2);
		assertEquals(28.0, actual, epsilon);
	}

	@Test
	public void len() {
		double epsilon = 0.000000000001;
		Vector3D v1 = new Vector3D(1,2,3);
		double actual = v1.len();
		assertEquals(Math.sqrt(14), actual, epsilon);
		assertEquals(1.0, new Vector3D(1,0,0).len(), epsilon);
	}

	@Test
	public void multiply() {
		Vector3D v1 = new Vector3D(1,2,3);
		Vector3D actual = v1.multiply(-1);
		assertEquals(new Vector3D(-1,-2,-3), actual);
	}

	@Test
	public void add(){
		Vector3D v1 = new Vector3D(0,0,0);
		Vector3D v2 = new Vector3D(1,0,0);
		Vector3D actual = v1.add(v2);
		assertEquals(new Vector3D(1, 0, 0), actual);
	}

	@Test
	public void sub(){
		Vector3D v1 = new Vector3D(0,0,0);
		Vector3D v2 = new Vector3D(1,0,0);
		Vector3D actual = v1.sub(v2);
		assertEquals(new Vector3D(-1, 0, 0), actual);
	}

	@Test
	public void vecX() {
		Vector3D v1 = new Vector3D(-3,2,-1);
		Vector3D v2 = new Vector3D(1,0,2);
		Vector3D actual = v1.vecX(v2);
		assertEquals(new Vector3D(4, 5, -2), actual);
	}

	@Test
	public void pcollin() {
		Vector3D v1 = new Vector3D(-3,2,-1);
		Vector3D v2 = new Vector3D(-3,2,-1);
		boolean actual = v1.pcollin(v2);
		assertEquals(false, actual);
	}
}
