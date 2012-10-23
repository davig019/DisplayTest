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
	    //window stuff
	    this.setVisible(true);
	    this.setResizable(false);
	    device.setFullScreenWindow( this );
	    //load content
	    loadContent();
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
		GameImages.loadImages(this);
	}
	
	public void createStage(){
		int width = this.getWidth();
		int height = this.getHeight();
		//Create sprite layer
		spl = new SpriteLayer();
		//Create Ship
		ply = new Player(width/2, 3*height/4);
		spl.addSprite(ply);
		//create platforms
		Sprite box = new Sprite(GameImages.image_platform, width/2 - 300, 3*height/4 + 100);
		spl.addSprite(box);
		Sprite box2 = new Sprite(GameImages.image_platform_tall, width/2 - 900, 3*height/4 + 30);
		spl.addSprite(box2);
		Sprite box3 = new Sprite(GameImages.image_platform_tall, width/2 + 300, 3*height/4 + 30);
		spl.addSprite(box3);
		//
		for( int i = 0; i < 18; i++){
			Crate crate = new Crate(width/2-900 + 100*i, -100-(int)(Math.random()*900));
			spl.addSprite(crate);
		}
	}
	
	public void update(){
		spl.update();
	}
	
	public void draw( Graphics g ){
		Graphics buffer = offscreen.getGraphics();
		//draw background
		buffer.drawImage(GameImages.image_back, 0, 0, this.getWidth(), this.getHeight(), null);
		//draw all sprites in sprite layer
		spl.draw(buffer);
		//draw hud
		buffer.drawImage(GameImages.image_hp, 30, 30, ply.getHealth(), 30, null);
		buffer.setColor(Color.black);
		buffer.drawString("HP : "+ply.getHealth(), 50, 50);
		//draw buffer to screen
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
