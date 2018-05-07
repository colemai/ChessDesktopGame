package Tests;

import java.util.ArrayList;
import java.util.List;
import ChessBoard.Board;
import ChessGame.RuleSet;
import ChessPieces.ChessPiece;
import ChessPieces.CreateChessPieces;
import junit.framework.TestCase;

/**
 * Series of unit tests that check that a given piece is only allowed to make legal moves
 * For each test, all pieces except the specified piece are in their beginning positions (see CreateChessPiesces.java for these)
 * To make a test, copy and paste one of the piece you want to test, specify the startPos and endPos (first vertical then horizontal axis)
 * 
 * At the bottom there are tests for special moves, check and checkmate
 */

public class RuleSetTest extends TestCase {
	
	//Queen movement test (diagonal), should return true
	public void testQueen1() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece queen = new ChessPiece("queen", "black", 0, 7, "moves", "data/images/blackQueen.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(4);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(2);
		endPos.add(2);
		
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean queenBool = ruleSet.queenAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), queen, startPos, endPos);
		assertTrue(queenBool);
	}
	
	//Queen movement test (straight), should return true
	public void testQueen2() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece queen = new ChessPiece("queen", "black", 0, 7, "moves", "data/images/blackQueen.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(2);
		startPos.add(3);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(5);
		endPos.add(3);
			
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean queenBool = ruleSet.queenAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), queen, startPos, endPos);
		assertTrue(queenBool);
	}
	
	//Queen movement test, should return false
	public void testQueen3() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece queen = new ChessPiece("queen", "black", 0, 7, "moves", "data/images/blackQueen.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(3);
		startPos.add(3);
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(5);
		endPos.add(4);
		
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean queenBool = ruleSet.queenAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), queen, startPos, endPos);
		assertFalse(queenBool);
	}
	
	//King movement test (1 space diagonal), should return true
	public void testKing1() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece king = new ChessPiece("king", "black", 0, 7, "moves", "data/images/blackKing.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(1);
		startPos.add(3);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(2);
		endPos.add(2);
			
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean kingBool = ruleSet.queenAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), king, startPos, endPos);
		assertTrue(kingBool);
	}
	
	//King movement test (1 space straight), should return true
	public void testKing2() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece king = new ChessPiece("king", "black", 0, 7, "moves", "data/images/blackKing.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(1);
		startPos.add(3);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(2);
		endPos.add(3);
			
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean kingBool = ruleSet.queenAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), king, startPos, endPos);
		assertTrue(kingBool);
	}
	
	//King movement test, should return false
	public void testKing3() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece king = new ChessPiece("king", "black", 0, 7, "moves", "data/images/blackKing.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(4);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(6);
		endPos.add(6);
			
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean kingBool = ruleSet.kingAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), king, startPos, endPos);
		assertFalse(kingBool);
	}
	
	//Rook movement test (vertical), should return true
	public void testRook1() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece rook = new ChessPiece("rook", "black", 4, 4, "moves", "data/images/blackRook.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(4);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(4);
		endPos.add(6);
			
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean rookBool = ruleSet.rookAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), rook, startPos, endPos);
		assertTrue(rookBool);
	}
	
	//Rook movement test (horizontal), should return true
	public void testRook2() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece rook = new ChessPiece("rook", "black", 0, 7, "moves", "data/images/blackRook.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(6);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(3);
		endPos.add(6);
			
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean rookBool = ruleSet.rookAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), rook, startPos, endPos);
		assertTrue(rookBool);
	}
	
	//Rook movement test (diagonal), should return false
	public void testRook3() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece rook = new ChessPiece("rook", "black", 0, 7, "moves", "data/images/blackRook.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(4);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(6);
		endPos.add(6);
			
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean rookBool = ruleSet.rookAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), rook, startPos, endPos);
		assertFalse(rookBool);
	}
	
	//Knight movement test (one right, two down), should return true
	public void testKnight1() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece knight = new ChessPiece("knight", "black", 0, 7, "moves", "data/images/blackKnight.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(4);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(5);
		endPos.add(6);
		
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean knightBool =  ruleSet.knightAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), knight, startPos, endPos);
		assertTrue(knightBool);
	}
	
	//Knight movement test (two left, one down), should return true
	public void testKnight2() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece knight = new ChessPiece("knight", "black", 0, 7, "moves", "data/images/blackKnight.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(4);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(2);
		endPos.add(5);
	
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean knightBool =  ruleSet.knightAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), knight, startPos, endPos);
		assertTrue(knightBool);
	}
	
	//Knight movement test (two right, two down), should return false
	public void testKnight3() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece knight = new ChessPiece("knight", "black", 0, 7, "moves", "data/images/blackKnight.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(4);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(6);
		endPos.add(6);
	
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean knightBool =  ruleSet.knightAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), knight, startPos, endPos);
		assertFalse(knightBool);
	}
	
	//Bishop movement test (diagonal), should return true
	public void testBishop1() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece bishop = new ChessPiece("bishop", "black", 0, 7, "moves", "data/images/blackBishop.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(6);
		startPos.add(6);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(5);
		endPos.add(5);
			
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean bishopBool = ruleSet.bishopAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), bishop, startPos, endPos); 
		assertTrue(bishopBool);
	}
	
	//Bishop movement test (vertical), should return false
	public void testBishop2() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece bishop = new ChessPiece("bishop", "black", 0, 7, "moves", "data/images/blackBishop.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(2);
		startPos.add(2);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(3);
		endPos.add(2);
	
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean bishopBool = ruleSet.bishopAllowedMove(displacement) && ruleSet.noCollision(boardInstance.getBoardState(), bishop, startPos, endPos); 
		assertFalse(bishopBool);
	}
	
	//Black pawn straight movement test (moving forward), should return true
	public void testBlackPawn1() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece pawn = new ChessPiece("pawn", "black", 0, 7, "moves", "data/images/blackPawn.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(4);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(4);
		endPos.add(5);
	
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean pawnBool = ruleSet.pawnAllowedMove(displacement, "black", true, endPos, boardInstance.getBoardState()) && ruleSet.noCollision(boardInstance.getBoardState(), pawn, startPos, endPos);
		assertTrue(pawnBool);
	}
	
	//Black pawn straight movement test (moving 2 spaces forward from starting position), should return true
	public void testBlackPawn2() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece pawn = new ChessPiece("pawn", "black", 0, 7, "moves", "data/images/blackPawn.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(2);
		startPos.add(1);
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(2);
		endPos.add(3);
		
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean pawnBool = ruleSet.pawnAllowedMove(displacement, "black", false, endPos, boardInstance.getBoardState()) && ruleSet.noCollision(boardInstance.getBoardState(), pawn, startPos, endPos);
		assertTrue(pawnBool);
	}
	
	//Black pawn straight movement test (moving backward), should return false
	public void testBlackPawn3() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece pawn = new ChessPiece("pawn", "black", 0, 7, "moves", "data/images/blackPawn.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(6);
		startPos.add(6);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(6);
		endPos.add(4);
	
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean pawnBool = ruleSet.pawnAllowedMove(displacement, "black", true, endPos, boardInstance.getBoardState()) && ruleSet.noCollision(boardInstance.getBoardState(), pawn, startPos, endPos);
		assertFalse(pawnBool);
	}
	
	//Black pawn take diagonally test, should be true
	public void testBlackPawn4() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece pawn = new ChessPiece("pawn", "black", 0, 7, "moves", "data/images/blackPawn.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(3);
		startPos.add(5);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(2);
		endPos.add(6);
	
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean pawnBool = ruleSet.pawnAllowedMove(displacement, "black", true, endPos, boardInstance.getBoardState()) && ruleSet.noCollision(boardInstance.getBoardState(), pawn, startPos, endPos);
		assertTrue(pawnBool);
	}
	
	//Black pawn take vertically, should return FALSE
	public void testBlackPawn5() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece pawn = new ChessPiece("pawn", "black", 0, 7, "moves", "data/images/blackRook.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(3);
		startPos.add(5);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(3);
		endPos.add(6);
	
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean pawnBool = ruleSet.pawnAllowedMove(displacement, "black", true, endPos, boardInstance.getBoardState()) && ruleSet.noCollision(boardInstance.getBoardState(), pawn, startPos, endPos);
		assertFalse(pawnBool);
	}
	
	//White pawn movement test (moving forward), should return true
	public void testWhitePawn1() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece pawn = new ChessPiece("pawn", "white", 0, 7, "moves", "data/images/whitePawn.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(3);
		startPos.add(6);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(3);
		endPos.add(5);
	
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean pawnBool = ruleSet.pawnAllowedMove(displacement, "white", false, endPos, boardInstance.getBoardState()) && ruleSet.noCollision(boardInstance.getBoardState(), pawn, startPos, endPos);
		assertTrue(pawnBool);
	}
	
	//White pawn movement test (moving backward), should return false
	public void testWhitePawn2() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		ChessPiece pawn = new ChessPiece("pawn", "white", 0, 7, "moves", "data/images/whitePawn.png");
		Board boardInstance = new Board();
		
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(4);
		List<Integer> endPos = new ArrayList<Integer>(); 
		endPos.add(4);
		endPos.add(5);
	
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean pawnBool = ruleSet.pawnAllowedMove(displacement, "white", true, endPos, boardInstance.getBoardState()) && ruleSet.noCollision(boardInstance.getBoardState(), pawn, startPos, endPos);
		assertFalse(pawnBool);
	}
	
	//Test for en passant, should return true. Also tests if pawn was taken en passant.
	public void testEnPassant1() {
		RuleSet ruleSet = new RuleSet();
		CreateChessPieces.initializeSets();
		Board board = new Board();
		ChessPiece pawn = new ChessPiece("pawn", "white", 0, 7, "moves", "data/images/whitePawn.png");
		
		// Get a boardstate in which en passant will be possible
		ChessPiece[][] boardState = getEnPassantBoardState();
		
		// Save it to the board object created earlier
		board.setBoardState(boardState);
		
		// Make move BEFORE en passant, so it uses move history
		// Black pawn moves from 6,1 to 6,3
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(6);
		startPos.add(1);		
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(6);
		endPos.add(3);
		board.runTurn(startPos, endPos);
		
		// Then white pawn will move from 7,3 to 6,2 and take black pawn at 6,3
		// This is allowed because the pawn move to 6,3 was the previous move
		startPos.set(0, 7);
		startPos.set(1, 3);
		endPos.set(0, 6);
		endPos.set(1, 2);
		
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean enPassantBool = ruleSet.pawnAllowedMove(displacement, "white", true, endPos, board.getBoardState()) && ruleSet.noCollision(board.getBoardState(), pawn, startPos, endPos);
		assertTrue(enPassantBool);
		
		// Run the turn and check if black pawn was taken en passant!!
		board.runTurn(startPos, endPos);
		assertNull(board.getBoardState()[3][6]); //x and y are inverted in ChessPiece[][]
	}
	
	// Test for en passant, should return false
	public void testEnPassant2() {
		RuleSet ruleSet = new RuleSet();
		CreateChessPieces.initializeSets();
		Board board = new Board();
		ChessPiece pawn = new ChessPiece("pawn", "white", 0, 7, "moves", "data/images/blackRook.png");
		
		// Get a boardstate in which en passant will be possible
		ChessPiece[][] boardState = getEnPassantBoardState();
		
		// Save it to the board object created earlier
		board.setBoardState(boardState);
		
		// Make move BEFORE en passant, so it uses move history
		// Black pawn moves from 6,1 to 6,3
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(6);
		startPos.add(1);		
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(6);
		endPos.add(3);
		board.runTurn(startPos, endPos);
		
		// Then a white pawn will move from 2,3 to 3,2 and try to take black pawn at 3,3
		// This should not be allowed because the pawn move to 3,3 was not the previous move
		startPos.set(0, 2);
		startPos.set(1, 3);
		endPos.set(0, 3);
		endPos.set(1, 2);
		
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		boolean enPassantBool = ruleSet.pawnAllowedMove(displacement, "white", true, endPos, board.getBoardState()) && ruleSet.noCollision(board.getBoardState(), pawn, startPos, endPos);
		assertFalse(enPassantBool);
	}

	/**
	 * Used in testEnPassant1() and testEnPassant2() to build a BoardState in which en passant can be executed correctly and incorrectly
	 * Two black pawns can/will be on row 3, two white pawns can/will be on row 3
	 * TODO: maybe include image of this resulting boardState in doc
	 * @return ChessPiece[][] boardState
	 */
	private ChessPiece[][] getEnPassantBoardState() {
		CreateChessPieces.initializeSets();
		Board board = new Board();
		
		// White pawn from 2,6 to 2,4
		List<Integer> loc1 = new ArrayList<Integer>();
		loc1.add(2);
		loc1.add(6);
		List<Integer> loc2 = new ArrayList<Integer>();
		loc2.add(2);
		loc2.add(4);
		board.runTurn(loc1, loc2);
		
		// Black pawn from 3,1 to 3,3
		loc1.set(0, 3);
		loc1.set(1, 1);
		loc2.set(0, 3);
		loc2.set(1, 3);
		board.runTurn(loc1, loc2);
		
		// White pawn from 2,4 to 2,3
		loc1.set(0, 2);
		loc1.set(1, 4);
		loc2.set(0, 2);
		loc2.set(1, 3);
		board.runTurn(loc1, loc2);
		
		// Black knight from 1,0 to 0,2
		loc1.set(0, 1);
		loc1.set(1, 0);
		loc2.set(0, 0);
		loc2.set(1, 2);
		board.runTurn(loc1, loc2);
		
		// White pawn from 7,6 to 7,4
		loc1.set(0, 7);
		loc1.set(1, 6);
		loc2.set(0, 7);
		loc2.set(1, 4);
		board.runTurn(loc1, loc2);
		
		// Black pawn from 1,1 to 1,2
		loc1.set(0, 1);
		loc1.set(1, 1);
		loc2.set(0, 1);
		loc2.set(1, 2);
		board.runTurn(loc1, loc2);
		
		// White pawn from 7,4 to 7,3
		loc1.set(0, 7);
		loc1.set(1, 4);
		loc2.set(0, 7);
		loc2.set(1, 3);
		board.runTurn(loc1, loc2);
		
		return board.getBoardState();
	}
	
	//Test for castling on king side (short castling), should return true. Also tests if both King and Rook moved.
	public void testCastlingKingSide() {
		CreateChessPieces.initializeSets();
		Board castlingBoard = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece king = new ChessPiece("king", "white", 4, 7, "moves", "data/images/whiteKing.png");
		
		// Get boardState in which castling is allowed
		ChessPiece[][] boardState = getKingCastlingBoardState();
		
		// Save it to the board object created earlier
		castlingBoard.setBoardState(boardState);
		
		// Create displacement for the King's move during castling
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(7);		
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(6);
		endPos.add(7);
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		
		BoardTest.printBoardstate(boardState);
		
		Boolean castlingBool = ruleSet.castlingAllowed(boardState, king, displacement, "white", endPos);
		assertTrue(castlingBool);
		
		// Execute the castling and check if both King and Rook moved
		boardState = ruleSet.updateBoardState(boardState, startPos, endPos);
		assertNull(boardState[7][4]);
		assertNotNull(boardState[7][6]);
		assertNull(boardState[7][7]);
		assertNotNull(boardState[7][5]);
	}
	
	/**
	 * Generates a boardState in which the white king is allowed to castle on king side (short castling)
	 * Also used in testKingMovedCastling() and testRookMovedCastling() to assertFalse that castling only happens if both pieces have never moved before
	 * @return ChessPiece[][] boardstate
	 */
	private ChessPiece[][] getKingCastlingBoardState() {
		CreateChessPieces.initializeSets();
		Board board = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece[][] boardState = board.getBoardState();
		
		// White pawn from 4,6 to 4,4
		List<Integer> loc1 = new ArrayList<Integer>();
		loc1.add(4);
		loc1.add(6);
		List<Integer> loc2 = new ArrayList<Integer>();
		loc2.add(4);
		loc2.add(4);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// White bishop from 5,7 to 2,4
		loc1.set(0, 5);
		loc1.set(1, 7);
		loc2.set(0, 2);
		loc2.set(1, 4);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// White knight from 6,7 to 5,5
		loc1.set(0, 6);
		loc1.set(1, 7);
		loc2.set(0, 5);
		loc2.set(1, 5);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		return boardState;
	}
	
	//Test for castling on queen side (long castling), should return true. Also tests if both King and Rook moved.
	public void testCastlingQueenSide() {
		CreateChessPieces.initializeSets();
		Board castlingBoard = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece king = new ChessPiece("king", "white", 4, 7, "moves", "data/images/whiteKing.png");
		
		// Get boardState in which castling is allowed
		ChessPiece[][] boardState = getQueenCastlingBoardState();
		
		// Save it to the board object created earlier
		castlingBoard.setBoardState(boardState);
		
		// Create displacement for the King's move during castling
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(7);		
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(2);
		endPos.add(7);
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		
		BoardTest.printBoardstate(boardState);
		
		Boolean castlingBool = ruleSet.castlingAllowed(boardState, king, displacement, "white", endPos);
		assertTrue(castlingBool);
		
		// Execute the castling and check if both King and Rook moved
		boardState = ruleSet.updateBoardState(boardState, startPos, endPos);
		assertNull(boardState[7][4]);
		assertNotNull(boardState[7][2]);
		assertNull(boardState[7][0]);
		assertNotNull(boardState[7][3]);
	}
	
	/**
	 * Generates a boardState in which the white king is allowed to castle on queen side (long castling)
	 * @return ChessPiece[][] boardstate
	 */
	private ChessPiece[][] getQueenCastlingBoardState() {
		CreateChessPieces.initializeSets();
		Board board = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece[][] boardState = board.getBoardState();
		
		// White pawn from 1,6 to 1,5
		List<Integer> loc1 = new ArrayList<Integer>();
		loc1.add(1);
		loc1.add(6);
		List<Integer> loc2 = new ArrayList<Integer>();
		loc2.add(1);
		loc2.add(5);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// White bishop from 2,7 to 1,6
		loc1.set(0, 2);
		loc1.set(1, 7);
		loc2.set(0, 1);
		loc2.set(1, 6);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// White knight from 1,7 to 2,5
		loc1.set(0, 1);
		loc1.set(1, 7);
		loc2.set(0, 2);
		loc2.set(1, 5);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// White pawn from 4,6 to 4,4
		loc1.set(0, 4);
		loc1.set(1, 6);
		loc2.set(0, 4);
		loc2.set(1, 4);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// White queen from 3,7 to 4,6
		loc1.set(0, 3);
		loc1.set(1, 7);
		loc2.set(0, 4);
		loc2.set(1, 6);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		return boardState;
	}
	
	//Test castling when there is a piece between King and Rook (using initial boardstate, there is both Bishop and Knight)
	public void testPieceCastling() {
		CreateChessPieces.initializeSets();
		Board pieceCastlingBoard = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece[][] boardState = pieceCastlingBoard.getBoardState();
		
		ChessPiece king = new ChessPiece("king", "white", 4, 7, "moves", "data/images/whiteKing.png");
		
		// Create displacement for the King's move during castling
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(7);		
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(2);
		endPos.add(7);
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		
		boolean castlingBool = ruleSet.castlingAllowed(boardState, king, displacement, "white", endPos);
		assertFalse(castlingBool);
	}
	
	//Test castling while King passes through Check, should return false
	public void testCheckCastling() {
		CreateChessPieces.initializeSets();
		Board checkCastlingBoard = new Board();
		RuleSet ruleSet = new RuleSet();
		
		// Creat the king that will attempt to castle
		ChessPiece king = new ChessPiece("king", "white", 4, 7, "moves", "data/images/whiteKing.png");
		
		// Get and set the castle
		ChessPiece[][] boardState = getCheckCastlingBoardstate();
		checkCastlingBoard.setBoardState(boardState);
		
		// Create displacement for the King's move during castling
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(7);		
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(6);
		endPos.add(7);
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		
		Boolean castlingBool = ruleSet.castlingAllowed(boardState, king, displacement, "white", endPos);
		assertFalse(castlingBool);
	}
	
	/**
	 * Creates a boardState in which the King cannot castle due to passing through check by black bishop
	 * @return ChessPiece[][] boardState
	 */
	private ChessPiece[][] getCheckCastlingBoardstate() {
		RuleSet ruleSet = new RuleSet();
		CreateChessPieces.initializeSets();
		Board board = new Board();
		ChessPiece[][] boardState = board.getBoardState();
		
		// White pawn from 4,6 to 4,5
		List<Integer> loc1 = new ArrayList<Integer>();
		loc1.add(4);
		loc1.add(6);
		List<Integer> loc2 = new ArrayList<Integer>();
		loc2.add(4);
		loc2.add(5);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);

		// White bishop from 5,7 to 2,4
		loc1.set(0, 5);
		loc1.set(1, 7);
		loc2.set(0, 2);
		loc2.set(1, 4);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);

		// White knight from 6,7 to 5,5
		loc1.set(0, 6);
		loc1.set(1, 7);
		loc2.set(0, 5);
		loc2.set(1, 5);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// Black bishop from 2,0 to 2,4
		loc1.set(0, 2);
		loc1.set(1, 0);
		loc2.set(0, 2);
		loc2.set(1, 4);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		return boardState;
	}
	
	//Test castling while King has moved before
	public void testKingMovedCastling() {
		CreateChessPieces.initializeSets();
		Board kingMovedCastlingBoard = new Board();
		RuleSet ruleSet = new RuleSet();
		
		// Create the king that will attempt to castle
		ChessPiece king = new ChessPiece("king", "white", 4, 7, "moves", "data/images/whiteKing.png");
		king.setHasMoved(true);
		
		// Get and set the castle
		ChessPiece[][] boardState = getKingCastlingBoardState();
		kingMovedCastlingBoard.setBoardState(boardState);
		
		// Create displacement for the King's move during castling
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(4);
		startPos.add(7);		
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(6);
		endPos.add(7);
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		
		// Notice we pass "true" as Boolean hasMoved for the King!
		Boolean castlingBool = ruleSet.castlingAllowed(boardState, king, displacement, "white", endPos);
		assertFalse(castlingBool);
	}
	
	//Test castling while Rook has moved before
	public void testRookMovedCastling() {
		CreateChessPieces.initializeSets();
		Board rookMovedCastlingBoard = new Board();
		RuleSet ruleSet = new RuleSet();
		
		// Create the king that will attempt to castle
		ChessPiece king = new ChessPiece("king", "white", 4, 7, "moves", "data/images/whiteKing.png");
		
		// Get and set the castle
		ChessPiece[][] boardState = getKingCastlingBoardState();
		rookMovedCastlingBoard.setBoardState(boardState);
		
		// Move Rook back and forth
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(7);
		startPos.add(7);
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(6);
		endPos.add(7);
		boardState = ruleSet.updateBoardState(boardState, startPos, endPos);
		
		startPos.set(0, 6);
		startPos.set(1, 7);
		endPos.set(0, 7);
		endPos.set(1, 7);
		boardState = ruleSet.updateBoardState(boardState, startPos, endPos);
		
		// Create displacement for the King's move during castling
		startPos.set(0, 4);
		startPos.set(1, 7);
		endPos.set(0, 6);
		endPos.set(1, 7);
		List<Integer> displacement = RuleSet.displacement(startPos, endPos);
		
		Boolean castlingBool = ruleSet.castlingAllowed(boardState, king, displacement, "white", endPos);
		assertFalse(castlingBool);
	}

	//Test whether the king is check, should return false (king is not check in initial boardState)
	public void testIsKingCheck1() {
		CreateChessPieces.initializeSets();
		Board kingCheckBoard = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece[][] boardState = kingCheckBoard.getBoardState();

		boolean kingCheckBool = ruleSet.isKingCheck(boardState, "white");
		assertFalse(kingCheckBool);
	}
	
	//Tests whether the king is check, should return true
	public void testIsKingCheck2() {
		RuleSet ruleSet = new RuleSet();
		CreateChessPieces.initializeSets();
		Board board = new Board();
		ChessPiece[][] boardState = board.getBoardState();
		
		// Create boardstate in which white king *will be* put in check (is not in check yet!)
		boardState = getCheckBoardState();
		
		// Save it to the board object created earlier
		board.setBoardState(boardState);
		
		// Make last move by Black, putting white king in check
		// Black Bishop will move from 5,0 to 1,4
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(5);
		startPos.add(0);		
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(1);
		endPos.add(4);
		
		// Run the turn as a move is done in-game
		boardState = ruleSet.updateBoardState(boardState, startPos, endPos);
		
		boolean kingCheckBool = ruleSet.isKingCheck(boardState, "white");
		assertTrue(kingCheckBool);
	}

	/**
	 * Used in testIsKingCheck2() to build a BoardState in which white king can be put in check
	 * TODO: maybe include image of this resulting boardState in doc
	 * @return ChessPiece[][] boardState
	 */
	private ChessPiece[][] getCheckBoardState() {
		CreateChessPieces.initializeSets();
		Board board = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece[][] boardState = board.getBoardState();
		
		// White pawn from 4,6 to 4,4
		List<Integer> loc1 = new ArrayList<Integer>();
		loc1.add(4);
		loc1.add(6);
		List<Integer> loc2 = new ArrayList<Integer>();
		loc2.add(4);
		loc2.add(4);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// Black pawn from 4,1 to 4,3
		loc1.set(0, 4);
		loc1.set(1, 1);
		loc2.set(0, 4);
		loc2.set(1, 3);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// White pawn from 3,6 to 3,5
		loc1.set(0, 3);
		loc1.set(1, 6);
		loc2.set(0, 3);
		loc2.set(1, 5);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);

		return boardState;
	}
	
	//Tests whether King is checkmate, should return false (King is not checkmate in starting position)
	public void testIsKingCheckMate1() {
		CreateChessPieces.initializeSets();
		Board kingCheckBoard = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece[][] boardState = kingCheckBoard.getBoardState();

		boolean kingCheckMateBool = ruleSet.checkForCheckMate(boardState, "white");
		assertFalse(kingCheckMateBool);
	}
	
	//Tests whether King is checkmate, should return true
	public void testIsKingCheckMate2() {
		CreateChessPieces.initializeSets();
		RuleSet ruleSet = new RuleSet();
		Board board = new Board();
		ChessPiece[][] boardState = board.getBoardState();
		
		// Create boardstate in which black king is one move away from checkmate
		boardState = getCheckMateBoardState();
		
		// Save it to the board object created earlier
		board.setBoardState(boardState);
		
		// Make last move with white putting black king in checkmate
		// White Queen will move from 7,3 to 5,1
		List<Integer> startPos = new ArrayList<Integer>();
		startPos.add(7);
		startPos.add(3);		
		List<Integer> endPos = new ArrayList<Integer>();
		endPos.add(5);
		endPos.add(1);
		
		// Update the boardstate
		boardState = ruleSet.updateBoardState(boardState, startPos, endPos);
		
		boolean kingCheckMateBool = ruleSet.checkForCheckMate(boardState, "black");
		assertTrue(kingCheckMateBool);
	}
	
	/**
	 * Used in testIsKingCheckMate2() to build a BoardState in which black king is almost checkmate
	 * TODO: maybe include image of this resulting boardState in doc
	 * @return ChessPiece[][] boardState
	 */
	private ChessPiece[][] getCheckMateBoardState() {
		CreateChessPieces.initializeSets();
		Board board = new Board();
		RuleSet ruleSet = new RuleSet();
		ChessPiece[][] boardState = board.getBoardState();
		
		// White pawn from 4,6 to 4,4
		List<Integer> loc1 = new ArrayList<Integer>();
		loc1.add(4);
		loc1.add(6);
		List<Integer> loc2 = new ArrayList<Integer>();
		loc2.add(4);
		loc2.add(4);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// Black pawn from 0,1 to 0,2
		loc1.set(0, 0);
		loc1.set(1, 1);
		loc2.set(0, 0);
		loc2.set(1, 2);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// White queen from 3,7 to 7,3
		loc1.set(0, 3);
		loc1.set(1, 7);
		loc2.set(0, 7);
		loc2.set(1, 3);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// black pawn from 0,2 to 0,3
		loc1.set(0, 0);
		loc1.set(1, 2);
		loc2.set(0, 0);
		loc2.set(1, 3);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// white bishop from 5,7 to 2,4
		loc1.set(0, 5);
		loc1.set(1, 7);
		loc2.set(0, 2);
		loc2.set(1, 4);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);
		
		// black pawn from 0,3 to 0,4
		loc1.set(0, 0);
		loc1.set(1, 3);
		loc2.set(0, 0);
		loc2.set(1, 4);
		boardState = ruleSet.updateBoardState(boardState, loc1, loc2);

		return boardState;
	}
}
