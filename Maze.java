/** Maze.java - Class representing a Maze object
 * @author Bob Wilson
 * @version 02/24/2011
 * 
 */
import java.util.*;

public class Maze
{
  private Bird start;
  private Bird end;
  
  public Maze()
  {
    // construct the diagrammed maze
    int MAX_ROW = 5;
    int MAX_COL = 7;
    Bird [][] maze = new Bird[MAX_ROW][MAX_COL];
    
    // row 0
    maze[0][0] = new Bird(0, 0, Bird.S);
    maze[0][1] = new Bird(0, 1, Bird.SW);
    maze[0][2] = new Bird(0, 2, Bird.S);
    maze[0][3] = new Bird(0, 3, Bird.SE);
    maze[0][4] = new Bird(0, 4, Bird.SW);
    maze[0][5] = new Bird(0, 5, Bird.SW);
    maze[0][6] = new Bird(0, 6, Bird.SW);
    
    // row 1
    maze[1][0] = new Bird(1, 0, Bird.S);
    maze[1][1] = new Bird(1, 1, Bird.W);
    maze[1][2] = new Bird(1, 2, Bird.SW);
    maze[1][3] = new Bird(1, 3, Bird.S);
    maze[1][4] = new Bird(1, 4, Bird.N);
    maze[1][5] = new Bird(1, 5, Bird.S);
    maze[1][6] = new Bird(1, 6, Bird.W);
    
    // row 2
    maze[2][0] = new Bird(2, 0, Bird.NE);
    maze[2][1] = new Bird(2, 1, Bird.NW);
    maze[2][2] = new Bird(2, 2, Bird.N);
    maze[2][3] = new Bird(2, 3, Bird.W);
    maze[2][4] = new Bird(2, 4, Bird.SE);
    maze[2][5] = new Bird(2, 5, Bird.NE);
    maze[2][6] = new Bird(2, 6, Bird.E);
    
    // row 3
    maze[3][0] = new Bird(3, 0, Bird.SE);
    maze[3][1] = new Bird(3, 1, Bird.NE);
    maze[3][2] = new Bird(3, 2, Bird.E);
    maze[3][3] = new Bird(3, 3, Bird.NW);
    maze[3][4] = new Bird(3, 4, Bird.NW);
    maze[3][5] = new Bird(3, 5, Bird.E);
    maze[3][6] = new Bird(3, 6, Bird.W);
    
    // row 4
    maze[4][0] = new Bird(4, 0, Bird.N);
    maze[4][1] = new Bird(4, 1, Bird.NE);
    maze[4][2] = new Bird(4, 2, Bird.N);
    maze[4][3] = new Bird(4, 3, Bird.N);
    maze[4][4] = new Bird(4, 4, Bird.NE);
    maze[4][5] = new Bird(4, 5, Bird.W);
    maze[4][6] = new Bird(4, 6, Bird.N);
    
    start = maze[2][0];
    end   = maze[2][6];
    
    // for each Bird in the 2-D array 
    //   instantiate a queue to contain Bird objects 
    //   find the direction for this Bird
    //   calculate the indices for each Bird in the direction
    //   add a reference to each Bird along the direction to the queue
    //   call the Bird object's setBirdQueue method with the queue

    // write your code here
    for(int i = 0; i < MAX_ROW; i++) {
      for(int j = 0; j < MAX_COL; j++) {
        int k = 0;
        int l = 0;
       Queue<Bird> birdQueue = new LinkedList<Bird>();
       int direction = maze[i][j].getDirection();
       switch(direction) {
         case 0 :                                  // if its going north
           k = i-1;
           while(k >= 0){                // for all elements north process
            birdQueue.offer(maze[k--][j]);           // add each bird object going north to birdQueue
           }
           maze[i][j].setBirdQueue(birdQueue);     //set bird queue for object by passing the birdQueue along.
           System.out.println(maze[i][j]);
           System.out.println(birdQueue);
           break;
         case 1 :                                // if the direction is NE
           k = i-1; l = j+1;                        // set the current location to the alternate variables
           while(k >= 0 && l < MAX_COL) {                      // k = row, so it can't go higher than 0
               birdQueue.offer(maze[k--][l++]);  // pre increment l to get the next NE element and predecrement k to move up as well
           }
           maze[i][j].setBirdQueue(birdQueue);    // set bird object's bird queue.
           System.out.println(maze[i][j]);
           System.out.println(birdQueue);           
           break;
         case 2 :                                 // if 2 then direction is east so just traverse via column
           l = j+1;                                 // set l to the column j to make the pass equal
           while(l < MAX_COL) {                  // l cannot go further than MAX_COL so this should work
             birdQueue.offer(maze[i][l++]);       // pre increment since you need the next element for it
           }
           maze[i][j].setBirdQueue(birdQueue);      // set bird queue with birdQueue
           System.out.println(maze[i][j]);
           System.out.println(birdQueue);           
           break;
         case 3 :                                 // if 3 direction is SE
           k = i+1; l = j+1;                          // set corresponding points
           while(k < MAX_ROW && l < MAX_COL) {  // k cannot go futher down than max row and likewise l cannot go futher than max col
             birdQueue.offer(maze[k++][l++]);     // get elements pre incrementing the variables
           }
           maze[i][j].setBirdQueue(birdQueue);    // set bird queue with birdQueue
           System.out.println(maze[i][j]);
           System.out.println(birdQueue);           
           break;
         case 4 :                                 // 4 equals south direction
           k = i+1;
           while(k < MAX_ROW) {                   // set k to row i. k cannot go futher down than max row
             birdQueue.offer(maze[k++][j]);        // add the next K element and keep doing so until cannot
           }
           maze[i][j].setBirdQueue(birdQueue);     // set the bird queue with birdQueue
           System.out.println(maze[i][j]);
           System.out.println(birdQueue);           
           break;
         case 5 :                                  // 5 equals southwest
           k = i+1;l = j-1;                            // set the current maze to the proper location using k and l
           while(k < MAX_ROW && l >= 0) {
             birdQueue.offer(maze[k++][l--]);      // using k for row and j for columns, I have to increase one and 
           }
           maze[i][j].setBirdQueue(birdQueue);
           System.out.println(maze[i][j]);
           System.out.println(birdQueue);           
           break;
         case 6 :                                  // 6 equals west
          l = j-1;                                    // set l to the proper column number
          while(l >= 0) {
            birdQueue.offer(maze[i][l--]);
          }
          maze[i][j].setBirdQueue(birdQueue);
           System.out.println(maze[i][j]);
           System.out.println(birdQueue);          
          break;
         case 7 :                                   // case 7 equals NW
           k = i-1;l = j-1;                              // set proper row and column to k and l
           while( k>=0 && l>=0) {                     // since both are traversing close to 0,neither can be greater than zero
             birdQueue.offer(maze[k--][l--]);
           }
           maze[i][j].setBirdQueue(birdQueue);
           System.out.println(maze[i][j]);
           System.out.println(birdQueue);           
           break;
       }
      }
    }
  }
           
           

  public Bird getStart()
  {
    return this.start;
  }
  
  public Bird getEnd()
  {
    return this.end;
  }
  
}