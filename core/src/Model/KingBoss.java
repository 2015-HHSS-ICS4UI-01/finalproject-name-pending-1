/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author NamePending
 */
public class KingBoss extends Entity {

    public enum State {

        STANDING, THROWING
    }
    private float stateTime;
    private State state;
    private int health;

    public KingBoss(float x, float y, float width, float height) {
        super(x, y, width, height);
        stateTime = 0;
        state = State.STANDING;
        health = 3;
    }

    public void update(float delta) {
        stateTime += delta;
    }
    
    public float getStateTime() {
        return stateTime;
    }

    public State getState() {
        return state;
    }

    public void setState(State s) {
        if (state != s) {
            stateTime = 0;
            state = s;
        }
    }
    
    public int getHealth(){
        return health;
    }
    
    public void loseHealth(){
        health--;
    }
    
    public boolean isAlive(){
        if (health==0)
            return false;
        else
            return true;
    }
}
