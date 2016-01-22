/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author NamePending
 */
public class KnightBoss extends Entity {

    public enum State {

        STUNNED, CHARGING, STANDING
    }
    private boolean isFacingLeft;
    private final float MAX_VELOCITY = 4f, DAMP = 0.9f;
    private float stateTime;
    private State state;
    private Vector2 velocity;
    private int health;

    public KnightBoss(float x, float y, float width, float height,int health) {
        super(x, y, width, height);
        isFacingLeft = true;
        stateTime = 0;
        state = State.STANDING;
        velocity = new Vector2(0, 0);
        health = this.health;
    }

    public boolean isFacingLeft() {
        return isFacingLeft;
    }

    public float getStateTime() {
        return stateTime;
    }

    public State getState() {
        return state;
    }

    public float getVelX() {
        return velocity.x;
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
