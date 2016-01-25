/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author janaj4926
 */
public class Sword extends Entity{
    
    public float x;
    public float width;
    
    public Sword(float x, float y, float width, float height) {
        super(x,y,width,height);
        x=this.x;
      
    }
    
    public void setX(float x){
        x=this.x;
    }
    
    public float getWidth(){
        return width;
    }
}
