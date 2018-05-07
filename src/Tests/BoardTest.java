package Tests;

import java.util.ArrayList;
import java.util.List;

import ChessBoard.Board;
import ChessGame.RuleSet;
import ChessPieces.ChessPiece;
import ChessPieces.CreateChessPieces;
import ChessPieces.Piece;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	
	// Test Board initialization
	public void testInitialState() {
		CreateChessPieces.initializeSets();
		Board board = new Board();

		ChessPiece[][] boardState = board.getBoardState();
		ArrayList<Piece> checkedPieces = new ArrayList<Piece>();
		for (int i = 0; i < boardState.length; i++) {
			for (int j = 0; j < boardState[i].length; j++) {
				if(boardState[i][j] != null){
					checkedPieces.add(boardState[i][j]);
				}
			}
		}
		
		assertNotNull(board);
		assertNotNull(boardState);
		assertEquals(32, checkedPieces.size());
	}

	// Test getting the white set of chess pieces, should be 16 of them
	public void testGetWhiteSet() {
		CreateChessPieces.initializeSets();
		Board board = new Board();
		List<ChessPiece> whiteSet = board.getWhiteSet();
		assertEquals(16, whiteSet.size());
		
		// Test a random piece in there
		ChessPiece whitePiece = board.getWhiteSet().get(5);
		String whitePieceColorString = whitePiece.getColour();
		assertNotNull(whitePiece);
		assertEquals("white", whitePieceColorString);
	}
	
	// Test translating tileName to List of integers
	public void testGetBoardPositionClicked() {
		String tileName = "63";
		List<Integer> testPositionClicked = new ArrayList<Integer>();
		testPositionClicked.add(6); //yLoc
		testPositionClicked.add(3); //xLoc
			
		CreateChessPieces.initializeSets();
		Board board = new Board();
		
		List<Integer> boardPositionClicked = board.getBoardPositionClicked(tileName);
		assertNotNull(boardPositionClicked);
		assertEquals(boardPositionClicked, testPositionClicked);
	}
	
	// Test updating boardstate DOES NOT WORK
	public void testUpdateBoardState() {
		CreateChessPieces.initializeSets();
		Board board = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece[][] firstBoardState = board.getBoardState();
		
		// Create a copy that will remain unchanged
		ChessPiece[][] secondBoardState = ruleSet.copyBoard(firstBoardState);
		
		// Move something (disregarding whether move is legal)
		List<Integer> oldLoc = new ArrayList<Integer>();
		oldLoc.add(7);
		oldLoc.add(4);
		List<Integer> newLoc = new ArrayList<Integer>();
		newLoc.add(2);
		newLoc.add(4);
		
		// Update secondBoardState
		board.updateBoardState(oldLoc, newLoc);
		//printBoardstate(firstBoardState);
		//printBoardstate(secondBoardState);
		//printBoardstate(board.getBoardState());
		
		// Check that boardstate changed (they have the same dimensions at least)
		//assertEquals(Arrays.toString(firstBoardState), Arrays.toString(secondBoardState));
		//assertFalse(Arrays.equals(firstBoardState, secondBoardState));
	}
	
	// Print a boardstate (just piece types and NULL for empty tiles)
	public static void printBoardstate(ChessPiece[][] boardstate) {
		for (int i = 0; i < 8; i++) {
			String cl = "";
			for (int j = 0; j < 8; j++) {
				if(boardstate[i][j] != null) {
					cl = cl + " " + boardstate[i][j].getType();
				} else {
					cl = cl + " NULL";
				}
			}
			System.out.println(cl);
		}
	}
}
