package src;
import java.awt.Point;

public class Robot {

	private Planet planet;
	private Point location;
	private Orientation orientation;
	private boolean isLost = false;
	private Scent scent;

	public Robot(Planet planet,Point startingLocation, Orientation startingOrientation){
		setPlanet(planet);
		setLocation(startingLocation);
		setOrientation(startingOrientation);
		
		planet.addRobot(this);
	}
	
	public void instructionString(String instructions){
		for(int i = 0; i < instructions.length(); i++){
			
			if(isLost){
				break;
			}
			
        	switch(instructions.charAt(i)){
        		case 'R': turnRight(); break;
        		case 'L': turnLeft(); break;
        		case 'F': moveForward(); break;
        	}
        }
	}

	public void turnRight(){
		switch(orientation){
		case N: orientation = Orientation.E; break;
		case E: orientation = Orientation.S; break;
		case S: orientation = Orientation.W; break;
		case W: orientation = Orientation.N; break;
		}
	}

	public void turnLeft(){
		switch(orientation){
		case N: orientation = Orientation.W; break;
		case E: orientation = Orientation.N; break;
		case S: orientation = Orientation.E; break;
		case W: orientation = Orientation.S; break;
		}
	}

	public void moveForward(){

		Scent tempScent = new Scent(new Point(location), orientation);
		
		//if there's a matching scent stored in the planet do nothing else move
		if(hasMatchingScent(tempScent)){
			return;
		} else {
			//move
			switch(orientation){
			case N: location.y++; break;
			case E: location.x++; break;
			case S: location.y--; break;
			case W: location.x--; break;
			}
			
			//if move has caused robot to fall off planet
			if(isLost()){
				scent = tempScent;
				planet.addScent(scent);
			}
		}
		
	}
	
	public boolean hasMatchingScent(Scent scent){
		for(Scent storedScent : planet.getScents()){
			if(scent.equals(storedScent)){
				return true;
			}
		}
		
		return false;
	}

	public boolean isLost(){
		if(location.x > planet.getUpperRightPoint().x || location.y > planet.getUpperRightPoint().y || 
				location.x < 0 || location.y < 0){
			isLost = true;
		}
		return isLost;
	}
	
	public Planet getPlanet() {
		return planet;
	}
	
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public String toString(){
		if(isLost){
			return scent.getPoint().x + " " + scent.getPoint().y + " " + scent.getOrientation().toString() + " LOST";
		} else return location.x + " " + location.y + " " + orientation.toString();
	}
}
