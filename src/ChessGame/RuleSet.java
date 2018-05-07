package ChessGame;
import static java.lang.Math.abs;

// Need to clean up imports.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ChessBoard.Board;
import ChessPieces.ChessPiece;


/** Dictates piece movements and rules
 * Includes checks for check and checkmate
 * This class generally needs 4 things: piece name, piece colour, initial (x,y), new (x,y).
 * @author Whole team
*/
public class RuleSet {

	// --------------------------------------------------------------------------------------------------------------------
	// In this segment, methods can be called depending on piece. It will calculate
	// whether a move is legal or not.

	// Method that collects the board state from <int turnsAgo> turns back
	
	/**
	 * gets the boardstate from n turns ago and returns the boardstate as a 2d array
	 * @param turnsAgo the amount of turns back you want it to work
	 * @return ChessPiece[][] */
	public ChessPiece[][] getPreviousBoard(int turnsAgo){
		ChessPiece[][] previousBoardState;	// New empty 2D array
		// Make sure boardHistory isn't empty and turnsAgo request doesn't exceed the amount of actual turns.
		if (Board.boardHistory.size() > 0 && turnsAgo <= Board.boardHistory.size()) {
			// To get the board from X turns ago, you request the index that matches the length of the 
			// boardHistory array, minus the turns ago (so next to last), and then again -1 because size() starts from
			// 1 and index from 0.
			previousBoardState = (ChessPiece[][]) Board.boardHistory.get((Board.boardHistory.size()-turnsAgo)-1);
			// Example request: previousBoardState[6][3].getType()
			return previousBoardState;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Checks if a threefold repetition of the board has occured
	 * @param boardHistory
	 * @return true if threefold occurrence, else false
	 */
	public boolean threefoldRepetition(ArrayList<Object> boardHistory) {
		if (boardHistory.size() > 3) { // At least 3 turns
			for (int i = 0; i < boardHistory.size(); i++) { // Loop over all board histories
				ChessPiece[][] templateBoardState = (ChessPiece[][]) boardHistory.get(i); // Take template boardhistory for index i
				int threefold_count = 0; // Int that counts identical occurrences
				for (int j = 0; j < boardHistory.size(); j++) { // Lay template board against other boards (models)
					ChessPiece[][] modelBoardState = (ChessPiece[][]) boardHistory.get(j); 
					// Loop over all board positions, check them 1 by 1
					int tiles = 0;
					for (int k = 0; k < modelBoardState.length; k++) { // Y, rows
						for (int k2 = 0; k2 < modelBoardState[k].length; k2++) { // X, columns
							if(templateBoardState[k][k2] == modelBoardState[k][k2]) { // Compare template to model
								tiles++; // Identical --> +1
							}
						}
					}
					if (tiles == 64) { //  if 64 tiles(complete board) are identical
						threefold_count++;
					}
				}
				if(threefold_count > 3) {  // Larger than 3, because it will loop over itself once, always generating a +1
					return true; // More than three occurrences of same board, return true
				}
			}
			return false; // Return false if boardHistory > 3, but no threefold repetition
		}
		return false; // Default return, continues the game
	}
	
	/**
	 * checks if the given location is reachable for the king.
	 * @param displacement a int list containing the x and y coordinates.
	 * @return true if possible false if not.
	 */
    public boolean kingAllowedMove(List<Integer> displacement){
        // Don't allow ranges <-1 and >1, but every combination is possible.
        if (abs(displacement.get(0)) == 1 && (abs(displacement.get(1)) == 0)  || abs(displacement.get(1)) == 1 && abs(displacement.get(0)) == 0 ) {
            return true;
        } else 
        	// Diagonal
        	if (abs(displacement.get(0)) == 1 && abs(displacement.get(1)) == 1){
        		return true;
        	} return false;
    }
    /**
	 * checks if the given location is reachable for the queen.
	 * @param displacement a int list containing the x and y coordinates.
	 * @return true if possible false if not.
	 */
    public boolean queenAllowedMove(List<Integer> displacement){
        // Since all combinations of +/- are possible, just check absolute value.
        // Vertical / horizontal.
        if (((inRange(abs(displacement.get(0)),1,8) && displacement.get(1)==0)) ||
                ((inRange(abs(displacement.get(1)),1,8) && displacement.get(0)==0))){
            return true;
        } else
            // Diagonal.
            if (abs(displacement.get(0))==abs(displacement.get(1)) && inRange(abs(displacement.get(0)),1,8)){
                return true;
        }
        return false;
    }
    /**
	 * checks if the given location is reachable for the rook.
	 * @param displacement a int list containing the x and y coordinates.
	 * @return true if possible false if not.
	 */
    public boolean rookAllowedMove(List<Integer> displacement){
        // Since all combinations of +/- are possible, just check absolute value.
        // Vertical / horizontal.
        if (((inRange(abs(displacement.get(0)),1,8) && displacement.get(1)==0)) ||
                ((inRange(abs(displacement.get(1)),1,8) && displacement.get(0)==0))) {
            return true;
        } return false;
    }
    /**
	 * checks if the given location is reachable for the bishop.
	 * @param displacement a int list containing the x and y coordinates.
	 * @return true if possible false if not.
	 */
    public boolean bishopAllowedMove(List<Integer> displacement){
        // Diagonal.
        if (abs(displacement.get(0))==abs(displacement.get(1)) && inRange(abs(displacement.get(0)),1,8)) {
            return true;
        } return false;
    }
    /**
	 * checks if the given location is reachable for the knight.
	 * @param displacement a int list containing the x and y coordinates.
	 * @return true if possible false if not.
	 */
    public boolean knightAllowedMove(List<Integer> displacement){
        // Knights can take any combination of -2,-1,1,2 for X and Y, as long as
        // they are not both (-)1 or (-)2.
        if (abs(displacement.get(0))==1 && abs(displacement.get(1))==2 ||
                abs(displacement.get(0))==2 && abs(displacement.get(1))==1){
            return true;
        } return false;
    }

    // The pawn has 2 types of movement: forward, or sideways if a piece is taken.
    /**
	 * checks if the given location is reachable for the pawn.
	 * @param displacement a int list containing the x and y coordinates.
	 * @return true if possible false if not.
	 */
    public boolean pawnAllowedMove(List<Integer> displacement, String pieceColour, Boolean hasMoved, 
    		List<Integer> newPosition, ChessPiece[][] boardState){
        // 1 Or 2 Y movement, 0 X movement.
        // white = player, so upwards.
        
    
        // White pawn basic forward movement
        if (pieceColour.equals("white")) {
            //System.out.println("RuleSet.pawnAllowedMove: displacement = " + displacement);
            if((displacement.get(0) == 0 && displacement.get(1) == -1) || // x=0, y= 1 up
            		// OR
            		(!hasMoved && displacement.get(1) == -2 && displacement.get(0)==0)) { // not moved, x=0, y= 2 up
                if (boardState[newPosition.get(1)][newPosition.get(0)] != null) { // can't move to tile with other piece on it
                    return false;
                } else {
                return true; // one of the above OR's + empty tile
                }
            // White pawn diagonal taking
            } else if (displacement.get(1)==-1 && (displacement.get(0)==-1 || displacement.get(0)==1) ){
                if (boardState[newPosition.get(1)][newPosition.get(0)] != null) { // If new place NOT empty.
                    return true;
                } else if (boardState[newPosition.get(1)+1][newPosition.get(0)] != null) { // Check en passant
					if(boardState[newPosition.get(1)+1][newPosition.get(0)].getType().equals("pawn") && // Passing pawn
                		boardState[newPosition.get(1)+1][newPosition.get(0)].getColour() != pieceColour){ // pawn of different color
	                    if(getPreviousBoard(1)[newPosition.get(1)-1][newPosition.get(0)] != null) { // previous turn not empty
	                    	if (getPreviousBoard(1)[newPosition.get(1)-1][newPosition.get(0)].getType().equals("pawn") // previous turn was pawn
	                    			&& getPreviousBoard(1)[newPosition.get(1)-1][newPosition.get(0)].getColour() != pieceColour) { // previous turn was different colour
	                    		boardState[newPosition.get(1)+1][newPosition.get(0)] = null; // Delete passed piece
	                            return true;
	                    	}
	                    }
                    }
                	return false;
                    
                } else {
                    return false;
                } 
            } else {
                return false;
            }
        // Black pawn basic forward movement
        } else if (pieceColour.equals("black")){
            if(displacement.get(0) == 0 && (displacement.get(1) == 1 || // x=0, y= 1 down
            		// OR
            		(!hasMoved && displacement.get(1) == 2 && displacement.get(0)==0)) ) { // not moved and x=0 and y = 2 down
                if (boardState[newPosition.get(1)][newPosition.get(0)] != null) { // can't move to tile with other piece on it
                    return false;
                } else {
                return true; // one of the above OR's + empty tile
                }
            // Black pawn diagonal taking
            } else if (displacement.get(1)==1 && (displacement.get(0)==-1 || displacement.get(0)==1) ){
                if (boardState[newPosition.get(1)][newPosition.get(0)] != null) { // If new place NOT empty.
                    return true;
                } else if(boardState[newPosition.get(1)-1][newPosition.get(0)] != null){ // Check en passant
                	if(boardState[newPosition.get(1)-1][newPosition.get(0)].getType().equals("pawn") && // Passing pawn
                		boardState[newPosition.get(1)-1][newPosition.get(0)].getColour() != pieceColour){ // pawn of different color
	                    if(getPreviousBoard(1)[newPosition.get(1)+1][newPosition.get(0)] != null) { // previous turn not empty
	                    	if (getPreviousBoard(1)[newPosition.get(1)+1][newPosition.get(0)].getType().equals("pawn") // previous turn was pawn
	                    			&& getPreviousBoard(1)[newPosition.get(1)+1][newPosition.get(0)].getColour() != pieceColour) { // previous turn was different colour
	                    		boardState[newPosition.get(1)-1][newPosition.get(0)] = null; // Delete passed piece
	                            return true;
							}
	                    }
                    }
                	return false;
                    
                } else {
                    return false;
                } 
            } else {
                return false;
            }
        }
        return false;
    }
  
    
    /**
     * Checks if castling is allowed on the current board state - returns true but does not update board state now 
     * @param boardState the current boardstate a 2d ChessPiece array
     * @param selectedPiece the selected ChessPiece 
     * @param displacement for the piece given as a Int list
     * @param pieceColour the colour of the piece
     * @param newPosition the new possition of the piece.
     * @return true if possible false if not.
     */
    public boolean castlingAllowed(ChessPiece[][] boardState, ChessPiece selectedPiece, List<Integer> displacement, String pieceColour, 
            List<Integer> newPosition) {
        // is king, never moved
        if(selectedPiece.getType().equals("king") && selectedPiece.getHasMoved()==false && 
                // 0 Y movement, 2 X movement
                (abs(displacement.get(0))==2 && abs(displacement.get(1))==0)) {
            // left side -------------------------------------------------------------------------------------------------------------
        	// e.g. [rook][null][null][null][king]
            if (displacement.get(0)==-2) {            
            	
            	//Check that every tile between the king and the rook is empty (null)
            	for (int i = selectedPiece.getxLoc() - 1; i > 0; i-- ) {
            		if (boardState[selectedPiece.getyLoc()][i] != null) {
            			return false;
            		}
            	}
            	
            	//Check rook is in original position/has not moved
            	if (!boardState[selectedPiece.getyLoc()][0].getType().equals("rook") || boardState[selectedPiece.getyLoc()][0].getHasMoved()==true) {
            		return false;
            	}
            	
            	// Check that the tiles the king moves to and through would not be in check (NB this checks for check)
            	List<Integer> tileToCheck = new ArrayList<Integer>();
            	for (int i = selectedPiece.getxLoc(); i >= newPosition.get(0); i-- ) {
            		tileToCheck.clear();
            		tileToCheck.add(i);
            		tileToCheck.add(selectedPiece.getyLoc());
            		if (canAnyPieceMoveHere(boardState, pieceColour, tileToCheck)) {
            			return false;
            		}
            	}           	
            	
            	//If legal then update the rook position and return true (king position will update elsewhere)
            	List<Integer> newRookPos = new ArrayList<Integer>();
            	newRookPos.add(newPosition.get(0)+1);
            	newRookPos.add(selectedPiece.getyLoc());
            	List<Integer> initialRookPos = new ArrayList<Integer>();
            	initialRookPos.add(0);
            	initialRookPos.add(selectedPiece.getyLoc());
            	updateBoardState(boardState, initialRookPos, newRookPos);
            	return true;
            	
            	
            } else if (displacement.get(0)==2) {
            	
            	//Check that every tile between the king and the rook is empty (null)
            	for (int i = selectedPiece.getxLoc() + 1; i < 7; i++ ) {
            		if (boardState[selectedPiece.getyLoc()][i] != null) {
            			return false;
            		}
            	}
            	
            	//Check rook is in original position/has not moved
            	if (!boardState[selectedPiece.getyLoc()][7].getType().equals("rook") || boardState[selectedPiece.getyLoc()][7].getHasMoved()==true) {
            		return false;
            	}
            	
            	// Check that the tiles the king moves to and through would not be in check (NB this checks for check)
            	List<Integer> tileToCheck = new ArrayList<Integer>();
            	for (int i = selectedPiece.getxLoc(); i <= newPosition.get(0); i++ ) {
            		tileToCheck.clear();
            		tileToCheck.add(i);
            		tileToCheck.add(selectedPiece.getyLoc());
            		if (canAnyPieceMoveHere(boardState, pieceColour, tileToCheck)) {
            			return false;
            		}
            	}
            	
            	// Update 
            	List<Integer> newRookPos = new ArrayList<Integer>();
            	newRookPos.add(newPosition.get(0)-1);
            	newRookPos.add(selectedPiece.getyLoc());
            	List<Integer> initialRookPos = new ArrayList<Integer>();
            	initialRookPos.add(7);
            	initialRookPos.add(selectedPiece.getyLoc());
            	updateBoardState(boardState, initialRookPos, newRookPos);
            	return true;
            	
            	
            }
            return false; // DUMMY
        }
        return false;
    }

    /**
     * the Delta change in x,y coordinates, used for the PieceAllowedMove methods.
     * @param initialPosition current possition of a piece as int list
     * @param newPosition new position of a piece as int list
     * @return returns a int list.
     */
    public static List<Integer> displacement(List<Integer> initialPosition, List<Integer> newPosition){
        List<Integer> displacement = new ArrayList<Integer>();
        Integer yDisp = newPosition.get(0)-initialPosition.get(0);
        Integer xDisp = newPosition.get(1)-initialPosition.get(1);
        displacement.add(yDisp);
        displacement.add(xDisp);
        return displacement;
    }

    /**
     * Simple checker to see if integer is in certain range.
     * @param i the int of interest
     * @param low to lowest int in range
     * @param high highest int in range  
     * @return true if in range false if not.
     */
    public boolean inRange(int i, int low, int high){
        if (low<0 && high<0 && high<low && i<=low && i>=high) { // For negative values, i.e. low=-1 and high=-8.
            return true;
        } else if (i >= low && i <= high) { // For positive values.
                return true;
            } return false;
    }

    // ----------------------------------------------------------------------------------------------------------------
    // In this segment, additional checks are placed (checkmate, piece taken, collision?, )
    /**
     * Take a desired move and run both legal-move checks (Allowed move and noCollission) if both true then return true to approve move
     * @param boardState records positions of pieces at this point in time
     * @param selectedPiece a piece object including colour and type
     * @param initialPosition position at begining of move
     * @param newPosition position at end of desired move
     * @return true if move is allowed false if not.
     */
    public boolean isMoveAllowed(ChessPiece[][] boardState, ChessPiece selectedPiece, List<Integer> initialPosition, List<Integer> newPosition) {
    	// Make switch / if/else statement to call the correct pieceAllowedMove method.
    	if(selectedPiece==null) {
    		return false;
    	}
    	if (Board.boardHistory.size() > 3) {
    		if(threefoldRepetition(Board.boardHistory)) {
        		System.out.println("THREEFOLD REPETITION!");
        	}
		}	
    	boolean legalMove = false;
    	boolean legalCastle = false;
    	String pieceType = selectedPiece.getType();
    	switch (pieceType) {
		case "king": 
			if (!selectedPiece.getHasMoved() && abs(displacement(initialPosition, newPosition).get(0)) > 1) {
				// user trying to castle, check if castling is allowed
				legalCastle = castlingAllowed(boardState, selectedPiece, displacement(initialPosition, newPosition), selectedPiece.getColour(), newPosition); 
			}
			legalMove = kingAllowedMove(displacement(initialPosition, newPosition)) && noCollision(boardState, selectedPiece, initialPosition, newPosition);
			break;
		case "queen": 
			legalMove = queenAllowedMove(displacement(initialPosition, newPosition)) && noCollision(boardState, selectedPiece, initialPosition, newPosition);
			break;
		case "rook": 
			legalMove = rookAllowedMove(displacement(initialPosition, newPosition)) && noCollision(boardState, selectedPiece, initialPosition, newPosition);
			break;
		case "bishop": 
			legalMove = bishopAllowedMove(displacement(initialPosition, newPosition)) && noCollision(boardState, selectedPiece, initialPosition, newPosition);
			break;
		case "knight": 
			legalMove = knightAllowedMove(displacement(initialPosition, newPosition)) && noCollision(boardState, selectedPiece, initialPosition, newPosition);
			break;
		case "pawn": 
			legalMove = pawnAllowedMove(displacement(initialPosition, newPosition), selectedPiece.getColour(), selectedPiece.getHasMoved(), newPosition, boardState) && noCollision(boardState, selectedPiece, initialPosition, newPosition);
			break;	
		}

    	
    	// If move is legal or if castling is allowed, return true
    	if (legalMove || legalCastle) {
    		System.out.println("RuleSet.isMovedAllowed: --------- Move Summary : " + selectedPiece.getType() + " moves from " + String.valueOf(initialPosition.get(0)) + "," + String.valueOf(initialPosition.get(1)) + " to " + String.valueOf(newPosition.get(0)) + "," + String.valueOf(newPosition.get(1)) + " --------");
    		return true;
    	} else {
    		return false;
    	}
	}
   
    
   /**
    * Returns true if a movement does not involve an illegal collision of pieces 
    * Else returns false
    *   
    * @param boardState this holds the state of the board - where all the pieces are
    * @param selectedPiece the exact chesspiece with traits including type and colour
    * @param initialPosition piece's starting board position
    * @param newPosition the board position the piece wants to move to
    * @return Boolean (true if a legal move)
    */
   public Boolean noCollision(ChessPiece[][] boardState, ChessPiece selectedPiece, List<Integer> initialPosition, List<Integer> newPosition){
	   
	   // Check if same colour piece on new position   
	   if(boardState[newPosition.get(1)][newPosition.get(0)] != null) {
		   if(selectedPiece.getColour()==boardState[newPosition.get(1)][newPosition.get(0)].getColour()) {
			   return false;
		   }
	   }
	   if(selectedPiece.getType() == "knight") {
		   	  return true;
	   }
	   
	   List<Integer> disp = displacement(initialPosition,newPosition);
	   
	   if(disp.get(1) == 0){ //horizontal
		   if(initialPosition.get(0) < newPosition.get(0)) {
			   for(int i = initialPosition.get(0) + 1; i< newPosition.get(0); i++){
				   if(boardState[initialPosition.get(1)][i] != null){
						   return false;
				   }
			   }
	   		}
		   if(initialPosition.get(0) > newPosition.get(0)) {
			   for(int i = initialPosition.get(0) - 1; i > newPosition.get(0); i--){
				   if(boardState[initialPosition.get(1)][i] != null){
						   return false;
				   }
			   }
		   }
	   }else if(disp.get(0) == 0){ //vertical
		   if(initialPosition.get(1) < newPosition.get(1))
			   for(int i = initialPosition.get(1) + 1; i< newPosition.get(1); i++){
				   if(boardState[i][initialPosition.get(0)] != null){
						   return false;
				   }
			   }
		   
		   if(initialPosition.get(1) > newPosition.get(1))
			   for(int i = initialPosition.get(1) - 1; i > newPosition.get(1); i--){
				   if(boardState[i][initialPosition.get(0)] != null){
						   return false;
				   }
			   }
		   
	   }else if(disp.get(0) > 0 && disp.get(1) > 0) { //diagonal
		   for(int i = initialPosition.get(1) + 1, j = initialPosition.get(0) + 1; i< initialPosition.get(1)+disp.get(1); i++, j++) {
			   if(boardState[i][j] != null){
					   return false;
			   }
				  
		   }
	   
	   }
	   else if (disp.get(0) < 0 && disp.get(1) > 0) { //diagonal
		   for(int i = initialPosition.get(1) + 1, j = initialPosition.get(0) - 1; i< initialPosition.get(1)+disp.get(1); i++, j--) {
			   if(boardState[i][j] != null){
					   return false;
			   }   
		   }
	   } else if (disp.get(0) < 0 && disp.get(1) < 0) { //diagonal
		   for(int i = initialPosition.get(1) - 1, j = initialPosition.get(0) - 1; i> initialPosition.get(1)+disp.get(1); i--, j--) {
			   if(boardState[i][j] != null){
					   return false;
			   }  
		   }
	   
	   } else if (disp.get(0) > 0 && disp.get(1) < 0) { //diagonal
		   for(int i = initialPosition.get(1) - 1, j = initialPosition.get(0) + 1; i> initialPosition.get(1)+disp.get(1); i--, j++) {
			   if(boardState[i][j] != null){
					   return false;
			   }
			   
		   }
	   
	   }
	   return true;   
   }
   
   /**
    * A method used to find the possition of a king given the colour and boardstate.
    * @param boardState the current state of the board as a 2d ChessPiece Array
    * @param colour the colour of interest
    * @return The ChessPiece Object that belongs to a king.
    */
   public List<Integer> findKing(ChessPiece[][] boardState, String colour) {
   	// Determine location of the king of the player who's making a move
   	// Looping through the 2D array boardstate to find the king
   	List<Integer> kingPos = new ArrayList<Integer>();
   	for (int i = 0; i < boardState.length; i++) {
   		for (int j = 0; j < boardState[i].length; j++) {
   			if (boardState[i][j] != null) {
   				if (boardState[i][j].getType().equals("king") && boardState[i][j].getColour().equals(colour)) {
       				// Save its location
   					kingPos.add(j);
       				kingPos.add(i);
   					return kingPos;
       			} 
   			}
   		}
   	}
   	return null;
   }
    /**
     * Checks if the king is currently in check.
     * @param boardState the current state of the board as ChessPiece array.
     * @param turnColour the colour of the current turn
     * @return true if king is check false if not.
     */
    public boolean isKingCheck(ChessPiece[][] boardState, String turnColour) {
    	List<Integer> kingPos = findKing(boardState, turnColour);
    	
    	// Cycle through the pieces on the board
    	for (int i = 0; i < boardState.length; i++) {	
    		for (int j = 0; j < boardState[i].length; j++) {
    			if (boardState[i][j] != null) {
    				// Piece found, save its colour and location
    				if(boardState[i][j].getColour() != turnColour){
    					ChessPiece selectedPiece = boardState[i][j];
    					List<Integer> piecePos = new ArrayList<Integer>();
    					piecePos.add(j);
    					piecePos.add(i);
    					// If an enemy piece can take the player's king, return true, king is in check
    					if (isMoveAllowed(boardState, selectedPiece, piecePos, kingPos)) {
    						System.out.println("RuleSet.isKingCheck: the " + selectedPiece.getColour() + " " +selectedPiece.getType() + " is putting the  " + turnColour + " king in check");
    						return true;
    					}
    				}
    				
    				
    				
    			}
    		}
    	}	
    	// If no enemy piece can take the king, king is safe, return false
    	return false;
	}
    
    /**
     * updates the boardstate and the state of a piece given the initial position and the new one
     * @param boardState the current state of the board as ChessPiece array.
     * @param loc1 old position 
     * @param loc2 new position 
     * @return new Board as ChessPiece array.
     */
	public ChessPiece[][] updateBoardState(ChessPiece[][] boardState, List<Integer> loc1, List<Integer> loc2) {
		ChessPiece mPiece = new ChessPiece(boardState[loc1.get(1)][loc1.get(0)]);
		mPiece.setHasMoved(true);
		boardState[loc1.get(1)][loc1.get(0)] = null;
		mPiece.setxLoc(loc2.get(0));
		mPiece.setyLoc(loc2.get(1));
		boardState[loc2.get(1)][loc2.get(0)] = mPiece;
		return boardState;
	}
	
	 /**
     * Take a chess piece (the king) and return false if it has somewhere it can legally move to, else true.
     * @param piece the piece of interest as ChessPiece.
     * @param boardState the current state of the board as ChessPiece array.
     * @param turnColour colour that can move this turn.
     * @return true if it can lift check false if not.
     */
	public boolean canCheckBeLifted(List<Integer> piecePos, ChessPiece[][] boardState, String turnColour){
		ChessPiece piece = boardState[piecePos.get(1)][piecePos.get(0)]; 
    	List<Integer> newPiecePos = new ArrayList<Integer>();
    	ChessPiece[][] tempBoard;

    	boolean[][] pieceMoves = possibleMoves(boardState, piece, piecePos); // create multi-dim array of 8*8 boolean possible moves for the king 
    	for (int i = 0; i < pieceMoves.length; i++) {
    		for (int j = 0; j < pieceMoves[i].length; j++) { // iterate through 8*8 tiles with boolean possible move of king
				if(pieceMoves[i][j]){ // if king can move into this tile r
					newPiecePos.clear();
					newPiecePos.add(i);
					newPiecePos.add(j);
					System.out.println("del me");
					tempBoard = null;
					tempBoard = copyBoard(boardState);
					tempBoard = updateBoardState(tempBoard, piecePos, newPiecePos);
					// if king not check
					if(!isKingCheck(tempBoard, turnColour)){
						System.out.println("King not in check");
						return false;
					}
					
				}
    		}
    	}
    	return true;
    }


	/**
	 * Method to check if any enemy piece can move to the specified tile
	 * @param boardState the current state of the board as ChessPiece array.
	 * @param turnColour colour that can move this turn.
	 * @param tilePosition the tile of interest 
	 * @return true if possible false if not .
	 */
    public boolean canAnyPieceMoveHere(ChessPiece[][] boardState, String turnColour, List<Integer> tilePosition){
    	for (int i = 0; i < boardState.length; i++) {
       		for (int j = 0; j < boardState[i].length; j++) {
       			if (boardState[i][j] != null && !boardState[i][j].getColour().equals(turnColour)) {
       				List<Integer> initialPosition = new ArrayList<>();
       	    		initialPosition.add(boardState[i][j].getxLoc());
       	    		initialPosition.add(boardState[i][j].getyLoc());
       				if (isMoveAllowed(boardState, boardState[i][j], initialPosition, tilePosition)) {
       	    			return true;
       	    		}	
       			}
       		}
       	}
    	return false;
    }
    
	/**
	 * Select the king of the person whose turn it is next,
	 * @param boardState
	 * @param turnColour
	 * @return
	 */
    public boolean checkForCheckMate(ChessPiece[][] boardState, String turnColour){
    	List<Integer> kingPos = findKing(boardState, turnColour);
    	Boolean mate = true;
    	if(!canCheckBeLifted(kingPos, boardState, turnColour)){
    		mate = false; // true if the king is in mate.
    	}
   		for (int y = 0; y < boardState.length; y++) {	
       		for (int x = 0; x < boardState[y].length; x++) {
       			if(boardState[y][x] != null){
       				if(boardState[y][x].getColour() == turnColour){
       					List<Integer> piecePos = new ArrayList<>();
           	    		piecePos.add(x);
           	    		piecePos.add(y);
       					if(!canCheckBeLifted(piecePos, boardState, turnColour)){
       						mate = false;
       					}
       				}
       			}
       		}
    	}
    	if(mate){
    		System.out.println("RuleSet.checkCheckMate: " + turnColour + "king in checkmate");
    	}else{
    		System.out.println("RuleSet.checkCheckMate: " + turnColour + "king in check, not mate");
    	}
    	return mate;
    } 
    
    public boolean[][] possibleMoves(ChessPiece[][] boardState,ChessPiece selectedPiece, List<Integer> selectLocation){
		//List<int[]>  posMoveList = new ArrayList<int[]>();
		boolean[][] posMoveArray = new boolean[8][8];
		for (int i = 0; i < posMoveArray.length; i++) {
			for (int j = 0; j < posMoveArray[i].length; j++) {
				List<Integer> newPosition = new ArrayList<Integer>();
				newPosition.add(i); //select row
				newPosition.add(j); //select col
				posMoveArray[i][j] = isMoveAllowed(boardState ,selectedPiece, selectLocation, newPosition);
			}
		}
    	return posMoveArray;
    	
    }
    
    /**
     * This function checks the last row of the board for wither black or white. if there is a pawn at the end of the board
     *  it will give a popup window that allows the user to select what he/she wants to promote the piece too. 
     * @param board the current board state
     * @param turnColour the colour whos turn it currently is (either black or white)
     */
    public void upForPromotion(ChessPiece[][] board,String turnColour){
    	//new frame to place a popup in
    	PieceImageGetter imageGetter = new PieceImageGetter();
    	JFrame parent = new JFrame();
    	//list of choices
    	Object[] possibilities = {"queen", "rook", "bishop","knight"};
    	 

       //if its white's turn
    	if(turnColour == "white"){
    		//for each column
    		for(int x = 0; x < 8;x++){
    			// if the tile on the top column isnt empty (no piece) continue
    			if(board[0][x] != null){
    				//if piece colour is white and type is pawn.
    				if(board[0][x].getColour() == "white" && board[0][x].getType() == "pawn"){
    					//show dialog
    					 String s = (String)JOptionPane.showInputDialog(
    	                     parent,
    	                     "What would you like to promote"
    	                     + "the pawn to?",
    	                     "Customized Dialog",
    	                     JOptionPane.PLAIN_MESSAGE,
    	                     null, possibilities,
    	                     "queen");
    					 //changes the type of the piece
    					 board[0][x].setType(s);
    					 board[0][x].setPiecePicture(imageGetter.getPieceImage(s, "white"));
    				}
    			}
    			

    		}
    	//same for black just checks the bottom tiles instead of top tiles.
    	}else if(turnColour == "black"){
    		for(int x = 0; x < 8;x++){
    			if(board[7][x] != null){
    				if(board[7][x].getColour() == "black" && board[7][x].getType() == "pawn"){
       					 String s = (String)JOptionPane.showInputDialog(
       	                     parent,
       	                     "What would you like to promote"
       	                     + "the pawn to?",
       	                     "Customized Dialog",
       	                     JOptionPane.PLAIN_MESSAGE,
       	                     null, possibilities,
       	                     "queen");
       					 board[7][x].setType(s);
    					 board[7][x].setPiecePicture(imageGetter.getPieceImage(s, "black"));
       				}
    			}
    		}
    	}
    }
    public ChessPiece[][] copyBoard(ChessPiece[][] originalBoard) {
        if (originalBoard == null) {
            return null;
        }

        ChessPiece[][] tempBoard = new ChessPiece[8][8];
        for (int i = 0; i < 8; i++) {
        	for(int j = 0; j < 8; j++){
        		if(originalBoard[i][j] != null){
        			tempBoard[i][j] = new ChessPiece(originalBoard[i][j]);
        		}
        	}
        }
        return tempBoard;
    }




// --------------------------------------------------------------------------------------------------------------------
    // Not useful yet. Only prints all combinations of an int array, returns some default
    // value (needs to be fixed if this is used somehow).
    // Maybe useful sometime but probably not...
    public int[][] permuteLists(int[] intList){
        int[][] permutationList={{1,1}, {2,2}}; // Update if we want something dynamic.
        int combinations = 0;
        for (int i = 0; i < intList.length; i++) {
            for (int j = 0; j < intList.length; j++) {
                combinations++;
                int[] tempList = {intList[i],intList[j]};
                System.out.println(Arrays.toString(tempList));
            }
        }
        return permutationList;
    }

    // Simple method that creates int[] Array. I think it works..
    // Maybe useful later on.
    @SuppressWarnings("unused")
	private static int[] Range(int low, int high) {
        int[] rangeList = new int[high+1-low];
        int counter = 0;
        for (int i = low; i < high+1; i++) {
            rangeList[counter] = i;
            counter++;
        }
        return rangeList;
    }

    public boolean moveSolvesCheck(ChessPiece[][] currentBoardState,List<Integer>oldPosition ,List<Integer> newPosition,boolean whiteTurn){
        /**
         * method to see whether the move solves check, which returns true if the move doesnt result in a position with the player in check.
         * @param currentBoardState, a boardstate 2d Array to be copied
         * @param oldPosition
         * @param newPosition*/
    	boolean legalMove = false;
    	//making a temporary boardstate. to see whether the move is legal
    	ChessPiece[][] tempBoard =  Board.boardStateCopy(currentBoardState);
    	tempBoard[newPosition.get(1)][newPosition.get(0)] = tempBoard[oldPosition.get(1)][oldPosition.get(0)];
    	tempBoard[newPosition.get(1)][newPosition.get(0)].setxLoc(newPosition.get(0));
    	tempBoard[newPosition.get(1)][newPosition.get(0)].setyLoc(newPosition.get(1));
    	tempBoard[oldPosition.get(1)][oldPosition.get(0)] = null;
    	
    	String turnString = turnBooleanToString(whiteTurn); 
    	if(isKingCheck(tempBoard,turnString)){
    		legalMove = false;	
    	} else {
    		legalMove = true;
    	}
    	return legalMove;
    }
    
    public String turnBooleanToString(boolean whiteTurn) {
    	/**
         * Turn boolean whiteTurn into a String 'black' or 'white' as this format needed for most methods
         * @param whiteTurn, a boolean - true if white's turn else false*/
    	//if the move results in a state of (continued) check, the move is illegal
    	String turnString = "string";
    	if(whiteTurn){
    		turnString = "white";
    	}else{
    		turnString = "black";
    	}
    	return turnString;
    }
} // End of class.



