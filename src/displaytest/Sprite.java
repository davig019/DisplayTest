package displaytest;

import java.awt.Graphics;
import java.awt.Image;

public class Sprite {
	
	public SpriteLayer parent;
	private Image image;
	protected float x;
	protected float y;
	protected int rotation;
	
	public Sprite(Image img, int a, int b){
		image = img;
		x = a;
		y = b;
	}
	
	public void draw(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	public void update(){
		//for override
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public int getHeight(){
		return image.getHeight(null);
	}
	
	public int getWidth(){
		return image.getWidth(null);
	}
	
	public SpriteLayer getParent(){
		return parent;
	}
	
}
