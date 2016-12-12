public enum PetKind {
	CAT (" cat"),
	DOG (" dog"),
	RABBIT (" rabbit"),
	HAMSTER (" hamster"),
	UNKNOWN (" unknown");
	
	private String message;
	
	private PetKind(String msg){
		message = msg;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getState(){
		return this.toString();
	}
}
