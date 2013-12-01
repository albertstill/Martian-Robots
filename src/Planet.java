package src;
import java.awt.Point;
import java.util.ArrayList;


public class Planet {

	private Point upperRightPoint;
	private ArrayList<Scent> scents = new ArrayList<Scent>();
	private ArrayList<Robot> robots = new ArrayList<Robot>();
	
	public Planet(Point upperRightPoint){
		this.setUpperRightPoint(upperRightPoint);
	}
	
	public void addRobot(Robot robot){
		robots.add(robot);
	}
	
	public void addScent(Scent scent){
		scents.add(scent);
	}
	
	public ArrayList<Robot> getRobots() {
		return robots;
	}
	
	public void setRobots(ArrayList<Robot> robots) {
		this.robots = robots;
	}
	
	public ArrayList<Scent> getScents() {
		return scents;
	}
	
	public void setScents(ArrayList<Scent> scents) {
		this.scents = scents;
	}
	
	public Point getUpperRightPoint() {
		return upperRightPoint;
	}
	
	public void setUpperRightPoint(Point upperRightPoint) {
		this.upperRightPoint = upperRightPoint;
	}
}
