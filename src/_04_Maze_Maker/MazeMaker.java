package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		// 4. select a random cell to start
		Random rand1 = new Random();
		Random rand2 = new Random();
		int randX = rand1.nextInt(width);
		int randY = rand2.nextInt(height);

		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.getCell(randX, randY));

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);
		// B. Get an ArrayList of unvisited neighbors using the current cell and the
		// method below
		ArrayList<Cell> unvistedNeighbors;
		unvistedNeighbors = getUnvisitedNeighbors(currentCell);
		// C. if has unvisited neighbors,
		if (unvistedNeighbors.size() > 0) {
			// C1. select one at random.
			Random rand = new Random();
			Cell randNeigh = unvistedNeighbors.get(rand.nextInt(unvistedNeighbors.size()));
			// C2. push it to the stack
			uncheckedCells.push(randNeigh);
			// C3. remove the wall between the two cells
			removeWalls(currentCell, randNeigh);
			// C4. make the new cell the current cell and mark it as visited
			currentCell = randNeigh;
			currentCell.hasBeenVisited();
			// C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
		// D. if all neighbors are visited
		if (unvistedNeighbors.size() == 0) {
			// D1. if the stack is not empty
			if (!uncheckedCells.isEmpty()) {
				// D1a. pop a cell from the stack
				currentCell = uncheckedCells.pop();
				// D1b. make that the current cell
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}
		}
	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {

		if (c1.getX() == c2.getX()) {

			if (c1.getY() > c2.getY()) {

				c1.setNorthWall(false);

				c2.setSouthWall(false);

			} else {

				c2.setNorthWall(false);

				c1.setSouthWall(false);

			}

		} else {

			if (c1.getX() > c2.getX()) {

				c1.setWestWall(false);

				c2.setEastWall(false);

			} else {

				c2.setWestWall(false);

				c1.setEastWall(false);

			}

		}

	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		int x = c.getX();
		int y = c.getY();
		ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();
		if (x > 0 && !maze.getCell(x - 1, y).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(x - 1, y));
		}
		if (y > 0 && !maze.getCell(x, y - 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(x, y - 1));
		}
		if (x < width - 1 && !maze.getCell(x + 1, y).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(x + 1, y));
		}
		if (y < height - 1 && !maze.getCell(x, y + 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(x, y + 1));
		}
		return unvisitedNeighbors;
	}
}