package hw4.maze;

import java.util.ArrayList;

public class Grid {

	private ArrayList<Row> rows;

	public Grid(ArrayList<Row> rows) {                   //This code is used to create the grid used in the program
		this.rows = rows;
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Row> getRows() {
		// TODO Auto-generated method stub
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
}