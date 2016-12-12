import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CoffeeShop extends Application{

	public void start(Stage stage){
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 400, 500, Color.WHITE);
		stage.setTitle("Coffee Shop");
		stage.setResizable(false);
		
		//Set background image
		Image image = new Image("images/background.jpg");
		borderPane.setStyle("-fx-background-image: url(\"images/background.jpg\");-fx-background-size: 500, 300;-fx-background-repeat: no-repeat;");
		
		//Draw the coffee shop
		DrawShop ds = new DrawShop(borderPane);
		ds.drawAll();

		stage.setScene(scene);
		stage.show();
	}

	public static void main (String [] args){
		launch(args);
	}
}
