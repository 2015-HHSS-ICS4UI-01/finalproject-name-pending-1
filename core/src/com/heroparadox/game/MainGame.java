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

/**
 *
 * @author janaj4926
 */
public class MainGame implements Screen {

    private World world;
    private Player player;
    private WorldRenderer renderer;
    GdxGame game;

    public MainGame(GdxGame game) {
        this.game = game;
        world = new World();
        player = world.getPlayer();
        renderer = new WorldRenderer(world);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float deltaTime) {
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            game.changeScreen(game.pausedGameScreen);
        }
        if (player.getState() != Player.State.FALLEN && player.getState() != Player.State.FROZEN) {
            if (Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D)) {
                player.setVelX(-3f);
//                System.out.println(player.getVelX());
            }
            if (Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.A)) {
                player.setVelX(3f);
//                System.out.println(player.getVelX());
            }
            System.out.println(player.getVelY());
            if (Gdx.input.isKeyPressed(Keys.SPACE)) {
                player.jump();
            }
        }
//        System.out.println(player.getX());
        player.update(deltaTime);
        //go through each block
        for (Floor b : world.getFloor()) {
            //if mario is hitting a bloclk
            if (player.isColliding(b)) {
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
                        if (player.getY() > b.getY()) {
                            player.addToPosition(0f, overY);
//                            if(player.getState() == player.State.JUMPING)
//                                player.setState(player.State.STANDING);
                        } else {
                            player.addToPosition(0f, -overY);

                        }
                        player.setVelY(0f);
                    }
                }
            }
        }
        System.out.println(player.getVelY());

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
