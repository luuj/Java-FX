package Controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

import Entities.Block;
import Entities.BlueBlock;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/********************************************
 * Singleton class to maintain game state
 ********************************************/

public class Block_Singleton {
    private static Block_Singleton sBlock;
    private ArrayList<Block> allBlocks;
    private HashSet<Block> highlightedBlocks;
	private ArrayList<VBox> allColumns;
	
	private Label score, level;
	private int currScore, currLevel;
    
    private Block_Singleton() {
        allBlocks = new ArrayList<Block>();
        allColumns = new ArrayList<VBox>();
        highlightedBlocks = new HashSet<Block>();
        currScore = 0;
        currLevel = 1;
    }
    
    public static Block_Singleton get() {
        if (sBlock == null)
            sBlock = new Block_Singleton();

        return sBlock;
    }
    
    //Sort allBlocks based on location
    public void sortAllBlocks(){
        Collections.sort(allBlocks, new BlockCompare());
    }
    
	//Comparator for Collections.sort
    public class BlockCompare implements Comparator<Block> {
        @Override
        public int compare(Block lhs, Block rhs) {
            return lhs.getLocation() - rhs.getLocation();
        }
    }

    //Parse the given block's surrounding blocks to look for matches
    public HashSet<Block> parse(Block initialBlock){
        String startingColor = initialBlock.getType();
        HashSet<Block> tempSet = new HashSet<Block>();
        tempSet.add(initialBlock);
        
        LinkedList<Block> bfsList = new LinkedList<Block>();
        bfsList.add(initialBlock);

        while (!bfsList.isEmpty()) {
            int startingPosition = bfsList.getFirst().getLocation();
            
            //If the starting position is on the left edge
            if ((startingPosition % 7) == 0) {
                //If starting position is 0
                if (startingPosition == 0) {
                    //Add positions 1 and 7 to the queue if not visited already and match colors
                    checkSides(false, true, false, true, tempSet, bfsList, startingColor, startingPosition);
                    bfsList.remove();
                    continue;
                }
              //If starting position is 77
                if (startingPosition == 77) {
                    //Add positions 70 and 78 to the queue if not visited already and match colors
                    checkSides(false, true, true, false, tempSet, bfsList, startingColor, startingPosition);
                    bfsList.remove();
                    continue;
                }

                //Else if it is anywhere else on the left edge
                checkSides(false, true, true, true, tempSet, bfsList, startingColor, startingPosition);
                bfsList.remove();
                continue;
            }

            //If the starting position is on the right edge
            if ((startingPosition % 7) == 6){
                if (startingPosition == 6){
                    checkSides(true, false, false, true, tempSet, bfsList, startingColor, startingPosition);
                    bfsList.remove();
                    continue;
                }
                if (startingPosition == 83){
                    checkSides(true, false, true, false, tempSet, bfsList, startingColor, startingPosition);
                    bfsList.remove();
                    continue;
                }

                //Else if it is anywhere else on the right edge
                checkSides(true, false, true, true, tempSet, bfsList, startingColor, startingPosition);
                bfsList.remove();
                continue;
            }

            //If the starting position is on the top
            if (startingPosition < 7){
                checkSides(true, true, false, true, tempSet, bfsList, startingColor, startingPosition);
                bfsList.remove();
                continue;
            }

            //If the starting position is on the bottom
            if (startingPosition > 76){
                checkSides(true, true, true, false, tempSet, bfsList, startingColor, startingPosition);
                bfsList.remove();
                continue;
            }

            //General algorithm for center blocks
            checkSides(true, true, true, true, tempSet, bfsList, startingColor, startingPosition);
            bfsList.remove();
        }

        //If only initial block is selected, do not highlight
        if (tempSet.size() == 1)
            initialBlock.setSelected(false);

        return tempSet;
    }
        
    //Given a current block, check if the sides are adjacent and add to queue
    public void checkSides(boolean left, boolean right, boolean up, boolean down, HashSet<Block> selectedBlocks, LinkedList<Block> bfsList, String startingColor, int startingPosition){
        if (up == true) {
            if (!allBlocks.get(startingPosition - 7).getSelected() && (allBlocks.get(startingPosition - 7).getType().equals(startingColor))) {
                allBlocks.get(startingPosition - 7).setSelected(true);
                bfsList.add(allBlocks.get(startingPosition - 7));
                selectedBlocks.add(allBlocks.get(startingPosition - 7));
            }
        }
        if (down == true) {
            if (!allBlocks.get(startingPosition + 7).getSelected() && (allBlocks.get(startingPosition + 7).getType().equals(startingColor))) {
                allBlocks.get(startingPosition + 7).setSelected(true);
                bfsList.add(allBlocks.get(startingPosition + 7));
                selectedBlocks.add(allBlocks.get(startingPosition + 7));
            }
        }
        if (right == true) {
            if (!allBlocks.get(startingPosition + 1).getSelected() && (allBlocks.get(startingPosition + 1).getType().equals(startingColor))) {
                allBlocks.get(startingPosition + 1).setSelected(true);
                bfsList.add(allBlocks.get(startingPosition + 1));
                selectedBlocks.add(allBlocks.get(startingPosition + 1));
            }
        }
        if (left == true) {
            if (!allBlocks.get(startingPosition - 1).getSelected() && (allBlocks.get(startingPosition - 1).getType().equals(startingColor))) {
                allBlocks.get(startingPosition - 1).setSelected(true);
                bfsList.add(allBlocks.get(startingPosition - 1));
                selectedBlocks.add(allBlocks.get(startingPosition - 1));
            }
        }
    }
    
    //When blocks fall, update their grid location
    public void updateBlockPositions(){
        @SuppressWarnings("unchecked")
		HashSet<Block> updateRowList = (HashSet<Block>) highlightedBlocks.clone();

        for (Block i : updateRowList){
            //Get the first element in the queue
            int currPosition = i.getLocation();

            //If the block is not in the first row or the block is not blank
            while (currPosition > 6){
                if( (allBlocks.get(currPosition-7).getType().equals("Blank")) ) {
                	Block temp = new Block("Blank");
                	temp.setLocation(currPosition);
                    allBlocks.set(currPosition, temp);
                    break;
                }
                Block nextBlock = allBlocks.get(currPosition - 7);
                nextBlock.setLocation(currPosition);
                allBlocks.set(currPosition, nextBlock);
                currPosition = currPosition-7;
            }

            if (currPosition <= 6){
            	Block temp = new Block("Blank");
            	temp.setLocation(currPosition);
                allBlocks.set(currPosition, temp);
            }
        }
        updateRowList.clear();
        /*
        for (int i=0; i<12; i++){
        	for (int k=0; k<7; k++)
        		System.out.print(allBlocks.get((i*7)+k).getType() + " ");
        	System.out.println();
        }*/
    }

    //Check to see if there are any remaining moves left to end the game
    public boolean checkRemainingMoves(){
        for (int i=allBlocks.size()-1; i>=0; i--){
            if (allBlocks.get(i).getType().equals("Blank"))
                continue;

            //If block is currently not blank, check to see if it has any moves
            HashSet<Block> tempBlockCheck = parse(allBlocks.get(i));
            for (Block b: tempBlockCheck){
                b.setSelected(false);
            }
            
            if (tempBlockCheck.size() > 1) {
                return true;
            }
        }
        return false;
    }
    
    //Reset Singleton variables for a new game
    public void Reset(){
    	allBlocks.clear();
    	allColumns.clear();
    	highlightedBlocks.clear();
    	
    	currScore = 0;
		score.setText("Score: " + Integer.toString(currScore));
    }
    
    //Getters and setters
    public void addNewBlock(Block b){
    	allBlocks.add(b);
    }
    
    public void removeBlock(Block b){
    	VBox currColumn = allColumns.get(b.getLocation() % 7);
    	currColumn.getChildren().remove(b.getImage());		
    	
    	if (currColumn.getChildren().isEmpty()){
    		Block emptyBlock = new BlueBlock();
    		emptyBlock.getImage().setVisible(false);
    		currColumn.getChildren().add(emptyBlock.getImage());
    	}
    }
    
    public int allBlockSize(){
    	return allBlocks.size();
    }
   
    public void addNewColumn(VBox column){
    	allColumns.add(column);
    }
    
    public HashSet<Block> getHighlighted(){
    	return highlightedBlocks;
    }
    
    public void setHighlighted(HashSet<Block> input){
    	highlightedBlocks = input;
    }
    
    public void clearHighlighted(){
    	highlightedBlocks.clear();
    }

    public void updateScore(int i){
    	currScore += i;
		score.setText("Score: " + Integer.toString(currScore));
    }

	public void setLabels(Label s, Label l){
		score = s;
		level = l;
	}
	
	public int getScore(){
		return currScore;
	}
	
	public void increaseLevel(){
		currLevel++;
		level.setText("Level: " + Integer.toString(currLevel));
	}
	
	public void resetLevel(){
		currLevel = 1;
		level.setText("Level: " + Integer.toString(currLevel));
	}
	
	
}
