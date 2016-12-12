import java.text.DecimalFormat;

public class CheckingAccount extends BankAccount{
	private int checkCount;
	private static final double FEE_AMOUNT = 0.10;
	
	public CheckingAccount(){
		this(0);
	}
	
	public CheckingAccount(double bal){
		super(bal);
		checkCount = 0;
	}
	
	public void writeCheck(double givenAmount){
		if (givenAmount < 0){
			System.out.println("Attempted to write a check for less than $0. Cancelling check deposit.");
			return;
		}
		
		subtractFromBalance(givenAmount);
		checkCount++;
	}
	
	@Override
	public double computeFees() {
		double totalFees = 0.00;
		
		//No fees if balance > 1000
		if (super.getBalance() >= 1000)
			return totalFees;
		else{
			totalFees += FEE_AMOUNT * checkCount;
			
			if (super.getBalance() < 100)
				totalFees += 5.00;
		}
		return totalFees;
	}
	
	@Override
	public String toString() {
		DecimalFormat format = new DecimalFormat("0.00");

		return "CheckingAccount: Account number is:" + super.getAccountNumber() + ";  Balance is: $" + format.format(super.getBalance()) + ";  Fees are:  $" +  format.format(computeFees());
	}

}
