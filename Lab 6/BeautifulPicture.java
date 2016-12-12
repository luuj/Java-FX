import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class BeautifulPicture extends Application{
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500, Color.CYAN);
		stage.setTitle("JavaFX Art Piece");

		Car newCar = new Car(root);
		House newHouse = new House(root);
		
		stage.setScene(scene);
		stage.show();
	}
	

	
	public static void main(String[] args){
		launch(args);
	}

}
