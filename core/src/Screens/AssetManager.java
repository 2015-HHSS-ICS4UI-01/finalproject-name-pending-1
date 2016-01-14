/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author janaj4926
 */
public class AssetManager {
    private static TextureAtlas atlas;
    
    //bosses
    public static TextureRegion GolemBoss;
    public static TextureRegion KingBoss;
    public static TextureRegion KnightBoss;
    public static TextureRegion TurtleBoss;
    
    //floors
    public static TextureRegion DirtFloor;
    public static TextureRegion SandFloor;
    public static TextureRegion CastleFloor;
    
    //player
    public static TextureRegion PlayerStand;
    public static Animation PlayerWalk;
    public static Animation PlayerWalkL;
    
    //background
    public static TextureRegion background;
    
    public static void load(){
        atlas = new TextureAtlas("starter pack.pack");
        PlayerStand = atlas.findRegion("Mitch");
        DirtFloor = atlas.findRegion("Dirt");
        background = atlas.findRegion("start screen");
        
//        Array<AtlasRegion> run = atlas.findRegion(walk);
//        PlayerWalk = new Animation(0.1f, walk);
//        walk = atlas.findRegions("walk");
//        PlayerWalkL = new Animation(0.1f, walk);
//        for(TextureRegion r: PlayerWalkL.getKeyFrames()){
//            r.flip(true, false);
//        }
        
        
    }
}
