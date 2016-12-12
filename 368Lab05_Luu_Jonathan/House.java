import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class House {
	public House(Group root){
		makeBase(root);
		makeWindow(root,295,320);
		makeWindow(root, 385, 320);
		makeDoor(root);
		makeImage(root);
	}
	
	public void makeBase(Group root){
		Rectangle base = new Rectangle (280, 300, 170, 180);
		base.setFill(Color.CYAN);
		base.setStroke(Color.BROWN);
		
		root.getChildren().addAll(base);
	}
	
	public void makeWindow(Group root, int x, int y){
		Rectangle window = new Rectangle(x, y, 50, 50);
		window.setFill(Color.CYAN);
		window.setStroke(Color.PURPLE);
		
		Line xLine = new Line(x+25, y, x+25, y+50);
		xLine.setStroke(Color.PURPLE);
		
		Line yLine = new Line(x, y+25, x+50, y+25);
		yLine.setStroke(Color.PURPLE);
		
		root.getChildren().addAll(window, xLine, yLine);
	}
	
	public void makeDoor(Group root){
		Rectangle door = new Rectangle (345, 420, 40, 60);
		door.setFill(Color.BROWN);
		
		root.getChildren().addAll(door);
	}
	
	public void makeImage(Group root){
		Image i = new Image("images/javaisfun.png");
		ImageView v1 = new ImageView( i );
		v1.setFitWidth(100);
		v1.setPreserveRatio(true);
		v1.setSmooth(true);
		v1.setCache(true);
		v1.setX(20);
		v1.setY(20);
		root.getChildren().add(v1);
	}
}
