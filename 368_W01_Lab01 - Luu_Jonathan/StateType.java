//Enumerations for pet states

public enum StateType {
	SLEEPING (" is currently fast asleep."),
	EATING (" is currently chowing down on food."),
	THINKING (" is currently pondering life."),
	PLAYING (" is currently frolicking about."),
	UNKNOWN (" is currently awaiting instructions.");
	
	private String message;
	
	private StateType(String msg){
		message = msg;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getState(){
		return this.toString().toLowerCase();
	}
	
}
