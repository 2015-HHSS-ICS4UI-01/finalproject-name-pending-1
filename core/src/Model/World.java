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

    private Array<Floor> Floors;
    private Player player;

    public World() {
        
        player = new Player(0, 50, 25, 25);
        Floors = new Array<Floor>();
        demoLevel();
        
    }

    public void demoLevel() {

        for (int i = 0; i < 50; i++) {
            Floor b = new Floor(i * 50, 0, 50, 50);
            Floors.add(b);
        }
    }

    public void update(float deltaTime) {
    }

    public Player getPlayer() {
        return player;
    }

    public Array<Floor> getFloor() {
        return Floors;
    }
}
