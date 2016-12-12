package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RedBlock extends Block{
	public RedBlock() {
		super();
		String pathString = "images/redblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(55);
		mImage.setFitWidth(90);
	}
	
}
