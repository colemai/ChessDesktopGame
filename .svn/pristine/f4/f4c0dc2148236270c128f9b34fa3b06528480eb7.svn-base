package ChessGame;

import GUI.BoardGUI;

/**
 *A chess clock implementing the runnable interface so it can run in a different thread concurrent with the game */

public class ChessClock implements Runnable {
	
	
	private boolean whiteTurn = true; //which player is at play, true for white, false for black
	
	//time for both players in tenth's(0.1sec) 
	private int p1remaining; 
	private int p2remaining;
	
	/**
	 *this constructor takes the time in seconds and sets the time for the players in tenth's
	 *@param p1time the white player's time
	 *@param p2time the black players time 
	 **/
	public ChessClock(int p1time, int p2time){
		p1remaining = p1time*10;
		p2remaining = p2time*10;
	}
	
	/**
	 * the run method for the ChessClock class. this method runs the clock until one of the two hits 0*/
	public void run() {
		boolean shouldRun = true; //boolean to run the while loop properly(no break)
		
		//this loop loops through the clock time of both players, decrementing every 100 milliseconds
		while(shouldRun) 
			
		{
			System.out.print("");//unnecessary but necessary
			try 
			{
				Thread.sleep(100);//thread waits 100 ms
				if(whiteTurn)
				{
					p1remaining--; //decrement
					
					//update both clocks. turn red the one at play
					BoardGUI.p1ClockSetter("<html><p style='color:red; font-size:20px'>"+p1remaining/600+":"+(p1remaining%600)/10+":"+(p1remaining%600)%10+"</p></html>");
					BoardGUI.p2ClockSetter("<html><p style='color:black; font-size:20px'>"+p2remaining/600+":"+(p2remaining%600)/10+":"+(p2remaining%600)%10+"</p></html>");
					
					//ends the game if time runs out. proclaims winner
					if(p1remaining == 0)
					{
						GameEnder gameEnder = new GameEnder();
						gameEnder.endGame("Black");
						shouldRun = false;
					}
				}
				else
				{
					p2remaining--; //decrement
					
					//updates both clocks, turns red the one at play
					BoardGUI.p1ClockSetter("<html><p style='color:black; font-size:20px'>"+p1remaining/600+":"+(p1remaining%600)/10+":"+(p1remaining%600)%10+"</p></html>");
					BoardGUI.p2ClockSetter("<html><p style='color:red; font-size:20px'>"+p2remaining/600+":"+(p2remaining%600)/10+":"+(p2remaining%600)%10+"</p></html>");
					
					//ends the game if time runs out. proclaims winner
					if(p2remaining==0)
					{
						GameEnder gameEnder = new GameEnder();
						gameEnder.endGame("White");
						shouldRun = false;
					}
				}
			}
			catch(InterruptedException e){}
			
		}
	}
	
	/**
	 * Allows the setting of the white turn boolean, which is used by the clock to determine which clock to decrement
	 * */
	public void setWhiteTurn(boolean mWhiteTurn){
		whiteTurn= mWhiteTurn;
	}
	
	


}
