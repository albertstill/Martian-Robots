package src;
import java.awt.Point;

public class Scent {

	private Point point;
	private Orientation orientation;

	public Scent(Point point, Orientation orientation){
		this.setPoint(point);
		this.setOrientation(orientation);
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public boolean equals(Scent scent){
		return point.equals(scent.getPoint()) && orientation.equals(scent.getOrientation());
	}
}
