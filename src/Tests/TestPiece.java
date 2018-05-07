package Tests;

/**
 * Testcases for Piece and ChessPiece
 */

import ChessPieces.ChessPiece;
import ChessPieces.Piece;
import junit.framework.TestCase;

public class TestPiece extends TestCase {
	int xLoc = 4;
	int yLoc = 2;
	String colour = "black";
	String type = "knight";
	String moveSet = "I CAN JUMP!";
	String piecePicture = "horse.png"; 
	
	// Testing creation of a Piece object
	public void testCreatePiece(){
		Piece piece = new Piece(4,2);
		assertNotNull(piece);
		assertEquals(piece.getxLoc(),xLoc);
		assertEquals(piece.getyLoc(),yLoc);
	}
	
	// Testing creation of a ChessPiece object
	public void testCreateChessPiece(){
		ChessPiece chessPiece = new ChessPiece("knight", "black", 4, 2, "I CAN JUMP!", "horse.png");
		assertNotNull(chessPiece);
		assertEquals(chessPiece.getType(), type);
		assertEquals(chessPiece.getColour(), colour);
		assertEquals(chessPiece.getMoveSet(), moveSet);
		assertEquals(chessPiece.getPiecePicture(), piecePicture);
		assertEquals(chessPiece.getxLoc(), xLoc);
		assertEquals(chessPiece.getyLoc(), yLoc);
	}
}
