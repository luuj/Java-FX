import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapOfPeople {
	private HashMap<String, Person> hashMap;
	private TreeMap<String, Person> treeMap;
	
	MapOfPeople(){
		hashMap = new HashMap<String, Person>();
		treeMap = new TreeMap<String, Person>();
	}
	
	void hashMapFun(){
		populateHashMap();
		
		Set<String> allPeople = hashMap.keySet();
		printKeySet(allPeople, "HashMap KeySet Fun");
		
		getKey("Babs");
		getKey("Cosmo");
		
		Collection<Person> allPersons = hashMap.values();
		printObjectSet(allPersons, "HashMap ObjectSet Fun");
	}
	
	void treeMapFun(){
		populateTreeMap();
		
		Collection<Person> allPersons = treeMap.values();
		printObjectSet(allPersons, "TreeMap ObjectSet Fun");
		tailTreeMap();

		removeTreeMap();
		pollTreeMap();
	}
	
	//Adds people into the hash-map
	void populateHashMap(){
		hashMap.put("Bob", new Person("Bob", "bob@usc.edu", "June 20, 1995"));
		hashMap.put("Santa", new Person("Santa", "santa@usc.edu", "December 25, 1880"));
		hashMap.put("Labbit", new Person("Labbit", "cat@usc.edu", "April 20, 6969"));
		hashMap.put("Babs", new Person("Babs", "sir@usc.edu", "January 1, 1990"));
		hashMap.put("Cosmo", new Person("Cosmo", "notcat@usc.edu", "November 10, 1992"));
		hashMap.put("Bobbert", new Person("Bobbert", "bob2@usc.edu", "June 22, 1995"));
	}
	
	//Takes in a set and prints it out
	void printKeySet(Set<String> allPeople, String message){
		System.out.println("\n***** " + message + " *****");
		for (String s : allPeople){
			System.out.println(s + " is in the set!");
		}
	}
	
	//Find a specific person in the hash-map and print them out
	void getKey(String key){
		Person p = hashMap.get(key);
		System.out.println("\n***** Get specific person from HashMap *****");
		System.out.println(p.getName() + " was retrieved from the HashMap");
	}
	
	//Takes in a collection and prints it out
	void printObjectSet(Collection<Person> allPersons, String message){
		System.out.println("\n***** " + message + " *****");
		for (Person p : allPersons){
			System.out.println(p);
		}
	}
	
	//Adds people into the hash-map
	void populateTreeMap(){
		treeMap.put("Bob", new Person("Bob", "bob@usc.edu", "June 20, 1995"));
		treeMap.put("Santa", new Person("Santa", "santa@usc.edu", "December 25, 1880"));
		treeMap.put("Labbit", new Person("Labbit", "cat@usc.edu", "April 20, 6969"));
		treeMap.put("Babs", new Person("Babs", "sir@usc.edu", "January 1, 1990"));
		treeMap.put("Cosmo", new Person("Cosmo", "notcat@usc.edu", "November 10, 1992"));
		treeMap.put("Bobbert", new Person("Bobbert", "bob2@usc.edu", "June 22, 1995"));
	}	
	
	//Testing the size and remove functions of TreeMap
	void removeTreeMap(){
		System.out.println("\n***** Removal and Size of TreeMap *****");
		System.out.println("Current size of TreeMap is: " + treeMap.size());
		System.out.println(treeMap.remove("Santa").getName() + " was removed from the TreeMap");
		System.out.println("Current size of TreeMap is: " + treeMap.size());
	}
	
	//Testing the poll functions of TreeMap
	void pollTreeMap(){
		Map.Entry<String, Person> firstEntry = treeMap.pollFirstEntry();
		Map.Entry<String, Person> lastEntry = treeMap.pollLastEntry();
		
		System.out.println("\n*****Polling first and last entries of TreeMap *****");
		System.out.println(firstEntry.getKey() + " is the first entry and was removed");
		System.out.println(lastEntry.getKey() + " is the last entry and was removed");
		System.out.println("Current size of TreeMap is: " + treeMap.size());
	}

	void tailTreeMap(){
		SortedMap<String, Person> sm = treeMap.tailMap("Cosmo");
		Iterator<Entry<String, Person>> it = sm.entrySet().iterator();

		System.out.println("\n***** Create sub-TreeMap using tail function *****");
		while (it.hasNext()){
			Map.Entry<String, Person> pair = (Map.Entry<String, Person>)it.next();
			System.out.println(pair.getKey() + " is in the tail TreeMap");
		}
	}
}
