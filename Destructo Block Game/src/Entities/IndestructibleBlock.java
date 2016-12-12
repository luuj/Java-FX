package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*************************
 * Indestructible Block
 * Special block type that cannot be destroyed
 ************************/

public class IndestructibleBlock extends Block{

	public IndestructibleBlock() {
		super("indestructable");
		String pathString = "images/indestructable.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(BLOCK_HEIGHT);
		mImage.setFitWidth(BLOCK_WIDTH);
	}
	
}
