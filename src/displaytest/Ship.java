package displaytest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship extends Sprite implements KeyListener {
	
	private int moveSpeed = 5;
	
	public Ship(int a, int b){
		super(GameImages.image_ship, a, b);
	}
	
	@Override
	public void update(){
		
	}
	
	//Key listener stuff

	@Override
	public void keyPressed(KeyEvent e) {
		if( e.getKeyChar() == 'a'){
			x -= moveSpeed;
		}else if( e.getKeyChar() == 'd'){
			x += moveSpeed;
		}
		
		if( e.getKeyChar() == 'p'){
			DisplayTest.updateRate++;
			System.out.println(DisplayTest.updateRate);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
