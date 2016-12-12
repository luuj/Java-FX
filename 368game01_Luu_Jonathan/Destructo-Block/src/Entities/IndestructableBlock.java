package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IndestructableBlock extends Block{

	public IndestructableBlock() {
		super();
		String pathString = "images/indestructable.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(55);
		mImage.setFitWidth(90);
	}
	
}
