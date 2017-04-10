package ponggame.framework;

import java.awt.Rectangle;

public class CollisionObject {
	Rectangle r;
	public CollisionObject() {
		// TODO Auto-generated constructor stub
		r = new Rectangle(0,0,0,0);
	}

	public Rectangle getRectangle(){
		return r;
	}
	
	public void HandleCollision(){
		
	}
}
