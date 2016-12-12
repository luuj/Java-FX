package Controller;

import View.BlockPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/********************************************
 * Game_Controller
 * Checks to see if there are any remaining moves left in the game
 * If not, end the game by creating a pop-up window that lets the user reset 
 ********************************************/

public class Game_Controller {
	private static Game_Controller gameController;
	private Stage passedStage;
	private Scene passedScene, passedMenuScene;
	private static final int FINAL_SCORE = 70;
	private static int currBlockCount;
	
	private Game_Controller(){
        currBlockCount = 2;
	}
	
	public static Game_Controller get(){
        if (gameController == null)
            gameController = new Game_Controller();

        return gameController;
	}
	
	public void setStage(Stage s){
		passedStage = s;
	}
	
	public Stage getStage(){
		return passedStage;
	}
	
	public void setScene(Scene s){
		passedScene = s;
	}
	
	public Scene getScene(){
		return passedScene;
	}
	
	public void setMenuScene(Scene s){
		passedMenuScene = s;
	}
	
	public Scene getMenuScene(){
		return passedMenuScene;
	}
	
	public void increaseBlockCount(){
		if (currBlockCount < 5)
			currBlockCount++;
	}
	
	public int getBlockCount(){
		return currBlockCount;
	}
	
	public void resetBlockCount(){
		currBlockCount = 2;
	}
	
	public void createNewGame(){
		Game_Controller.get().resetBlockCount();
		Block_Singleton.get().resetLevel();
		Block_Singleton.get().Reset();
		BlockPanel.Reset();	
	}
	
	//Check to see if the game is over or not by looking at the number of possible moves left
	public void check(){
		if (!Block_Singleton.get().checkRemainingMoves()){
			final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(passedStage);
            dialog.initStyle(StageStyle.UNDECORATED);
	        
            BorderPane pane = new BorderPane();
            VBox dialogVbox = new VBox();
            dialogVbox.setSpacing(10);
            dialogVbox.setPadding(new Insets(50,0,0,0));
            pane.setStyle("-fx-background-image: url(\"images/pause_menu.jpg\");");
            
            Text winText = new Text("You win!");
            winText.setFont(new Font("Verdana", 15));
            Text loseText = new Text("You lose!");
            loseText.setFont(new Font("Verdana", 15));
            dialogVbox.setAlignment(Pos.TOP_CENTER);
            
			if (Block_Singleton.get().getScore() >= FINAL_SCORE){	
                dialogVbox.getChildren().add(winText);		
    			Button nextLevel = new Button("Next Level");
    			nextLevel.setOnAction(e->	{ 
    				Block_Singleton.get().Reset();
    				Block_Singleton.get().increaseLevel();
    				increaseBlockCount();
    				BlockPanel.Reset();	
    				dialog.close();});
    			nextLevel.setStyle("-fx-font: 14 arial; -fx-base: #98FB98;");
    			nextLevel.setMinWidth(130);
    			
    			dialogVbox.getChildren().add(nextLevel);
			}
			else
			{
                dialogVbox.getChildren().add(loseText);
    			Button resetButton = new Button("New Game");
    			resetButton.setOnAction(e->	{ 
    				createNewGame();
    				dialog.close();});
    			resetButton.setStyle("-fx-font: 14 arial; -fx-base: #98FB98;");
    			resetButton.setMinWidth(130);
    			
    			dialogVbox.getChildren().add(resetButton);
			}
			
			pane.setCenter(dialogVbox);
			Scene dialogScene = new Scene(pane, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();
		}
	}
}
