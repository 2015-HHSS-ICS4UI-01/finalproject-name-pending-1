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

        BLOCKING, SLASHING, SPEARING, RUNNING, STANDING, FROZEN, JUMPING
    }
    private boolean isFacingLeft;
    private final float MAX_VELOCITY = 2f, TERMINAL_VELOCITY = 4f, DAMP = 0.9f;
    private float stateTime;
    private State state;
    private Vector2 velocity;

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
        state = State.STANDING;
        velocity = new Vector2(0, 0);
        stateTime = 0;
        isFacingLeft = false;
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
}