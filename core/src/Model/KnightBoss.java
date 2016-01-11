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
    private float stateTime, health;
    private State state;
    private Vector2 velocity;

    public KnightBoss(float x, float y, float width, float height) {
        super(x, y, width, height);
        isFacingLeft = true;
        stateTime = 0;
        state = State.STANDING;
        velocity = new Vector2(0, 0);
        health = 9;
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
}
