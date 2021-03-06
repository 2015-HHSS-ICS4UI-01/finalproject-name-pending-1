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
    //create the variables
    private Array<Floor> floors;
    private Player player;
    private KingBoss king;
    private GoldBlock gold;
    private TurtleBoss turtle;
    private Sword sword;
    private final Array<Floor> floorsBrick;

    /*
    set the vairables actual values
    */
    public World() {
        player = new Player(0, 100, 100, 200);
        king = new KingBoss(6400, 100, 100, 200);
        gold = new GoldBlock(6400, 100, 20, 10);
        turtle = new TurtleBoss(3040, 100, 320, 140,3);
        sword = new Sword(player.getX()+player.getWidth(),player.getY()/2,181,70);
        floors = new Array<Floor>();
        floorsBrick = new Array<Floor>();
        demoLevel();
    }

    /*
    create the blocks and their positions
    */
    public void demoLevel() {

        for (int i = 0; i < 50; i++) {
            Floor b = new Floor(i * 100, 0, 100, 100);
            floors.add(b);
        }
        for (int i = 50; i < 110; i++) {
            Floor c = new Floor(i*100,0,100,100);
            floorsBrick.add(c);
        }
    }

    public void update(float deltaTime) {
    }
    
    //return the player's postion
    public Player getPlayer() {
        return player;
    }

    //return the floor array
    public Array<Floor> getFloor() {
        return floors;  
    }
    
    //return the brick floor array
    public Array<Floor> getFloorBrick(){
        return floorsBrick;
    }

    //return the king and its position
    public KingBoss getKing() {
        return king;
    }
    
    //return the gold's position
    public GoldBlock getGold() {
        return gold;
    }
    
    //return the turtle's position
    public TurtleBoss getTurtle() {
        return turtle;
    }
    
    //reutrn the sword's postion
    public Sword getSword(){
        return sword;
    }
    
    
}
