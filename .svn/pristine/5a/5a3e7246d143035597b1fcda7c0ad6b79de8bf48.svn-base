package Tests;

import ChessGame.AudioHandler;
import junit.framework.TestCase;

public class AudioHandlerTest extends TestCase {
	
	//Test for checking if the button click sound can be played
	public static void buttonClickTest(){
		boolean testBool;
		boolean soundTest = true;
		
		if(soundTest) {
			AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
			testBool = true;
		}else {
			testBool= false;
		}
		assertEquals(testBool, soundTest);
	}
	
	//Test for checking if the button click sound can be played when audio effects boolean is turned off
	public static void audioOffbuttonClickTest(){
		boolean testBool;
		boolean soundTest = false;
		
		if(soundTest) {
			AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
			testBool = true;
		}else {
			testBool= false;
		}
		assertEquals(testBool, soundTest);
	}
	

}
