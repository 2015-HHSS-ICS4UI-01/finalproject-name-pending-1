/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.badlogic.gdx.math.Vector2;

/**
 *creates the final boss
 * @author NamePending
 */
public class KingBoss extends Entity {

    public enum State {

        STANDING, THROWING, ATTACKING, JUMPING, COLLECTING
    }
    private boolean isFacingLeft;
    private final float MAX_VELOCITY = 4f, TERMINAL_VELOCITY = 4f, DAMP = 0.9f;
    private float stateTime, health;
    private State state;
    private Vector2 velocity;

    public KingBoss(float x, float y, float width, float height) {
        super(x, y, width, height);
        isFacingLeft = true;
        stateTime = 0;
        state = State.STANDING;
        velocity = new Vector2(0, 0);
        health = 3;
    }

    /**
     *sees if the boss is facing left
     * @return true/false
     */
    public boolean isFacingLeft() {
        return isFacingLeft;
    }

    /**
     *gets the bosses time in a state 
     * @return state time
     */
    public float getStateTime() {
        return stateTime;
    }

    /**
     *finds the bosses state
     * @return state
     */
    public State getState() {
        return state;
    }

    /**
     *gets the side to side velocity of the king
     * @return velocity in x-axis
     */
    public float getVelX() {
        return velocity.x;
    }

    /**
     *gets the up and down velocity of the golem
     * @return velocity in the y-axis
     */
    public float getVelY() {
        return velocity.y;
    }
}