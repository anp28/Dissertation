package animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import Images.ImageUtilities;

public class AnimationGen extends ImageUtilities implements ActionListener {

	Timer t = new Timer(50, this);
	String[] animations = { "Circular Bounce", "Hex radiate", "Splash"};
	String currentAnimation;
	ArrayList<Circle> circles = new ArrayList<Circle>();
	int wait = 0, degradeTime = 20;
	int radius = 0;
	
	public String[] getAnimationList() {
		return animations;
	}

	public void start(String s) {
		currentAnimation = s;
		t.start();
	}
	
	public void stop(){
		radius = 0;
		wait = 0;
		circles= new ArrayList<Circle>(); 
		t.stop();
		makeBlank();
		//panel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (currentAnimation) {
		case "Circular Bounce":
			int[] bounceSpec = this.readNumFromSequence(1);
				drawCircle(panel.getWidth()/2, panel.getHeight()/2, radius, setColour( bounceSpec[0]));
				radius ++;
				
				if(radius >= panel.getWidth()/2)
					radius = 0;
				
			break;
			
		case "Hex radiate":
			degrade();
			short[] col = {255,255,255};
			/*
			int[] hexSpec = this.readNumFromSequence(3);
			short[] col = setColour(hexSpec[0]);
			int cRadius = hexSpec[1]*15;
			int extraRadius = hexSpec[2];
			
			drawFilledHex(panel.getWidth()/2, panel.getHeight()/2,  cRadius, col);
			drawHex(panel.getWidth()/2, panel.getHeight()/2,  cRadius+ radius + extraRadius, col);
			*/
			
			drawFilledHex(panel.getWidth()/2, panel.getHeight()/2,  50, col);
			drawHex(panel.getWidth()/2, panel.getHeight()/2,  50+ radius , col);
			
			if((50+ radius ) >= panel.getWidth()/2)
				radius = 0;
			
			radius ++;
			
			break;
			
		case "Splash":
			t.setDelay(75);
			degrade();
			if (wait == 0) {
				int[] spec = this.readNumFromSequence(5);
				Circle c = new Circle();
				c.setColour(setColour(spec[0]));
				c.setMaxRadius(spec[1]*10);
				c.setThickness(spec[2]);
				c.setX(spec[3]*100);
				c.setY(spec[4]*100);
				circles.add(c);
				wait = 20;
			}
			for(int i = 0; i < circles.size();i++){
				splash(circles.get(i));
				if(circles.get(i).getRadius() >= circles.get(i).getMaxRadius()){
					circles.remove(i);
				}
			}
			wait--;
			break;
		}
		
		paint(panel);
	}
	
	public void degrade(){
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (red[row][col] > degradeTime) {
					red[row][col] -= degradeTime;
				} else
					red[row][col] = 0;

				if (green[row][col] > degradeTime){
					green[row][col] -= degradeTime;
				} else
					green[row][col] = 0;

				if (blue[row][col] > degradeTime) {
					blue[row][col] -= degradeTime;
				} else
					blue[row][col] = 0;
			}

		}
		//image = makeNewBufferedImage(red, green, blue);
	}


	public void splash(Circle c) {
		for(int i = 0; i < c.getThickness(); i++){
			drawCircle(c.getX(), c.getY(), c.getRadius()+i, c.getColour()); 
			c.setRadius(c.getRadius() + 1);
		}

	}

}
