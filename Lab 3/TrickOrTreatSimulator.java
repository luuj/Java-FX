import java.util.ArrayList;

public class TrickOrTreatSimulator {
	
	private ArrayList<Kid> kids;
	private ArrayList<House> houses;

	public TrickOrTreatSimulator() {
		kids = makeSampleKids();
		houses = makeSampleHouses(10);
	}
	
	public TrickOrTreatSimulator(ArrayList<Kid> kids, ArrayList<House> houses) {
		this.kids = kids;
		this.houses = houses;
	}

	public static ArrayList<Kid> makeSampleKids() {
		ArrayList<Kid> myKids = new ArrayList<Kid>();
		myKids.add(new Kid("Bryce", "Nerd Emoji"));
		myKids.add(new Kid("Eridani", "Kissing Face Emoji"));
		myKids.add(new Kid("Tony", "Tiger"));
		myKids.add(new Kid("Jake", "Deadshot"));
		myKids.add(new PickyKid("Bobby", "Potato", "Kit-Kat"));
		return myKids;
	}
	
	public static ArrayList<House> makeSampleHouses(int numHouses) {
		ArrayList<House> myHouses = new ArrayList<>(numHouses);
		for(int i = 0; i < numHouses/2; i++){
			myHouses.add(new House(CandyFactory.getABunchOfLollipops()));
			myHouses.add(new House(CandyFactory.getAMixedBag()));
		}
		return myHouses;
	}

	//Displays menu options and prompts user for input
	private void run() {
		while (true){
			System.out.println(MenuOptions.getWholeMenu());
			int option = InputHelper.getRestrictedIntFromUser("\nChoose a menu option by entering in a number", 1, 11);
			
			switch(option){
			case 1:
				DisplayHelper.displayAllKids(kids);
				break;
			case 2:
				DisplayHelper.displayAllHouses(houses);
				break;
			case 3:
				DisplayHelper.displayPeekPrompt(kids);
				break;
			case 4:
				DisplayHelper.sortCandy(kids);
				break;
			case 5:
				DisplayHelper.displayHouseCandy(houses, MenuOptions.CHECK_HOUSE);
				break;
			case 6:
				DisplayHelper.displayHouseCandy(houses, MenuOptions.CANDY_HOUSE_CHECK);
				break;
			case 7:
				DisplayHelper.displayHouseCandy(houses, MenuOptions.CHOCOLATE_HOUSE_CHECK);
				break;
			case 8:
				DisplayHelper.sendAllKids(kids, houses);
				break;
			case 9:
				DisplayHelper.sendOneKid(kids, houses);
				break;
			case 10:
				DisplayHelper.eatCandy(kids);
				break;
			case 11:
				return;
			}
			
			//Wait before re-showing the menu
			try{
				Thread.sleep(2000);
			}catch(Exception ex){
			}
		}
	}
	
	public static void main(String[] args) {
		TrickOrTreatSimulator sim = new TrickOrTreatSimulator(makeSampleKids(), makeSampleHouses(8));
		sim.run();
	}

}
