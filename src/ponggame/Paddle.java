package ponggame;

import java.awt.Graphics;
import java.awt.Rectangle;
import ponggame.framework.CollisionObject;

public class Paddle extends CollisionObject{
	
	private int speed;
	private int position;
	private int bot;
	private int top;
	private int length;
	private int width = 10;
	private Rectangle r;
	
	public Paddle(int position, int botLimit, int topLimit, int length) {
		speed = 0;
		this.bot = botLimit;
		this.top = topLimit;
		this.length = length;
		this.position = position;
		super.getRectangle().setBounds(0, position, width, length);
	}
	
	public int getLength(){
		return length;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getBot() {
		return bot;
	}

	public void setBot(int bot) {
		this.bot = bot;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public void update(){
		if((position >= top + speed) && (position <= bot - length + speed)){
			position -= speed;	
		}
		super.getRectangle().setLocation(0, position);
	}

	public void moveUp(){
		speed = 6;
	}
	
	public void moveDown(){
		speed = -6;
	}
	
	public void stop(){
		speed = 0;
	}
	
	public void HandleCollision(){
		
	}
}
