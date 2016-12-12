/* Name: Jonathan Luu
 * Date: August 27, 2016
 * Explanations are written in comment form rather than in a separate text file
 */

public class Lab1Strings {
	public static void main (String [] args){
		//Initialize strings
		String s1 = "Welcome to Java";
		String s2 = s1;
		String s3 = new String("Welcome to Java");
		String s4 = s3.intern();
		
		//s1==s2. Since == determines whether or not they occupy the same memory address and we assign s2 to s1, they are the same.
		System.out.println("I predict true for s1==s2. The answer is: " + (s1==s2));
		
		//s1==s3. Although they have the same data, they point to different places in memory so they are not the same.
		System.out.println("I predict false for s1==s3. The answer is: " + (s1==s3));

		//s1.equals(s2). Since they point to the same memory address, they have the same data as well so they are equal
		System.out.println("I predict true for s1.equals(s2). The answer is: " + s1.equals(s2));

		//s2.equals(s3). Since s2 has the same data value as s3, it is true
		System.out.println("I predict true for s2.equals(s3). The answer is: " + s2.equals(s3) );

		//s1.compareTo(s2). Since the values are equal, it will return 0.
		System.out.println("I predict 0 for s1.compareTo(s2). The answer is: " + s1.compareTo(s2));
		
		//s1.compareTo(s3). Since the values are still equal, it will return 0 as it is looking at data values.
		System.out.println("I predict 0 for s2.compareTo(s3). The answer is: " + s2.compareTo(s3) );

		//s1==s4. Since it looks up a reference to see if the string exists previously, it should output true
		System.out.println("I predict true for s1==s4. The answer is: " + (s1==s4));
		
		//s1.charAt(0). The first character in s1 is W
		System.out.println("I predict that it will be 'W'. The answer is: " + s1.charAt(0));
		
		//s1.indexOf('j').  There is no lower case j so it will output -1
		System.out.println("I predict that it will be -1 as there is no lowercase j. The answer is: " + s1.indexOf('j'));

		//s1.indexOf('to'). It will output the index value of t as 'to' is in the String
		System.out.println("I predict that it will be 8. The answer is: " + s1.indexOf("to"));
		
		//s1.substring(5,11). It will output the string s1 between index values [5,11)
		System.out.println("I predict that it will be \"me to \". The answer is: " + s1.substring(5,11));
		
		//s1.toLowerCase(). It will output string s1 in lower-case
		System.out.println("I predict that it will be \"welcome to java\". The answer is: " + s1.toLowerCase());

		//s1.toUpperCase(). It will output string s1 in upper-case
		System.out.println("I predict that it will be \"WELCOME TO JAVA\". The answer is: " + s1.toUpperCase());

		//" Welcome ".trim(). It will remove the white-spaces from Welcome
		System.out.println("I predict that it will be \"Welcome\". The answer is: " + " Welcome ".trim());

		//s1.substring(5). It will cut off values prior to the index value of 5 in s1
		System.out.println("I predict that it will be \"me to Java\". The answer is: " + s1.substring(5));
	
	}	
}
