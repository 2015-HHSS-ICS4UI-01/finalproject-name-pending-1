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
        STANDING, THROWING, ATTACKING, JUMPING
    }
    
    public KingBoss(float x, float y, float width, float height) {
        super(x, y, width, height);
    }
}
