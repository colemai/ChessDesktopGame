package ChessGame;

import ChessPieces.CreateChessPieces;

/**
 * This class is used to get an chess piece image based on the pieceType and given colour 
 * the user chose during the promotion of a piece.
 */
public class PieceImageGetter {
	/**
	 * Returns the piece based on the pieceType and colour
	 * @param pieceType string containing all piece types (pawn, rook, etc.)
	 * @param colour string containing the colour (black, white)
	 * @return a string containing the path to the image for the requested piece. piecesLists; 
	 * contains all pieces (pawn, rook, etc.) for the classic or the modern sets. int setTyp; 
	 * 0 = classic, 1 = modern
	 */
	public String getPieceImage(String pieceType,String colour){
		//combine type and colour.
		String wantedPiece = pieceType+colour;
		switch (wantedPiece) {
		case "queenwhite":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(9);
		case "rookwhite":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(6);
		case "bishopwhite":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(8);
		case "knightwhite":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(9);
		case "pawnwhite":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(9);
		case "kingwhite":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(7);
		case "queenblack":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(3);
		case "rookblack":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(0);
		case "bishopblack":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(2);
		case "knightblack":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(1);
		case "pawnblack":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(9);
		case "kingblack":
			return (String) CreateChessPieces.piecesLists.get(CreateChessPieces.setType).get(4);
		default:
			return wantedPiece + " not found!";
		}
	}
}
