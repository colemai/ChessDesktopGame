/**
 * The AudioHandler class handles the playing of music and sound effects(piece moves/takes/buttonclicks) 
 * all fields and methods are static because the music plays continuously throughout the game and the settings work universally*/
package ChessGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.UIDefaults.ProxyLazyValue;

/**
 *This class creates AudioHandler object which can be used to play, loop and mute music and sound effects.  
 */

public class AudioHandler {
	
	private static Clip clip;
	private static boolean playSoundEffects = true;

	/**
	 *The method playLoop can be used to loop a WAV file.
	 *@param path a String object specifying the file path
	 *@param dealy an int object specifying the play-back start delay
	 *@param numberOfLoops an int object used to initiate the instances of files delay
	 */
	
	public static void playLoop(String path, int delay, int numberOfLoops) {
		for (int i = 0; i < numberOfLoops; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						File file = new File(path);
						initializeClip();
						clip.open(AudioSystem.getAudioInputStream(file));
						clip.loop(100);
						Thread.sleep(clip.getMicrosecondLength());
						clip.stop(); 
						Thread.sleep(clip.getMicrosecondLength());
							
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}.start();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *The method playSingle can be used to play a WAV file once.
	 *@param path a String object specifying the file path
	 *@param dealy an int object specifying the play-back start delay
	 */
	
		public static void playSingle(String path, int delay) {
				if (playSoundEffects) {
					new Thread() {
						@Override
						public void run() {
							try {
								File file = new File(path);
								Clip clip = AudioSystem.getClip();
								clip.open(AudioSystem.getAudioInputStream(file));
								clip.start();
								Thread.sleep(clip.getMicrosecondLength());

							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					}.start();
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}	
}
	
	/**
	*The method initializes the audio clip that is currently playing, this can be used to stop the music.
	*/
		
	public static void initializeClip(){
		try{
			clip = AudioSystem.getClip();
		}catch(Error | LineUnavailableException e){
			System.out.println("Audiohandler.initializeClip: Line unavailable exception");
		}
	}
	
	/**
	 *The method can be called to stop the play-back of a file or looped file.
	 */
	
	public static void stopBackgroundMusic(){
		clip.stop();
	}

	/**
	 *The method can be called to set a boolean from a GUI so the sounds effects can be muted.
	 *@param inputBool is the input that is used to set  the boolean playSoundEffects.
	 */
	
	public static void setPlaySoundEffects(boolean inputBool) {
		playSoundEffects = inputBool;
	}
	
	/**
	 *This boolean is used to create a static boolean that can be set using the setPlaySoundEffects method.
	 */
	
	public static boolean getPlaySoundEffects() {
		return playSoundEffects;
	}
}
	
