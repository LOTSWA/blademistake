package hw4.maze;

import java.util.ArrayList;

public class Row {
	
	private ArrayList<Cell> cells;                           //RETURNS ROWS OF CELLS
	
	public Row(ArrayList<Cell> cells) {
		this.cells = cells;
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}
}