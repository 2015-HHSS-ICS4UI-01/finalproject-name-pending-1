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
 * @author NamePending
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
        atlas = new TextureAtlas("Pictures for project.pack");
        PlayerStand = atlas.findRegion("white.png");
        DirtFloor = atlas.findRegion("Dirt.png");
        background = atlas.findRegion("background.png");
        
//        Array<AtlasRegion> run = atlas.findRegion(walk);
//        PlayerWalk = new Animation(0.1f, walk);
        
        
        
    }
}
