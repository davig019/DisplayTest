package displaytest;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameImages {
	
	public static boolean loaded = false;

	public static Image image_player;
	public static Image image_back;
	
	public static void loadImages(){

		try {
			image_player = ImageIO.read(new File("img/player.png"));
			image_back = ImageIO.read(new File("img/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		loaded = true;
	}
	
	
}
