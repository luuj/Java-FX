
public class Person {
	private String name, email, birthday;
	
	Person(String name, String email, String birthday){
		this.name = name;
		this.email = email;
		this.birthday = birthday;
	}
	
	Person(){
		this("Unknown", "unknown@gmail.com", "January 1, 1990");
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getBirthday() {
		return birthday;
	}


	@Override
	public String toString() {
		return name + "'s email is " + email + " and his birthday is " + birthday;
	}
	
	
}
