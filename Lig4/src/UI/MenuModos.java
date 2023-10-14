package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import Game.Player;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuModos {

	private JFrame frame;
	private double dif = 1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuModos window = new MenuModos();
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
	public MenuModos(Player player1, Player player2) {
		initialize(player1, player2);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player player1, Player player2) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNormal = new JLabel("Normal");
		lblNormal.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNormal.setBounds(12, 12, 94, 15);
		frame.getContentPane().add(lblNormal);
		
		JLabel lblTurbo = new JLabel("Turbo");
		lblTurbo.setFont(new Font("Dialog", Font.BOLD, 17));
		lblTurbo.setBounds(12, 89, 94, 15);
		frame.getContentPane().add(lblTurbo);
		
		JLabel lblTurboMaluco = new JLabel("Turbo Maluco");
		lblTurboMaluco.setFont(new Font("Dialog", Font.BOLD, 17));
		lblTurboMaluco.setBounds(12, 168, 172, 15);
		frame.getContentPane().add(lblTurboMaluco);
		
		JButton btnNormal = new JButton("Normal");
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GameUI windowGame = new GameUI(player1, player2);
			}
		});
		btnNormal.setBounds(12, 39, 117, 25);
		frame.getContentPane().add(btnNormal);
		
		JButton btnPontos = new JButton("Pontos");
		btnPontos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GamePointUI windowGame = new GamePointUI(player1, player2);
			}
		});
		btnPontos.setBounds(141, 39, 117, 25);
		frame.getContentPane().add(btnPontos);
		
		JButton btnPontos_1 = new JButton("Pontos");
		btnPontos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GamePointTurboUI windowGame = new GamePointTurboUI(player1, player2);
			}
		});
		btnPontos_1.setBounds(141, 116, 117, 25);
		frame.getContentPane().add(btnPontos_1);
		
		JButton btnNormal_1 = new JButton("Normal");
		btnNormal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GameTurboUI windowGame = new GameTurboUI(player1, player2);
			}
		});
		btnNormal_1.setBounds(12, 116, 117, 25);
		frame.getContentPane().add(btnNormal_1);
		
		JButton btnPontos_2 = new JButton("Pontos");
		btnPontos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GamePointTurboMalucoUI windowGame = new GamePointTurboMalucoUI(player1, player2, dif);
			}
		});
		btnPontos_2.setBounds(141, 195, 117, 25);
		frame.getContentPane().add(btnPontos_2);
		
		JButton btnNormal_2 = new JButton("Normal");
		btnNormal_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GameTurboMalucoUI windowGame = new GameTurboMalucoUI(player1, player2, dif);
			}
		});
		btnNormal_2.setBounds(12, 195, 117, 25);
		frame.getContentPane().add(btnNormal_2);
		
		
		
		JRadioButton rdbtnMedicado = new JRadioButton("Medicado");
		rdbtnMedicado.setSelected(true);
		rdbtnMedicado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dif = 1;
			}
		});
		rdbtnMedicado.setBounds(8, 228, 98, 23);
		frame.getContentPane().add(rdbtnMedicado);
		
		JRadioButton rdbtnLoko = new JRadioButton("LOKO");
		rdbtnLoko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dif = 2;
			}
		});
		rdbtnLoko.setBounds(110, 228, 74, 23);
		frame.getContentPane().add(rdbtnLoko);
		
		JRadioButton rdbtnAahhhhh = new JRadioButton("AAHHHHH!!!!!!");
		rdbtnAahhhhh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dif = 3;
			}
		});
		rdbtnAahhhhh.setBounds(188, 228, 154, 23);
		frame.getContentPane().add(rdbtnAahhhhh);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnMedicado);
		buttonGroup.add(rdbtnLoko);
		buttonGroup.add(rdbtnAahhhhh);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MenuPrincipal windowGame = new MenuPrincipal();
			}
		});
		btnVoltar.setBounds(351, 8, 77, 25);
		frame.getContentPane().add(btnVoltar);
	}
}
