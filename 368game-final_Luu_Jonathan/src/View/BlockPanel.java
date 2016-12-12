package View;
import java.util.concurrent.ThreadLocalRandom;

import Controller.Block_Singleton;
import Controller.Game_Controller;
import Entities.*;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*************************
 * Block Panel
 * Creates blocks and displays them on the main game panel
 ************************/

public class BlockPanel {
	static BorderPane borderReference;
	static HBox columnContainer;
	
	private static final int ROW_COUNT = 12;
	private static final int COLUMN_COUNT = 7;
	
	private static int maxIndestructable;
	
	public BlockPanel(BorderPane bp){
		borderReference = bp;
		columnContainer = new HBox();
		maxIndestructable = 0;
		
		InitializeColumns();
		 
		borderReference.setCenter(columnContainer);
	}
	
	//Initialize all the blocks and add them to the BorderPane
	private static void InitializeColumns(){
		Block createdBlock = null;
		
		for (int i=0; i<COLUMN_COUNT; i++){
			VBox column = new VBox();
			column.setAlignment(Pos.BOTTOM_LEFT);
			
			for (int k=0; k<ROW_COUNT; k++){
				createdBlock = CreateSingleBlock();
				createdBlock.setLocation((k*7)+i);
				column.getChildren().add(createdBlock.getImage());
			}

			Block_Singleton.get().addNewColumn(column);
			columnContainer.getChildren().add(column);
		}
		
		Block_Singleton.get().sortAllBlocks();
	}
	
	//Create one random block and place it in the Block_Singleton
	private static Block CreateSingleBlock(){
		int selectedNum = randInt(0, Game_Controller.get().getBlockCount());
		Block createdBlock = null;
				
		if (Game_Controller.get().getBlockCount() == 5)
		{
			if (selectedNum == 5 && maxIndestructable<3)
				maxIndestructable++;
			else
				selectedNum = randInt(0,Game_Controller.get().getBlockCount()-1);
		}
		
		switch (selectedNum){
	        case 0:
	            createdBlock = new BlueBlock();
	            break;
	        case 1:
	            createdBlock = new YellowBlock();
	            break;
	        case 2:
	            createdBlock = new GreenBlock();
	            break;
	        case 3:
	            createdBlock = new RedBlock();
	            break;
	        case 4:
	        	createdBlock = new GrayBlock();
	        	break;
	        case 5:
	        	createdBlock = new IndestructibleBlock();
	        	createdBlock.setType(Integer.toString(maxIndestructable));
	        	break;
		}
		
		Block_Singleton.get().addNewBlock(createdBlock);
		
		return createdBlock;
	}
	
	private static int randInt(int min, int max){
		return ThreadLocalRandom.current().nextInt(min, max+1);
	}
	
	public static void Reset(){
		columnContainer.getChildren().clear();
		maxIndestructable = 0;
		InitializeColumns();
	}
	
}
