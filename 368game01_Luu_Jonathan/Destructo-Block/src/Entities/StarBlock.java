package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StarBlock extends Block{

	public StarBlock(String color) {
		super();
		String pathString = "images/starblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(55);
		mImage.setFitWidth(90);
	}
	
	private void DestroyAllColorBlocks(){}

}
