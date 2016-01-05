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
        
    }
}
