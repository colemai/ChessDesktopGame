package GUI;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import ChessGame.AudioHandler;
import ChessGame.MainApplication;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	private PicturePanel contentPane;
	private Image img;
	private Toolkit kit = Toolkit.getDefaultToolkit();
	
	/**
	 * Create the MainGUI
	 */
	public static MainGUI main() {
			MainGUI frame = new MainGUI();
			frame.setVisible(true);
			frame.setResizable(false);
			return frame;
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("data/Images/cheapSet/cheapBlackPawn80.80.png"));
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 214, 284);
		img = kit.getImage("data/Images/GUIBG/ChessBoardBG.jpg");
        img = img.getScaledInstance(300, -1, Image.SCALE_SMOOTH);
		contentPane = new PicturePanel();
		contentPane.setOpaque(true);
		setContentPane(contentPane);

		
		JLabel lblChess = new JLabel("CHESS");
		lblChess.setHorizontalAlignment(SwingConstants.CENTER);
		lblChess.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleUsernameGUI();
			}
		});
		
		JButton btnShowHighscores = new JButton("History");
		btnShowHighscores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLoadHistoryGUI();
			}
		});
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLoadOptionsGUI();
			}
		});
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
					handleQuitGame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		contentPane.setOpaque(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChess, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnQuitGame, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
						.addComponent(btnOptions, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
						.addComponent(btnShowHighscores, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnStartGame, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
					.addGap(57))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblChess)
					.addGap(26)
					.addComponent(btnStartGame)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnShowHighscores)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOptions)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnQuitGame)
					.addGap(58))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Actions behind quit button
	 * If user clicks Yes: close all windows
	 * If user clicks No: return to main menu
	 * @throws SQLException 
	 */
	protected void handleQuitGame() throws SQLException {
        //Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
        
		if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Quit ChessGame",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
	        //Play button press sound 2
	        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	        MainApplication.manager.CloseConnection();
			// yes option
        	System.exit(0);
        } else {
	        //Play button press sound 2
	        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
            // no option
        	MainApplication.changeGUI("MainGUI");
        }
	}

	/**
	 * Actions behind options button
	 * Changes window to the GUI where the user can configure sound settings
	 */
	protected void handleLoadOptionsGUI() {
		MainApplication.changeGUI("OptionsGUI");
        //Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	}

	/**
	 * Actions behind show highscores button
	 * Changes window to the GUI where the user can see a list of high scores
	 */
	protected void handleLoadHistoryGUI() {
		MainApplication.changeGUI("GameHistoryGUI");
        //Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	}

	/**
	 * Actions behind start button
	 * Changes window to the GUI where the user can choose game settings
	 */
	protected void handleUsernameGUI() {
		MainApplication.changeGUI("UsernameGUI");
        //Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	}
	/**
	 * Fun little overwrite to make it possible to set a background for a JPanel
	 * @author ozing003
	 * overwrites the paint method to make it accept images.
	 */
	private class PicturePanel extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(img,0,0,this);
            setOpaque(false);
			super.paint( g ) ;
			setOpaque(true);
        }
    }
}
