package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InGameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimerPlaceholder;

	/**
	 * First we wanted to use this GUI for displaying the board etc. but now not anymore.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InGameGUI frame = new InGameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InGameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{267, 221, 242, 0};
		gbl_contentPane.rowHeights = new int[]{14, 14, 14, 23, 33, 40, 59, 185, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblPlayer1 = new JLabel("Player 1");
		GridBagConstraints gbc_lblPlayer1 = new GridBagConstraints();
		gbc_lblPlayer1.anchor = GridBagConstraints.NORTH;
		gbc_lblPlayer1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer1.gridx = 0;
		gbc_lblPlayer1.gridy = 1;
		contentPane.add(lblPlayer1, gbc_lblPlayer1);
		
		JLabel lblPlayer2 = new JLabel("Player 2");
		GridBagConstraints gbc_lblPlayer2 = new GridBagConstraints();
		gbc_lblPlayer2.anchor = GridBagConstraints.NORTH;
		gbc_lblPlayer2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer2.gridx = 0;
		gbc_lblPlayer2.gridy = 2;
		contentPane.add(lblPlayer2, gbc_lblPlayer2);
		
		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 3;
		contentPane.add(btnSave, gbc_btnSave);
		
		JButton btnForfeit = new JButton("Forfeit");
		GridBagConstraints gbc_btnForfeit = new GridBagConstraints();
		gbc_btnForfeit.anchor = GridBagConstraints.NORTH;
		gbc_btnForfeit.insets = new Insets(0, 0, 5, 0);
		gbc_btnForfeit.gridx = 2;
		gbc_btnForfeit.gridy = 3;
		contentPane.add(btnForfeit, gbc_btnForfeit);
		
		txtTimerPlaceholder = new JTextField();
		txtTimerPlaceholder.setText("Timer placeholder");
		GridBagConstraints gbc_txtTimerPlaceholder = new GridBagConstraints();
		gbc_txtTimerPlaceholder.anchor = GridBagConstraints.NORTH;
		gbc_txtTimerPlaceholder.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTimerPlaceholder.insets = new Insets(0, 0, 5, 5);
		gbc_txtTimerPlaceholder.gridx = 1;
		gbc_txtTimerPlaceholder.gridy = 4;
		contentPane.add(txtTimerPlaceholder, gbc_txtTimerPlaceholder);
		txtTimerPlaceholder.setColumns(10);
		
		JButton btnPause = new JButton("Pause");
		btnPause.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnPause = new GridBagConstraints();
		gbc_btnPause.anchor = GridBagConstraints.NORTH;
		gbc_btnPause.insets = new Insets(0, 0, 5, 0);
		gbc_btnPause.gridx = 2;
		gbc_btnPause.gridy = 4;
		contentPane.add(btnPause, gbc_btnPause);
		
		JTextPane txtpnLostPiecesPlayer = new JTextPane();
		txtpnLostPiecesPlayer.setText("Lost pieces Player 1");
		GridBagConstraints gbc_txtpnLostPiecesPlayer = new GridBagConstraints();
		gbc_txtpnLostPiecesPlayer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnLostPiecesPlayer.anchor = GridBagConstraints.NORTH;
		gbc_txtpnLostPiecesPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnLostPiecesPlayer.gridx = 1;
		gbc_txtpnLostPiecesPlayer.gridy = 5;
		contentPane.add(txtpnLostPiecesPlayer, gbc_txtpnLostPiecesPlayer);
		
		JLabel lblScorePlayer = new JLabel("Score Player 1");
		GridBagConstraints gbc_lblScorePlayer = new GridBagConstraints();
		gbc_lblScorePlayer.insets = new Insets(0, 0, 5, 0);
		gbc_lblScorePlayer.gridx = 2;
		gbc_lblScorePlayer.gridy = 5;
		contentPane.add(lblScorePlayer, gbc_lblScorePlayer);
		
		JTextPane txtpnLostPiecesPlayer_1 = new JTextPane();
		txtpnLostPiecesPlayer_1.setText("Lost pieces Player 2");
		GridBagConstraints gbc_txtpnLostPiecesPlayer_1 = new GridBagConstraints();
		gbc_txtpnLostPiecesPlayer_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnLostPiecesPlayer_1.anchor = GridBagConstraints.NORTH;
		gbc_txtpnLostPiecesPlayer_1.insets = new Insets(0, 0, 0, 5);
		gbc_txtpnLostPiecesPlayer_1.gridheight = 2;
		gbc_txtpnLostPiecesPlayer_1.gridx = 1;
		gbc_txtpnLostPiecesPlayer_1.gridy = 6;
		contentPane.add(txtpnLostPiecesPlayer_1, gbc_txtpnLostPiecesPlayer_1);
		
		JLabel lblScorePlayer_1 = new JLabel("Score Player 2");
		GridBagConstraints gbc_lblScorePlayer_1 = new GridBagConstraints();
		gbc_lblScorePlayer_1.anchor = GridBagConstraints.NORTH;
		gbc_lblScorePlayer_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblScorePlayer_1.gridx = 2;
		gbc_lblScorePlayer_1.gridy = 6;
		contentPane.add(lblScorePlayer_1, gbc_lblScorePlayer_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);
		
		JLabel lblHistoryOfMoves = new JLabel("History of moves");
		scrollPane.setColumnHeaderView(lblHistoryOfMoves);
		lblHistoryOfMoves.setHorizontalAlignment(SwingConstants.LEFT);
		
		JTextPane txtpnHistoryOfMoves = new JTextPane();
		scrollPane.setViewportView(txtpnHistoryOfMoves);
		txtpnHistoryOfMoves.setText("History of moves");
	}

}
