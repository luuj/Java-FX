import java.text.DecimalFormat;

public class SavingAccount extends BankAccount{

	private int transactionNum;
	private static final double ACTION_AMOUNT = 0.05;

	public SavingAccount(){
		this(0);
	}
	
	public SavingAccount(double bal){
		super(bal);
		transactionNum = 0;
	}
	
	public void deposit(double val){
		if (val < 0){
			System.out.println("Given deposit value is less than 0. Cancelling deposit.");
			return;
		}
		
		addToBalance(val);
		transactionNum++;
	}
	
	public void withdraw(double val){
		if (val < 0){
			System.out.println("Given withdrawal value is less than 0. Cancelling withdrawal.");
			return;
		}
		
		subtractFromBalance(val);
		transactionNum++;
	}
	
	@Override
	public double computeFees() {
		double totalFees = 0.00;
		
		//No fees if balance > 1000
		if (super.getBalance() >= 2000)
			return totalFees;
		else{
			//First 5 actions are free
			if (transactionNum > 5)
				totalFees += ACTION_AMOUNT * (transactionNum-5);
			
			if (super.getBalance() < 500)
				totalFees += 10.00;
		}
		return totalFees;
	}
	
	@Override
	public String toString() {
		DecimalFormat format = new DecimalFormat("0.00");

		return "SavingAccount: Account number is:" + super.getAccountNumber() + ";  Balance is: $" + format.format(super.getBalance()) + ";  Fees are:  $" +  format.format(computeFees());	
	}

}
