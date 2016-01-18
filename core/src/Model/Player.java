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
public class Player extends Entity {

    public enum State {

        BLOCKING, ATTACKING, RUNNING, STANDING, FROZEN, JUMPING, CROUCHING, FALLEN
    }
    private boolean isFacingLeft;
    private final float MAX_VELOCITY = 2f, TERMINAL_VELOCITY = 6f, DAMP = 0.7f;
    private float stateTime;
    private State state;
    private Vector2 acceleration, velocity;
    private float x;

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
        isFacingLeft = false;
        stateTime = 0;
        state = State.STANDING;
        acceleration = new Vector2(0, 0);
        velocity = new Vector2(0, 0);      
    }

    public void update(float delta) {
        acceleration.y = -9.8f;
        
        velocity.mulAdd(acceleration, delta);
        
        velocity.x = velocity.x * DAMP;
        if (velocity.x < 0.01f && velocity.x > -0.01f) {
            velocity.x = 0;
        }
        addToPosition(velocity.x, velocity.y);
        
        isFacingLeft = false;
        if (state != State.RUNNING && state != State.JUMPING) {
            stateTime = 0;
            state = State.RUNNING;
        }
        if (velocity.x > 0) {
            isFacingLeft = false;
        } else if (velocity.x < 0) {
            isFacingLeft = true;
        } else {
            state = State.STANDING;
        }
        x = x+ velocity.x;
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

    public float getVelY() {
        return velocity.y;
    }

    public void setVelX(float x) {
        velocity.x = x;
    }

    public void setVelY(float y) {
        velocity.y = y;
    }

    public void setState(State s) {
        if (state != s) {
            stateTime = 0;
            state = s;
        }
    }

    public void jump() {
        if (state != State.JUMPING && velocity.y == 0) {
            velocity.y = TERMINAL_VELOCITY;
            state = State.JUMPING;
            stateTime = 0;
        }
    }
    
    public void setFacingL(boolean facingLeft) {
        isFacingLeft = facingLeft;
    }
}