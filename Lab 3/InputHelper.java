import java.util.ArrayList;
import java.util.Scanner;

public class InputHelper {
	private static Scanner sc = new Scanner(System.in);
	
	public static int getIntFromUser(String prompt){
		System.out.println(prompt);
		int enteredInt = 0;
		
		while (true){
			try{
				enteredInt = sc.nextInt();
				sc.nextLine();
				break;
			}catch(Exception ex){
				System.out.println("Please enter in a valid integer");
				sc.nextLine();
				continue;
			}
		}
		return enteredInt;
	}
	
	public static int getRestrictedIntFromUser(String prompt, int low, int high){
		int restrictedInt = 0;
		while (true){
			restrictedInt = getIntFromUser(prompt);
			if (restrictedInt < low || restrictedInt > high){
				System.out.println("Please enter in an integer between " + low + " and " + high);
				continue;
			}
			break;
		}
		return restrictedInt;
	}
	
	public static String getStringFromUser(String prompt){
		System.out.println("\n" + prompt);
		String enteredString = "";
		enteredString = sc.nextLine();

		return enteredString;
	}
	
	public static int getKidStringFromUser(String prompt, ArrayList<Kid> kids){
		int kidIndex = -1;
		
		System.out.println("***VALID KID NAMES***");
		for (Kid k: kids)
			System.out.println(k.getName());

		while(true){
			String restrictedString = getStringFromUser(prompt).toLowerCase();
			for (int i=0; i<kids.size(); i++){
				String tempInput = kids.get(i).getName().toLowerCase();
				if (tempInput.equals(restrictedString))
					kidIndex = i;
			}
			
			//If invalid kid name is entered, try again
			if (kidIndex == -1){
				System.out.println("Error. Invalid kid name");
				continue;
			}
			break;
		}
		
		return kidIndex;
	}
}
