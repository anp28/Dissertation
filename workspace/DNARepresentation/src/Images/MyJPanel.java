package Images;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MyJPanel extends JPanel{
	
	Image img;
	
	public void setImage(Image i){
		img = i;
	}
	
	@Override
	public void paint(Graphics g){
		g.drawImage(img, 0,0,null);
	}
	

}
