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
    
    //game screens
    public static TextureRegion startScreen;
    public static TextureRegion pauseScreen;
    
    //bosses
    public static TextureRegion kingBoss;
    public static TextureRegion knightBoss;
    public static TextureRegion turtleBoss;
    
    //floors
    public static TextureRegion dirtFloor;
    public static TextureRegion brickFloor;
    public static TextureRegion castleFloor;
    
    //player
    public static TextureRegion player;
    public static Animation playerWalk;
    public static Animation playerWalkL;
    
    //background
    public static TextureRegion background;
    
    public static void load(){
        atlas = new TextureAtlas("pack.pack");
        player = atlas.findRegion("mitch");
        dirtFloor = atlas.findRegion("grassFloor");
        brickFloor = atlas.findRegion("brickFloor");
        background = atlas.findRegion("background");
        startScreen = atlas.findRegion("startScreen");
        pauseScreen = atlas.findRegion("pauseScreen");
        
//        Array<AtlasRegion> run = atlas.findRegion(walk);
//        PlayerWalk = new Animation(0.1f, walk);
//        walk = atlas.findRegions("walk");
//        PlayerWalkL = new Animation(0.1f, walk);
//        for(TextureRegion r: PlayerWalkL.getKeyFrames()){
//            r.flip(true, false);
//        }
        
        
    }
}
