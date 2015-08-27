/** Solve2.java - Class containing the main method for recursive solution
 * @author Bob Wilson
 * @version 02/24/2011
 * 
 */

import java.util.Stack;

public class Solve2
{
  public static void main(String [] args)
  {
    // create the maze to solve
    Maze maze = new Maze();

    // create a Stack of Bird objects named path here
    Stack<Bird> path = new Stack<Bird>();
    
    // call recursive method to solve the maze and print the path
    recurse(path, maze.getStart(), maze.getEnd());
    System.out.println("got this far");
    print(path);
  }
    
  private static boolean recurse(Stack<Bird> path, Bird current, Bird end)
  {
    Bird temp;
    if(current == null) {
      current = path.pop();
      temp = current.getNextBird();
      if(temp == null) {
        current = path.pop();
      }
      path.push(current);
      current = temp;
      recurse(path, current, end);
      return false;
    } else if(current == end) {
      path.push(current);
      return true;
    } else {
      path.push(current);
      current = current.getNextBird();
      recurse(path, current, end);
      return false;
    }
  }
  
  private static void print(Stack<Bird> stack)
  {
    // write your code for recursively printing the stack here
    Bird temp = stack.pop();
    System.out.println(temp.toString());
    if(stack.peek() != null) {
       print(stack);
    }
  }



}