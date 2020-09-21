package othetoe;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	ImageIcon playerImage;
	String playerName;
	int point;
	boolean playerTurn;
	Player(ImageIcon playerImage, String playerName){
		Image resized= playerImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		this.playerImage = new ImageIcon(resized);
		this.playerName = playerName;
	}
	
}
