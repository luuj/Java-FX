package View;
import Controller.Block_Singleton;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/********************************************
 * Score Panel
 * Contains current score and score goal
 ********************************************/

public class ScorePanel {
	BorderPane borderReference;
	Label score, scoreGoal, level;
	HBox bottomPanel;
	
	public ScorePanel(BorderPane bp){
		borderReference = bp;
		bottomPanel = new HBox();
		bottomPanel.setPrefHeight(50);
		
		DrawBar();
		DrawText();
		
		borderReference.setBottom(bottomPanel);
	}
	
	//Draw grey panel
	private void DrawBar(){
		Line line = new Line(0, 775, 1000, 775); 
		line.setStroke(Color.LIGHTGRAY);
		line.setStrokeWidth(50);
		
		borderReference.getChildren().add(line);
	}
	
	//Draw text for the bottom bar
	private void DrawText(){
		score = new Label("Score: 0");
		score.setFont(new Font("Verdana", 15));
		score.setPadding(new Insets(15,0,15,150));
		
		scoreGoal = new Label("Score Goal: 70");
		scoreGoal.setFont(new Font("Verdana", 15));
		scoreGoal.setPadding(new Insets(15,0,15,150));
		
		level = new Label("Level: 1");
		level.setFont(new Font("Verdana", 15));
		level.setPadding(new Insets(15,0,15,15));
		Block_Singleton.get().setLabels(score, level);

		bottomPanel.getChildren().addAll(level, score, scoreGoal);		
	}
	
}
