package displaytest;

import java.awt.Graphics;

public class SpriteLayer {

	Sprite sprites[];
	int sprn = 0; 
	
	public SpriteLayer(){
		sprites = new Sprite[100];
	}
	
	public void addSprite(Sprite spr){
		sprites[sprn]=spr;
		sprn++;
	}
	
	public void draw( Graphics g ){
		for( Sprite s : sprites) {
			if( s != null ){
				s.draw(g);
			}
		}
	}
	
	public void update(){
		for( Sprite s : sprites) {
			if( s != null ){
				s.update();
			}
		}
	}
}
