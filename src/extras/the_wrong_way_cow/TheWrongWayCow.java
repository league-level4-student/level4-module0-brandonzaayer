//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

import java.util.ArrayList;
import java.util.HashMap;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the x,y coordinate position of the
        // head (letter 'c') of the wrong way cow!
        int numOfN = 0;
        int numOfE = 0;
        int numOfS = 0;
        int numOfW = 0;
        HashMap<String, String> cattle = new HashMap<>();
        for(int i = 0; i < field.length; i++) {
    		for (int j = 0; j < field[i].length; j++) {
    			//checks corners
    			if(field[0][0] == 'c') {
    				if(field[1][0] == 'o') {
    					numOfE++;
    					cattle.put("East", "0, 0");
    				}
    				if(field[0][1] == 'o') {
    					numOfS++;
    					cattle.put("South", "0, 0");
    				}
    			}
    			if(field[field.length-1][0] == 'c') {
    				if(field[field.length-2][0] == 'o') {
    					numOfW++;
    					cattle.put("West", "0, " + field[field.length-1][0] + "");
    				}
    				if(field[field.length-1][1] == 'o') {
    					numOfS++;
    					cattle.put("South", "0, " + field[field.length-1][0] + "");
    				}
    			if(field[0][field.length-1] == 'c') {
        			if(field[0][field.length-2] == 'o') {
        				numOfN++;
        				cattle.put("North", "0, " + field[0][field.length-1] + "");
        			}
       				if(field[1][field.length-1] == 'o') {
       					numOfE++;
       					cattle.put("East", "0, " + field[0][field.length-1] + "");
       				}
    			}
    			if(field[field.length-1][field.length-1] == 'c') {
        			if(field[field.length-2][field.length-1] == 'o') {
        				numOfW++;
        				cattle.put("West", "0, " + field[0][field.length-1] + "");
        			}
       				if(field[field.length-1][field.length-2] == 'o') {
       					numOfN++;
       					cattle.put("North", "0, " + field[1][field.length-1] + "");
       				}
    			}
        		/*if (x != 0) {
        			if (cells[x - 1][y].isAlive)
        				livingNeighbors++;
        		}

        		if (x != cellsPerRow - 1) {
        			if (cells[x + 1][y].isAlive)
        				livingNeighbors++;
        		}
        		if (y != 0) {
        			if (cells[x][y - 1].isAlive)
        				livingNeighbors++;
        		}
        		if (y != cellsPerRow - 1) {
        			if (cells[x][y + 1].isAlive)
        				livingNeighbors++;
        		}*/
        }
        return null;
    }
}
