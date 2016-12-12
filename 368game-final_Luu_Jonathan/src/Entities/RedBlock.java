package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*************************
 * Red Block
 * Normal block type that can be destroyed when near other blocks
 ************************/

public class RedBlock extends Block{
	public RedBlock() {
		super("red");
		String pathString = "images/redblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(BLOCK_HEIGHT);
		mImage.setFitWidth(BLOCK_WIDTH);
	}
	
}
