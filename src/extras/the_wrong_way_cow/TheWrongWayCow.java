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
		HashMap<String, String> cattle = new HashMap<>();
		int numOfN = 0;
		int numOfE = 0;
		int numOfS = 0;
		int numOfW = 0;
		// checks corners
		int location = field.length - 1;
		if (field[0][0] == 'c') {
			if (field[1][0] == 'o') {
				numOfS++;
				cattle.put("South", "0, 0");
			}
			if (field[0][1] == 'o') {
				numOfE++;
				cattle.put("East", "0, 0");
			}
		}
		if (field[field.length - 1][0] == 'c') {
			if (field[field.length - 2][0] == 'o') {
				numOfW++;
				cattle.put("West", "" + location + ", 0");
			}
			if (field[field.length - 1][1] == 'o') {
				numOfS++;
				cattle.put("South", "" + location + ", 0");
			}
		}
		if (field[0][field.length - 1] == 'c') {
			if (field[0][field.length - 2] == 'o') {
				numOfN++;
				cattle.put("North", "0, " + location + "");
			}
			if (field[1][field.length - 1] == 'o') {
				numOfE++;
				cattle.put("East", "0, " + location + "");
			}
		}
		if (field[field.length - 1][field.length - 1] == 'c') {
			if (field[field.length - 2][field.length - 1] == 'o') {
				numOfW++;
				cattle.put("West", "" + location + ", " + location);
			}
			if (field[field.length - 1][field.length - 2] == 'o') {
				numOfN++;
				cattle.put("North", "" + location + ", " + location);
			}
		}
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				// checks edges
				if (i == 0 && field[i][j] == 'c') {
					if (j > 0 && field[0][j - 1] == 'o') {
						numOfW++;
						cattle.put("West", "0, " + j);
					}
					if (j < field.length - 1 && field[0][j + 1] == 'o') {
						numOfE++;
						cattle.put("East", "0, " + j);
					}
					if (field[i + 1][j] == 'o') {
						numOfS++;
						cattle.put("South", "0, " + j);
					}
				}
				if (i == field.length - 1 && j != 0) {
					if (field[i][j - 1] == 'o') {
						numOfW++;
						cattle.put("West", i + ", " + j);
					}
					if (field[i][j + 1] == 'o') {
						numOfE++;
						cattle.put("East", i + ", " + j);
					}
					if (field[i - 1][j] == 'o') {
						numOfS++;
						cattle.put("South", i + ", " + j);
					}
				}
				if (j == 0 && i != field.length-1) {
					if (i > 0 && field[i - 1][0] == 'o') {
						numOfN++;
						cattle.put("North", i + ", 0");
					}
					if (field[i + 1][0] == 'o') {
						numOfS++;
						cattle.put("South", i + ", 0");
					}
					if (field[i][1] == 'o') {
						numOfE++;
						cattle.put("East", i + ", 0");
					}
				}
				if (j == field.length - 1 && i != 0) {
					if (field[i - 1][j] == 'o') {
						numOfN++;
						cattle.put("North", i + ", " + j);
					}
					if (field[i + 1][j] == 'o') {
						numOfS++;
						cattle.put("South", i + ", " + j);
					}
					if (field[i][j - 1] == 'o') {
						numOfW++;
						cattle.put("West", i + ", " + j);
					}
				}
				// checks the rest
				if (numOfN == 1 || numOfE == 1 || numOfS == 1 || numOfW == 1) {
					break;
				} else {
					if ((j != 0 || j != field.length - 1) && (i != 0 || i != field.length - 1)) {
						if (i > 1 && j > 0 && field[i - 1][j] == 'o') {
							numOfN++;
							cattle.put("North", i + ", " + j);
						}
						if (j < field.length - 1 && field[i][j + 1] == 'o') {
							numOfE++;
							cattle.put("East", i + ", " + j);
						}
						if (i < field.length - 1 && field[i + 1][j] == 'o') {
							numOfS++;
							cattle.put("South", i + ", " + j);
						}
						if (j > 0 && field[i][j - 1] == 'o') {
							numOfW++;
							cattle.put("West", i + ", " + j);
						}
					}
				}
			}
		}

		if (numOfN == 1) {
			char cordsX = cattle.get("North").charAt(0);
			char cordsY = cattle.get("North").charAt(4);
			String stringCordsX = cordsX + "";
			String stringCordsY = cordsY + "";
			int xCords = Integer.parseInt(stringCordsX);
			int yCords = Integer.parseInt(stringCordsY);
			int[] cords = { xCords, yCords };
			return cords;
		} else if (numOfE == 1) {
			char cordsX = cattle.get("East").charAt(0);
			char cordsY = cattle.get("East").charAt(4);
			String stringCordsX = cordsX + "";
			String stringCordsY = cordsY + "";
			int xCords = Integer.parseInt(stringCordsX);
			int yCords = Integer.parseInt(stringCordsY);
			int[] cords = { xCords, yCords };
			return cords;
		} else if (numOfS == 1) {
			char cordsX = cattle.get("South").charAt(0);
			char cordsY = cattle.get("South").charAt(4);
			String stringCordsX = cordsX + "";
			String stringCordsY = cordsY + "";
			int xCords = Integer.parseInt(stringCordsX);
			int yCords = Integer.parseInt(stringCordsY);
			int[] cords = { xCords, yCords };
			return cords;
		} else {
			char cordsX = cattle.get("West").charAt(0);
			char cordsY = cattle.get("West").charAt(4);
			String stringCordsX = cordsX + "";
			String stringCordsY = cordsY + "";
			int xCords = Integer.parseInt(stringCordsX);
			int yCords = Integer.parseInt(stringCordsY);
			int[] cords = { xCords, yCords };
			return cords;
		}
	}
}