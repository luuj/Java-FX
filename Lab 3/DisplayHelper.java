import java.util.ArrayList;
import java.util.Collections;

public class DisplayHelper {
	
	protected static void displayAllKids(ArrayList<Kid> kids){
		System.out.println("You chose: Display all kids, names, and costumes");
		for (Kid k: kids){
			System.out.println(k);
		}
	}
	
	protected static void displayAllHouses(ArrayList<House> houses){
		System.out.println("You chose: Display all houses");
		for (House h: houses){
			System.out.println(h);
		}
	}
	
	protected static void displayPeekPrompt(ArrayList<Kid> kids){
		System.out.println("You chose: Peek inside a kid's bag");
		int kidIndex = InputHelper.getKidStringFromUser("Choose a kid name", kids);
		kids.get(kidIndex).peekBag();
	}
	
	protected static void displayHouseCandy(ArrayList<House> houses, MenuOptions type){
		//Type determines whether we choose option 5, 6, or 7 on the menu
		System.out.println("You chose: " + type.getDisplayString());
		
		if (houses.isEmpty()){
			System.out.println("There are no houses to get candy at. Sorry.");
			return;
		}
		
		int option = InputHelper.getRestrictedIntFromUser("Choose a house number between 1 and " + houses.size(), 1, houses.size());
		
		if (type == MenuOptions.CHECK_HOUSE){
			if (houses.get(option-1).getCandyCount() == 0)
				System.out.println("Sorry, this house has no more candy.");
			else
				System.out.println("Yes. " + houses.get(option-1));
		}
		else if (type == MenuOptions.CANDY_HOUSE_CHECK){
			System.out.println(houses.get(option-1));
		}
		else if (type == MenuOptions.CHOCOLATE_HOUSE_CHECK){
			houses.get(option-1).printChocolateCount();
		}
	}
	
	protected static void sendAllKids(ArrayList<Kid> kids, ArrayList<House> houses){
		System.out.println("You chose: Send all kids to a house");
		int houseNum = InputHelper.getRestrictedIntFromUser("Choose a house number between 1 and " + houses.size(), 1, houses.size());
		
		House house = houses.get(houseNum-1);
		try{
			for(Kid k: kids){
				Candy piece = house.givePiece();
				k.collectCandy(piece);
			}
		}catch(OutOfCandyException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	protected static void sendOneKid(ArrayList<Kid> kids, ArrayList<House> houses){
		System.out.println("You chose: Send one kid to a house");
		int kidIndex = InputHelper.getKidStringFromUser("Choose a kid name", kids);
		int houseNum = InputHelper.getRestrictedIntFromUser("Choose a house number between 1 and " + houses.size(), 1, houses.size());
		
		try{
			Candy piece = houses.get(houseNum-1).givePiece();
			kids.get(kidIndex).collectCandy(piece);
		}catch(OutOfCandyException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	protected static void eatCandy(ArrayList<Kid> kids){
		System.out.println("You chose: Let one lucky kid eat a random amount of candy");
		int kidIndex = InputHelper.getKidStringFromUser("Choose a kid name", kids);
		
		Kid chosenKid = kids.get(kidIndex);
		
		if (chosenKid.getBagSize() == 0){
			System.out.println(chosenKid.getName() + " has no candy to eat");
			return;
		}
		
		int randNum = (int)(Math.random() * chosenKid.getBagSize()) + 1;
		
		for (int i=0; i<randNum; i++)
			chosenKid.eatCandy();
	}
	
	protected static void sortCandy(ArrayList<Kid> kids){
		System.out.println("You chose: Sort a kid's bag of candy");
		int kidIndex = InputHelper.getKidStringFromUser("Choose a kid name", kids);
		
		Kid chosenKid = kids.get(kidIndex);
		chosenKid.sortBag();
		System.out.println(chosenKid.getName() + "'s candy bag has been sorted.");
	}
	
}
