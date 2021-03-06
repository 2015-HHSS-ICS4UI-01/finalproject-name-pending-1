/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

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
    public static TextureRegion playerJump;
    
    //background/environment
    public static TextureRegion background;
    public static TextureRegion coliseumEntrance;
    public static TextureRegion collumns;
    public static TextureRegion house;
    
    //items
    public static TextureRegion sword;
    public static TextureRegion shield;
    public static TextureRegion gold;
    
    public static void load(){
        atlas = new TextureAtlas("finalisimo.pack");
        //player
        player = atlas.findRegion("mitch");
        playerJump = atlas.findRegion("mitchJump");
        
        //floors
        dirtFloor = atlas.findRegion("grassFloor");
        brickFloor = atlas.findRegion("brickFloor");
        
        //background/environment
        background = atlas.findRegion("background");
        coliseumEntrance = atlas.findRegion("Coliseum");
        collumns = atlas.findRegion("Coliseum Pillars");
        house = atlas.findRegion("old man house");
        
        //game screens
        startScreen = atlas.findRegion("startScreen");
        pauseScreen = atlas.findRegion("pauseScreen");
        
        //bosses
        kingBoss = atlas.findRegion("king");
        turtleBoss = atlas.findRegion("turtle");
        
        //items
        sword = atlas.findRegion("Master sword");
        shield = atlas.findRegion("shield");
        gold = atlas.findRegion("gold bar");
        
//        Array<AtlasRegion> run = atlas.findRegion(playerWalk);
//        PlayerWalk = new Animation(0.1f, walk);
//        walk = atlas.findRegions("walk");
//        PlayerWalkL = new Animation(0.1f, walk);
//        for(TextureRegion r: PlayerWalkL.getKeyFrames()){
//            r.flip(true, false);
//        }
//        
        Array<TextureRegion> run = new Array<TextureRegion>();
        run.add(player);
        run.add(playerJump);
        playerWalk = new Animation(0.25f, run);
        
        Array<TextureRegion> runL = new Array<TextureRegion>();
        runL.add((new TextureRegion(player)));
        runL.add((new TextureRegion(playerJump)));
        playerWalkL = new Animation(0.25f, runL);
        for(TextureRegion r: playerWalkL.getKeyFrames()){
            r.flip(true, false);
        }
    }
}
