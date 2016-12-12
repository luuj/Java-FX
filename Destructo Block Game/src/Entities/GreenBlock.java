package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*************************
 * Green Block
 * Normal block type that can be destroyed when near other blocks
 ************************/

public class GreenBlock extends Block{

	public GreenBlock() {
		super("green");
		String pathString = "images/greenblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(BLOCK_HEIGHT);
		mImage.setFitWidth(BLOCK_WIDTH);
	}

}
