
public class Vector3D {
	private double x;
	private double y;
	private double z;

	Vector3D(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	double getX() {
		return x;
	}

	double getY() {
		return y;
	}

	double getZ() {
		return z;
	}

	double scalar(Vector3D v) {
		return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ(); 
	}
	
	double len(){
		return Math.sqrt(scalar(this));
	}
	
	Vector3D multiply(double factor) {
		return new Vector3D(factor * x, factor * y, factor * z);
	}
	
	Vector3D add(Vector3D v) {
		return new Vector3D(this.x + v.getX(), this.y + v.getY(), this.z + v.getZ());
	}
	
	Vector3D sub(Vector3D v) {
		return this.add(v.multiply(-1));
	}
	
	private static double det2(double a11, double a12, double a21, double a22){
		return a11 * a22 - a12 * a21;
	}
	
	Vector3D vecX(Vector3D v) {
		double newX = det2(this.y, this.z, v.getY(), v.getZ());
		double newY = -1 * det2(this.x, this.z, v.getX(), v.getZ());  
		double newZ = det2(this.x, this.y, v.getX(), v.getY());				
		return new Vector3D(newX, newY, newZ);		
	}
	
	boolean pcollin(Vector3D v) {
		Vector3D vecX = this.vecX(v);
		double scalar = vecX.scalar(vecX);
		double epsilon = 0.00000000000001;
		if (Math.abs(scalar) < epsilon) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean equals(Object o) {
		Vector3D vector3D = (Vector3D) o;
		double epsilon = 0.00000000000001;		
		return  Math.abs(this.x - vector3D.getX()) <  epsilon &&
				Math.abs(this.y - vector3D.getY()) <  epsilon &&
				Math.abs(this.z - vector3D.getZ()) <  epsilon;
	}
}
