package displaytest;

import java.awt.Graphics;
import java.awt.Image;

public class Sprite {
	
	private Image image;
	protected int x;
	protected int y;
	protected int rotation;
	
	public Sprite(Image img, int a, int b){
		image = img;
		x = a;
		y = b;
	}
	
	public void draw(Graphics g){
		g.drawImage(image, x, y, null);
	}
	
	public void update(){
		//for override
	}
	
	
}
