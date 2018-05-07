package ChessGame;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import ChessBoard.Board;


/**
 * the GameEnder class ends and saves the game. It also gives the player the option of a rematch*/
public class GameEnder {
		private String winnerString;
		
		/**
		 * the endGame method takes a string and then proclaims that player the winner via a popup window
		 * @param winColour a String, white or black referring to the player that has won*/
	public void endGame(String winColour){
		winnerString = winColour + " wins the game!";
		
		MainApplication.svg.setNumberOfTurns(Board.turnCount);
		MainApplication.svg.setPointDiff(Board.getPointDifference());
		MainApplication.svg.setVictor(winColour);
					
		//Play button press sound 2
	    AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	    try {
	    	MainApplication.svg.saveGame(MainApplication.manager);
		} catch (ClassNotFoundException | SQLException e) {
			MainApplication.changeGUI("MainGUI");
			e.printStackTrace();
		}
	    handleEndGame(winnerString);
	}
	
	/**
	 * this method draws and saves the game, also asks for rematch*/
	public void drawGame(){
		MainApplication.svg.setNumberOfTurns(Board.turnCount);
		MainApplication.svg.setPointDiff(Board.getPointDifference());
		MainApplication.svg.setVictor("Draw");
		
		AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	    try {
	    	MainApplication.svg.saveGame(MainApplication.manager);
		} catch (ClassNotFoundException | SQLException e) {
			MainApplication.changeGUI("MainGUI");
			e.printStackTrace();
		}
	    
	    handleEndGame("The game is a draw!");
		
	}
		
	/**
	 * this method calls the pop-up window that informs the players that the game has ended
	 * @param winnerString a String denoting who won the game*/
	protected static void handleEndGame(String winnerString) {
        //Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
        
		if (JOptionPane.showConfirmDialog(null, winnerString, "Rematch?",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	        //Play button press sound 2
	        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
			// yes option
        	MainApplication.changeGUI("UsernameGUI");
        } else {
	        //Play button press sound 2
	        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
            // no option
        	MainApplication.changeGUI("MainGUI");
        }
	}
	}

