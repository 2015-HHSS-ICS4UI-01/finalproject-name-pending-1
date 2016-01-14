/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.badlogic.gdx.math.Vector2;

/**
 *creates the attack foot for the boss(which is essentially the boss)
 * @author NamePending
 */
public class GolemFoot extends Entity {

    public enum State {

        STANDING, ATTACKING, LIFTING, STUCK
    }
    private final float TERMINAL_VELOCITY = 4f;
    private float stateTime, health;
    private State state;
    private Vector2 velocity;

    public GolemFoot(float x, float y, float width, float height) {
        super(x, y, width, height);
        stateTime = 0;
        state = State.STANDING;
        velocity = new Vector2(0, 0);
        health = 9;
    }

    /**
     *returns the time the golem has been in a state
     * @return state time
     */
    public float getStateTime() {
        return stateTime;
    }

    /**
     *returns the current state of the golem
     * @return state
     */
    public State getState() {
        return state;
    }

    /**
     *gets the side to side velocity of the golem
     * @return velocity in the x-axis
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