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
public class TurtleBoss extends Entity {

    public enum State {

        SPINNING, DIZZY, STANDING;
    }
    private boolean isFacingLeft;
    public final float MAX_VELOCITY = 14f, DAMP = 0.9f;
    private float stateTime;
    private State state;
    private Vector2 velocity;
    private int health;
    
    public TurtleBoss(float x, float y, float width, float height, int health) {
        super(x, y, width, height);
        isFacingLeft = true;
        stateTime = 0;
        state = State.STANDING;
        velocity = new Vector2(0, 0);
        health = this.health;
    }
    
    public void update(float delta) {
        addToPosition(velocity.x, 0);
        stateTime += delta;
    }

    public void setState(State s) {
        if (state != s) {
            stateTime = 0;
            state = s;
        }
    }
    
    public State getState() {
        return state;
    }

    public void setVelX(float x){
        velocity.x=x;
    }
    
    public float getVelX() {
        return velocity.x;
    }
    
    public float getStateTime() {
        return stateTime;
    }
    
    public void setHealth(int health){
        health=this.health;
    }
    
    public int getHealth(){
        return health;
    }
    
    
    public boolean isAlive(){
        if (health==0)
            return false;
        else
            return true;
    }
    
    public void setState(State s) {
        if (state != s) {
            stateTime = 0;
            state = s;
        }
    }
    
    public void setVelX(float x) {
        velocity.x = x;
    }
}
