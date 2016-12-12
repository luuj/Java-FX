import java.util.ArrayList;
import java.util.Random;

public class LargestNumberRecursion {
	ArrayList<Integer> allNumbers;
	
	LargestNumberRecursion(){
		allNumbers = new ArrayList<Integer>();
		
		//Add 20 random numbers to the array
		populateArray();
		
		//Print array for reference
		printArray();
		
		//Recursively find max integer
		System.out.println("\nMax number is: " + recurseMax(0));
	}
	
	void populateArray(){
		Random rNumber = new Random();
		for (int i=0; i<20; i++)
			allNumbers.add(rNumber.nextInt(1000));
	}
	
	void printArray(){
		System.out.println("***** All Numbers in ArrayList *****");
		for (int j=0; j<4; j++){
			for (int i=0; i<5; i++)
				System.out.print(allNumbers.get((j*5) + i) + "  ");
			System.out.println();
		}
	}
	
	int recurseMax(int index){
		if (index < allNumbers.size()){
			return Math.max(allNumbers.get(index), recurseMax(index+1));
		}else
			return allNumbers.get(allNumbers.size()-1);
	}
}
