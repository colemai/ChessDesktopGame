package SaveGame;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JOptionPane;

import ChessGame.MainApplication;

public class GameSaver {
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private String namePlayer1;
	private String namePlayer2;
	private String gameType;
	private String victor = "n/a";
	private int numberOfTurns = -1;
	private int pointDiff = -1;
	private String moveHistory = "";
	
	/**
	 * When a move is made, the move is converted to a string in boardGUI.
	 * Here, that string is appended to a string for the history.
	 * @param newMove: string of the move that is going to be appended to moveHistory.
	 */
	public void AddMoveToHistory(String newMove) {
		moveHistory = moveHistory + "-" + newMove;
		//System.out.println("MoveHistory = " + moveHistory);
	}
	
	/**
	 * Make sure no fields are null, before the game is saved.
	 * If a field is null, return true, cancel the save and print an error statement.
	 * Else, false will be returned and saving will continue.
	 */
	public boolean missingDataCheck() {
		if(namePlayer1 == null) {
			System.out.println("namePlayer1");
			return true;
		} else if(namePlayer2 == null) {
			System.out.println("namePlayer2");
			return true;
		} else if(gameType == null) {
			System.out.println("gameType");
			return true;
		} else if(victor == null) {
			System.out.println("victor");
			return true;
		} else if(numberOfTurns == -1) {
			System.out.println("numberOfTurns");
			return true;
		} else if(pointDiff == -1) {
			System.out.println("pointDiff");
			return true;
		} else {
			return false; // If no fields are null.
		}
	}
	
	/**
	 * Method that returns the game type of the current game. 
	 * For now there is only 1 gametype, but this setup allows for future expansion.
	 * @return string: string of the type of game.
	 */
	public String GetGameType() {
		return "multiplayer";
	}
	
	/**
	 * Method that sets the variables storing game data, to null after saving is complete.
	 * Avoids concatenating save data.
	 */
	public void ClearData() {
		 namePlayer1 = null;
		 namePlayer2 = null;
		 gameType = null;
		 victor = null;
		 numberOfTurns = -1;
		 pointDiff = -1;
	}
	
	/**
	 * Method that returns the current date
	 * @return date: String of the current date from DateTimeFormatter.
	 */
	public String getDate() {
		LocalDate localDate = LocalDate.now();
		String date = DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
		date = date.replaceAll("/", "-");
        return date;
	}

	/**
	 * Method that returns a unique GameID based on the date and time.
	 * @return gameID: String of the game ID based on a date.
	 */
	public String CreateGameID() {
		Date date = new Date();
        String gameID = sdf.format(date).replace("/", "").replaceAll(" ", "").replaceAll(":","");
        return gameID;
	}
	
	/**
	 * Method that handles saving the game to the database.
	 * @param manager: Instance of the database connection handler.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void saveGame(DatabaseManager manager) throws ClassNotFoundException, SQLException {
		try {
			if(!missingDataCheck()) {
				String qry = "INSERT INTO match_statistics VALUES('" + CreateGameID() + "','" + getDate() + "','" + GetGameType() 
							 +"','" + namePlayer1 + "','"+ namePlayer2 + "','"+victor+"','"+ numberOfTurns+"')";
				manager.ExecuteSQLUpdate(qry);;
			} else {
				System.out.println("Game could not be saved because data is missing. Please contact the development team");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that handles saving the game to the database.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void SaveGame() throws ClassNotFoundException, SQLException {
		if(!missingDataCheck()) {
			//CREATE TABLE match_statistics (gameID = CreateGameID(),date = getDate(), gamemode = gameType, player_1 = namePlayer1 ,player_2 = namePlayer2, victor = victor, number_of_turns = numberOfTurns ,
			String qry = "INSERT INTO match_statistics VALUES('" + CreateGameID() + "','" + getDate() + "','" + gameType +"','" +namePlayer1+ "','"+namePlayer2+"','"+victor+"','"+numberOfTurns+"')";
			MainApplication.manager.ExecuteSQLUpdate(qry);;
		} else {
			System.out.println("Game could not be saved because data is missing. Please contact the development team");
		}
	}
	
	/**
	 * Getter: Get the name of player 1, as a string.
	 * @return: String of player 1
	 */
	public String getNamePlayer1() {
		return namePlayer1;
	}

	/**
	 * Setter: Set the name of the first player, as a string. 
	 */
	public void setNamePlayer1(String namePlayer1) {
		this.namePlayer1 = namePlayer1;
	}

	/**
	 * Getter: Get the name of player 2, as a string.
	 * @return: String of player 2
	 */
	public String getNamePlayer2() {
		return namePlayer2;
	}

	/**
	 * Setter: Set the name of the second player, as a string.
	 */
	public void setNamePlayer2(String namePlayer2) {
		this.namePlayer2 = namePlayer2;
	}

	/**
	 * Getter: Get the current gametype being played.
	 * @return: Returns string gametype
	 */
	public String getGameType() {
		return gameType;
	}

	/**
	 * Setter: Set the gametype, as a string.
	 */
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	/**
	 * Getter: Get the victor of the game.
	 * @return: Returns string: the victor of a game.
	 */
	public String getVictor() {
		return victor;
	}

	/**
	 * Setter: Set the victor of a game, as a string.
	 */
	public void setVictor(String victor) {
		this.victor = victor;
	}

	/**
	 * Getter: Get the current amount of turns that are made.
	 * @return: Integer of the amount of turns.
	 */
	public int getNumberOfTurns() {
		return numberOfTurns;
	}

	/**
	 * Setter: Set the current number of turns, as an integer.
	 */
	public void setNumberOfTurns(int numberOfTurns) {
		this.numberOfTurns = numberOfTurns;
	}

	/**
	 * Getter: Get the difference in points between players.
	 * @return: Integer of the difference in points.
	 */
	public int getPointDiff() {
		return pointDiff;
	}

	/**
	 * Setter: Set the difference in points between players, as an integer.
	 */
	public void setPointDiff(int pointDiff) {
		this.pointDiff = pointDiff;
	}
}
