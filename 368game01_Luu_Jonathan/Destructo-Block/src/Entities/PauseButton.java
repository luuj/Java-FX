package Entities;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;

public class PauseButton {
	public PauseButton(double X, double Y, BorderPane bp){
		Rectangle leftSide = new Rectangle (X-15, Y-5, 10, 30);
		Rectangle rightSide = new Rectangle (X+20-15, Y-5, 10, 30);
		
		bp.getChildren().addAll(leftSide, rightSide);
	}
}
