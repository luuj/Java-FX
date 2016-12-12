package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*************************
 * Yellow Block
 * Normal block type that can be destroyed when near other blocks
 ************************/

public class YellowBlock extends Block{
	public YellowBlock() {
		super("yellow");
		String pathString = "images/yellowblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(BLOCK_HEIGHT);
		mImage.setFitWidth(BLOCK_WIDTH);
	}
}
