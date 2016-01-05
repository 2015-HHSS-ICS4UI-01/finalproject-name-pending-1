/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author NamePending
 */
public class TurtleBoss extends Entity {

    public TurtleBoss(float x, float y, float width, float height) {
        super(x, y, width, height);
    }
    
    public enum State{
        Attacking, Standing, Stunned
    }
}
