import java.util.ArrayList;
import java.util.Collections;

public class Kid {
	private String name;
	private ArrayList<Candy> bag;
	private String costume;
	
	public Kid(String name, String costume) {
		this.name = name;
		this.costume = costume;
		bag = new ArrayList<Candy>();
	}

	public void collectCandy(Candy piece){
		System.out.println(this.name + " just got " + piece.getName());
		bag.add(piece);
	}
	
	public void eatCandy(){
		int randNum = (int)(Math.random() * bag.size());
		Candy piece = bag.remove(randNum);
		System.out.println(name + " just ate " + piece);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Kid " + name + " in a cool " + costume + " costume";
	}
	
	public void peekBag(){
		System.out.println(name + "'s candy bag's contents:");
		for (Candy c : bag)
			System.out.println(c);
		
		if (bag.isEmpty())
			System.out.println("Empty");
	}
	
	public String getName(){
		return name;
	}
	
	public int getBagSize(){
		return bag.size();
	}
	
	public void sortBag(){
		Collections.sort(bag);
	}
	
}
