package GUI;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ChessBoard.Board;
import ChessGame.AudioHandler;
import ChessGame.MainApplication;
import ChessPieces.CreateChessPieces;

@SuppressWarnings("serial")
public class OptionsGUI extends JFrame {
	//new PicturePanel
	private PicturePanel contentPane;
	//New Image
	private Image img;
	//Toolkit Instance to handle images.
	private Toolkit kit = Toolkit.getDefaultToolkit();
	
	/**
	 * Create the options GUI, this GUI allows the user to change settings before starting the game.
	 */
	public static OptionsGUI main() {
		OptionsGUI frame = new OptionsGUI();
		frame.setVisible(true);
		frame.setResizable(false);
		return frame;
	}

	/**
	 * Create the frame. Sound Effects, Music, Chess Pieces (graphical representation) and Board 
	 * Rotation are the 4 options. All options have a default setting. For Sound Effects, Music 
	 * and Board Rotation the default setting is "On" and for Chess Pieces the default setting is "Classic".
	 * 
	 */
	
	public OptionsGUI() {
		// Background image, it is working properly but WindowBuilder Editor is not useable anymore.  
		setIconImage(Toolkit.getDefaultToolkit().getImage("data/Images/cheapSet/cheapBlackPawn80.80.png"));
		setTitle("Chess - Options");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 295);
		img = kit.getImage("data/Images/GUIBG/ChessBoardBG.jpg");
        img = img.getScaledInstance(350, -1, Image.SCALE_SMOOTH);
		contentPane = new PicturePanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[]{0, 0, 34, 9, 15, 0, 0};
		gbl_contentPane.columnWidths = new int[]{105, 108};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.gridwidth = 2;
		gbc_lblOptions.insets = new Insets(0, 0, 5, 0);
		gbc_lblOptions.gridx = 0;
		gbc_lblOptions.gridy = 0;
		contentPane.add(lblOptions, gbc_lblOptions);
		
		// Sound Effects options
		JLabel lblNewLabel = new JLabel("Sound Effects");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.gridx = 1;
		gbc_splitPane.gridy = 2;
		contentPane.add(splitPane, gbc_splitPane);
		
		// Sound Effects option On
		JRadioButton rdbtnSoundEffectsOn = new JRadioButton("On", true);
		rdbtnSoundEffectsOn.setVerticalAlignment(SwingConstants.BOTTOM);
		splitPane.setLeftComponent(rdbtnSoundEffectsOn);
		ButtonGroup soundEffectsOnOff  = new ButtonGroup();
		soundEffectsOnOff.add(rdbtnSoundEffectsOn);// TURN CLICK SOUND ON
		rdbtnSoundEffectsOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonSoundEffectsOn();
		}});
		
		// Sound Effects option Off
		JRadioButton rdbtnSoundEffectsOff = new JRadioButton("Off");
		rdbtnSoundEffectsOff.setVerticalAlignment(SwingConstants.BOTTOM);
		splitPane.setRightComponent(rdbtnSoundEffectsOff);
		soundEffectsOnOff.add(rdbtnSoundEffectsOff); //TURN CLICK SOUND OFF
		rdbtnSoundEffectsOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonSoundEffectsOff();
		}});
		
		// Music option
		JLabel lblMusic = new JLabel("Music");
		GridBagConstraints gbc_lblMusic = new GridBagConstraints();
		gbc_lblMusic.insets = new Insets(0, 0, 5, 5);
		gbc_lblMusic.gridx = 0;
		gbc_lblMusic.gridy = 3;
		contentPane.add(lblMusic, gbc_lblMusic);
		
		JSplitPane splitPane_1 = new JSplitPane();
		GridBagConstraints gbc_splitPane_1 = new GridBagConstraints();
		gbc_splitPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane_1.gridx = 1;
		gbc_splitPane_1.gridy = 3;
		contentPane.add(splitPane_1, gbc_splitPane_1);
		
		// Music option On
		JRadioButton rdbtnMusicOn = new JRadioButton("On", true);
		splitPane_1.setLeftComponent(rdbtnMusicOn);
		ButtonGroup musicOnOff = new ButtonGroup();
		musicOnOff.add(rdbtnMusicOn);
		rdbtnMusicOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonMusicOn();
		}});

		// Music option Off
		JRadioButton rdbtnMusicOff = new JRadioButton("Off");
		rdbtnMusicOff.setVerticalAlignment(SwingConstants.BOTTOM);
		splitPane_1.setRightComponent(rdbtnMusicOff);
		musicOnOff.add(rdbtnMusicOff);
		rdbtnMusicOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonMusicOff();
		}});
		
		// Back button
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBackToMainMenu();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 6;
		contentPane.add(btnBack, gbc_btnBack);

		// Chess pieces (graphical representation) option		
		JLabel lblChessPieces = new JLabel("Chess Pieces");
		lblChessPieces.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblChessPieces = new GridBagConstraints();
		gbc_lblChessPieces.insets = new Insets(0, 0, 5, 5);
		gbc_lblChessPieces.gridx = 0;
		gbc_lblChessPieces.gridy = 4;
		contentPane.add(lblChessPieces, gbc_lblChessPieces);
		
		JSplitPane splitPane_2 = new JSplitPane();
		GridBagConstraints gbc_splitPane_2 = new GridBagConstraints();
		gbc_splitPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane_2.gridx = 1;
		gbc_splitPane_2.gridy = 4;
		contentPane.add(splitPane_2, gbc_splitPane_2);
		
		// Chess pieces options Classic
		JRadioButton rdbtnClassic = new JRadioButton("Classic", true);
		ButtonGroup setChessPieces = new ButtonGroup();
		setChessPieces.add(rdbtnClassic);
		rdbtnClassic.setVerticalAlignment(SwingConstants.BOTTOM);
		splitPane_2.setLeftComponent(rdbtnClassic);
		rdbtnClassic.setActionCommand("Classic");
		rdbtnClassic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonSelectionClassic();
			}
		});
		
		// Chess pieces option Modern
		JRadioButton rdbtnModern = new JRadioButton("Modern");
		setChessPieces.add(rdbtnModern);
		rdbtnModern.setVerticalAlignment(SwingConstants.BOTTOM);
		splitPane_2.setRightComponent(rdbtnModern);
		rdbtnModern.setActionCommand("Modern");
		rdbtnModern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonSelectionModern();
			}
		});
		
		// Board rotation option		
		JLabel lblRotateBoard = new JLabel("Board Rotation");
		lblRotateBoard.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblRotateBoard = new GridBagConstraints();
		gbc_lblRotateBoard.insets = new Insets(0, 0, 5, 5);
		gbc_lblRotateBoard.gridx = 0;
		gbc_lblRotateBoard.gridy = 5;
		contentPane.add(lblRotateBoard, gbc_lblRotateBoard);
		
		JSplitPane splitPane_3 = new JSplitPane();
		GridBagConstraints gbc_splitPane_3 = new GridBagConstraints();
		gbc_splitPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane_3.gridx = 1;
		gbc_splitPane_3.gridy = 5;
		contentPane.add(splitPane_3, gbc_splitPane_3);
		
		// Board rotation option On
		JRadioButton rdbtnOn = new JRadioButton("On", true);
		ButtonGroup setBoardRotation = new ButtonGroup();
		setBoardRotation.add(rdbtnOn);
		rdbtnOn.setVerticalAlignment(SwingConstants.BOTTOM);
		splitPane_3.setLeftComponent(rdbtnOn);
		rdbtnOn.setActionCommand("On");
		rdbtnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonRotationOn();
			}
		});

		// Board rotation option Off
		JRadioButton rdbtnOff = new JRadioButton("Off");
		setBoardRotation.add(rdbtnOff);
		rdbtnOff.setVerticalAlignment(SwingConstants.BOTTOM);
		splitPane_3.setRightComponent(rdbtnOff);
		rdbtnOff.setActionCommand("Off");
		rdbtnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonRotationOff();
			}
		});

	}

	/**
	 * Handles actions behind the back button and all the other options.
	 */
	protected void handleBackToMainMenu() {
		MainApplication.changeGUI("MainGUI");
        //Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	}

	protected void handleRadioButtonMusicOff() {
		//Stop background music.
		AudioHandler.stopBackgroundMusic();
        //Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	}
	
	protected void handleRadioButtonMusicOn() {
		//Start background music
		AudioHandler.playLoop("data/Sounds/background/OlafurArnaldsDoria.wav", 0, 1);
        //Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
	}
	
	protected void handleRadioButtonSoundEffectsOff() {
		//Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
        
		//set the audiohandler settings to false
		AudioHandler.setPlaySoundEffects(false);
	}
	
	protected void handleRadioButtonSoundEffectsOn() {
		//Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
		
        //set the audiohandler settings to true
		AudioHandler.setPlaySoundEffects(true);
	}

	protected void handleRadioButtonSelectionClassic(){
		//Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
		
		//set the chess pieces setting to 0 (classic)
		CreateChessPieces.changeSets(0);
	}

	protected void handleRadioButtonSelectionModern(){
		 //Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
		
		//set the chess pieces setting to 1 (modern)
		CreateChessPieces.changeSets(1);
	}
	
	protected void handleRadioButtonRotationOn(){
		//Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
		
		//set the rotate board setting to true
		Board.setBoardPositionClicked(true);
	}

	protected void handleRadioButtonRotationOff(){
		//Play button press sound 2
        AudioHandler.playSingle("data/Sounds/OtherFx/PressButton2.wav", 0);
		
		//set the rotate board setting to false
		Board.setBoardPositionClicked(false);
	}
	/**
	 * A small overwrite to make it possible to set a background for a JPanel.
	 * Overwrites the paint method to make it accept images.
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
	

