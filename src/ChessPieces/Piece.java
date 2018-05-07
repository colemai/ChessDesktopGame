package ChessPieces;

import java.util.List;

/**
 * This class creates a piece object
 * The object has a x and y location.
 */
public class Piece {
	
	//The xLoc of the piece
	protected int xLoc;
	//The yLoc of the piece
	protected int yLoc;

	/**
	 * initiates the Piece class. When created it requires a x and y loc.
	 * @param xLoc x location of the piece
	 * @param yLoc y location of the piece
	 */
	public Piece(int xLoc,int yLoc){
		setyLoc(yLoc);
		setxLoc(xLoc);
	}
	
	//returns the xLocation
	public int getxLoc() {
		return xLoc;
	}
	//sets the x location
	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}
	//gets the y location
	public int getyLoc() {
		return yLoc;
	}
	//sets the y location or changes it
	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
	/**
	 * changes the x and y locations for a piece.
	 * @param newLoc the new location.
	 */
	public void move(List<Integer> newLoc){
		System.out.println(newLoc.get(0) + " " + newLoc.get(1));
		this.setxLoc(newLoc.get(0));
		this.setyLoc(newLoc.get(1));
	}
}
