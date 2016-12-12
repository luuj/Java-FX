package Entities;
import javafx.scene.image.ImageView;

public class Block {
	private ImageView mImage;
	private boolean mIsSelected, mIsDestroyed;
	
	public Block(){
		mImage = new ImageView();
	}

	//Getters and Setters
	public ImageView getImage() {
		return mImage;
	}

	public void setImage(ImageView mImage) {
		this.mImage = mImage;
	}

	public boolean isSelected() {
		return mIsSelected;
	}

	public void setIsSelected(boolean mIsSelected) {
		this.mIsSelected = mIsSelected;
	}

	public boolean isDestroyed() {
		return mIsDestroyed;
	}

	public void setIsDestroyed(boolean mIsDestroyed) {
		this.mIsDestroyed = mIsDestroyed;
	}
	
	public void setImageLocation(double X, double Y){
		mImage.setX(X);
		mImage.setY(Y);
	}
	
}
