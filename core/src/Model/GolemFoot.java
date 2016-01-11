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