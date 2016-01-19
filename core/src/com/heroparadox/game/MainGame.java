/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import Model.Floor;
import Model.Player;
import Model.World;
import Screens.WorldRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

/**
 *
 * @author janaj4926
 */
public class MainGame implements Screen {

    private World world;
    private Player player;
    private WorldRenderer renderer;
    private Music music;
    GdxGame game;

    public MainGame(GdxGame game) {
        this.game = game;
        world = new World();
        player = world.getPlayer();
        renderer = new WorldRenderer(world);
        music = Gdx.audio.newMusic(Gdx.files.internal("music/1.mp3"));
        music.setVolume(0.5f);                 // sets the volume to half the maximum volume
        music.setLooping(true);                // will repeat playback until music.stop() is called        
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float deltaTime) {
        // clear the screen with black
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        music.play();
        
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) 
            game.changeScreen(game.pausedGameScreen);

        if (player.getState() != Player.State.FALLEN && player.getState() != Player.State.FROZEN) {
            if (Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D)) {
                player.setVelX(-7f);
            }
            if (Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.A)) {
                player.setVelX(7f);
            }
            if (Gdx.input.isKeyPressed(Keys.SPACE)) {
                player.jump();
            }
        }
        player.update(deltaTime);
        //go through each block
        for (Floor b: world.getFloor()){
            //if player is hitting a bloclk
            if(player.isColliding(b)){
                float overX = player.getOverlapX(b);
                float overY = player.getOverlapY(b);

                //just fixing the y if not moving
                if (player.getVelX() == 0f) {
                    //player is above the block
                    if (player.getY() > b.getY()) {
                        player.addToPosition(0f, overY);
                    } else {
                        player.addToPosition(0f, -overY);
                    }
                    //fix the smallest overlap
                    player.setVelY(0f);
                } else {
                    //fix the smallest overlap
                    if (overX < overY) {
                        //left of the block
                        if (player.getX() < b.getX()) {
                            player.addToPosition(-overX, 0f);
                        } else {
                            player.addToPosition(overX, 0f);
                        }
                    } else {
                        //player is above the block
                        if(player.getY() > b.getY()){
                            player.addToPosition(0, overY);
                            if(player.getState() == Player.State.JUMPING)
                                player.setState(Player.State.STANDING);
                        }else{
                            player.addToPosition(0, -overY);

                        }
                        player.setVelY(0f);
                    }
                    
                }
            }
        }
        
        for (Floor b: world.getFloorBrick()){
            //if player is hitting a bloclk
            if(player.isColliding(b)){
                float overX = player.getOverlapX(b);
                float overY = player.getOverlapY(b);

                //just fixing the y if not moving
                if (player.getVelX() == 0f) {
                    //player is above the block
                    if (player.getY() > b.getY()) {
                        player.addToPosition(0f, overY);
                    } else {
                        player.addToPosition(0f, -overY);
                    }
                    //fix the smallest overlap
                    player.setVelY(0f);
                } else {
                    //fix the smallest overlap
                    if (overX < overY) {
                        //left of the block
                        if (player.getX() < b.getX()) {
                            player.addToPosition(-overX, 0f);
                        } else {
                            player.addToPosition(overX, 0f);
                        }
                    } else {
                        //player is above the block
                        if(player.getY() > b.getY()){
                            player.addToPosition(0, overY);
                            if(player.getState() == Player.State.JUMPING)
                                player.setState(Player.State.STANDING);
                        }else{
                            player.addToPosition(0, -overY);

                        }
                        player.setVelY(0f);
                    }
                }
            }
        }
        
//      if (player.getState() != Player.State.FALLEN && player.getState() != Player.State.FROZEN) {
//          System.out.println(player.getState());
//          if ((player.getState() == Player.State.ATTACKING || player.getState() == Player.State.BLOCKING) && player.getStateTime() > 1f) {
//              player.setState(Player.State.STANDING);
//          }
//          if (player.getState() != Player.State.ATTACKING && player.getState() != Player.State.CROUCHING && player.getState() != Player.State.BLOCKING &&
//                  !Gdx.input.isButtonPressed(Buttons.LEFT) && !Gdx.input.isButtonPressed(Buttons.RIGHT)) {
//            if (Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D)) {
//                player.setVelX(-2f);
//                player.setState(Player.State.RUNNING);
//            }
//            if (!Gdx.input.isKeyPressed(Keys.A) && Gdx.input.isKeyPressed(Keys.D)) {
//                player.setVelX(2f);
//                player.setState(Player.State.RUNNING);
//            }
//          }
//          if (!Gdx.input.isKeyPressed(Keys.A) && Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) && !Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isButtonPressed(Buttons.LEFT) && !Gdx.input.isButtonPressed(Buttons.RIGHT)) {
//              player.setFacingL(false);
//          }
//          if (!Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) && !Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isButtonPressed(Buttons.LEFT) && !Gdx.input.isButtonPressed(Buttons.RIGHT)) {
//              
//          }
//          if (!Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) && Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isButtonPressed(Buttons.LEFT) && !Gdx.input.isButtonPressed(Buttons.RIGHT)) {
//              
//          }
//            if (!Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) && !Gdx.input.isKeyPressed(Keys.SPACE) && Gdx.input.isButtonPressed(Buttons.LEFT) && !Gdx.input.isButtonPressed(Buttons.RIGHT)) {
//                player.setState(Player.State.ATTACKING);
//            }
//            if (!Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) && !Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isButtonPressed(Buttons.LEFT) && Gdx.input.isButtonPressed(Buttons.RIGHT)) {
//                player.setState(Player.State.BLOCKING);
//            }
        
        renderer.render(deltaTime);
        }
        
    @Override
    public void resize(int width, int height) {
        renderer.resize(renderer.WIDTH, renderer.HEIGHT);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
