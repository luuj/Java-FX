package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlueBlock extends Block{
	public BlueBlock() {
		super();
		String pathString = "images/blueblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(55);
		mImage.setFitWidth(90);
	}
}
