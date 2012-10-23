package displaytest;

import java.awt.Graphics;

public class SpriteLayer {

	Sprite[] sprites;
	int sprn = 0; 
	
	public SpriteLayer(){
		sprites = new Sprite[1000];
	}
	
	public void addSprite(Sprite spr){
		sprites[sprn]=spr;
		sprn++;
		spr.parent = this;
	}
	
	public void draw( Graphics g ){
		for( Sprite s : sprites) {
			if( s != null ){
				s.draw(g);
			}
		}
	}
	
	public Sprite[] getSprites(){
		return sprites;
	}
	
	public void update(){
		for( Sprite s : sprites) {
			if( s != null ){
				s.update();
			}
		}
	}
}
