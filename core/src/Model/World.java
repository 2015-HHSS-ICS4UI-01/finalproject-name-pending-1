/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.badlogic.gdx.utils.Array;

/**
 *
 * @author janaj4926
 */
public class World {

    private Array<Floor> floors;
    private Player player;
    private final Array<Floor> floorsBrick;

    public World() {
        
        player = new Player(1280, 100, 100, 200);
        floors = new Array<Floor>();
        floorsBrick = new Array<Floor>();
        
        demoLevel();
        
    }

    public void demoLevel() {

        for (int i = 0; i < 101; i++) {
            Floor b = new Floor(i * 100, 0, 100, 100);
            floors.add(b);
        }
        for (int i = 0; i < 5; i++) {
            Floor b = new Floor(-100,i*100,100,100);
            floorsBrick.add(b);
        }
    }

    public void update(float deltaTime) {
    }

    public Player getPlayer() {
        return player;
    }

    public Array<Floor> getFloor() {
        return floors;  
    }
    
    public Array<Floor> getFloorBrick(){
        return floorsBrick;
    }
    
    
}
