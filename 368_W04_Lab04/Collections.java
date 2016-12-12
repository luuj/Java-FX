
public class Collections {
	static void collectionFun(){
		ListOfPeople lp = new ListOfPeople();
		lp.arrayListFun();
		lp.linkedListFun();
		
		MapOfPeople mp = new MapOfPeople();
		mp.hashMapFun();
		mp.treeMapFun();
	}
	
	public static void main(String [] args){
		//Part 1: Collections
		//collectionFun();
		
		//Part 2: Recursion
		LargestNumberRecursion recurse = new LargestNumberRecursion();
	}
}
