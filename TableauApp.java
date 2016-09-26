package week05;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    //  public static void main(String[] args) {
    //   int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
    //   System.out.println(TableauApp.toString(valid));
    //    System.out.println(rowLengthsDecrease(valid));
    // }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        boolean gaz = false;
        if(rowLengthsDecrease(t)){
            gaz = true;
        }
        if(rowValuesIncrease(t)){
            gaz = true;
        }
        if(columnValuesIncrease(t)){
            gaz = true;
        }
        if(isSetOf1toN(t)){
            gaz = true;
        }
        return gaz;
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * Return true if no row is longer than the previous.
     * @param t a two-dimensional array which represents tableau.
     * @return boolean for true or false.
     */
    public static boolean rowLengthsDecrease(int[][]t){
        boolean gaz = false;
        boolean gayson = false;
        for(int i = 1; i < t.length; i++){
            if(t[i].length <= t[i-1].length){
                gaz=true;
            } else{
                gayson = true;
            } 
        }
        if(gayson){
            gaz = false;
        }
        return gaz;
    
    }

    /**
     * Return true if integers are increasing from left to right.
     * @param t a two-dimensional array which represents tableau.
     * @return boolean for true or false.
     */
    public static boolean rowValuesIncrease(int [][] t){
        boolean gaz = false;
        boolean gayson = false;
        for(int row = 0; row < t.length; row++){
            for(int col = 1; col < t[row].length; col++){
                if(t[row][col] > t[row][col-1]){
                    gaz = true;
                }else{
                    gayson = true;
                }
            }
            if(gayson){
                gaz = false;
            }
            
        } return gaz;          
        
    }

    /**
     * Return true if colums are not increasing from up to down.
     * @param t a two-dimensional array which represents tableau.
     * @return boolean for true or false.
     */
    public static boolean columnValuesIncrease(int [][] t){
        boolean gaz = false;
        boolean gayson = false;
        for(int row = 1; row < t.length; row++){
            for(int col = 0; col < t[row].length; col++){
                if(t[row][col] > t[row-1][col]){
                    gaz = true;
                }else{
                    gayson = true;
                }
            }
            if(gayson){
                gaz = false;
            }
            
        } return gaz;          
        
    }

    /**
     * Return true cells are of form 1 to n.
     * @param t a two-dimensional array which represents tableau.
     * @return boolean for true or false.
     */
    public static boolean isSetOf1toN(int [][] t){
        boolean gaz = false;
        int count = 0;
        int sum = 0;
        for(int row = 0; row < t.length; row++){
            for(int col = 0; col < t[row].length; col++){
                count++;
                sum += count;
                sum -= t[row][col];
            }
        }
        if(sum == 0){
            gaz = true;
        }
        return gaz;     


    }
}
