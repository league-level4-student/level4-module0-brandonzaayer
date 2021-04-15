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

import java.util.HashMap;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the x,y coordinate position of the
		// head (letter 'c') of the wrong way cow!
		HashMap<String, int[]> cattle = new HashMap<>();
		int numOfN = 0;
		int numOfE = 0;
		int numOfS = 0;
		int numOfW = 0;
		// checks corners
		int location = field.length - 1;
		if (field[0][0] == 'c') {
			if (field[1][0] == 'o') {
				numOfS++;
				cattle.put("South", new int[] { 0, 0 });
			}
			if (field[0][1] == 'o') {
				numOfE++;
				cattle.put("East", new int[] { 0, 0 });
			}
		}
		if (field[field.length - 2][0] == 'c') {
			if (field[field.length - 2][0] == 'o') {
				numOfW++;
				cattle.put("West", new int[] { location, 0 });
			}
			if (field[field.length - 1][0] == 'o') {
				numOfS++;
				cattle.put("South", new int[] { location, 0 });
			}
		}
		if (field[0][field.length - 1] == 'c') {
			if (field[0][field.length - 2] == 'o') {
				numOfN++;
				cattle.put("North", new int[] { 0, location });
			}
			if (field[1][field.length - 1] == 'o') {
				numOfE++;
				cattle.put("East", new int[] { 0, location });
			}
		}
		if (field[field.length - 1][field.length - 1] == 'c') {
			if (field[field.length - 2][field.length - 1] == 'o') {
				numOfW++;
				cattle.put("West", new int[] { location, location });
			}
			if (field[field.length - 1][field.length - 2] == 'o') {
				numOfN++;
				cattle.put("North", new int[] { location, location });
			}
		}
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				// checks edges
				if (i == 0 && field[i][j] != 'c') {
					if (j > 0 && field[0][j - 1] == 'o') {
						numOfW++;
						cattle.put("West", new int[] { j, 0 });
					}
					if (j < field.length - 1 && field[0][j + 1] == 'o') {
						numOfE++;
						cattle.put("East", new int[] { j, 0 });
					}
					if (field[i + 1][j] == 'o') {
						numOfS++;
						cattle.put("South", new int[] { j, 0 });
					}
				}
				if(field[i][j] == 'c' &&(i != 0 && j != 0)) {
				if (i == field.length - 1 && j != 0) {
					if (field[i][j - 1] == 'o') {
						numOfW++;
						cattle.put("West", new int[] { j, i });
					}
					if (field[i][j + 1] == 'o') {
						numOfE++;
						cattle.put("East", new int[] { j, i });
					}
					if (field[i - 1][j] == 'o') {
						numOfS++;
						cattle.put("South", new int[] { j, i });
					}
				}
				if (j == 0 && i != field.length - 1) {
					if (i > 0 && field[i - 1][0] == 'o') {
						numOfN++;
						cattle.put("North", new int[] { 0, i });
					}
					if (field[i + 1][0] == 'o') {
						numOfS++;
						cattle.put("South", new int[] { 0, i });
					}
					if (field[i][1] == 'o') {
						numOfE++;
						cattle.put("East", new int[] { 0, i });
					}
				}
				if (j == field.length - 1 && i != 0) {
					if (field[i - 1][j] == 'o') {
						numOfN++;
						cattle.put("North", new int[] { j, i });
					}
					if (field[i + 1][j] == 'o') {
						numOfS++;
						cattle.put("South", new int[] { j, i });
					}
					if (field[i][j - 1] == 'o') {
						numOfW++;
						cattle.put("West", new int[] { j, i });
					}
				}
				}
				// checks the rest
				if (numOfN == 1 && numOfE + numOfS + numOfW == 0|| numOfE == 1 && numOfN + numOfS + numOfW == 0|| numOfS == 1 && numOfN + numOfE + numOfW == 0|| numOfW == 1 && numOfN + numOfS + numOfE == 0) {
					break;
				} else {
					if ((j != 0 || j != field.length - 1) && (i != 0 || i != field.length - 1)) {
						if (i > 1 && j > 0 && field[i][j] == 'c') {
							if (field[i - 1][j] == 'o') {
								numOfN++;
								cattle.put("North", new int[] { j, i });
							}
						}
						if (j < field.length - 1 && field[i][j] == 'c') {
							if (field[i][j + 1] == 'o') {
								numOfE++;
								cattle.put("East", new int[] { j, i });
							}
						}
						if (i < field.length - 1 && field[i][j] == 'c') {
							if (field[i + 1][j] == 'o') {
								numOfS++;
								cattle.put("South", new int[] { j, i });
							}
						}
						if (j > 0 && field[i][j] == 'c') {
							if (field[i][j - 1] == 'o') {
								numOfW++;
								cattle.put("West", new int[] { j, i });
							}
						}
					}
				}
			}
		}

		if (numOfN == 1) {
			int[] cords = cattle.get("North");
			System.out.println(cords[0]);
			System.out.println(cords[1]);
			return cords;
		} else if (numOfE == 1) {
			int[] cords = cattle.get("East");
			System.out.println(cords[0]);
			System.out.println(cords[1]);
			return cords;
		} else if (numOfS == 1) {
			int[] cords = cattle.get("South");
			System.out.println(cords[0]);
			System.out.println(cords[1]);
			return cords;
		} else {
			int[] cords = cattle.get("West");
			System.out.println(cords[0]);
			System.out.println(cords[1]);
			return cords;
		}
	}
}