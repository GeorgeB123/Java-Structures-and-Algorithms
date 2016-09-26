/* File: StackException.java - April 2015 */
package week09;

/**
 * Execption/Error handling for RPN stack.
 * 
 * @author Joe Benn, George Bonnici-Carter
 */

public class StackException extends RuntimeException{
  
  public StackException(String message) {
    super(message);
  }
}
