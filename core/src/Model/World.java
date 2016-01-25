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
    private KingBoss king;
    private GoldBlock gold;
    private TurtleBoss turtle;
    private Sword sword;
    private final Array<Floor> floorsBrick;

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

    public KingBoss getKing() {
        return king;
    }
    
    public GoldBlock getGold() {
        return gold;
    }
    
    public TurtleBoss getTurtle() {
        return turtle;
    }
    
    public Sword getSword(){
        return sword;
    }
    
    
}
