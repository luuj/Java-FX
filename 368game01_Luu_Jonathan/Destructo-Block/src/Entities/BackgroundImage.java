package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundImage {
	private ImageView mBI;
	
	public BackgroundImage(){
		String pathString = "images/game_background.png";
		Image image = new Image(pathString);
		mBI = new ImageView();
		mBI.setImage(image);
		
		mBI.setFitHeight(400);
		mBI.setFitWidth(350);
	}
	
	public ImageView getImage(){
		return mBI;
	}
	
	public void setImageLocation(double X, double Y){
		mBI.setX(X);
		mBI.setY(Y);
	}
}
