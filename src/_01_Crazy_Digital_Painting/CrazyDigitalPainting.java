package _01_Crazy_Digital_Painting;

import java.awt.Color;
import java.util.Random;

public class CrazyDigitalPainting {
	// 1. Create two final static integers for the width and height of the display.
	final static int WIDTH = 600;
	final static int HEIGHT = 600;
	// 2. Create a 2D array of Color objects. You will need to import
	// java.awt.Color. Initialize the size of the array using the
	// integers created in step 1.
	Color[][] colors = new Color[WIDTH][HEIGHT];

	public CrazyDigitalPainting() {
		// 3. Open the crazy_digital_painting.png file and look at the image.

		// 4. Iterate through the 2D array and initialize each Color object
		// to a new color. The sample image was created using the following
		// pattern:
		// colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
		/*for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < colors[i].length; j++) {
				colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
			}
		}*/
		// 5. Come up with your own pattern to make a cool crazy image.
		Random rand = new Random();
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < colors[i].length; j++) {
				int rR = rand.nextInt(256);
				int rG = rand.nextInt(256);
				int rB = rand.nextInt(256);
				int rRGB = rand.nextInt(3);
				if(rRGB == 0) {
					colors[i][j] = new Color(rR, 0, 0);
				}
				else if(rRGB == 1) {
					colors[i][j] = new Color(0, rG, 0);
				}
				else {
					colors[i][j] = new Color(0, 0, rB);
				}
			}
		}
		// 6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method
		// to show off your picture.
		ColorArrayDisplayer.displayColorsAsImage(colors);
	}

	public static void main(String[] args) {
		new CrazyDigitalPainting();
	}
}
