/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author simma1980
 */
public class GoldBlock extends Entity {

    private Vector2 velocity;
    public GoldBlock(float x, float y, float width, float height) {
        super(x, y, width, height);
        velocity = new Vector2(0, 0);
    }

    public void update(float deltaTime) {
        velocity.x = 4f;
        addToPosition(velocity.x, 0);
    }
}
