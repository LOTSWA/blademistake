package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Grid;
import hw4.player.Movement;
import hw4.player.Player;
import hw4.maze.Row;
import hw4.maze.CellComponents;
import hw4.maze.Cell;

public class Game {
	/**
	 * making fields for grid and random, random is for making random comps
	 */
	private Random random = new Random();
	private Grid grid;

		/**
		 * grid parameter for the game
		 * @param grid
		 */
	public Game(Grid grid) {
		this.grid = grid;
		// TODO Auto-generated constructor stub
	}

		/**
		 * parameter to randomize grid pattern
		 * @param size
		 * 			size is between 3 and 7
		 */
	public Game(int size) {
		this.grid = createRandomGrid(size);
		// TODO Auto-generated constructor stub
	}

		/**
		 * getter for the grid
		 * @return
		 * 			returns the current grid
		 */
	public Grid getGrid() {
		// TODO Auto-generated method stub
		return grid;
	}

		/**
		 * setter for the grid
		 * @param grid
		 * 			sets the grid
		 */
	public void setGrid(Grid grid) {
		this.grid = grid;
		// TODO Auto-generated method stub
	}
	
	/**
	 * this method generates random cell comps which can be the wall or aperture
	 * @return
	 * 		returns the randomized wall or aperture
	 */
	private CellComponents getRandomize() {
		if(random.nextBoolean())
		{
			return CellComponents.WALL;
		}
		else
		{
			return CellComponents.APERTURE;
		}
	}

		/**
		 * this method is for the movement, handled by using a switch statement
		 * @param movement
		 * 				movement is the direct which can be up down left or right
		 * @param player
		 * 				player is moving
		 * @return
		 * 				returning either true if it worked or false if it didnt
		 */
	public boolean play(Movement movement, Player player) {
		if(movement == null || player == null)
		{
			return false;
		}
		// TODO Auto-generated method stub
		
		Cell currentCell = player.getCurrentCell();
		Row currentRow = player.getCurrentRow();
		int indexR = grid.getRows().indexOf(currentRow);
		int indexC = currentRow.getCells().indexOf(currentCell);
		
		switch(movement) 
		{
			case LEFT:
				if(currentCell.getLeft() == CellComponents.APERTURE)
				{
					if(indexC > 0)
					{
						player.setCurrentCell(currentRow.getCells().get(indexC - 1));
						return true;
					}
				}
				else if(currentCell.getLeft() == CellComponents.EXIT)
				{
					return true;
				}
				break;
				
			case RIGHT:
				if(currentCell.getRight() == CellComponents.APERTURE)
				{
					if(indexC < currentRow.getCells().size() - 1)
					{
						player.setCurrentCell(currentRow.getCells().get(indexC + 1));
						return true;
					}
				}
				break;
			
			case UP:
				if(currentCell.getUp() == CellComponents.APERTURE)
				{
					if(indexR > 0)
					{
						player.setCurrentRow(grid.getRows().get(indexR - 1));
						player.setCurrentCell(grid.getRows().get(indexR - 1).getCells().get(indexC));
						return true;
					}
				}
				break;
				
			case DOWN:
				if(currentCell.getDown() == CellComponents.APERTURE)
				{
					if(indexR < grid.getRows().size() - 1)
					{
						player.setCurrentRow(grid.getRows().get(indexR + 1));
						player.setCurrentCell(grid.getRows().get(indexR + 1).getCells().get(indexC));
						return true;
					}
				}
				break;
		}
		return false;	
	}

		/**
		 * this method creates a grid that is randomized and within the constraints of 3 to 7 and exit to left
		 * @param i
		 * 			i is the size for the grid, which is limited to 3 to 7
		 * @return
		 * 			returning the grid or null if it doesn't work
		 */
	public Grid createRandomGrid(int i) {
		if(i < 3 || i > 7)
		{
			return null;
		}
		Random random = new Random();
		ArrayList<Row> rows = new ArrayList<>();
		int exitRow = random.nextInt(i);
		
		for(int j = 0; j < i; j++)
		{
			ArrayList<Cell> cells = new ArrayList<>();
			for(int k = 0; k < i; k++)
			{
				CellComponents left;
				CellComponents right;
				CellComponents up;
				CellComponents down;
				
				if(k==0)
				{
					if(j == exitRow)
					{
						left = CellComponents.EXIT;
					}
					else
					{
						left = CellComponents.WALL;
					}
				}
				else
				{
					left = cells.get(k - 1).getRight();
				}
				if(j < i -1)
				{
					down = getRandomize();
				}
				else
				{
					down = CellComponents.WALL;
				}
				if(k < i - 1)
				{
					right = getRandomize();
				}
				else
				{
					right = CellComponents.WALL;
				}
				if(j == 0)
				{
					up = CellComponents.WALL;
				}
				else
				{
					up = rows.get(j - 1).getCells().get(k).getDown();
				}
				Cell cell = new Cell(left, right, up, down);
				cells.add(cell);
			}
			Row row = new Row(cells);
			rows.add(row);
		}
		return new Grid(rows);
		// TODO Auto-generated method stub
	}
	/**
	 * this is a string to string method
	 */
	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
}
