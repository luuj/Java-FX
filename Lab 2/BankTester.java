public class BankTester {
	
	//Part 1 -- testing BankAccount
	public static void testAccountsBasic(){
		CheckingAccount test1 = new CheckingAccount();
		SavingAccount test2 = new SavingAccount();
		SavingAccount test3 = new SavingAccount(400.20);
		CheckingAccount test4 = new CheckingAccount(650.50);
		
		BankAccount[] allAccounts = new BankAccount[4];
		allAccounts[0] = test1;
		allAccounts[1] = test2;
		allAccounts[2] = test3;
		allAccounts[3] = test4;
		
		test2.deposit(390.0);
		test3.withdraw(100);
		
		for (int i=0; i<4; i++)
			System.out.println(allAccounts[i]);
	}
	
	public static void main(String [] args){	
		//testAccountsBasic();
		ATM atm = new ATM();
		
		while (true){
			atm.printCurrentAccounts();
		
			int currAccount = atm.promptAccountNumber();
			
			//Exit the program if user quits
			if (currAccount == -1)
				return;
			
			if (atm.getBankAccount(currAccount) instanceof CheckingAccount){
				atm.promptCheckingOptions((CheckingAccount)atm.getBankAccount(currAccount));
			}
			else if (atm.getBankAccount(currAccount) instanceof SavingAccount){
				atm.promptSavingOptions((SavingAccount)atm.getBankAccount(currAccount));
			}
			else
				System.out.println("Error finding account.");
		}
	}
}
