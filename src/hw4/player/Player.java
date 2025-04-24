package hw4.player;

import java.util.ArrayList;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {
	
	private ArrayList<Cell> cells;
	private Row currentRow;
	private Cell currentCell;
	
	public Player(Row row, Cell cell) {
		this.currentRow = row;
		this.currentCell = cell;
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	public Row getCurrentRow() {
		// TODO Auto-generated method stub
		return currentRow;
	}

	public Cell getCurrentCell() {
		// TODO Auto-generated method stub
		return currentCell;
	}

	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}

}