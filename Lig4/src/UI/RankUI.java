package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RankUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankUI window = new RankUI();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public RankUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	
	private void initialize() {
		Ranking rank = new Ranking();
		String[] rankeds = rank.getRanking();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MenuPrincipal window = new MenuPrincipal();
			}
		});
		voltar.setBounds(351, 12, 77, 25);
		frame.getContentPane().add(voltar);
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setFont(new Font("Dialog", Font.BOLD, 25));
		lblRanking.setBounds(157, 12, 126, 30);
		frame.getContentPane().add(lblRanking);
		
		if(rankeds.length > 0) {
		JLabel rank_0 = new JLabel("1º - "+rankeds[0]);
		rank_0.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_0.setBounds(34, 58, 157, 19);
		frame.getContentPane().add(rank_0);
		}
		if(rankeds.length > 1) {
		JLabel rank_1 = new JLabel("2º - "+rankeds[1]);
		rank_1.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_1.setBounds(34, 90, 157, 19);
		frame.getContentPane().add(rank_1);
		}
		if(rankeds.length > 2) {
		JLabel rank_2 = new JLabel("3º - "+rankeds[2]);
		rank_2.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_2.setBounds(34, 121, 157, 19);
		frame.getContentPane().add(rank_2);
		}
		if(rankeds.length > 3) {
		JLabel rank_3 = new JLabel("4º - "+rankeds[3]);
		rank_3.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_3.setBounds(34, 152, 157, 19);
		frame.getContentPane().add(rank_3);
		}
		if(rankeds.length > 4) {
		JLabel rank_4 = new JLabel("5º - "+rankeds[4]);
		rank_4.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_4.setBounds(34, 183, 157, 19);
		frame.getContentPane().add(rank_4);
		}
		if(rankeds.length > 5) {
		JLabel rank_5 = new JLabel("6º - "+rankeds[5]);
		rank_5.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_5.setBounds(246, 58, 157, 19);
		frame.getContentPane().add(rank_5);
		}
		if(rankeds.length > 6) {
		JLabel rank_6 = new JLabel("7º - "+rankeds[6]);
		rank_6.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_6.setBounds(246, 90, 157, 19);
		frame.getContentPane().add(rank_6);
		}
		if(rankeds.length > 7) {
		JLabel rank_7 = new JLabel("8º - "+rankeds[7]);
		rank_7.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_7.setBounds(246, 121, 157, 19);
		frame.getContentPane().add(rank_7);
		}
		if(rankeds.length > 8) {
		JLabel rank_8 = new JLabel("9º - "+rankeds[8]);
		rank_8.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_8.setBounds(246, 152, 157, 19);
		frame.getContentPane().add(rank_8);
		}
		if(rankeds.length > 9) {
		JLabel rank_9 = new JLabel("10º - "+rankeds[9]);
		rank_9.setFont(new Font("Dialog", Font.BOLD, 16));
		rank_9.setBounds(246, 183, 157, 19);
		frame.getContentPane().add(rank_9);
		}
	}

}
