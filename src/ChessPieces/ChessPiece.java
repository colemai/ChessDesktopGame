package ChessPieces;
/**
 *This class creates chesspiece object. 
 *The class extends the piece class.
 *The ChessPiece object has a type, colour, moveset,piecePicture,hasMoved
 *and inherits the x and y locations from Piece
 */
public class ChessPiece extends Piece {
	//the type of the piece (king,queen, etc)
	private String type;
	//the colour of the piece (black,white)
	private String colour;
	//info to calculate the legal moves it can do.
	private String moveSet;
	// image the piece can use for itself
	private String piecePicture;
	//indicates if the piece has moved in this game
	private Boolean hasMoved = false;	
	
	/**
	 * Constructor for Piece requires 6 variables. 
	 * @param type  the type of the piece as string
	 * @param colour the colour of the piece as string
	 * @param xLoc the yLocation of the piece as int
	 * @param yLoc the xLocation of the piece as int
	 * @param moveSet the data to calculate the legal moves
	 * @param piecePicture the picture used for the piece on the board
	 */
	public ChessPiece(String type, String colour, int xLoc, int yLoc, String moveSet, String piecePicture) {
		super(xLoc, yLoc);
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		setColour(colour);
		setMoveSet(moveSet);
		setType(type);
		setPiecePicture(piecePicture);
	}
	/**
	 * Constructor for Piece requires 7 variables. this time with hasMoved 
	 * @param type  the type of the piece as string
	 * @param colour the colour of the piece as string
	 * @param xLoc the yLocation of the piece as int
	 * @param yLoc the xLocation of the piece as int
	 * @param moveSet the data to calculate the legal moves
	 * @param piecePicture the picture used for the piece on the board
	 * @param hasMoved boolean telling if the piece has moved or not
	 */
	public ChessPiece(String type, String colour, int xLoc, int yLoc, String moveSet, String piecePicture,Boolean hasMoved) {
		super(xLoc, yLoc);
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		setColour(colour);
		setMoveSet(moveSet);
		setType(type);
		setPiecePicture(piecePicture);
		setHasMoved(hasMoved);
	}
	/**
	 * a Copy Constructor for Piece requiring a exisiting piece. 
	 * @param aChessPiece a existing ChessPiece Object
	 */
	public ChessPiece(ChessPiece aChessPiece) {
	    this(aChessPiece.getType(), aChessPiece.getColour(), aChessPiece.getxLoc(), aChessPiece.getyLoc(), aChessPiece.getMoveSet(), aChessPiece.getPiecePicture(), aChessPiece.getHasMoved());
	    //no defensive copies are created here, since 
	    //there are no mutable object fields (String is immutable)
	}
	
	//returns the colour
	public String getColour() {
		return colour;
	}

	//allows to set or change the colour
	public void setColour(String colour) {
		this.colour = colour;
	}

	//returns the moveSet
	public String getMoveSet() {
		return moveSet;
	}

	//sets the moveset or change it
	public void setMoveSet(String moveSet) {
		this.moveSet = moveSet;
	}

	//gets the picture
	public String getPiecePicture() {
		return piecePicture;
	}

	//allows changing or setting of pieces
	public void setPiecePicture(String piecePicture) {
		this.piecePicture = piecePicture;
	}
	
	//gets the type of the piece
	public String getType() {
		return type;
	}

	//sets or changes the type of a piece
	public void setType(String type) {
		this.type = type;
	}
	
	//gets the true or false if the piece has moved or not
	public Boolean getHasMoved() {
		return hasMoved;
	}
	
	//allows setting or changing of the hasmoved value.
	public void setHasMoved(Boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
