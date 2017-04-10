package ponggame;

import ponggame.framework.CollisionObject;

public class Ball extends CollisionObject{
	private int x;
	private int y;
	private int speedX;
	private int speedY;
	private int left_bound = 0;
	private int right_bound = 800;
	private int top_bound = 0;
	private int bot_bound = 480;
	private int diameter = 10;
	
	public Ball(int x, int y, int speedX, int speedY) {
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		super.getRectangle().setBounds(x,y,diameter,diameter);
	}
	
	public void update(){
		if(x > right_bound)
			speedX = speedX*(-1);
		if(y < top_bound || y > bot_bound)
			speedY = speedY*(-1);
		x += speedX;
		y += speedY;
		super.getRectangle().setLocation(x, y);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	@Override
	public void HandleCollision() {
		speedX = (-speedX)+1;
	}
}
