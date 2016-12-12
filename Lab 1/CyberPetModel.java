public class CyberPetModel {
	private String name;
	private StateType st;
	private PetKind pk;

	//Base Constructor
	public CyberPetModel(){
		this("Unknown", PetKind.CAT);
	}
	
	public CyberPetModel(String givenName, PetKind petkind){
		name = givenName;
		
		//Set state-type and pet-kind to unknown at first
		st = StateType.SLEEPING;
		pk = petkind;
	}
		
	//Set pet status
	public void eat(){
		st = StateType.EATING;
	}
	
	public void sleep(){
		st = StateType.SLEEPING;
	}
	
	public void think(){
		st = StateType.THINKING;
	}
	
	public void play(){
		st = StateType.PLAYING;
	}
	
	public String getName(){
		return name;
	}
	
	public String getType(){
		return pk.getState();
	}
	
	public String getState(){
		return st.getMessage();
	}
	
	//Overload toString() method to print
	public String toString(){
		String status = "CyberPet " + name + st.getMessage();
		return status;
	}
		
}

