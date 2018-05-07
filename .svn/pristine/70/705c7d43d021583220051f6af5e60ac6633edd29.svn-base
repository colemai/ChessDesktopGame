package ChessPieces;
import java.util.ArrayList;
/**
 * All chess pieces are created here, this class also allows to change the graphical representation of the
 * chess pieces.
 */
public class CreateChessPieces {
	/* ArrayList<ChessPiece> = pieceType, pieceColour, yloc, xloc, moveSet, pieceImage
	 * @param piecesLists; contains all pieces (black and white) for the classic or the modern button
	 * @param int setTyp; 0 = classic, 1 = modern
	 */
	private ArrayList<ChessPiece> blackPieces = new ArrayList<ChessPiece>();
	private ArrayList<ChessPiece> whitePieces = new ArrayList<ChessPiece>();
	public static int setType = 0;
	@SuppressWarnings("rawtypes")
	public static ArrayList<ArrayList> piecesLists = new ArrayList<ArrayList>(); // all the different kind of pieces
	
	/**
	 * creates a set of black pieces with a given image.
	 * @return an arraylist of ChessPieces
	 */
	public ArrayList<ChessPiece> CreateBlackSet(){
		blackPieces.add(new ChessPiece("rook","black", 0, 0, "moves",(String) piecesLists.get(setType).get(0)));
		blackPieces.add(new ChessPiece("rook","black", 7, 0, "moves", (String) piecesLists.get(setType).get(0)));
		blackPieces.add(new ChessPiece("knight","black", 1, 0, "moves", (String) piecesLists.get(setType).get(1)));
		blackPieces.add(new ChessPiece("knight","black", 6, 0, "moves", (String) piecesLists.get(setType).get(1)));
		blackPieces.add(new ChessPiece("bishop","black", 2, 0, "moves", (String) piecesLists.get(setType).get(2)));
		blackPieces.add(new ChessPiece("bishop","black", 5, 0, "moves", (String) piecesLists.get(setType).get(2)));
		blackPieces.add(new ChessPiece("queen","black", 3, 0, "moves", (String) piecesLists.get(setType).get(3)));	
		blackPieces.add(new ChessPiece("king","black", 4, 0, "moves", (String) piecesLists.get(setType).get(4)));
		blackPieces.add(new ChessPiece("pawn","black", 0, 1, "moves", (String) piecesLists.get(setType).get(5)));
		blackPieces.add(new ChessPiece("pawn","black", 1, 1, "moves",(String) piecesLists.get(setType).get(5)));
		blackPieces.add(new ChessPiece("pawn","black", 2, 1, "moves", (String) piecesLists.get(setType).get(5)));
		blackPieces.add(new ChessPiece("pawn","black", 3, 1, "moves", (String) piecesLists.get(setType).get(5)));
		blackPieces.add(new ChessPiece("pawn","black", 4, 1, "moves", (String) piecesLists.get(setType).get(5)));
		blackPieces.add(new ChessPiece("pawn","black", 5, 1, "moves", (String) piecesLists.get(setType).get(5)));
		blackPieces.add(new ChessPiece("pawn","black", 6, 1, "moves", (String) piecesLists.get(setType).get(5)));
		blackPieces.add(new ChessPiece("pawn","black", 7, 1, "moves", (String) piecesLists.get(setType).get(5)));
		return blackPieces;
		
	}
	/**
	 * creates a set of white pieces with a given image.
	 * @return an arraylist of ChessPieces
	 */
	public ArrayList<ChessPiece> CreateWhiteSet(){
		whitePieces.add(new ChessPiece("rook","white", 0, 7, "moves", (String) piecesLists.get(setType).get(6)));
		whitePieces.add(new ChessPiece("rook","white", 7, 7, "moves", (String) piecesLists.get(setType).get(6)));
		whitePieces.add(new ChessPiece("knight","white", 1, 7, "moves", (String) piecesLists.get(setType).get(7)));
		whitePieces.add(new ChessPiece("knight","white", 6, 7, "moves", (String) piecesLists.get(setType).get(7)));
		whitePieces.add(new ChessPiece("bishop","white", 2, 7, "moves", (String) piecesLists.get(setType).get(8)));
		whitePieces.add(new ChessPiece("bishop","white", 5, 7, "moves", (String) piecesLists.get(setType).get(8)));
		whitePieces.add(new ChessPiece("queen","white", 3, 7, "moves", (String) piecesLists.get(setType).get(9)));
		whitePieces.add(new ChessPiece("king","white", 4, 7, "moves", (String) piecesLists.get(setType).get(10)));
		whitePieces.add(new ChessPiece("pawn","white", 0, 6, "moves", (String) piecesLists.get(setType).get(11)));
		whitePieces.add(new ChessPiece("pawn","white", 1, 6, "moves", (String) piecesLists.get(setType).get(11)));
		whitePieces.add(new ChessPiece("pawn","white", 2, 6, "moves", (String) piecesLists.get(setType).get(11)));
		whitePieces.add(new ChessPiece("pawn","white", 3, 6, "moves", (String) piecesLists.get(setType).get(11)));
		whitePieces.add(new ChessPiece("pawn","white", 4, 6, "moves", (String) piecesLists.get(setType).get(11)));
		whitePieces.add(new ChessPiece("pawn","white", 5, 6, "moves", (String) piecesLists.get(setType).get(11)));
		whitePieces.add(new ChessPiece("pawn","white", 6, 6, "moves", (String) piecesLists.get(setType).get(11)));
		whitePieces.add(new ChessPiece("pawn","white", 7, 6, "moves", (String) piecesLists.get(setType).get(11)));
		return whitePieces;
		
	}
	/**
	 * initialized the images to be used for the pieces.
	 */
	public static void initializeSets(){
		
		ArrayList<String> set = new ArrayList<String>();
		// Classic chess pieces
		set.add("data/images/cheapSet/cheapBlackRook80.80.png");
		set.add("data/images/cheapSet/cheapBlackKnight80.80.png");
		set.add("data/images/cheapSet/cheapBlackBishop80.80.png");
		set.add("data/images/cheapSet/cheapBlackQueen80.80.png");
		set.add("data/images/cheapSet/cheapBlackKing80.80.png");
		set.add("data/images/cheapSet/cheapBlackPawn80.80.png");
		
		set.add("data/images/cheapSet/cheapWhiteRook80.80.png");
		set.add("data/images/cheapSet/cheapWhiteKnight80.80.png");
		set.add("data/images/cheapSet/cheapWhiteBishop80.80.png");
		set.add("data/images/cheapSet/cheapWhiteQueen80.80.png");
		set.add("data/images/cheapSet/cheapWhiteKing80.80.png");
		set.add("data/images/cheapSet/cheapWhitePawn80.80.png");

		piecesLists.add(set);
		
		// The piecesLists will be overwritten when the option "modern" has been chosen.
		set = new ArrayList<String>();
		// Modern chess pieces
		set.add("data/images/shinySet/shinyBlackRook.png");
		set.add("data/images/shinySet/shinyBlackKnight.png");
		set.add("data/images/shinySet/shinyBlackBishop.png");
		set.add("data/images/shinySet/shinyBlackQueen.png");
		set.add("data/images/shinySet/shinyBlackKing.png");
		set.add("data/images/shinySet/shinyBlackPawn.png");
		
		set.add("data/images/shinySet/shinyWhiteRook.png");
		set.add("data/images/shinySet/shinyWhiteKnight.png");
		set.add("data/images/shinySet/shinyWhiteBishop.png");
		set.add("data/images/shinySet/shinyWhiteQueen.png");
		set.add("data/images/shinySet/shinyWhiteKing.png");
		set.add("data/images/shinySet/shinyWhitePawn.png");
		
		piecesLists.add(set);


	}
	/**
	 * changes the images used for pieces.
	 * @param typeNr
	 */
	public static void changeSets(int typeNr){
		/*
		 * 0=classic
		 * 1=modern
		 * 2=etc*/
		
		setType=typeNr;
	}
	
	/**
	 * sets the new type for pieces.
	 * @return the setType
	 */
	public static int getSetType(){
		return setType;
	}
	
	/**
	 * returns the Piece list
	 * @return the piece list as a array.
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<ArrayList> getPiecesList(){
		return piecesLists;
	}
}
