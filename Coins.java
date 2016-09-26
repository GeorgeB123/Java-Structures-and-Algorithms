/* Coins.java
 * Lab02  
 * George Bonnici-Carter
 * COSC241
 * 03/03/2015
 */

package week02;
import java.util.Random;

/** class declaration.
    @author George Bonnici-Carter.
*/
public class Coins{

    /**first data fields.
     */
    public static final boolean HEADS = true;
    /**second data field.
     */
    public static final boolean TAILS = false;

    /**boolean array.
     */
    private boolean[] coins;

    /**declaring a random.
     */
    private Random rnd = new Random();

    /** main method.
     *@param args which prints out the different constructors.
     */
    public static void main(String [] args) {
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        Coins s = new Coins("HHHHTTTHHHTTTTHHHH");
        // Coins l = new Coins(35);
        System.out.println(c.countHeads());
        System.out.println(s.toString());
        System.out.println(s.countHeads());
        System.out.println(s.countRuns());
    }

    /**Constructor to initialise coins.
     *@param coins which declares coins.  
     */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    
    /**countHeads constructor.
     *@return int counting the amount of heads that are returned.
     */
    public int countHeads(){
        int count = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] == HEADS){
                count++;
            }
        }
        return count;
    }

    /**toString method to return number of heads and tails.
     *@return String which stores the heads or tails in a String.
     */
    public String toString(){
        String nipples = "";
        for(int l = 0; l < coins.length; l++){
            if(coins[l] == HEADS){
                nipples += "H";
            } else {
                nipples += "T";
            }
        }
        return nipples ;
    }

    /**string Coins method.
     *@param c which is the string in which heads or tails are saved in.
     */
    public Coins(String c){
        coins = new boolean[c.length()];
        for(int i = 0; i < c.length(); i++){
            if(c.charAt(i) == 'H'){
                coins[i] = HEADS;
            }else if(c.charAt(i) == 'T'){
                coins[i] = TAILS;
            }
        }
                
   
    }

    /**int Coins method.
     *@param length which gives random values of heads or tails.
     */
    public Coins(int length){
        coins = new boolean[length];  
        for(int i = 0; i < length; i++){
            int g = rnd.nextInt(2);
            if(g == 0){
                coins[i] = HEADS;
            }else if(g == 1){
                coins[i] = TAILS;
            }
        }
    }

    /**countRuns method to count the runs.
     *@return int which gives the amount of runs.
     */
    public int countRuns(){
        int runs = 1;
        for(int i = 1; i < coins.length; i++){
            if(coins[i-1] != coins[i]){
                runs++;
            }
        }
        return runs;
    }
}
