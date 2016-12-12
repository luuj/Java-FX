package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BombBlock extends Block{

	public BombBlock() {
		super();
		String pathString = "images/bombblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(55);
		mImage.setFitWidth(90);
	}

	private void DestroyAdjacentBlocks(){}
}
