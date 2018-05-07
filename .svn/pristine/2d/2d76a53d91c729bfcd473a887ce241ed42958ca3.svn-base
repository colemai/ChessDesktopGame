package Tests;
import java.sql.ResultSet;
import java.sql.SQLException;

import SaveGame.DatabaseManager;
import junit.framework.TestCase;

public class DatabaseManagerTest extends TestCase {
	
	// Test opening the connection - missing assertion statement
	public void testDBCreation() {
		DatabaseManager manager = new DatabaseManager();
		try {
			manager.checkForDBConnection();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Test data insertion - missing assertion statement
	public void testDataInsertion() throws SQLException, ClassNotFoundException {
		DatabaseManager manager = new DatabaseManager();
		manager.ExecuteSQLUpdate("INSERT INTO match_statistics VALUES('102','2018-04-14','multiplayer','Luuk','also Luuk','Luuk','1','10')");
	}
	
	// Test querying the database - missing assertion statement
	public void testShowData() throws ClassNotFoundException, SQLException {
		DatabaseManager manager = new DatabaseManager();
		ResultSet rs = manager.ExecuteSQLquery("SELECT * FROM match_statistics");
		while ( rs.next() ) {
	         int gameID = rs.getInt("gameID");
	         String date = rs.getString("date");
	         String gamemode  = rs.getString("gamemode");
	         String player_1 = rs.getString("player_1");
	         String player_2 = rs.getString("player_2");
	         String victor = rs.getString("victor");
	         int numbOfTurns = rs.getInt("number_of_turns");
	         int pointDifference = rs.getInt("point_difference");
	         
	         System.out.println("gameID = " + gameID);
	         System.out.println("date = " + date);
	         System.out.println("gamemode = " + gamemode);
	         System.out.println("player_1 = " + player_1);
	         System.out.println("player_2 = " + player_2);
	         System.out.println("victor = " + victor);
	         System.out.println("numbOfTurns = " + numbOfTurns);
	         System.out.println("pointDifference = " + pointDifference);
	         System.out.println();
	    }
	}
	
//	// Is not working
//  // Test removing data - also missing assertion statement
//	public void testDeleteData() throws SQLException, ClassNotFoundException {		
//		DatabaseManager manager = new DatabaseManager();
//		manager.ExecuteSQLUpdate("DROP TABLE main.match_statistics");		
//	}
//	
//	//Is not working
	
	

}
