package displaytest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Sprite {
	
	private int moveSpeed = 5;
	
	public Player(int a, int b){
		super(GameImages.image_player, a, b);
	}
	
	@Override
	public void update(){
		Controller controls = DisplayTest.controls;
		if( controls.getKeyState(Controller.KEY_UP)){
			this.y-=100;
		}
		
		System.out.println(Controller.KEY_DOWN);
	}
	
}
