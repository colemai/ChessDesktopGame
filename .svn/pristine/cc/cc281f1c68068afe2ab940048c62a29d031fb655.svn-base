package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ChessGame.AudioHandler;
import ChessGame.ChessClock;
import ChessGame.MainApplication;

public class PreGameOptionGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2267215538169966652L;
	private JTextField txtNamePlayer1;
	private JTextField txtNamePlayer2;
	private JTextField txtP1Clock;
	private JTextField txtP2Clock;
	private PicturePanel contentPane;
	private Image img;
	private Toolkit kit = Toolkit.getDefaultToolkit();

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// UsernameGUI frame = new UsernameGUI();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public static PreGameOptionGUI main() {
		PreGameOptionGUI frame = new PreGameOptionGUI();
		frame.setVisible(true);
		frame.setResizable(false);
		return frame;
	}
	/**
	 * creates the GUI with ImageIcon screen name background and the textfields and buttons.
	 */
	public PreGameOptionGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("data/Images/cheapSet/cheapBlackPawn80.80.png"));
		setTitle("Chess - Player Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 244, 180);
		img = kit.getImage("data/Images/GUIBG/ChessBoardBG.jpg");
		img = img.getScaledInstance(250, -1, Image.SCALE_SMOOTH);
		contentPane = new PicturePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Player 1 name 
		JLabel lblPlayer = new JLabel("Player 1 name");
		lblPlayer.setBounds(20, 10, 102, 14);
		contentPane.add(lblPlayer);
		txtNamePlayer1 = new JTextField();
		txtNamePlayer1.setBounds(20, 24, 91, 20);
		txtNamePlayer1.setColumns(10);
		contentPane.add(txtNamePlayer1);
		
		//Player 2 name
		JLabel lblPlayer_1 = new JLabel("Player 2 name");
		lblPlayer_1.setBounds(138, 10, 85, 14);
		contentPane.add(lblPlayer_1);
		txtNamePlayer2 = new JTextField();
		txtNamePlayer2.setBounds(132, 24, 91, 20);
		txtNamePlayer2.setColumns(10);
		contentPane.add(txtNamePlayer2);

		//Clock added to pane for player 1
		JLabel lblClock = new JLabel("Clock");
		lblClock.setBounds(20, 51, 57, 14);
		contentPane.add(lblClock);
		txtP1Clock = new JTextField();
		txtP1Clock.setBounds(20, 66, 91, 20);
		txtP1Clock.setColumns(10);
		contentPane.add(txtP1Clock);
		
		//Clock added to pane for player 2
		JLabel lblBlackClock = new JLabel("Clock");
		lblBlackClock.setBounds(132, 51, 55, 14);
		contentPane.add(lblBlackClock);
		txtP2Clock = new JTextField();
		txtP2Clock.setBounds(132, 66, 91, 20);
		txtP2Clock.setColumns(10);
		contentPane.add(txtP2Clock);

		//added the checkbutton for if you want to use the clock
		JCheckBox chckbxUseClock = new JCheckBox("Use Clock?");
		chckbxUseClock.setBounds(20, 93, 102, 23);
		contentPane.add(chckbxUseClock);

		//added the start button
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(20, 125, 70, 23);
		contentPane.add(btnStart);
		//listener for the start button
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleGameStart(chckbxUseClock);
			}
		});
		
		//back button added to the Gui
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setBounds(132, 125, 70, 23);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleStartChessGame();
				MainGUI frame = new MainGUI();
				MainApplication.currentGUI.setVisible(false);
				MainApplication.currentGUI = frame;
				frame.setVisible(true);
			}
		});
		contentPane.add(btnBack_1);

	}
	/**
	 * Sends the information to the Game once start is pressed. based on the user selected input.
	 * @param chckbxUseClock the checkbox for check use clock.
	 */
	private void handleGameStart(JCheckBox chckbxUseClock) {
		String name1 = txtNamePlayer1.getText();
		String name2 = txtNamePlayer2.getText();
		// Sends the player names to the SaveGame class and stores it there so
		// it can use it when it needs to save the game
		MainApplication.svg.setNamePlayer1(name1);
		MainApplication.svg.setNamePlayer2(name2);
		MainApplication.svg.setGameType("multiplayer");

		try (FileWriter Username = new FileWriter("resources/UsernameTest.txt");
				BufferedWriter b = new BufferedWriter(Username);
				PrintWriter p = new PrintWriter(b);) {
			p.println(name1);
			p.println(name2);
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		handleStartChessGame();
		int p1Time = 0;
		int p2Time = 0;
		boolean validInput = true;
		try {
			p1Time = Integer.parseInt(txtP1Clock.getText());
			p2Time = Integer.parseInt(txtP2Clock.getText());

		} catch (NumberFormatException e) {
			if (chckbxUseClock.isSelected()) {
				//shows error if anything thats not a number is entered.
				JOptionPane.showMessageDialog(null, "Please enter the amount of time in seconds for both players");
				validInput = false;
			}
		}
		// starts game with clock
		if (chckbxUseClock.isSelected() && validInput) {
			handleStartChessGame();
			ChessClock clock = new ChessClock(p1Time, p2Time);
			BoardGUI frame = new BoardGUI(clock);
			this.setVisible(false);
			MainApplication.currentGUI = frame;
			frame.setVisible(true);
		// starts game without clock
		} else if (validInput || !chckbxUseClock.isSelected()) {
			handleStartChessGame();
			BoardGUI frame = new BoardGUI();
			this.setVisible(false);
			MainApplication.currentGUI = frame;
			frame.setVisible(true);
		}
	}
	/**
	 * plays a sound on button press when start game is used.
	 */
	protected void handleStartChessGame() {
		// Play button press sound 2
		AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	}

	/**
	 * Fun little overwrite to make it possible to set a background for a JPanel
	 * overwrites the paint method to make it accept images.
	 */
	@SuppressWarnings("serial")
	private class PicturePanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, this);
			setOpaque(false);
			super.paint(g);
			setOpaque(true);
		}
	}

}
