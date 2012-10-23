package displaytest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends PhysicsObject {
	
	private int moveSpeed = 5;
	
	public Player(int a, int b){
		super(GameImages.image_player, a, b);
		hp = 100;
		mass = 60;
	}
	
	@Override
	public void update(){
		Controller controls = DisplayTest.controls;
		if( controls.getKeyState(Controller.KEY_UP) && this.isGrounded()){
			force(0,-500);
		}
		if( controls.getKeyState(Controller.KEY_LEFT)){
			force(-50,0);
		}
		if( controls.getKeyState(Controller.KEY_RIGHT)){
			force(50,0);
		}
		super.update();
	}
	
	
	
	public int getHealth(){
		return hp;
	}
	
}
