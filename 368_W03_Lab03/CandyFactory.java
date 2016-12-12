import java.util.*;
public class CandyFactory {

	public static Candy getNewSnickers(){
		return new FilledChocolate("Snickers", 30, 20, "Caramel & nuts");	
	}

	public static ArrayList<Candy> getABunchOfLollipops(){
		ArrayList<Candy> lollies = new ArrayList<>(120);
		for(int i = 0; i < 120 ; i++){
			lollies.add(new Candy("Dum-Dums", 5));
		}
		return lollies;
	}
	
	public static ArrayList<Candy> getAMixedBag(){
		ArrayList<Candy> bag = new ArrayList<>(100);
		for(int i = 0; i < 12 ; i++){
			bag.add(new Candy("Dum-Dums", 5));
		}
		for(int i = 0; i < 12 ; i++){
			bag.add(new SolidChocolate("Hershey's", 20, 30, 4));
		}
		for(int i = 0; i < 12 ; i++){
			bag.add(new FilledChocolate("Milky Ways", 20, 30, "Caramel"));
		}
		for(int i = 0; i < 12 ; i++){
			bag.add(new FilledChocolate("Kit-Kat", 20, 30, "wafer-cookies"));
		}
		return bag;
	
	}
}
