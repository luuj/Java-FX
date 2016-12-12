package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GreenBlock extends Block{

	public GreenBlock() {
		super();
		String pathString = "images/greenblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(55);
		mImage.setFitWidth(90);
	}

}
