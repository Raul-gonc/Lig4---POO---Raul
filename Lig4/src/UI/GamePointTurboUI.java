package UI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import Game.GameTurbo;
import Game.Player;
import Util.ValidateInput;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GamePointTurboUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameTurboUI window = new GameTurboUI();
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
	public GamePointTurboUI() {
		initialize(new Player("Sem Nome 1","y"), new Player("Sem Nome 2","r"));
		frame.setVisible(true);
	}
	public GamePointTurboUI(Player player1, Player player2) {
		initialize(player1, player2);
		frame.setVisible(true);
	}
	
	
	public void updateTable() {
		String[][] boardValues = game.getBoard().getBoardArray();
	    Color redColor = new Color(255, 0, 0); // Vermelho
	    Color yellowColor = new Color(255, 255, 0); // Amarelo
	    lblPlayer_1.setText(game.getPlayer().getName());
	    
	    if(!game.getBoard().verifyInsert(0)) {
	    	button_1.setEnabled(false);
	    }
		if(!game.getBoard().verifyInsert(1)) {
			button_2.setEnabled(false);
		}
		if(!game.getBoard().verifyInsert(2)) {
			button_3.setEnabled(false);
		}
		if(!game.getBoard().verifyInsert(3)) {
			button_4.setEnabled(false);
		}
		if(!game.getBoard().verifyInsert(4)) {
			button_5.setEnabled(false);
		}
		if(!game.getBoard().verifyInsert(5)) {
			button_6.setEnabled(false);
		}
		if(!game.getBoard().verifyInsert(6)) {
			button_7.setEnabled(false);
		}
	    
	    

	    JPanel[][] panels = {
	        { panel_0_0, panel_1_0, panel_2_0, panel_3_0, panel_4_0, panel_5_0, panel_6_0 },
	        { panel_0_1, panel_1_1, panel_2_1, panel_3_1, panel_4_1, panel_5_1, panel_6_1 },
	        { panel_0_2, panel_1_2, panel_2_2, panel_3_2, panel_4_2, panel_5_2, panel_6_2 },
	        { panel_0_3, panel_1_3, panel_2_3, panel_3_3, panel_4_3, panel_5_3, panel_6_3 },
	        { panel_0_4, panel_1_4, panel_2_4, panel_3_4, panel_4_4, panel_5_4, panel_6_4 },
	        { panel_0_5, panel_1_5, panel_2_5, panel_3_5, panel_4_5, panel_5_5, panel_6_5 }
	    };

	    for (int row = boardValues.length-1; row >= 0; row--) {
	        for (int col = 0; col < boardValues[row].length; col++) {
	            String value = boardValues[row][col];
	            if(value != null) {
	            	Color color = (value.equals("r")) ? redColor : (value.equals("y") ? yellowColor : Color.gray);
	            	panels[boardValues.length-row-1][col].setBackground(color);
	            }
	        }
	    }
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */	
	private JPanel panel_0_0 = new JPanel();
	private JPanel panel_0_1 = new JPanel();
	private JPanel panel_0_2 = new JPanel();
	private JPanel panel_0_3 = new JPanel();
	private JPanel panel_0_4 = new JPanel();
	private JPanel panel_0_5 = new JPanel();
	private JPanel panel_1_0 = new JPanel();
	private JPanel panel_1_1 = new JPanel();
	private JPanel panel_1_2 = new JPanel();
	private JPanel panel_1_3 = new JPanel();
	private JPanel panel_1_4 = new JPanel();
	private JPanel panel_1_5 = new JPanel();
	private JPanel panel_2_0 = new JPanel();
	private JPanel panel_2_1 = new JPanel();
	private JPanel panel_2_2 = new JPanel();
	private JPanel panel_2_3 = new JPanel();
	private JPanel panel_2_4 = new JPanel();
	private JPanel panel_2_5 = new JPanel();
	private JPanel panel_3_0 = new JPanel();
	private JPanel panel_3_1 = new JPanel();
	private JPanel panel_3_2 = new JPanel();
	private JPanel panel_3_3 = new JPanel();
	private JPanel panel_3_4 = new JPanel();
	private JPanel panel_3_5 = new JPanel();
	private JPanel panel_4_0 = new JPanel();
	private JPanel panel_4_1 = new JPanel();
	private JPanel panel_4_2 = new JPanel();
	private JPanel panel_4_3 = new JPanel();
	private JPanel panel_4_4 = new JPanel();
	private JPanel panel_4_5 = new JPanel();
	private JPanel panel_5_0 = new JPanel();
	private JPanel panel_5_1 = new JPanel();
	private JPanel panel_5_2 = new JPanel();
	private JPanel panel_5_3 = new JPanel();
	private JPanel panel_5_4 = new JPanel();
	private JPanel panel_5_5 = new JPanel();
	private JPanel panel_6_0 = new JPanel();
	private JPanel panel_6_1 = new JPanel();
	private JPanel panel_6_2 = new JPanel();
	private JPanel panel_6_3 = new JPanel();
	private JPanel panel_6_4 = new JPanel();
	private JPanel panel_6_5 = new JPanel();
	JLabel lblPlayer_1;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	
	GameTurbo game;
	Ranking rank = new Ranking();
	
	private void gameStart(Player player1, Player player2) {
		game = new GameTurbo(player1, player2);
	}
	
	private void endGame(Player player1, Player player2) {
		if(game.getBoard().verifyEnd()) {
			int p1 = game.getBoard().calculatePoints(player1.getPieceColor());
			int p2 = game.getBoard().calculatePoints(player2.getPieceColor());
			frame.dispose();
			
			if(p1 > p2) {
				rank.adicionarJogador(player1.getName());
				String mensagem = player1.getName()+" ganhou!\n"+player1.getName()+":"+p1+"\n"+player2.getName()+":"+p2;
		        JOptionPane.showMessageDialog(null, mensagem, "Fim", JOptionPane.INFORMATION_MESSAGE);
			}else if(p2 > p1) {
				rank.adicionarJogador(player2.getName());
				String mensagem = player2.getName()+" ganhou!\n"+player1.getName()+":"+p1+"\n"+player2.getName()+":"+p2;
		        JOptionPane.showMessageDialog(null, mensagem, "Fim", JOptionPane.INFORMATION_MESSAGE);
			}else {
				String mensagem = "Ouve um empate!";
		        JOptionPane.showMessageDialog(null, mensagem, "Empate", JOptionPane.INFORMATION_MESSAGE);
			}
			
			MenuPrincipal window = new MenuPrincipal();
		}
		
	}
	
	private void initialize(Player player1, Player player2) {
		frame = new JFrame();
		gameStart(player1, player2);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					game.makeMove(0);
					endGame(player1, player2);
					game.switchPlayer();
					updateTable();
				} catch (ValidateInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					game.makeMove(1);
					endGame(player1, player2);
					game.switchPlayer();
					updateTable();
				} catch (ValidateInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					game.makeMove(2);
					endGame(player1, player2);
					game.switchPlayer();
					updateTable();
				} catch (ValidateInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					game.makeMove(3);
					endGame(player1, player2);
					game.switchPlayer();
					updateTable();
				} catch (ValidateInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					game.makeMove(4);
					endGame(player1, player2);
					game.switchPlayer();
					updateTable();
				} catch (ValidateInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					game.makeMove(5);
					endGame(player1, player2);
					game.switchPlayer();
					updateTable();
				} catch (ValidateInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					game.makeMove(6);
					endGame(player1, player2);
					game.switchPlayer();
					updateTable();
				} catch (ValidateInput e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JLabel lblPlayer = new JLabel("Turno:");
		
		lblPlayer_1 = new JLabel(game.getPlayer().getName());
		
		panel_0_5.setBackground(new Color(186, 189, 182));
		
		panel_1_5.setBackground(new Color(186, 189, 182));
		
		panel_2_5.setBackground(new Color(186, 189, 182));
		
		panel_3_5.setBackground(new Color(186, 189, 182));
		
		panel_4_5.setBackground(new Color(186, 189, 182));
		
		panel_5_5.setBackground(new Color(186, 189, 182));
		
		panel_6_5.setBackground(new Color(186, 189, 182));
		
		panel_0_4.setBackground(new Color(186, 189, 182));
		
		panel_1_4.setBackground(new Color(186, 189, 182));
		
		panel_2_4.setBackground(new Color(186, 189, 182));
		
		panel_3_4.setBackground(new Color(186, 189, 182));
		
		panel_4_4.setBackground(new Color(186, 189, 182));
		
		panel_5_4.setBackground(new Color(186, 189, 182));
		
		panel_6_4.setBackground(new Color(186, 189, 182));
		
		panel_0_3.setBackground(new Color(186, 189, 182));
		
		panel_1_3.setBackground(new Color(186, 189, 182));
		
		panel_0_2.setBackground(new Color(186, 189, 182));
		
		panel_0_1.setBackground(new Color(186, 189, 182));
		
		panel_0_0.setBackground(new Color(186, 189, 182));
		
		panel_1_2.setBackground(new Color(186, 189, 182));
		
		panel_1_1.setBackground(new Color(186, 189, 182));
		
		panel_1_0.setBackground(new Color(186, 189, 182));
		
		panel_2_0.setBackground(new Color(186, 189, 182));
		
		panel_3_0.setBackground(new Color(186, 189, 182));
		
		panel_4_0.setBackground(new Color(186, 189, 182));
		
		panel_5_0.setBackground(new Color(186, 189, 182));
		
		panel_6_0.setBackground(new Color(186, 189, 182));
		
		panel_6_1.setBackground(new Color(186, 189, 182));
		
		panel_5_1.setBackground(new Color(186, 189, 182));
		
		panel_4_1.setBackground(new Color(186, 189, 182));
		
		panel_3_1.setBackground(new Color(186, 189, 182));
		
		panel_2_1.setBackground(new Color(186, 189, 182));
		
		panel_2_2.setBackground(new Color(186, 189, 182));
		
		panel_2_3.setBackground(new Color(186, 189, 182));
		
		panel_3_3.setBackground(new Color(186, 189, 182));
		
		panel_3_2.setBackground(new Color(186, 189, 182));
		
		panel_4_3.setBackground(new Color(186, 189, 182));
		
		panel_4_2.setBackground(new Color(186, 189, 182));
		
		panel_5_3.setBackground(new Color(186, 189, 182));
		
		panel_5_2.setBackground(new Color(186, 189, 182));
		
		panel_6_3.setBackground(new Color(186, 189, 182));
		
		panel_6_2.setBackground(new Color(186, 189, 182));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_0_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPlayer))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_1_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_2_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_3_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_4_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_5_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_6_5, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPlayer_1))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_0_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_5_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_6_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_0_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_5_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_6_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_0_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_5_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_6_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_0_0, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_1_0, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_2_0, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_3_0, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_4_0, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_5_0, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_0_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_4_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_6_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_6_0, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2)
						.addComponent(button_3)
						.addComponent(button_4)
						.addComponent(button_5)
						.addComponent(button_6)
						.addComponent(button_7)
						.addComponent(lblPlayer, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_0_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_6_5, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_0_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_6_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_0_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_6_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_6_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_0_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_0_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_6_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_0_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_6_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblPlayer_1))
					.addGap(46))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
