/* Counter.java
 * George Bonnici-Carter
 * COSC241
 * 27/02/2015
 */
 
package week01;
import java.util.Scanner;

/** class declaration.
    @author George Bonnici-Carter.
 */
public class Counter{

    /** main method is a sick cunt.
     *@param args which takes a string a returns the count.
     */
    public static void main(String[]args){

        //data fields
        int words = 0;
        int lines = 0;

        //declaring first scanner
        Scanner sc = new Scanner(System.in);

        //while loops for line number
        while(sc.hasNextLine()){
            String phrase = sc.nextLine();
            Scanner sc2 = new Scanner(phrase);
            lines++;

            //second while loop to read the amount of words in a line
            while(sc2.hasNext()){
                String blakebrah  = sc2.next();
                words++;
                
            }//end inner loop

        }//end loop
        
        System.out.println("lines: " + lines);
        System.out.println("words: " + words);
        
    }//end main
    
}//end class
