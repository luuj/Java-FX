package View;

import Controller.Game_Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/***
 * Start Panel Class
 * Contains the background image, new-game, and exit buttons for the start screen
 ***/

public class StartPanel {
	BorderPane borderReference;
	
	public StartPanel(BorderPane bp)
	{
		borderReference = bp;
		addButtons();
	}
	
	private void addButtons()
	{
		//Button to start a new game
		Button newGame = new Button();
		Image buttonImage = new Image("images/new_game.png");
		newGame.setGraphic(new ImageView(buttonImage));
		newGame.setStyle("-fx-font: 0 arial; -fx-base: #000000; -fx-focus-color: transparent;");

		newGame.setOnAction((ActionEvent event)->
		{
			Game_Controller.get().createNewGame();
			
			Stage stageReference = Game_Controller.get().getStage();
			Scene sceneReference = Game_Controller.get().getScene();
			stageReference.setScene(sceneReference);
		});
		
		//Button to view instructions
		Button instructionButton = new Button();
		Image instructionImage = new Image("images/instructions.png");
		instructionButton.setGraphic(new ImageView(instructionImage));
		instructionButton.setStyle("-fx-font: 0 arial; -fx-base: #000000; -fx-focus-color: transparent;");
		instructionButton.setOnAction((ActionEvent event)->
		{
			final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(Game_Controller.get().getStage());
            dialog.initStyle(StageStyle.UNDECORATED);
	        
            BorderPane pane = new BorderPane();
            VBox dialogVbox = new VBox();
            dialogVbox.setSpacing(10);
            dialogVbox.setPadding(new Insets(50,0,0,0));
            pane.setStyle("-fx-background-image: url(\"images/pause_menu.jpg\");");
            
            Label instructions[] = new Label[6];
            
            instructions[0] = new Label("Destructo Block Instructions");
            instructions[0].setPadding(new Insets(0,0,0,160));
            instructions[1] = new Label("Goal: Destroy as many blocks as possible!");
            instructions[2] = new Label("Blocks can only be destroyed if adjacent to another same-colored block.");
            instructions[3] = new Label("Reach the score goal in order to progress to the next level.");
            instructions[4] = new Label("As you progress onto further levels, more block colors will be introduced.");
            instructions[5] = new Label("Good luck and have fun!");
            
            Button closeInstructions = new Button("Close Instructions");
			closeInstructions.setStyle("-fx-font: 14 arial; -fx-base: #98FB98;");
			closeInstructions.setTranslateX(170);
			closeInstructions.setTranslateY(30);
			closeInstructions.setOnAction(e->{
				dialog.close();
			});
            
            dialogVbox.setAlignment(Pos.TOP_LEFT);
            dialogVbox.getChildren().add(instructions[0]);
            for (int i=1; i<6; i++)
            {
            	instructions[i].setPadding(new Insets(0,0,0,10));
            	dialogVbox.getChildren().add(instructions[i]);
            }
            
			dialogVbox.getChildren().add(closeInstructions);
			
			pane.setCenter(dialogVbox);
			Scene dialogScene = new Scene(pane, 500, 300);
            dialog.setScene(dialogScene);
            dialog.show();
		});
		
		//Button to exit the game
		Button exitGame = new Button();
		Image exitImage = new Image("images/exit.png");
		exitGame.setGraphic(new ImageView(exitImage));
		exitGame.setStyle("-fx-font: 0 arial; -fx-base: #000000; -fx-focus-color: transparent;");
		exitGame.setOnAction((ActionEvent event)->
		{
			Stage stageReference = Game_Controller.get().getStage();
			stageReference.close();
		});
		
		VBox buttonBox = new VBox();
		buttonBox.setSpacing(20);
		buttonBox.setPadding(new Insets(580, 0, 0, 20));
		
		buttonBox.getChildren().addAll(newGame, instructionButton, exitGame);
		
		borderReference.getChildren().add(buttonBox);
	}
}
