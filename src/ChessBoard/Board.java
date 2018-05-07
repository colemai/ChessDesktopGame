package ChessBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ChessGame.AudioHandler;
import ChessGame.ChessClock;
import ChessGame.GameEnder;
import ChessGame.RuleSet;
import ChessPieces.ChessPiece;
import ChessPieces.CreateChessPieces;

public class Board {

	public ChessPiece[][] boardState = new ChessPiece[8][8];
	private ArrayList<ChessPiece> whiteSet;
	private ArrayList<ChessPiece> blackSet;
	Random rand = new Random();
	public Boolean whiteTurn = true;
	public static ArrayList<Object> boardHistory = new ArrayList<Object>();
	public static int turnCount;
	private static int numPointsPlayer1;
	private static int numPointsPlayer2;
	ChessClock chessClock;
	
	
	/**
	 * Instantiate the board and two sets of Chess Pieces
	 * Call starting boardstate at the start of a game
	 */
	public Board() {
		CreateChessPieces chessPieceGenerator = new CreateChessPieces();
		this.whiteSet = chessPieceGenerator.CreateWhiteSet();
		this.blackSet = chessPieceGenerator.CreateBlackSet();
		setInitialState();
	}
	
	public Board(ChessClock mChessClock) {
		CreateChessPieces chessPieceGenerator = new CreateChessPieces();
		this.whiteSet = chessPieceGenerator.CreateWhiteSet();
		this.blackSet = chessPieceGenerator.CreateBlackSet();
		setInitialState();
		chessClock = mChessClock;//initializing the clock that will run in a separate thread
		Thread runner = new Thread(chessClock);
		runner.start(); //starting the thread
	}

	/**
	 * Get the current BoardState during a game
	 * @return ChessPiece[][] Boardstate containing which pieces are in which tiles
	 */
	public ChessPiece[][] getBoardState(){
		return this.boardState;	
	}

	/**
	 * Set the boardState as a variable
	 * @param boardState
	 */
	public void setBoardState(ChessPiece[][] boardState) {
		this.boardState = boardState;
	}

	/**
	 * Put chess pieces in their starting position
	 */
	public void setInitialState() {
		int xLoc;
		int yLoc;
		ChessPiece currentPiece;
		for (int i = 0; i < whiteSet.size(); i++) {
			xLoc = whiteSet.get(i).getxLoc();
			yLoc = whiteSet.get(i).getyLoc();
			currentPiece = whiteSet.get(i);
			this.boardState[yLoc][xLoc] = currentPiece;
			}
		for (int i = 0; i < blackSet.size(); i++) {
			xLoc = blackSet.get(i).getxLoc();
			yLoc = blackSet.get(i).getyLoc();
			currentPiece =blackSet.get(i); 
			this.boardState[yLoc][xLoc] = currentPiece;
		}
		System.out.println(boardHistory);
		boardHistory.add(boardState);
	}

	/**
	 * Get the chess pieces of the white player
	 * @return ArrayList<ChessPiece> whiteSet
	 */
	public ArrayList<ChessPiece> getWhiteSet() {
		return this.whiteSet;
	}
	
	/**
	 * Get the chess pieces of the black player
	 * @return ArrayList<ChessPiece> blackSet
	 */
	public ArrayList<ChessPiece> getBlackSet() {
		return this.blackSet;
	}
	
	/**
	 * Translates the tileName of the position on the board that was clicked to a list of integers for downstream parsing
	 * @param tileName - A string describing what tile was clicked, e.g. 63 where x=6 and  y=3 on the board
	 * @return List<Integer> boardPositionClicked - List with two integers, the x and y coordinate of the clicked tile
	 */
	
	
	public static boolean setRotation = true;
	public static void  setBoardPositionClicked (boolean inputBool) {
		setRotation = inputBool;
	}
	
	public List<Integer> getBoardPositionClicked(String tileName) {
		//tileName is a string like : "63" 6 being x 3 being y
		char first = tileName.charAt(0);
		char second = tileName.charAt(1);
		List<Integer> boardPositionClicked = new ArrayList<Integer>();
		
				
				
			if(setRotation && !whiteTurn) {
				// Inverting the board during Black's turn
				boardPositionClicked.add(7-Character.getNumericValue(first));
				boardPositionClicked.add(7-Character.getNumericValue(second));
			}else {
				boardPositionClicked.add(Character.getNumericValue(first));
				boardPositionClicked.add(Character.getNumericValue(second));
				
			}
		
		
		
		return boardPositionClicked;
	}
	
	/**
	 * Check whether a certain location contains a piece that belongs to the player whose turn it is
	 * @param location - List<Integer> Location of the clicked tile
	 * @param turn - Boolean describing whose turn it is (Players can only pick up their own pieces)
	 * @return ChessPiece if there is a piece, null if there isn't or it isn't theirs
	 */
	public ChessPiece searchPieceSet(List<Integer> location, Boolean turn) {
		//new piece return method
		ChessPiece mPiece = boardState[location.get(1)][location.get(0)];//find piece out of boardstate array
		if(mPiece != null){
			if(turn && mPiece.getColour() == "white" || !turn && mPiece.getColour() =="black"){//checks whether piece is selectable in this players turn
				return mPiece;//returns when true
			}
		}
		// else returns NUUUUULLLL
		return null;
	}
	
	/**
	 * Updates the boardState after a valid move by updating the Piece in the current ChessPiece[][] boardState
	 * @param loc1 List<Integer> Old location of the piece
	 * @param loc2 List<Integer> New location of the piece
	 */
	public void updateBoardState(List<Integer> loc1, List<Integer> loc2) {	
		// Add current board to board history
		// Needs to use clone to make a separate instance
		ChessPiece[][] tempBoard = boardStateCopy(boardState);
		boardHistory.add(tempBoard); 
		
		ChessPiece mPiece = new ChessPiece(boardState[loc1.get(1)][loc1.get(0)]); //grabs the piece
		mPiece.setHasMoved(true);
		this.boardState[loc1.get(1)][loc1.get(0)] = null; // makes the location where the selected piece was NULL
		
		if(this.boardState[loc2.get(1)][loc2.get(0)] != null){
			//Play a capture sound
			//int randomNum = rand.nextInt(4) + 1;
			//AudioHandler.playSingle("data/Sounds/wowSounds/Wow" +randomNum + ".wav", 0);
			AudioHandler.playSingle("data/Sounds/OtherFX/PieceCapture.wav", 0);
			this.boardState[loc2.get(1)][loc2.get(0)] = mPiece;
		} else {
			//Play a move sound
			AudioHandler.playSingle("data/Sounds/OtherFX/PieceMove.wav", 0);
			this.boardState[loc2.get(1)][loc2.get(0)] = mPiece;
		}
	}
	
	public ChessPiece[][] getPreviousBoard(int turnsAgo){
		ChessPiece[][] previousBoardState;	
		// Make sure boardHistory isn't empty and turnsAgo request doesn't exceed the amount of actual turns.
		if (boardHistory.size() > 0 && turnsAgo <= boardHistory.size()) {
			previousBoardState = (ChessPiece[][]) boardHistory.get(boardHistory.size()-turnsAgo);
			// Example request: previousBoardState[6][3].getType()
			return previousBoardState;
		} else {
			return null;
		}
	}
	
	/**
	 * Monitors an entire turn by loading the ruleset, checking if the king is Check, checking if a move is legal
	 * @param loc1 - List<Integer> Location of a piece before moving
	 * @param loc2 - List<Integer> Location where player wants to move the piece
	 * @return A string of the move that was made
	 */
	//GOD CRIXUS
	public String runTurn(List<Integer> loc1, List<Integer> loc2) {
		//Boolean isFinished = false;
		// display the move in the history log
		// click1Piece = moving piece
		// click2Piece = (optional) taken piece
		//an empty move string.
		String moveString = "";
		String Loc1String = loc1.get(0).toString() + ", " + loc1.get(1).toString();
		String Loc2String = loc2.get(0).toString() + ", " + loc2.get(1).toString();
				
		RuleSet ruleSet = new RuleSet();
		String playerString;
		String oppositionString;
		if (whiteTurn) {
			playerString = "white";
			oppositionString = "black";
		} else {
			playerString = "black";
			oppositionString = "white";
		}
		
	
		
		
		
		if (ruleSet.isMoveAllowed(boardState, this.boardState[loc1.get(1)][loc1.get(0)], loc1, loc2) && ruleSet.moveSolvesCheck(boardState, loc1, loc2, whiteTurn)) {
			System.out.println("Board.runTurn: Move is legal");
			boardState[loc1.get(1)][loc1.get(0)].move(loc2); //update the piece
			updateBoardState(loc1, loc2); //update the board
			//adds the made move to moveString
			moveString = boardState[loc2.get(1)][loc2.get(0)].getColour() + " " + boardState[loc2.get(1)][loc2.get(0)].getType() + " from " + Loc1String + " to " + Loc2String + "\n";
			ruleSet.upForPromotion(boardState, playerString);
			
			turnCount++;
			whiteTurn = !whiteTurn; //turn goes to other player
			if (chessClock != null) {
				chessClock.setWhiteTurn(whiteTurn);//the clock thread gets notified
			}
		}
		
		if (ruleSet.isKingCheck(boardState, oppositionString)) {
			// check whether the move would be possible for the selected piece on an empty board
			System.out.println("Board.runTurn: king in check");
			moveString = moveString + oppositionString + " king in check!" + System.lineSeparator();
			
			if (ruleSet.checkForCheckMate(boardState, oppositionString)) { // if the king is checkmate
				
				//System.out.println(ruleSet.checkForCheckMate(boardState, oppositionString));
				
				GameEnder gameEnder = new GameEnder();
				System.out.println("Board.runTurn: " + oppositionString + " king in checkmate");
				gameEnder.endGame(playerString);
			}else{
				System.out.println("Board.runturn: " + oppositionString + " king in check, not mate");
			}
			//TODO: Check for checkmate
			// if(!ruleSet.checkCheckMate(this.boardState, colourString)){
			// 	
			// } 
		} else {
			System.out.println("Board.runturn: " + oppositionString + " king not in check or mate");
			
		}
		// TODO: Write an else clause and pop-up message if a move is not valid.
		return moveString;
		
		
	}
	
	/**
	 * Get the state of the Boolean whiteTurn
	 * @return whiteTurn
	 */
	// TODO: Testcase
	public  Boolean getTurn() {
		// Gets the state of the boolean
		return whiteTurn;
	}

	public static int getPointDifference()
	{
		return numPointsPlayer1-numPointsPlayer2;
	}
	/**
	 * Copy constructor for board, that copies the input boardstate and puts it into a new board
	 * @param inputBoardState, the boardstate you wish this board to have*/
	
	public static ChessPiece[][] boardStateCopy(ChessPiece[][] inputBoardState){
		ChessPiece[][] tempBoard = new ChessPiece[inputBoardState.length][];
		for(int i = 0; i < inputBoardState.length; i++)
			tempBoard[i] = inputBoardState[i].clone();
		return tempBoard;
	}
	
}
