package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class YellowBlock extends Block{
	public YellowBlock() {
		super();
		String pathString = "images/yellowblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(55);
		mImage.setFitWidth(90);
	}
}
