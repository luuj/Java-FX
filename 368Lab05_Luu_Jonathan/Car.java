import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Car {
	public Car(Group root){
		makeBottomLine(root);
		makeCarWheels(root);
		makeCarBase(root);
	}
	
	public void makeBottomLine(Group root){
		Line line1 = new Line(0, 490, 500, 490); //straight line
		line1.setStroke(Color.GREEN);
		line1.setStrokeWidth(20);
		
		root.getChildren().add(line1);
	}
	
	public void makeCarWheels(Group root){
		Circle wheelOne = new Circle(90, 465, 15);
		wheelOne.setStroke(Color.BLACK);
		
		Circle wheelTwo = new Circle(180, 465, 15);
		wheelTwo.setStroke(Color.BLACK);
		
		Circle wheelOneInside = new Circle(90, 465, 5);
		wheelOneInside.setFill(Color.WHITE);
		
		Circle wheelTwoInside = new Circle(180, 465, 5);
		wheelTwoInside.setFill(Color.WHITE);
		
		root.getChildren().addAll(wheelOne, wheelTwo, wheelOneInside, wheelTwoInside);
	}
	
	public void makeCarBase(Group root){
		Line bottomBase = new Line(107.5, 465, 162.5, 465);
		bottomBase.setStroke(Color.RED);
		bottomBase.setStrokeWidth(5);
		
		Line sideBaseLeft = new Line(55.5, 465, 72.5, 465);
		sideBaseLeft.setStroke(Color.RED);
		sideBaseLeft.setStrokeWidth(5);
		
		Line sideBaseRight = new Line(197.5, 465, 214.5, 465);
		sideBaseRight.setStroke(Color.RED);
		sideBaseRight.setStrokeWidth(5);
		
		Line sideTrunkLeft = new Line(55.5, 465, 69.5, 435);
		sideTrunkLeft.setStroke(Color.RED);
		sideTrunkLeft.setStrokeWidth(5);
		
		Line sideTrunkRight = new Line(214.5, 465, 200.5, 435);
		sideTrunkRight.setStroke(Color.RED);
		sideTrunkRight.setStrokeWidth(5);
		
		Line roof = new Line(69.5, 435, 200.5, 435);
		roof.setStroke(Color.RED);
		roof.setStrokeWidth(5);
		
		Line doorLine = new Line(120, 435, 120, 465);
		doorLine.setStroke(Color.RED);
		doorLine.setStrokeWidth(5);
		
		Line windShield = new Line(175, 433, 165, 415);
		windShield.setStroke(Color.RED);
		windShield.setStrokeWidth(5);
		
		Line coverUp = new Line(112, 415, 165, 415);
		coverUp.setStroke(Color.RED);
		coverUp.setStrokeWidth(5);
		
		Line backWindow = new Line(112, 415, 102, 433);
		backWindow.setStroke(Color.RED);
		backWindow.setStrokeWidth(5);
		
		Rectangle doorHandle = new Rectangle(127, 442, 12, 7);
		
		root.getChildren().addAll(bottomBase, sideBaseLeft, sideBaseRight, sideTrunkLeft, sideTrunkRight,
				roof, doorLine, doorHandle, windShield, coverUp, backWindow);
	}
}
