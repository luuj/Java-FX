package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*************************
 * Blue Block
 * Normal block type that can be destroyed when near other blocks
 ************************/

public class BlueBlock extends Block{
	public BlueBlock() {
		super("blue");
		String pathString = "images/blueblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(BLOCK_HEIGHT);
		mImage.setFitWidth(BLOCK_WIDTH);
	}
}
