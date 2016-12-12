/* Name: Jonathan Luu
 * Date: August 27, 2016
 */

public class Lab1StringBuffer {

	public static void main (String [] args){
		//Initialize strings
		String s1 = "Welcome to Java";
		String s2 = s1;
		String s3 = new String("Welcome to Java");
		String s4 = s3.intern();
		
		StringBuilder sb = new StringBuilder();
		sb.append(s1);
		sb.append("\n");
		sb.append(s2);
		sb.append("\n");
		sb.append(s3);
		sb.append("\n");
		sb.append(s4);
		sb.append("\n");
		
		System.out.println(sb.toString());
	}
}
