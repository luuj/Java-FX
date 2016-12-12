/* Name: Jonathan Luu
 * Date: August 27, 2016
 */

public class Lab1P7 {

  public static void main (String[] args) {
    String myString;
    
    //Need to initialize myString
    myString = "Test String";
    
    reverseIt( myString );
  }
  
  public static void reverseIt( String original ) {
    
    for ( int i=original.length()-1; i>=0; i-- ) {
      System.out.print(original.substring(i,i+1) );
    }

    System.out.println();
    
    //Either remove the return statement or change the return type of the function -- I removed the return statement as there is no need for a String return
  }
}