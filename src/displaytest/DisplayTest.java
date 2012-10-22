package displaytest;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DisplayTest extends JFrame implements Runnable {
	
	public static int updateRate = 10;
	public static DisplayTest main;
	
	GraphicsDevice device;
	
	Image offscreen;
	
	SpriteLayer spl;
	
	Ship ship;
	
	public DisplayTest(){
		
	    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    device = env.getDefaultScreenDevice();
		
	    //load content
	    loadContent();
	    
	    
	    //window stuff
	    this.setVisible(true);
	    device.setFullScreenWindow( this );

	    //graphics buffer init
        offscreen = createImage(this.getWidth(),this.getHeight()); 
        
	    //create stage
	    createStage();
	    
	    //update thread
	    new Thread( this ).start();
		
	}
	
	public void loadContent(){
		GameImages.loadImages();
	}
	
	public void createStage(){
		int width = this.getWidth();
		int height = this.getHeight();
		//Create sprite layer
		spl = new SpriteLayer();
		//Create Ship
		ship = new Ship(width/2, 3*height/4);
		this.addKeyListener(ship);

		spl.addSprite(ship);
	}
	
	public void draw( Graphics g ){
		//
		Graphics buffer = offscreen.getGraphics();
		//draw background
		buffer.drawImage(GameImages.image_back, 0, 0, this.getWidth(), this.getHeight(), null);
		
		spl.draw(buffer);

        g.drawImage(offscreen,0,0,this); 
		g.dispose();
	}

	@Override
	public void run() {
		while( true ){
			if(GameImages.loaded){
				draw( this.getGraphics() );
			}
			try {
				Thread.sleep(updateRate);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]){
		main = new DisplayTest();
	}
	
}
