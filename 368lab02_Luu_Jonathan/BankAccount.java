import java.text.DecimalFormat;

public abstract class BankAccount {
	private static int nextAccountNumber = 11111;
	private int accountNumber;
	private double balance;

	public BankAccount() {
		accountNumber = nextAccountNumber;
		nextAccountNumber++;

		balance = 0;
	}

	public BankAccount( double bal ) {
		this();  //Calls the default constructor
		if (bal < 0){
			System.out.println("Bank Account initialized with negative value. Error.");
			return;
		}
		
		balance = bal;
	}

	public String toString() {
		DecimalFormat format = new DecimalFormat("0.00");

		return "BankAccount: Account number is:" + accountNumber + ";  Balance is: $" + format.format(balance) ;
	}

	public void addToBalance( double amt ) {
		balance += amt;
	}

	public void subtractFromBalance( double amt ) {
		balance -= amt;
	}

	public abstract double computeFees();
		
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public double getBalance(){
		return balance;
	}
}
