package displaytest;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameImages {
	
	public static boolean loaded = false;

	public static Image image_player;
	public static Image image_back;
	public static Image image_platform;
	public static Image image_platform_tall;
	public static Image image_crate;
	
	public static Image image_hp;
	
	public static void loadImages(JFrame jf){
		
		try {
			image_player = ImageIO.read(new File("img/player.png"));
			image_back = ImageIO.read(new File("img/background.png"));
			image_crate = ImageIO.read(new File("img/crate1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		paintImages(jf);
		loaded = true;
	}
	
	public static void paintImages(JFrame jf){
		Graphics pg;


		image_platform_tall = jf.createImage(600,150);
		pg = image_platform_tall.getGraphics();
		pg.setColor(Color.gray);
		pg.fillRect(0, 0, 600, 150);
		
		image_platform = jf.createImage(600,80);
		pg = image_platform.getGraphics();
		pg.setColor(Color.gray);
		pg.fillRect(0, 0, 600, 80);
		
		image_hp = jf.createImage(100,30);
		pg = image_hp.getGraphics();
		pg.setColor(Color.red);
		pg.fillRect(0, 0, 100, 30);
	}
	
	
}
