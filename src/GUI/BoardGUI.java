package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ChessGame.AudioHandler;
import ChessGame.ChessClock;
import ChessGame.GameEnder;
import ChessGame.MainApplication;
import ChessPieces.ChessPiece;
import ChessBoard.Board;

public class BoardGUI extends JFrame {

	//initialize all variables that need to be universal for this class
	private static final long serialVersionUID = 1L;
	private PicturePanel contentPane;
	private Boolean click1 = false;
	private Boolean click2 = false;
	public List<Integer> click1Loc = new ArrayList<Integer>();
	public List<Integer> click2Loc = new ArrayList<Integer>();
	public ChessPiece click1Piece = new ChessPiece("", "", 0, 0, "", "");
	public ChessPiece click2Piece = new ChessPiece("", "", 0, 0, "", "");
	public Board gameBoard = new Board();
	public JPanel chessBoard;
	public JButton[][] tileArray;
	public JTextArea historyLog = new JTextArea();
	private static JLabel lblP1timer;
	private static JLabel lblP2timer;
	private Image img;
	private Toolkit kit = Toolkit.getDefaultToolkit();
	String[] userNames = userNameReader();
	JLabel lblPlayer;
	JLabel lblPlayer_1;
	
	
	/**
	 * Launch the application. sets resizing to false
	 */
	public static BoardGUI main() {
		BoardGUI frame = new BoardGUI();
		frame.setVisible(true);
		frame.setResizable(false);
		return frame;
	}
	
	/**
	 * Parameterless constructor of the BoardGUI
	 */
	public BoardGUI() {
		initializeBoardGUI();
		lblP1timer.setVisible(false);
		lblP2timer.setVisible(false);
		
	}
	/**
	 * Constructor of the BoardGUI with a Clock
	 * @param ChessClock the chessClock object showing the remaining time per player
	 */
	public BoardGUI(ChessClock chessClock){
		gameBoard = new Board(chessClock);
		initializeBoardGUI();
		
	}
	/**
	 * Creates the board. giving it a ImageIcon a title and a background. then adding the chessBoard and buttons.
	 */
	private void initializeBoardGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("data/Images/cheapSet/cheapBlackPawn80.80.png"));
		setTitle("Chess - Game Board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 740);
		img = kit.getImage("data/Images/GUIBG/BoardGUI_BG3.jpg");
        img = img.getScaledInstance(900, -1, Image.SCALE_SMOOTH);
		contentPane = new PicturePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{129, 58, 78, 104, 79, 87, 77, 0};
		gbl_contentPane.rowHeights = new int[]{60, 0, 0, 14, 0, 460, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		lblPlayer = new JLabel(userNames[0]);
		lblPlayer.setText("<html><p style='color:red; font-size:15px'>"+userNames[0]+"</p></html>");
		GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
		gbc_lblPlayer.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPlayer.insets = new Insets(5, 5, 5, 5);
		gbc_lblPlayer.gridx = 5;
		gbc_lblPlayer.gridy = 0;
		contentPane.add(lblPlayer, gbc_lblPlayer);
		
		
		lblPlayer_1 = new JLabel(userNames[1]);
		lblPlayer_1.setText("<html><p style='color:black; font-size:15px'>"+userNames[1]+"</p></html>");
		GridBagConstraints gbc_lblPlayer_1 = new GridBagConstraints();
		gbc_lblPlayer_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPlayer_1.insets = new Insets(5, 5, 5, 0);
		gbc_lblPlayer_1.gridx = 6;
		gbc_lblPlayer_1.gridy = 0;
		contentPane.add(lblPlayer_1, gbc_lblPlayer_1);
        
        //making it part of the contentPane
        chessBoard = new JPanel();
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        GridBagConstraints gbc_chessBoard = new GridBagConstraints();
        gbc_chessBoard.gridwidth = 5;
        gbc_chessBoard.gridheight = 7;
        gbc_chessBoard.fill = GridBagConstraints.VERTICAL;
        gbc_chessBoard.insets = new Insets(5, 5, 0, 5);
        gbc_chessBoard.gridx = 0;
        gbc_chessBoard.gridy = 0;
        contentPane.add(chessBoard, gbc_chessBoard); // Add chessboard to the content panel.
        //sets the values for the chess board.
        chessBoard.setLayout(new GridLayout(8,8));
		
		lblP1timer = new JLabel("p1Timer");
		GridBagConstraints gbc_lblP1timer = new GridBagConstraints();
		gbc_lblP1timer.insets = new Insets(0, 0, 5, 5);
		gbc_lblP1timer.gridx = 5;
		gbc_lblP1timer.gridy = 1;
		contentPane.add(lblP1timer, gbc_lblP1timer);
		
		lblP2timer = new JLabel("p2Timer");
		GridBagConstraints gbc_lblP2timer = new GridBagConstraints();
		gbc_lblP2timer.insets = new Insets(0, 0, 5, 0);
		gbc_lblP2timer.gridx = 6;
		gbc_lblP2timer.gridy = 1;
		contentPane.add(lblP2timer, gbc_lblP2timer);
		
		
		// Undo move option with confirmation window
		JButton btnUndoMove = new JButton("Undo move");
		btnUndoMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleUndo();
			}		
		});
		
		// Place the undo button
		GridBagConstraints gbc_btnUndoMove = new GridBagConstraints();
		gbc_btnUndoMove.gridwidth = 2;
		gbc_btnUndoMove.insets = new Insets(0, 0, 5, 0);
		gbc_btnUndoMove.gridx = 5;
		gbc_btnUndoMove.gridy = 4;
		contentPane.add(btnUndoMove, gbc_btnUndoMove);
		
		// Creating GUI element for in-game log with history of moves
		JScrollPane scrollPane = new JScrollPane();
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(5, 5, 5, 0);
		gbc_scrollPane.gridx = 5;
		gbc_scrollPane.gridy = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		scrollPane.setViewportView(historyLog);
		historyLog.setEditable(false);
		
		//adding of the save Button
		JButton savebtn = new JButton("Draw");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleDraw();
			}
		});
		GridBagConstraints gbc_savebtn = new GridBagConstraints();
		gbc_savebtn.anchor = GridBagConstraints.NORTH;
		gbc_savebtn.insets = new Insets(5, 5, 0, 5);
		gbc_savebtn.gridx = 5;
		gbc_savebtn.gridy = 6;
		contentPane.add(savebtn, gbc_savebtn);
		
		
		// Forfeit button
		JButton resign = new JButton("Forfeit");
		resign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Popup window with that asks if you want a rematch
				forfeitHandler();
			}	
		});
		
		
		GridBagConstraints gbc_resign = new GridBagConstraints();
		gbc_resign.anchor = GridBagConstraints.NORTH;
		gbc_resign.insets = new Insets(5, 5, 0, 0);
		gbc_resign.gridx = 6;
		gbc_resign.gridy = 6;
		contentPane.add(resign, gbc_resign);
        
		/*
		create the chess board squares
   		for loop through 0-7 for the x and a loop through 0-7 for the y
		*/
        Insets buttonMargin = new Insets(0, 0, 0, 0); // Added 0,0,0,0 inset to make the 2D array square.
        tileArray = new JButton[8][8];  // Create new 2D JButton array; 8 arrays with 8 indexes each, so 64 squares.
        //tile colours.
        Color darkTile = new Color(95, 95, 95);
        Color lightTile = new Color(255, 255, 233);
		for (int yy = 0; yy <tileArray.length; yy++){ // Array rows, so 'Y'.
			for(int xx = 0; xx <tileArray[yy].length; xx++) { // Array columns, so 'X'.
				JButton tile =  new JButton(); // New JButton for array coordinates xx,yy.
				tile.setMargin(buttonMargin); // This margin is needed else the tiles won't render in a square.
				
				String tileName = ""+xx+yy; // Define tile name as it's x,y coordinates.
				tile.setName(tileName);
				
				ImageIcon tileImage = new ImageIcon(new BufferedImage(90, 90, BufferedImage.TYPE_INT_ARGB)); // Template for tile image.
				tile.setIcon(tileImage); // Add image to tile.
				
				// We need these 2 to make the board work on MacOS.
				tile.setOpaque(true);
				tile.setBorderPainted(false);
				
				if ((xx % 2 == 1 && yy % 2 == 1) || (xx % 2 == 0 && yy % 2 == 0)) {
					// For even row nr (yy), make every even column nr (xx) white, rest black.
					// For uneven row, use the opposite logic.
                    tile.setBackground(lightTile);
                } else {
                    tile.setBackground(darkTile);
                }
				tile.addActionListener(new ActionListener()
				{
				  public void actionPerformed(ActionEvent e){
					  // Forward tileName to next method/class
					  handleMoveAttempt(tileName, tileArray);
				  }
				});
				tileArray[xx][yy] = tile; //add the newly created button to the button array.
			}
		}
		// Here we add the tile objects to the chessboard (so we now have a 2d array in the GUI with clickable tiles).
		for (int i = 0; i < 8; i++) {			
			for (int j = 0; j < 8; j++) {
				chessBoard.add(tileArray[j][i]);
			}
		}
		
		// Iterate through all the chess pieces in the board state and apply their image to the given tile
		// This should be triggered/refreshed upon completed move
		//gameBoard.setInitialState();
		setBoardState(tileArray);
		
	
	
	
	}
	

	protected void handleDraw() {
		// TODO Auto-generated method stub
		GameEnder gameEnder = new GameEnder();
		gameEnder.drawGame();
	}

	/**
	 * reads the usernames from a saved file and returns them as a list with index 0 being white and 1 being black
	 * @return String[] */
	private String[] userNameReader(){
		String[] userNames = new String[2]; // {null, null}
		Scanner scanner;
		try {
			// Go through every line in the username file.
			scanner = new Scanner(new File("resources/UsernameTest.txt").getAbsoluteFile());
			//scanner.useDelimiter("\n");
			int count = 0;
			// If only 1 name is entered, userName will have only 1 name
			while (scanner.hasNext()) {
			    String line = scanner.next();
			    userNames[count] = line;
			    count++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// Add default usernames
			userNames[0] = "player1";
			userNames[1] = "player2";
		}
		// Catch empty usernames
		if (userNames[0] == null){
			userNames[0] = "player1";
		}
		if (userNames[1] == null){
			userNames[1] = "player2";
		}
		return userNames;
	}
	
	/**
	 *handles the clicks on the board, after 2 clicks it passes the location on to the gameboard to see whether the turn is legal.
	 *it also updates various fields on the board to reflect the current player at play, and the move log
	 *@param tileName the location on the board as a string, ie 46 for xloc 4 and yloc 6 
	 *@param tileArray the Jbutton 2d array that houses the buttons*/
	protected void handleMoveAttempt(String tileName, JButton[][] tileArray) {
		System.out.println(tileName);
		
		//on the first click it checks whether a piece of the correct color was collected
		if (!click1) {
			click1Loc = gameBoard.getBoardPositionClicked(tileName);
			click1Piece = gameBoard.searchPieceSet(click1Loc, gameBoard.getTurn());
				if (click1Piece != null) {
					// Found a piece that is owned by the player whose turn it is
					click1 = true;
				} 
		} else if (click1 && !click2) {
			//if this is the second click get the piece
			click2Loc = gameBoard.getBoardPositionClicked(tileName);
			System.out.println(String.valueOf(click1Loc) + String.valueOf(click2Loc));
			click2Piece = gameBoard.searchPieceSet(click2Loc, gameBoard.getTurn());
			System.out.println(click2Piece);
			
			//Send the move to be saved in the move history
			MainApplication.svg.AddMoveToHistory(click1Loc.toString());
			MainApplication.svg.AddMoveToHistory(click2Loc.toString());

			//reset clickChecks
			click1 = false;
			click2 = false;
			// check if move is legal
			// if yes, move the piece to the new location
			String moveString = gameBoard.runTurn(click1Loc,click2Loc);
			
			// adds move to history if it is made.
			if(moveString != ""){
				historyLog.append(moveString);
			}
			
			//and update the board
			setBoardState(tileArray);

			//update the player name colors to emphasize turns
			updatePlayerNameColour(gameBoard.getTurn());
			
		}
		
	}
	
	/**
	 * Handles the btnUndoMove process. Will revert to a previous boardstate and gives turn to previous pkayer.
	 */
	private void handleUndo() {
		if (JOptionPane.showConfirmDialog(null, "Do you want to undo the previous move?", "Undo move",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { // If clicked YES
			ChessPiece[][] previousBoardState; // Previous boardstate to change to
			if (Board.boardHistory.size() > 0 && 1 <= Board.boardHistory.size()) {	// Catch indexoutofbound
				try {
					Board.turnCount--; // Turns -1
					gameBoard.whiteTurn = !gameBoard.whiteTurn; // Previous players' turn
					previousBoardState = (ChessPiece[][]) Board.boardHistory.get((Board.boardHistory.size())-1); // Get last board state
					gameBoard.setBoardState(previousBoardState); // Change current boardstate to previous one
					// Here we reset the pawn's hasMoved booleans to re-allow the 2-set move
					for (int i = 0; i < gameBoard.boardState.length; i++) {
						if (i==1 || i==6) { // Only the pawn rows
							for (int j = 0; j < gameBoard.boardState[i].length; j++) {
								if (gameBoard.boardState[i][j] != null) { // Nullcheck to avoid nullpointerexception
									if(gameBoard.boardState[i][j].getType().equals("pawn")) {
										gameBoard.boardState[i][j].setHasMoved(false); // Reset the hasMoved
									}
								}
							}
						}		
					}
					setBoardState(tileArray); // Assign new tilearray to the board, to update the GUI
					Board.boardHistory.remove((Board.boardHistory.size())-1); // Remove last boardState
					
					
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
        } 
	}
	/**
	 * updates the representation of the boardGUI tileArray to represent the underlying gameboard boardstate
	 * @param tileArray the 2d JButton array where the piece icons should be shown*/
	public void setBoardState(JButton[][] tileArray){
	ChessPiece[][] initialState = gameBoard.getBoardState();
	
	// When it is white player's turn, or it's blacks turn and the rotation setting is off
	if (gameBoard.getTurn()|| !gameBoard.getTurn() && !Board.setRotation) {
		for (int i = 0; i<initialState.length; i++) {
			for (int j = 0; j<initialState[i].length; j++) {
				ChessPiece piece = initialState[i][j];
				int xloc = j;
				int yloc = i;
				if (piece != null) { 
					
					try {	
						BufferedImage myPicture = ImageIO.read(new File(piece.getPiecePicture()));
						tileArray[xloc][yloc].setIcon(new ImageIcon(myPicture));
					} 
					catch(Exception e) {
						System.out.println(e);
					}
				} else {
					tileArray[xloc][yloc].setIcon(null);
				}
			}
		}
	} else { //if it's blacks turn and the rotation is on
		for (int i = 0; i<initialState.length; i++) {
			for (int j = 0; j<initialState[i].length; j++) {
				ChessPiece piece = initialState[i][j];
				int xloc = 7 - j; // the 7 is used to inver the icon location
				int yloc = 7 - i; // idem
				if (piece != null) { 
					
					try {	
						BufferedImage myPicture = ImageIO.read(new File(piece.getPiecePicture()));
						tileArray[xloc][yloc].setIcon(new ImageIcon(myPicture));
					} 
					catch(Exception e) {
						System.out.println(e);
					}
				} else {
					tileArray[xloc][yloc].setIcon(null);
				}
			}
		}

	}
	}
	
	/**
	 * when the forfeit button is clicked, a popup dialogue appears prompting to save, and then ask for a rematch*/
	private void forfeitHandler() {
		//Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
		
		if (JOptionPane.showConfirmDialog(null, "Do you want to save this game?", "SAVE",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
		{
            // yes option
			MainApplication.svg.setNumberOfTurns(Board.turnCount);
			MainApplication.svg.setPointDiff(Board.getPointDifference());
			if (gameBoard.getTurn()) {
				MainApplication.svg.setVictor("black");
			} else {
				MainApplication.svg.setVictor("white");
			}
			
			//Play button press sound 2
	        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
			try {
				MainApplication.svg.saveGame(MainApplication.manager);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			//MainApplication.changeGUI("GameSettingsGUI");
        } else {
            // no option
        	//MainApplication.changeGUI("MainGUI");
        	
        	//Play button press sound 2
            AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
        }
		if (JOptionPane.showConfirmDialog(null, "Do you want a rematch?", "Rematch",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // yes option
			this.setVisible(false);
			MainApplication.changeGUI("UsernameGUI");
			
			//Play button press sound 2
	        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
        } else {
            // no option
        	this.setVisible(false);
        	MainApplication.changeGUI("MainGUI");
        
        	//Play button press sound 2
            AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
        }
	}
	/**
	 * Sets the text of the player 1 clock
	 * @param timeString the time you want to display, as a string
	 * */
	public static void p1ClockSetter(String timeString) {
		lblP1timer.setText(timeString);
	}
	/**
	 * Sets the text of the player 2 clock
	 * @param timeString the time you want to display, as a string
	 * */
	public static void p2ClockSetter(String timeString) {
		lblP2timer.setText(timeString);
	}
	/**
	 * Fun little overwrite to make it possible to set a background for a JPanel
	 * overwrites the paint method to make it accept images.
	 */
	@SuppressWarnings("serial")
	private class PicturePanel extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(img,0,0,this);
            setOpaque(false);
			super.paint( g ) ;
			setOpaque(true);
        }
    }
	
	/**
	 * turns the name of the player at play red, so it matches with that players clock
	 * @param whiteTurn a boolean; true for white at play, false for black*/
	private void updatePlayerNameColour(boolean whiteTurn) {
		if(whiteTurn) { // on white's turn
			//sets white player name label to red and black to black
			lblPlayer.setText("<html><p style='color:red; font-size:15px'>"+userNames[0]+"</p></html>");
			lblPlayer_1.setText("<html><p style='color:black; font-size:15px'>"+userNames[1]+"</p></html>");
		} else { // on blacks turn
			//sets black player name label to red and white to black
			lblPlayer.setText("<html><p style='color:black; font-size:15px'>"+userNames[0]+"</p></html>");
			lblPlayer_1.setText("<html><p style='color:red; font-size:15px'>"+userNames[1]+"</p></html>");
		}
	}
	
}
