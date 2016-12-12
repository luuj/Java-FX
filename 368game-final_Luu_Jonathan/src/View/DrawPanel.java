package View;

import Controller.Game_Controller;
import Controller.Music_Singleton;
import Entities.PauseButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*****************
 * Main Game Panel
 *****************/

public class DrawPanel extends Application{	
	@SuppressWarnings("unused")
	public void start(Stage stage){
		//Start menu screen
		BorderPane startPane = new BorderPane();
		Scene startScene = new Scene(startPane, 700, 800, Color.WHITE);
		
		//Game screen
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 700, 800, Color.WHITE);

		//Store JavaFX nodes in the controller
		Game_Controller.get().setStage(stage);
		Game_Controller.get().setScene(scene);
		Game_Controller.get().setMenuScene(startScene);

		//Set background image
		borderPane.setStyle("-fx-background-image: url(\"images/game_foreground_opacity.jpg\");");
		startPane.setStyle("-fx-background-image: url(\"images/start_background.png\");");
		
		//Draw elements of the game
		ScorePanel sp = new ScorePanel(borderPane);
		BlockPanel blocks = new BlockPanel(borderPane);
		PauseButton pause = new PauseButton(690, 10, borderPane);
		
		//Draw elements of the start menu
		StartPanel start = new StartPanel(startPane);

		//Start background music
		Music_Singleton.get().playBackground();
		
		stage.setTitle("Destructo-Block");
		stage.setResizable(false);
		stage.setScene(startScene);
		stage.show();
	}

	public static void main (String [] args){
		launch(args);
	}
}
