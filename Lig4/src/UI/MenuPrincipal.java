package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Game.Player;

import java.awt.Font;

public class MenuPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String player1Name = JOptionPane.showInputDialog(frame, "Nome do Jogador 1:");
				if(player1Name != null) {
					String player2Name = JOptionPane.showInputDialog(frame, "Nome do Jogador 2:");
					if (player2Name != null && !player2Name.equals(player1Name)) {
                	frame.dispose();
    				MenuModos windowGame = new MenuModos(new Player(player1Name, "y"), new Player(player2Name, "r"));
					}else if(player2Name.equals(player1Name)) {
						JOptionPane.showMessageDialog(null, "Nomes Iguais", "Erro", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
                
			}
		});
		btnJogar.setBounds(167, 118, 117, 25);
		frame.getContentPane().add(btnJogar);
		
		JButton btnRank = new JButton("Rank");
		btnRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RankUI windowRank = new RankUI();
			}
		});
		btnRank.setBounds(167, 155, 117, 25);
		frame.getContentPane().add(btnRank);
		
		JLabel lblLig = new JLabel("LIG4");
		lblLig.setFont(new Font("Dialog", Font.BOLD, 22));
		lblLig.setBounds(175, 47, 109, 39);
		frame.getContentPane().add(lblLig);
	}
}
