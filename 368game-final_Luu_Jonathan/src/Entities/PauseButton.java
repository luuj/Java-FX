package Entities;

import Controller.Game_Controller;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*************************
 * Pause button
 * Displays a pause menu when pressed in game
 ************************/

public class PauseButton{
	public PauseButton(double X, double Y, BorderPane bp){
		Rectangle leftSide = new Rectangle (X-15, Y-5, 5, 15);
		Rectangle rightSide = new Rectangle (X+10-15, Y-5, 5, 15);
		Rectangle square = new Rectangle(X-20, Y-8, 25, 21);
		
		//When clicked, display a pop-up window that lets the user continue or reset the current game
		square.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent t) 
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
    	        
                Button continueButton = new Button("Continue");
    			continueButton.setOnAction(e->dialog.close());
    			continueButton.setStyle("-fx-font: 14 arial; -fx-base: #98FB98;");
    			continueButton.setMinWidth(130);
    			
    			Button resetButton = new Button("New Game");
    			resetButton.setOnAction(e->	{ 
    				Game_Controller.get().createNewGame();
    				dialog.close();});
    			resetButton.setStyle("-fx-font: 14 arial; -fx-base: #98FB98;");
    			resetButton.setMinWidth(130);

    			Button returnButton = new Button("Return to Menu");
    			returnButton.setOnAction(e-> {
    				Stage passedStage = Game_Controller.get().getStage();
    				Scene passedScene = Game_Controller.get().getMenuScene();
    				passedStage.setScene(passedScene);
    				dialog.close();
    			});
    			returnButton.setStyle("-fx-font: 14 arial; -fx-base: #98FB98;");
    			returnButton.setMinWidth(130);
    			
                dialogVbox.setAlignment(Pos.TOP_CENTER);
    			dialogVbox.getChildren().addAll(continueButton, resetButton, returnButton);
    			
    			pane.setCenter(dialogVbox);
    			Scene dialogScene = new Scene(pane, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
            }
        });
		
		leftSide.setFill(Color.LIGHTGRAY);
		rightSide.setFill(Color.LIGHTGRAY);
		square.setFill(Color.TRANSPARENT);
		
		bp.getChildren().addAll(leftSide, rightSide, square);
	}
}
