package week03;

/** class declaration.
    @author George Bonnici-Carter.
*/
public class RecursiveApp{

    /** digits method of recursion.
     *@param n which gives a long value.
     *@return long which returns the amount of digits.
     */
    public static long digits(long n){
        if(n < 10){
            return 1;
        }
        return 1 + digits(n/10);
        

    }

    /** sumOfDigits method of recursion.
     *@param n which gives a long value.
     *@return long which returns the sum of the digits.
     */
    public static long sumOfDigits(long n){
        if(n/10 == 0){
            return n;
        }            
        return (n%10)+sumOfDigits(n/10);

    }

}
