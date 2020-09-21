package othetoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Cell extends JButton{
	int locX;
	int locY;
	Player player;
	Player exPlayer;
	
	
//	status : 2x point, 3x point, 4x, skip other player move, increase undo;
	
	public Cell(int size, int locX, int locY) {
		this.locX = locX;
		this.locY = locY;
		this.setPreferredSize(new Dimension(size,size));
		this.setFocusable(false);
		this.setOpaque(true);
		this.setBackground(Color.lightGray);
		this.setBorder( new LineBorder(Color.darkGray) );
	}
	
}
