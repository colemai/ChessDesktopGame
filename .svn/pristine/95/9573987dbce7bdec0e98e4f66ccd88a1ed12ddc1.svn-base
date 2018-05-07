package SaveGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	private static Connection con;	
	private static boolean hasData = false;
	
	/**
	 * Checks if there is a database connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void checkForDBConnection() throws ClassNotFoundException, SQLException {
		if(getCon() == null)
		{
			getConnection();
		}		
	}
	
	/**
	 * Takes in a query and executes it. Does not return anything. Use this method for updating or 
	 * queries that do not return any results
	 * @param query : Query to update the database with
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void ExecuteSQLUpdate(String query) throws SQLException, ClassNotFoundException {
		checkForDBConnection();
		
		//Create a statement
		Statement state = getCon().createStatement();
		//Execute it
		state.executeUpdate(query);

	}

	/**
	 * Takes in a query and executes it. Returns the resultset
	 * @param query
	 * @return res : returns the resultset
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ResultSet ExecuteSQLquery(String query) throws SQLException, ClassNotFoundException {
		if(getCon() == null) {
			getConnection();
		}	
		
		//Create a statement
		Statement state = getCon().createStatement();
		//Execute it
		ResultSet res = state.executeQuery(query);
		
		return res;
	}
	
	/**
	 * Method that gets a connection with the database
	 * Important!!!! If it can't find the class you first have to download the JDBC driver from:
	 * https://bitbucket.org/xerial/sqlite-jdbc/downloads/
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void getConnection() throws ClassNotFoundException, SQLException {
		//Load the JDBC driver into our driver manager
		//If it can't find the class, Throw Exception 
		Class.forName("org.sqlite.JDBC");
		//Create a Connection, Throws exception if there is an error in creating the connection
		setCon(DriverManager.getConnection("jdbc:sqlite:ChessGameStatisticsDatabase.db"));
		initialise();
	}

	/**
	 * Initial setup of the SQLite database
	 * @throws SQLException
	 */
	private void initialise() throws SQLException {
		if(!hasData) {		
			//set hasData to true so we don't get stuck in a loop of keep creating a db
			hasData = true;
			
			//Create a statement
			Statement state = getCon().createStatement();
			//sqlite_master is the master table of any sqlite database which keeps track of which
			//tables are inside the data base. This query checks if there is a table with the name match_statistics
			ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='match_statistics'");
			
			//if no table is in the database, make one
			if(!res.next()) {
				System.out.println("Building DB...");
				//Create statement
				Statement state2 = getCon().createStatement();
				
				//Statement to create the table
				state2.execute("CREATE TABLE match_statistics (gameID VARCHAR(255) NOT NULL,date DATE NOT NULL, gamemode VARCHAR(255) NOT NULL, player_1 VARCHAR(255) NOT NULL,player_2 VARCHAR(255) NOT NULL, victor VARCHAR(255) NOT NULL, number_of_turns INT NOT NULL, PRIMARY KEY (gameID))");

			}
		}
	}

	/**
	 * Close the DB connection
	 * @throws SQLException
	 */
	public void CloseConnection() throws SQLException {
		System.out.println("Closing DB");
		getCon().close();
	}

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		DatabaseManager.con = con;
	}
	
}
