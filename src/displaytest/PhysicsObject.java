package displaytest;

import java.awt.Image;

public class PhysicsObject extends Sprite {
	
	public static float g = 0.2f;
	
	protected float xVel = 0;
	protected float yVel = 0;
	protected float mass = 100;
	protected int hp;
	
	protected boolean friction = true;
	
	private boolean grounded = false;
	
	protected Sprite lastHit;
	
	public PhysicsObject(Image img, int a, int b){
		super(img, a, b);
	}
	
	@Override
	public void update(){
		move();
		if( friction ){
			if( grounded ){
				xVel *= 0.99;
			}else{
				xVel *= 0.98;
			}
		}
		force(0, g*mass);//gravity
	}
	
	private void move(){
		grounded = false;
		x += xVel;
		if( doHitTest() ){
			x -= xVel;
			xVel = 0;
			System.out.println("A");
		}
		y += yVel;
		if( doHitTest() ){
			y -= yVel;
			yVel = 0;
			if( lastHit.getY() > this.y ){
				grounded = true;
				if( lastHit instanceof PhysicsObject ){
					((PhysicsObject) lastHit).damage(10);
				}
			}else{
				if( lastHit instanceof PhysicsObject ){
					((PhysicsObject) lastHit).setGrounded(true);
				}
				damage(10);
			}
		}
	}
	
	private boolean doHitTest(){
		Sprite[] spr = this.getParent().getSprites();
		for( Sprite s : spr ){
			if( s != null && s!=this && this.hitTest(s) ){
				lastHit = s;
				return true;
			}
		}
		return false;
	}
	
	public void setMass(float m){
		mass = m;
	}
	
	public float getMass(){
		return mass;
	}
	
	public void force(float xf, float yf){
		yVel += yf / mass;
		xVel += xf / mass;
	}
	
	public boolean hitTest(Sprite spr){
		float x2 = spr.getX();
		float y2 = spr.getY();
		float width2 = spr.getWidth();
		float height2 = spr.getHeight();
		if( this.x + this.getWidth() > x2 && this.x < x2 + width2 && this.y + this.getHeight() > y2 && this.y < y2 + height2  ){
			return true;
		}
		return false;
	}
	
	public void setGrounded(boolean grounded){
		this.grounded = grounded;
	}
	
	public boolean isGrounded(){
		return grounded;
	}
	
	public void damage(int n){
		hp -= n;
	}
}
