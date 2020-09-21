package othetoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JFrame implements ActionListener{
	int n = 10;
	int straight = 5;
	int panelSize = 500;
	int cellSize = panelSize/n;
	JPanel P1panel;
	JPanel P2panel;
	JPanel headPanel;
	JPanel powerPanel;
	JPanel gamePanel;
	Cell[][] cell = new Cell[n][n];
	
	Player player1;
	Player player2;
	
	int clicked = 0;
	
	public Board() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLayout(new BorderLayout(10,10));
		this.setSize(new Dimension(920,750));
		this.setResizable(false);
		this.getContentPane().setBackground (new Color(70,70,70));
		
		//panel preparation;
		P1panel = new JPanel();
		P2panel = new JPanel();
		headPanel= new JPanel();
		powerPanel = new JPanel();
		gamePanel = new JPanel();
		
//		P1panel.setLayout(new );
		P1panel.setPreferredSize(new Dimension(200,panelSize));
		P1panel.setBackground(new Color(8, 158, 158));
		
		P2panel.setPreferredSize(new Dimension(200,panelSize));
		P2panel.setBackground(new Color(158, 13, 66));
		
		gamePanel.setBackground(Color.lightGray);
		
		headPanel.setPreferredSize(new Dimension(3000,100));
		headPanel.setBackground(new Color(55,55,55));
		
		powerPanel.setPreferredSize(new Dimension(3000,100));
		powerPanel.setBackground(new Color(45,45,45));
		
		

		//player setup;
		ImageIcon p1Image = new ImageIcon("res/Cat.png");
		ImageIcon p2Image = new ImageIcon("res/Elephant.png");
		
		player1 = new Player(p1Image, "UDIN");
		player2 = new Player(p2Image, "LORD");
		
		
		
		//panel for palayer 1;
		
		JLabel p1Label = new JLabel(player1.playerName);
		p1Label.setIcon(player1.playerImage);
		P1panel.add(p1Label);
		
		
		//panel for player 2;
		JLabel p2Label = new JLabel(player2.playerName);
		p2Label.setIcon(player2.playerImage);
		P2panel.add(p2Label);
		
		//game panel;		
		JPanel insideGamePanel = new JPanel();
		insideGamePanel.setBackground(new Color(70,70,70));
		insideGamePanel.setLayout(new GridLayout(n,n,0,0));
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				cell[i][j] = new Cell(cellSize, i, j);
				cell[i][j].addActionListener(this);
				insideGamePanel.add(cell[i][j]);
			}
		}
		insideGamePanel.add(cell[0][0]);
		gamePanel.setLayout(new GridLayout());
		gamePanel.add(insideGamePanel);
		
		
		
		//adding component to frame
		
		this.add(headPanel, BorderLayout.NORTH);
		this.add(P1panel, BorderLayout.WEST);
		this.add(gamePanel, BorderLayout.CENTER);
		this.add(P2panel, BorderLayout.EAST);
		this.add(powerPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
//		System.out.println(cell[0][0].getWidth()+ " " + cell[0][0].getHeight());
	}
	
	boolean isDiagonalLeft(int x, int y) {
		int count  = 1;
		Cell core = cell[x][y];	
		
		for (int i = 1; i<straight; i++) {
			if ( x-i >= 0 && y-i>=0 ) {
				if (cell[x-i][y-i].player == core.player) {
					count++;
				}
				else {
					break;
				}
			}
		}
		
		for (int i = 1; i<straight; i++) {
			if ( x+i <n && y+i<n) {
				if (cell[x+i][y+i].player == core.player) {
					count++;
				}
				else {
					break;
				}
			}
		}
//		System.out.println(count +" "+ core.player.playerName);
		return count>=straight;
	}
	boolean isDiagonalRight(int x, int y) {
		int count  = 1;
		Cell core = cell[x][y];	
		
		for (int i = 1; i<straight; i++) {
			if ( x-i >= 0 && y+i<n ) {
				if (cell[x-i][y+i].player == core.player) {
					count++;
				}
				else {
					break;
				}
			}
		}
		
		for (int i = 1; i<straight; i++) {
			if ( x+i <n && y-i>=0) {
				if (cell[x+i][y-i].player == core.player) {
					count++;
				}
				else {
					break;
				}
			}
		}
//		System.out.println(count +" "+ core.player.playerName);
		return count>=straight;
	}
	boolean isVertical(int x, int y) {
		int count  = 1;
		Cell core = cell[x][y];	
		
		for (int i = 1; i<straight; i++) {
			if ( x-i >= 0 ) {
				if (cell[x-i][y].player == core.player) {
					count++;
				}
				else {
					break;
				}
			}
		}
		
		for (int i = 1; i<straight; i++) {
			if ( x+i <n ) {
				if (cell[x+i][y].player == core.player) {
					count++;
				}
				else {
					break;
				}
			}
		}
//		System.out.println(count +" "+ core.player.playerName);
		return count>=straight;
	}
	boolean isHorizontal(int x, int y) {
		int count  = 1;
		Cell core = cell[x][y];	
		
		for (int i = 1; i<straight; i++) {
			if (y+i<n ) {
				if (cell[x][y+i].player == core.player) {
					count++;
				}
				else {
					break;
				}
			}
		}
		
		for (int i = 1; i<straight; i++) {
			if ( y-i>=0) {
				if (cell[x][y-i].player == core.player) {
					count++;
				}
				else {
					break;
				}
			}
		}
//		System.out.println(count +" "+ core.player.playerName);
		return count>=straight;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for (int i = 0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (arg0.getSource() == cell[i][j]) {
					cell[i][j].setEnabled(false);
					if (clicked%2 == 0) {
						cell[i][j].setBackground(new Color(8, 158, 158));
						cell[i][j].player = player1;
					}
					else {
						cell[i][j].setBackground(new Color(158, 13, 66));
						cell[i][j].player = player2;
					}
					clicked++;
					System.out.println("=======================");
					System.out.println(cell[i][j].player.playerName);
					System.out.println("left " + isDiagonalLeft(i,j));
					System.out.println("right " + isDiagonalRight(i,j));
					System.out.println("vertical " + isVertical(i, j));
					System.out.println("horizontal " + isHorizontal(i, j));
				}
			}
		}
		
	}
	
}
