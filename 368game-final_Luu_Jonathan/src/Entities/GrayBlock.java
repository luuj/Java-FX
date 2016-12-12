package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*************************
 * Gray Block
 * Normal block type that can be destroyed when near other blocks
 ************************/

public class GrayBlock extends Block{

	public GrayBlock() {
		super("Gray");
		String pathString = "images/grayblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(BLOCK_HEIGHT);
		mImage.setFitWidth(BLOCK_WIDTH);
	}

}
