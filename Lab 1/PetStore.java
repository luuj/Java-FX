import java.util.InputMismatchException;
import java.util.Scanner;

public class PetStore {
	private static CyberPetModel[] allPets;
	public static final int DEFAULT_CAPACITY = 8;
	
	//Hard-code pets into the store
	public static void initializeStore(){
		allPets = new CyberPetModel[DEFAULT_CAPACITY];
		
		allPets[0] = new CyberPetModel("Cosmo", PetKind.CAT);
		allPets[1] = new CyberPetModel("Oreo", PetKind.CAT);
		allPets[2] = new CyberPetModel("Rufus", PetKind.DOG);
		allPets[3] = new CyberPetModel("Tiger", PetKind.DOG);
		allPets[4] = new CyberPetModel("Hops", PetKind.RABBIT);
		allPets[5] = new CyberPetModel("Nibbler", PetKind.RABBIT);
		allPets[6] = new CyberPetModel("Bobster", PetKind.HAMSTER);
		allPets[7] = new CyberPetModel("Obstacle", PetKind.HAMSTER);
	}
	
	//Display all available pets for the user to choose from
	public static void displayPets(){
		//Formatting the display menu
		for (int i=0; i<80; i++){
			System.out.print("-");
			if (i==39)
				System.out.printf("\n%-20s %s\n", "Name", "Kind");
			if (i==79)
				System.out.println();
		}
		
		//Print out all pets available
		for (int i=0; i<DEFAULT_CAPACITY; i++){
			System.out.printf("%-20s %s\n", allPets[i].getName(), allPets[i].getType());
		}
	}
	
	//Check if a pet is currently in the store. If it is, return its index value
	public static int checkNameValidity(String name){
		for (int i=0; i<DEFAULT_CAPACITY; i++){
			if ( (allPets[i].getName().toLowerCase()).equals(name.toLowerCase()))
				return i;
		}
		
		return -1;
	}
	
	public static void main (String [] args){
		initializeStore();
		
		Scanner sc = new Scanner(System.in);
		String userInput;
		int currentPetNum = -1;
		int currentPetState = 0;
		boolean repeatProcess = true;

		System.out.println("Please select a pet from the menu below by entering in its name.");
		displayPets();
		
		//Prompt the user to select a pet
		while (true){
			userInput = sc.nextLine();
			currentPetNum = checkNameValidity(userInput);
			if (currentPetNum != -1){
				System.out.println("You have selected CyberPet " + allPets[currentPetNum].getName() + 
						", a " + allPets[currentPetNum].getType().toLowerCase() + " that" + allPets[currentPetNum].getState());
				break;
			}
			else
				System.out.println("Please try again. Pet could not be found.");
		}
		
		//Prompt the user to select a pet state
		while (repeatProcess){
			System.out.println("\nPlease select a pet state or exit the program by entering in a number.");
			System.out.printf("%-8s %-8s %-8s %-8s %s", "1-Sleep", "2-Eat", "3-Think", "4-Play", "5-Exit\n");
			
			//Check for valid input
			try{
				currentPetState = sc.nextInt();
			}catch(InputMismatchException ex){
				currentPetState = 0;
				sc.nextLine();
			}
			
			//Set the pet state
			switch (currentPetState){
			case 1: 
				allPets[currentPetNum].sleep();
				System.out.println(allPets[currentPetNum]);
				break;
			case 2:
				allPets[currentPetNum].eat();
				System.out.println(allPets[currentPetNum]);
				break;
			case 3:
				allPets[currentPetNum].think();
				System.out.println(allPets[currentPetNum]);
				break;
			case 4:
				allPets[currentPetNum].play();
				System.out.println(allPets[currentPetNum]);
				break;
			case 5:
				System.out.println("Exiting the pet store. See you next time!");
				repeatProcess = false;
				break;
			default:
				System.out.println("Error. Please enter in a valid number between 1 and 5 with no other characters.");
				break;
			}	
		}

	}
}
