/* File: RPNApp.java - April 2015 */
package week09;


import java.util.*;
/**
 * RPN calulator app.
 * 
 * @author Joe Benn, George Bonnici-Carter
 */
public class RPNApp {
    /**public data field for System.in scanner. */
    public static Scanner scan;
    /**public data field for variable type long. */
    public static long x;
    /**public data field for variable type long. */
    public static long y;
    /**public data field for variable type long. */
    public static long result;
    /**private ArrayList declaration for stack. */
    private static ArrayList <String> test;
    /**priavte Array of type String for input onto stack. */
    private static String[] inputStore;
    /**private ArrayList declaration for handling brackets. */
    private static ArrayList <String> brackets;
 
    /**
     *  Entry point of the program. Runs method which handles the stack.
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        rpnInput();
        
    
    }
 
    /**declaring whether or not the next operator is a binary operaator.
     * @param s a String representing an operator.
     * @return boolean - true/false given whether s is an operator.
     */
    public static boolean isOperator(String s){
        return (s.equals("+") || s.equals("-") || s.equals("*") ||
                s.equals("/") || s.equals("%")|| s.equals("d")||
                s.equals("o") ||s.equals("r") || s.equals("c") ||
                s.equals("+!") || s.equals("-!") || s.equals("*!") ||
                s.equals("/!") || s.equals("%!") || s.equals("(") |
                s.equals(")"));
    } 
   
    /**declaring whether or not the next operator is a number of type long.
     * @param s a String representing an number.
     * @return boolean - true/false given whether s is an number.
     */
    public static boolean isNum(String s){
        Long.parseLong(s);
        return true;
    }
    
  
    /**
     * method to input equation in RPN form.
     * 
     */
    public static void rpnInput(){
       
        scan = new Scanner(System.in);
        while(scan.hasNext()){
            String input = scan.nextLine();
            inputStore = input.split(" ");
            test = new ArrayList<String>();
            for(int i = 0; i < inputStore.length; i++){
                test.add(inputStore[i]);
                try{ 
                    if(isOperator(inputStore[i]) || isNum(inputStore[i])){
                    }                   
                }catch(Exception e){
                    System.out.println("Error: bad token " +"'"+
                                       inputStore[i]+"'");     
                }
                if(inputStore[i].equals("+!")){
                    test.remove(test.size() -1);
                    while(test.size() > 1){
                        arithmetic("+");
                    }
                }
                if(inputStore[i].equals("-!")){
                    test.remove(test.size() -1);
                    while(test.size() > 1){
                        arithmetic("-");
                    }
                }
                if(inputStore[i].equals("*!")){
                    test.remove(test.size() -1);
                    while(test.size() > 1){
                        arithmetic("*");
                    }
                }
                if(inputStore[i].equals("/!")){
                    test.remove(test.size() -1);
                    while(test.size() > 1){
                        arithmetic("/");
                    }
                }
                if(inputStore[i].equals("%!")){
                    test.remove(test.size() -1);
                    while(test.size() > 1){
                        arithmetic("%");
                    }
                }
                if(inputStore[i].equals("+")){
                    test.remove(test.size() -1);
                    arithmetic("+");
                }
                if(inputStore[i].equals("-")){
                    test.remove(test.size() -1);
                    arithmetic("-");
                }
                if(inputStore[i].equals("*")){
                    test.remove(test.size() -1);
                    arithmetic("*");      
                }
                if(inputStore[i].equals("/")){
                    test.remove(test.size() -1);
                    arithmetic("/"); 
                }
                if(inputStore[i].equals("%")){
                    test.remove(test.size() -1);
                    arithmetic("%"); 
                }
             
                if(inputStore[i].equals("o")){
                    test.remove(test.size() -1);
                    System.out.print(test.size() + " ");
                }
                if(inputStore[i].equals("c")){
                    test.remove(test.size() -1);
                    extraOps("c");
                }
             
                if(inputStore[i].equals("d")){
                    test.remove(test.size() -1);
                    extraOps("d");      
                }
                if(inputStore[i].equals("r")){
                    test.remove(test.size() -1);
                    extraOps("r");

                }
                if(inputStore[i].equals("(")){
                    extraOps("(");    
                }
            }
            System.out.println(test);
        }  
    }
    
  
   
    /**performs arithmatic depending on the binary operator.
     * @param s a String representing an binary operator.
     * 
     */
    public static void arithmetic(String s){
    
        x = Long.parseLong(test.remove(test.size() -1));
        y = Long.parseLong(test.remove(test.size() -1));
        if(s == "+"){
            result = x+y;
        }
        if(s == "-"){
            result = y-x;
        }
        if(s == "*"){
            result = x*y;
        }
        if(s == "/"){
            if(x==0){
                throw new StackException("Error: division by 0");
            }else{
                result = y/x;
            }
        }
                
                 
        if(s == "%"){
            result = y%x;
        }
            
        test.add(String.valueOf(result)); //result is pushed back onto the stack
    }
   
    /**Handles changes to the stack regarding a special operator.
     * @param s a String representing a special operator.
     */
     
    public static void extraOps(String s){
           
        if(s == "c"){
            x = Long.parseLong(test.remove(test.size() -1));
            y = Long.parseLong(test.remove(test.size() -1));
            long temp = x;                long temp1 = y;
            if(x < 0){
                throw new StackException("Error: negative copy");
            }
            result = temp1;
            for(int i=0; i < x;i++){
                test.add(String.valueOf(result));
            }
                
        }
        if(s == "d"){
            test.add(String.valueOf(test.size()));
                
        }
        if(s == "r"){
            long rf = Long.parseLong(test.get(test.size()-1));
            test.remove(test.size()-1);
            int shift = (int) rf - 1;
            String element = (test.get(test.size()-1));
            test.add((test.indexOf(element)-shift),(element));
            test.remove(test.size() -1);
                                             
        }
        if(s == "("){
            long factor = 0;
            int index1 = 0;
           

            for(int i = 0; i < test.size(); i++){

                if(test.get(i).equals("(")){
                    index1 = test.indexOf(test.get(i));
                    factor = Long.parseLong(test.get(index1-1));
                    test.remove(index1);
                    test.remove(index1-1);
                    
                }
                
            }
           


            
        }
   
    }
          
        

}
  
  










