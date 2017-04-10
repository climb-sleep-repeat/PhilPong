package ponggame.framework;

import java.util.ArrayList;

public class CollisionManager {

	private ArrayList<CollisionObject> collisionList;
	
	public CollisionManager() {
		collisionList = new ArrayList<CollisionObject>();
	}

	public void AddCollisionObject(CollisionObject co){
		collisionList.add(co);
	}
	
	public void DeleteCollisionObject(CollisionObject co){
		collisionList.remove(co);
	}
	
	public boolean CheckForCollisions(){
		boolean found = false;
		for (int i = 0; i < collisionList.size()-1; i++){
			for(int j = 1; j < collisionList.size(); j++){
				if(collisionList.get(i).r.intersects(collisionList.get(j).r)){
					collisionList.get(i).HandleCollision();
					collisionList.get(j).HandleCollision();
					found = true;
				}
			}
		}
		return found;
	}
}
