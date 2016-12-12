package Entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TimerBlock extends Block{
	private int mCurrTime;

	public TimerBlock() {
		super();
		String pathString = "images/timerblock.png";
		Image image = new Image(pathString);
		
		ImageView mImage = getImage();
		mImage.setImage(image);
		
		mImage.setFitHeight(55);
		mImage.setFitWidth(90);
	}
	
	private void CountDown(){}
	private void TransformToIndestructableBlock(){}

}
