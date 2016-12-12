
public class OutOfCandyException extends Exception{
	static String message = "This house has run out of candy. No more candy will be distributed";
	public OutOfCandyException(){
		super(message);
	}
}
