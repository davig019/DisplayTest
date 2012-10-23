package displaytest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

	public static final int KEY_UP = 0;
	public static final int KEY_DOWN = 1;
	public static final int KEY_LEFT = 2;
	public static final int KEY_RIGHT = 3;
	public static final int KEY_SPACE = 4;
	
	public boolean keyStatus[];
	
	public Controller(){
		keyStatus = new boolean[5];
		for( int i = 0; i < 5; i++){
			keyStatus[i] = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		toggleKey(e.getKeyChar(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		toggleKey(e.getKeyChar(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void toggleKey(char key, boolean status){
		switch( key ){
		case 'w':
			keyStatus[KEY_UP] = status;
			break;
		case 's':
			keyStatus[KEY_DOWN] = status;
			break;
		case 'a':
			keyStatus[KEY_LEFT] = status;
			break;
		case 'd':
			keyStatus[KEY_RIGHT] = status;
			break;
		case ' ':
			keyStatus[KEY_SPACE] = status;
			break;
		}
	}
	
	public boolean getKeyState(int key){
		return keyStatus[key];
	}
}
