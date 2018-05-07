package GUI;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ChessGame.MainApplication;

/**
 * Class that handles the panel of the game history, extending the JFrame class.
 * Displays previous games that are present in an embedded SQLite database.
 */
@SuppressWarnings("serial") // Suppressed because we do not serialize in this project. So no need to generate an ID.
public class GameHistoryGUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table_2;
	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static GameHistoryGUI main() throws SQLException, ClassNotFoundException {
		GameHistoryGUI frame = new GameHistoryGUI();
		frame.setVisible(true);
		frame.setResizable(false);
		return frame;
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public GameHistoryGUI() throws SQLException, ClassNotFoundException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("data/Images/cheapSet/cheapBlackPawn80.80.png"));
		setTitle("Chess - Game History");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		//Get all the data from the database
		ResultSet rs = MainApplication.manager.ExecuteSQLquery("SELECT * FROM match_statistics");
		List<Object[]> rows = new ArrayList<Object[]>();
		Object columns[] = {"Date", "Game Mode", "Player 1", "Player 2", "Victor", "Nr of Turns"};
		
		//Loop through the data	
		while(rs.next()) {
			Object[] newRow = new Object[6];
			newRow[0] = rs.getString("date");
			newRow[1]  = rs.getString("gamemode");
			newRow[2] = rs.getString("player_1");
			newRow[3] = rs.getString("player_2");
			newRow[4] = rs.getString("victor");
			newRow[5] = rs.getInt("number_of_turns");
			rows.add(newRow);
		}
		
		// Creates the game history panel and adds it to the content pane.
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{463, 0, 0};
		gbl_contentPane.rowHeights = new int[] {14, 290, 0, 30, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		// Adds a title to the content pane.
		JLabel lblGameHistory = new JLabel("Game History");
		GridBagConstraints gbc_lblGameHistory = new GridBagConstraints();
		gbc_lblGameHistory.insets = new Insets(0, 0, 5, 0);
		gbc_lblGameHistory.gridx = 0;
		gbc_lblGameHistory.gridy = 0;
		contentPane.add(lblGameHistory, gbc_lblGameHistory);
		
		// Allows scrolling through the pane.
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		table_2 = new JTable(rows.toArray(new Object[rows.size()][7]), columns);
		scrollPane.setViewportView(table_2);
		
		// Create the back button to return to the main menu.
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainApplication.changeGUI("MainGUI"); // To main menu.
			}
		});
		
		// Place the back button.
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.NORTH;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 2;
		contentPane.add(btnBack, gbc_btnBack);			
	}
}
