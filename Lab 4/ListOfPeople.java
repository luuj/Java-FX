import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfPeople {
	private ArrayList<Person> arrayList;
	private LinkedList<Person> linkedList;
	
	ListOfPeople(){
		arrayList = new ArrayList<Person>();
		linkedList = new LinkedList<Person>();
	}
	
	void arrayListFun(){
		arrayListPeopleCreation();
		printList(arrayList, "ArrayList of People");
		printSubArrayList(1,4);
		
		ArrayList<Person> bPeople = arrayListB();
		printList(bPeople, "ArrayList - Names that start with B");
	}
	
	void linkedListFun(){
		linkedListPeopleCreation();
		printList(linkedList, "LinkedList of People");
		peekLinkedPeople();
		popLinkedPeople();
		printList(linkedList, "Reduced LinkedList");
		peekLinkedPeople();
	}
	
	//Create people and add them to the array-list
	void arrayListPeopleCreation(){
		arrayList.add(new Person("Bob", "bob@usc.edu", "June 20, 1995"));
		arrayList.add(new Person("Santa", "santa@usc.edu", "December 25, 1880"));
		arrayList.add(new Person("Labbit", "cat@usc.edu", "April 20, 6969"));
		arrayList.add(new Person("Babs", "sir@usc.edu", "January 1, 1990"));
		arrayList.add(new Person("Cosmo", "notcat@usc.edu", "November 10, 1992"));
		arrayList.add(new Person("Bobbert", "bob2@usc.edu", "June 22, 1995"));
	}
	
	//Iterate through a list and print everyone inside
	void printList(List<Person> currList, String peopleType){
		System.out.println("\n***** " + peopleType + " *****");
		for (int i=0; i<currList.size(); i++)
			System.out.println(currList.get(i));
	}
	
	//Get a sub-array of array-list and print it out
	void printSubArrayList(int fromIndex, int toIndex){
		List<Person> subList = arrayList.subList(fromIndex, toIndex);
		printList(subList, "Sub-ArrayList of People: Index " + fromIndex + " to " + (toIndex-1));
	}
	
	//Find people who's name starts with the letter 'B'
	ArrayList<Person> arrayListB(){
		Person currPerson;
		String currPersonName;
		ArrayList<Person> bPeople = new ArrayList<Person>();
		
		for (int i=0; i<arrayList.size(); i++){
			currPerson = arrayList.get(i);
			currPersonName = currPerson.getName();
			if (currPersonName.charAt(0) == 'B')
				bPeople.add(currPerson);
		}
		
		return bPeople;
	}
	
	//Create people and add them to the linked-list
	void linkedListPeopleCreation(){
		linkedList.add(new Person("Yo", "c++isbetter@usc.edu", "August 20, 1995"));
		linkedList.add(new Person("Friend", "turdsandwich@usc.edu", "November 25, 1880"));
		linkedList.add(new Person("Ipod Touch", "shesbrave@usc.edu", "May 20, 6969"));
		linkedList.add(new Person("Banana", "stanmarsh@usc.edu", "February 1, 1990"));
		linkedList.add(new Person("Jelly", "stewie@usc.edu", "October 10, 1992"));
		linkedList.add(new Person("Time", "briangriffin@usc.edu", "September 22, 1995"));
	}
	
	//Remove some people from linked-list
	void popLinkedPeople(){
		System.out.println("\n***** Popping people from LinkedList *****");
		for (int i=0; i<3; i++)
			System.out.println(linkedList.pop().getName() + " was popped from the list");
	}
	
	//Look at front and end of linked-list
	void peekLinkedPeople(){
		System.out.println("\n***** Peeking at people from LinkedList *****");
		System.out.println(linkedList.peek().getName() + " was peeked at. They are the first person in the list");
		System.out.println(linkedList.peekLast().getName() + " was peeked at. They are the last person in the list");
	}
}
