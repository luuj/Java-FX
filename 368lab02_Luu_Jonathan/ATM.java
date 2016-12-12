import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
	ArrayList<BankAccount> allAccounts;
	private static final int TOTAL_ACCOUNTS = 14;
	private static final int ACCOUNT_NUMBER_START = 11111;
	private Scanner sc;
	
	public ATM(){
		allAccounts = new ArrayList<BankAccount>();
		sc = new Scanner(System.in);
		
		//Initialize accounts
		for (int i=0; i<TOTAL_ACCOUNTS; i++){
			allAccounts.add(new CheckingAccount(200*i+100));
			allAccounts.add(new SavingAccount(300*i+100+(50*i)));
		}
	}
	
	//Print all accounts currently in the ATM
	public void printCurrentAccounts(){
		System.out.printf("%-20s %-21s %-20s %s\n", "Account #", "Balance", "Fees", "Type");
		for (int i=0; i<73; i++) System.out.print('-');
		System.out.println();
		
		for (int i=0; i<TOTAL_ACCOUNTS; i++){
			System.out.printf("%-20d $%-20.2f $%-20.2f", allAccounts.get(i).getAccountNumber(), allAccounts.get(i).getBalance(), 
					allAccounts.get(i).computeFees());
		
		String type;
		if (allAccounts.get(i) instanceof CheckingAccount)
			type = "Checking";
		else
			type = "Saving";
		
		System.out.println(type);
		}
	}
	
	public int getTotalAccounts(){
		return TOTAL_ACCOUNTS;
	}
	
	public BankAccount getBankAccount(int i){
		return allAccounts.get(i-ACCOUNT_NUMBER_START);
	}
	
	
	/******************************************************************************
	 * Code to prompt users for account number and checking/saving account actions*
	 *****************************************************************************/
	public int promptAccountNumber(){
		System.out.println("\nWelcome to the ATM. Please enter in an account number or type 'Exit' to quit.");
		
		int accountNumber = -1;
		while (true){
			String enteredNumber = sc.nextLine();
			
			try{
				if ((enteredNumber.toLowerCase()).equals("exit") || (enteredNumber.toLowerCase()).equals("'exit'")){
					System.out.println("See you next time!");
					return -1;
				}
				if (testValidNumber(enteredNumber)){
					accountNumber = Integer.parseInt(enteredNumber);
					break;
				}
				else{
					System.out.println("\nPlease enter in a valid account number");
					continue;
				}
			}catch(Exception ex){
				System.out.println("\nPlease enter in a valid integer account number");
				continue;
			}
		}
		
		return accountNumber;
	}
	
	//Checking account options
	public void promptCheckingOptions(CheckingAccount currAccount){		
		while (true){
			System.out.println(currAccount + "\nPlease select a method by entering in a number:\n1.Write a check\n2.Return to home");
			String enteredNumber = sc.nextLine();
			
			try{
				if (Integer.parseInt(enteredNumber) == 1){
					updateCheckingAccount(currAccount);
				}
				else if (Integer.parseInt(enteredNumber) == 2){
					return;
				}
				else{
					System.out.println("\nPlease enter in a valid number");
					continue;
				}
			}catch(Exception ex){
				System.out.println("\nPlease enter in a valid integer number");
				continue;
			}
		}
	}
	
	//Saving account options
	public void promptSavingOptions(SavingAccount currAccount){
		while (true){
			System.out.println(currAccount + "\nPlease select a method by entering in a number:\n1.Withdraw\n2.Deposit\n3.Return to home");
			String enteredNumber = sc.nextLine();
			
			try{
				if (Integer.parseInt(enteredNumber) == 1){
					updateSavingAccount(currAccount, false);
				}
				else if (Integer.parseInt(enteredNumber) == 2){
					updateSavingAccount(currAccount, true);
				}
				else if (Integer.parseInt(enteredNumber) == 3){
					return;
				}
				else{
					System.out.println("\nPlease enter in a valid number");
					continue;
				}
			}catch(Exception ex){
				System.out.println("\nPlease enter in a valid integer number");
				continue;
			}
		}
	}
	
	//Test if check amount is valid
	public void updateCheckingAccount(CheckingAccount currAccount){
		while (true){
			DecimalFormat format = new DecimalFormat("0.00");
			System.out.println("Enter in a value for your check. Current balance: $" + format.format(currAccount.getBalance()) + "\nIf you wish to cancel this request, type cancel.");
			String checkingInput = sc.nextLine();
			double inputAmount;
			
			if ((checkingInput.toLowerCase()).equals("cancel")){
				return;
			}
			
			try{
				inputAmount = Double.parseDouble(checkingInput);
				//Check for valid check amounts
				if (inputAmount < 0){
					System.out.println("Error. Entered value is less than 0.");
					continue;
				}
				if (inputAmount > currAccount.getBalance()){
					System.out.println("Error. Entered value is greater than current balance.");
					continue;
				}
				
				currAccount.writeCheck(inputAmount);
				System.out.println("You have successfully written a check for $" + format.format(inputAmount));
				break;
			}catch(Exception ex){
				System.out.println("Please enter in a valid check deposit amount or type 'Cancel' to go back.");
			}
		}
	}
	
	//Test if deposit/withdrawal amount is valid
	public void updateSavingAccount(SavingAccount currAccount, Boolean depositTrue){
		while (true){
			DecimalFormat format = new DecimalFormat("0.00");
			
			if (depositTrue)
				System.out.println("Enter in an deposit amount. Current balance: $" + format.format(currAccount.getBalance()) + "\nIf you wish to cancel this request, type cancel.");
			else
				System.out.println("Enter in an withdrawal amount. Current balance: $" + format.format(currAccount.getBalance()) + "\nIf you wish to cancel this request, type cancel.");

			String checkingInput = sc.nextLine();
			double inputAmount;
			
			if ((checkingInput.toLowerCase()).equals("cancel")){
				return;
			}
			
			try{
				inputAmount = Double.parseDouble(checkingInput);
				//Check for valid check amounts
				if (inputAmount < 0){
					System.out.println("Error. Entered value is less than 0.");
					continue;
				}

				if (depositTrue){
					currAccount.deposit(inputAmount);
					System.out.println("You have successfully deposited $" + format.format(inputAmount));
				}
				else{
					if (inputAmount > currAccount.getBalance()){
						System.out.println("Error. Entered value is greater than current balance.");
						continue;
					}
					currAccount.withdraw(inputAmount);
					System.out.println("You have successfully withdrawn $" + format.format(inputAmount));
				}
				
				break;
			}catch(Exception ex){
				System.out.println("Please enter in a valid check deposit amount or type 'Cancel' to go back.");
			}
		}
	}
	
	//Test if account number is valid
	public boolean testValidNumber (String num) throws Exception{
		int convertedNum = Integer.parseInt(num);
		int currentAccountNum = new ATM().getTotalAccounts();

		int lowerLimit = 11111;
		int upperLimit = lowerLimit + currentAccountNum - 1;
		
		if (convertedNum >= lowerLimit && convertedNum <= upperLimit)
			return true;
		
		return false;
	}
}
