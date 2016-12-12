import java.util.ArrayList;

public class House {
	private ArrayList<Candy> candy;
	private static int HOUSE_NUMBER_GENERATOR = 1;
	private final int houseNumber;
	
	public House(ArrayList<Candy> startingCandy){
		candy = startingCandy;
		houseNumber = HOUSE_NUMBER_GENERATOR ;
		HOUSE_NUMBER_GENERATOR++;
	}
	
	public Candy givePiece() throws OutOfCandyException {
		if (candy.size() == 0)
			throw new OutOfCandyException();
		
		return candy.remove(candy.size()-1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "House # " + houseNumber + " has " + candy.size() + " pieces of Candy";
	}

	/**
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}
	
	public int getCandyCount(){
		return candy.size();
	}
	
	public int getChocolateCount(){
		int chocolateCount = 0;
		for (Candy c: candy)
			if (c instanceof Chocolate)
				chocolateCount++;
		
		return chocolateCount;
	}
	
	public void printChocolateCount(){
		System.out.println("House # " + houseNumber + " has " + getChocolateCount() + " pieces of chocolate");
	}
	
}
