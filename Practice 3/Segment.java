
public class Segment {
	
	private Vector3D startPoint;
	private Vector3D endPoint;
	
	Segment(Vector3D startPoint, Vector3D endPoint){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	Vector3D getStart() {
		return startPoint;
	}
	
	Vector3D getEnd(){
		return endPoint;
	}
	
	// ????? ???????
	double len(){
		Vector3D s = endPoint.sub(startPoint);
		return s.len();
	}
	
	// ?????????? ?? ????? ?? ???????
	double distanceTo(Vector3D point) {
		Vector3D A0 = startPoint;
		Vector3D A1 = endPoint;
		Vector3D A2 = point;
		Vector3D A0A1 = A1.sub(A0);
		Vector3D A1A2 = point.sub(A1);
		Vector3D A0A2 = point.sub(A0);
		if(A0A1.multiply(-1).scalar(A1A2) >= 0 && A0A1.scalar(A0A2) >= 0){
			Vector3D vecX = A1A2.vecX(A0A1);
			return vecX.len() / A0A1.len();
		}
		else{
			return Math.min(A0A2.len(), A1A2.len());
		}
	}
}
