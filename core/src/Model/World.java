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
    
    public World(){
        Floors = new Array<Floor>();
        demoLevel();
    }
    
    public void demoLevel(){
        player = new Player(16,16,16,32);
        for(int i = 0; i<50; i++){
            Floor b = new Floor(i*16,0,16,16);
            Floors.add(b);
        }
        
        Floors.add(new Floor(48,16,16,16));
        Floors.add(new Floor(96,32,16,16));
        Floors.add(new Floor(112,32,16,16));
        Floors.add(new Floor(128,96,16,16));
        Floors.add(new Floor(112,96,16,16));
    }
    
    public void update(float Delta){
        
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public Array<Floor> getFloor(){
        return Floors;
    }
}
