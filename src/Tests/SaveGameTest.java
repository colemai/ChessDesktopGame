package Tests;

import java.sql.SQLException;

import SaveGame.DatabaseManager;
import SaveGame.GameSaver;
import junit.framework.TestCase;

public class SaveGameTest extends TestCase {
	
	public void testmissingDataCheck() {
		System.out.println("Testing CheckForMissingData Method");
		GameSaver sv = new GameSaver();
		sv.setNamePlayer1("test1");
		sv.setNamePlayer2("test2");
		sv.setGameType("multiplayer");
		sv.setVictor("test1");
		sv.setNumberOfTurns(10);
		sv.setPointDiff(5);	
		
		System.out.println(sv.missingDataCheck());		
				
		sv.setNamePlayer1("test1");
		sv.setNamePlayer2("test2");
		sv.setGameType("multiplayer");
		sv.setVictor("test1");
		sv.setNumberOfTurns(-2);
		sv.setPointDiff(5);
		
		System.out.println(sv.missingDataCheck());
		
		sv.setNamePlayer1("test1");
		sv.setNamePlayer2(null);
		sv.setGameType("multiplayer");
		sv.setVictor("test1");
		sv.setNumberOfTurns(10);
		sv.setPointDiff(5);
		
		System.out.println(sv.missingDataCheck());		
	}
	
	public void testClearData() {
		System.out.println("Testing ClearData Method");
		GameSaver sv = new GameSaver();
		sv.setNamePlayer1("test1");
		sv.setNamePlayer2("test2");
		sv.setGameType("multiplayer");
		sv.setVictor("test1");
		sv.setNumberOfTurns(10);
		sv.setPointDiff(5);
		
		sv.ClearData();
		
		System.out.println(sv.getNamePlayer1());
		System.out.println(sv.getNamePlayer2());
		System.out.println(sv.getGameType());
		System.out.println(sv.getVictor());
		System.out.println(sv.getNumberOfTurns());
		System.out.println(sv.getPointDiff());
		
	}
	
	public void testGetDate() {
		System.out.println("Testing GetDate Method");
		GameSaver sv = new GameSaver();
		
		System.out.println(sv.getDate());
	}
	

	public void testGetGameID() {
		System.out.println("Testing GetGameID Method");
		GameSaver sv = new GameSaver();
		
		System.out.println(sv.CreateGameID());
	}

	
	
	
	public void testSaveGame() throws ClassNotFoundException, SQLException {
		System.out.println("Testing SaveGame Method");
		GameSaver sv = new GameSaver();
		
		sv.setNamePlayer1("test1");
		sv.setNamePlayer2("test2");
		sv.setGameType("multiplayer");
		sv.setVictor("test1");
		sv.setNumberOfTurns(10);
		sv.setPointDiff(5);
		
		sv.saveGame(new DatabaseManager());
	}
}
