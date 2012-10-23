package displaytest;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DisplayTest extends JFrame implements Runnable {
	
	public static DisplayTest main;
	public boolean open = true;
	public static Controller controls;
	
	GraphicsDevice device;
	Image offscreen;
	SpriteLayer spl;
	Player ply;
	
	public DisplayTest(){
		//Graphics environment
	    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    device = env.getDefaultScreenDevice();
	    //load content
	    loadContent();
	    //window stuff
	    this.setVisible(true);
	    device.setFullScreenWindow( this );
	    //controls initialisation
	    controls = new Controller();
	    this.addKeyListener(controls);
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
		ply = new Player(width/2, 3*height/4);
		
		spl.addSprite(ply);
	}
	
	public void update(){
		spl.update();
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
		while( open ){
			if(GameImages.loaded){
				update();
				draw( this.getGraphics() );
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]){
		main = new DisplayTest();
	}
	
}
