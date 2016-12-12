package Entities;
import java.util.HashSet;

import Controller.*;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/*************************
 * Virtual block class
 * Contains base block variables and animation functions
 ************************/

public class Block {
	private ImageView mImage;
	private boolean mIsSelected;
	private String blockType;
	private int blockLocation;
	protected static final int BLOCK_WIDTH = 100;
	protected static final int BLOCK_HEIGHT = 55;
		
	public Block(String bt){
		mImage = new ImageView();
		addImageListener();
		
		blockType = bt;
	}

	//Tells the current selected blocks what to do
	private void addImageListener(){
		mImage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				if (!mIsSelected){
	                //Check if another item has been clicked already and unselect them
					HashSet<Block> previousAllBlocks = Block_Singleton.get().getHighlighted();
	                if (previousAllBlocks.size() != 0) {
	                    for (Block i : previousAllBlocks)
	                    	if (i.mIsSelected)
	                    		i.unhighlightBlock();
	                }
	                
		            HashSet<Block> selectedBlocks = Block_Singleton.get().parse(Block.this);
		            Block_Singleton.get().setHighlighted(selectedBlocks);
		            
		            //Only highlight if more than one adjacent block
		            if (selectedBlocks.size() > 1)
		            	for (Block i : selectedBlocks)
		            		i.highlightBlock(1.0, 0.3);
				}
				else{
					HashSet<Block> previousAllBlocks = Block_Singleton.get().getHighlighted();
					int scoreUpdate = previousAllBlocks.size();
					if (previousAllBlocks.size() > 1) {
						 for (Block i : previousAllBlocks)
							 Block_Singleton.get().removeBlock(i);
						
						Block_Singleton.get().updateScore(scoreUpdate);
						Music_Singleton.get().playCrackle();
						Block_Singleton.get().updateBlockPositions();
						Game_Controller.get().check();
						Block_Singleton.get().clearHighlighted();
					}
				}
			}
		});
	}
	
	//Highlight or unhighlight the selected blocks
	public void highlightBlock(double initial, double end)
	{
		FadeTransition ft =	new	FadeTransition(Duration.millis(300), mImage);		
		ft.setFromValue(initial);	
		ft.setToValue(end);	
		
		ft.setCycleCount(1);	
		ft.play();
	}
	
	public void unhighlightBlock(){
		FadeTransition ft =	new	FadeTransition(Duration.millis(300), mImage);		
		ft.setFromValue(0.3);	
		ft.setToValue(1.0);	

		mIsSelected = false;
		ft.setCycleCount(1);	
		ft.play();
	}
	
	//Getters and Setters
	public ImageView getImage() {
		return mImage;
	}
	
	public void setLocation(int x){
		blockLocation = x;
	}
	
	public int getLocation(){
		return blockLocation;
	}
	
	public String getType(){
		return blockType;
	}
	
	public void setType(String type){
		blockType = type;
	}
	
	public void setSelected(boolean selected){
		mIsSelected = selected;
	}
	
	public boolean getSelected(){
		return mIsSelected;
	}
}
