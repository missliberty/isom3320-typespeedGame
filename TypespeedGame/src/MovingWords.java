
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovingWords extends JPanel{
	
	int x = 0;
	int y = 100;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gd = (Graphics2D)g;
		gd.drawString("Move text", x, y);
		
		try {
			Thread.sleep(100);
			x+=15;
		}
		catch (Exception e) {
			
}
		if(x>getWidth()) {
			x=0;
		}
		repaint();
	}
	
 

public static void moveWords() {
	
	JFrame f= new JFrame();
	f.setSize(500,500);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//f.add(First());
	f.setLocationRelativeTo(null);
	f.setVisible(true);
}

}
