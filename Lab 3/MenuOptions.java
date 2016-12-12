
public enum MenuOptions {
	DISPLAY_KIDS("Display all kids, names, and costumes"),
	DISPLAY_HOUSES("Display all houses"),
	PEEK_BAG("Peek inside a kid's bag"),
	SORT_BAG("Sort a kid's bag of candy"),
	CHECK_HOUSE("Check if a house still has candy"),
	CANDY_HOUSE_CHECK("Get total number of pieces of candy at a house"),
	CHOCOLATE_HOUSE_CHECK("Get total number of pieces of chocolate at a house"),
	SEND_ALL_KIDS("Send all kids to a house"),
	SEND_ONE_KID("Send one kid to a house"),
	KID_EAT("Let one lucky kid eat a random amount of candy"),
	EXIT("Exit the program");

	private String displayString; 

	private MenuOptions(String display){ //save display strings
		this.displayString = display;
	}
	
	public static String getWholeMenu(){
		String menu = "\n*****TRICK OR TREAT MENU *****";
		for(MenuOptions m : MenuOptions.values()){ 
			menu += "\n" + (m.ordinal() + 1) + ": " + m.getDisplayString();
			
		}
		return menu;
	}

	protected String getDisplayString() {
		return displayString;
	}

}
