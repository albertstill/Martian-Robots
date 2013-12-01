package test;
import java.awt.Point;
import src.Orientation;
import src.Planet;
import src.Robot;

public class Controller {

	public static void main(String[] args) {
		
		//Sample input data
		
		Planet mars = new Planet(new Point(5,3));
		
		Robot robot1 = new Robot(mars, new Point(1,1), Orientation.E);
		robot1.instructionString("RFRFRFRF");
		Robot robot2 = new Robot(mars, new Point(3,2), Orientation.N);
		robot2.instructionString("FRRFLLFFRRFLL");
		Robot robot3 = new Robot(mars, new Point(0,3), Orientation.W);
		robot3.instructionString("LLFFFLFLFL");
		
		for(Robot robot : mars.getRobots()){
			System.out.println(robot.toString());
	    }
		
        System.exit(0);
	}

}
