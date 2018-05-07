package ChessGame;

import java.sql.SQLException;

import javax.swing.JFrame;

import ChessPieces.CreateChessPieces;
import GUI.BoardGUI;
import GUI.GameHistoryGUI;
import GUI.MainGUI;
import GUI.OptionsGUI;
import GUI.PreGameOptionGUI;
import SaveGame.DatabaseManager;
import SaveGame.GameSaver;

/**
 * This class maintains the core of the application, like loading the database and switching between GUIs
 * 
 * @author Group B
 *
 */
public class MainApplication {
	// Set a GUI class variable, only one GUI should run at once
	public static JFrame currentGUI;
	
	
	// Initialize database manager
	public static DatabaseManager manager;
	public static GameSaver svg = new GameSaver();
	
	// Keep a Boolean that tracks white player's turn - if false, it's black player's turn
	// Default = True, white player will always start
	public Boolean whiteTurn = true;
	
	// Create ruleSet for the game
	RuleSet ruleSet = new RuleSet();
	
	public static void main(String[] args) {
		// Methods are called that need to be called on startup
		startupDatabase();
		
		//initialize different graphic piece sets
		CreateChessPieces.initializeSets();
		
		//start music
		AudioHandler.playLoop("data/Sounds/background/OlafurArnaldsDoria.wav", 0, 1);
		
		// Start the MainGUI which contains the main menu of the game
		currentGUI = MainGUI.main();
		System.out.println("Application starting up...");
	}
	
	/**
	 * Accepts the name of the GUI to open as String
	 * Closes the current GUI (sets visibility to false) and then opens the specified GUI
	 * @param gui
	 */
	public static void changeGUI(String gui) {
		currentGUI.setVisible(false);
		switch (gui) {
		    case "OptionsGUI": 
		    	currentGUI = OptionsGUI.main();
		        break;
		    case "MainGUI":
		    	currentGUI = MainGUI.main();
		    	break;
		    case "GameHistoryGUI":
		    	// Added a try catch statement to handle the SQL errors and ClassNotFound Errors that could be thrown
		    	// Decide whether to catch both exceptions with one catch
		    	try {
		    		currentGUI = GameHistoryGUI.main();
		    	} catch (ClassNotFoundException e) {
		    		// Thrown by DatabaseManager.java when JDBC class is not found
		    		// TODO Implement pop-up window saying something went wrong, button leads to main menu
		    		e.printStackTrace();
		    	} catch (SQLException e) {
		    		// Thrown when SQL query contains errors or when the DB cannot be reached
		    		// TODO Implement pop-up window saying something went wrong, button leads to main menu
		    		e.printStackTrace();
		    	}

		    	break;		    
		    case "UsernameGUI":
		    	currentGUI = PreGameOptionGUI.main();
		    	break;	
		    case "BoardGUI":
		    	currentGUI = BoardGUI.main();
		    	break;
		    default: 
		        System.out.println("Invalid class selected, please notify development team");
		        break;
			}		
		System.out.println("Changing window");
	}
	
	/**
	 * Starts the connection to the database behind GameHistoryGUI
	 */
	private static void startupDatabase() {
		manager = new DatabaseManager();
		try {
			manager.checkForDBConnection();
			System.out.println("DB Startup Succesful");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
