package hw4.maze;

import java.util.ArrayList;

public class Cell {
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;
	
	public Cell(CellComponents wall, CellComponents exit, CellComponents aperture, CellComponents wall2) {
		this.left = wall;
		this.right = exit;
		this.up = aperture;
		this.down = wall2;
		// TODO Auto-generated constructor stub
	}

	public CellComponents getLeft() {
		return left;
	}

	public void setLeft(CellComponents left) {
		if(left == null) {
			this.left = CellComponents.WALL;
		}
		else {
			this.left = left;
		}
	}

	public CellComponents getRight() {
		return right;
	}

	public void setRight(CellComponents right) {
		if(right == null) {
			this.right = CellComponents.WALL;
		}
		else {
			this.right = right;
		}
	}

	public CellComponents getUp() {
		return up;
	}

	public void setUp(CellComponents up) {
		if(up == null) {
			this.up = CellComponents.WALL;
		}
		else {
			this.up = up;
		}
	}

	public CellComponents getDown() {
		return down;
	}

	public void setDown(CellComponents down) {
		if(down == null) {
			this.down = CellComponents.WALL;
		}
		else {
			this.down = down;
		}
	}

	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
}