/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import Model.Player;
import Model.World;
import Screens.WorldRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;

/**
 *
 * @author janaj4926
 */
public class MainGame implements Screen {

    private World world;
    private Player mitch;
    private WorldRenderer renderer;
    private int gameState;
    private GdxGame manager;

    public MainGame(GdxGame manager) {
        world = new World();
        mitch = world.getPlayer();
        renderer = new WorldRenderer(world);
        gameState = 0;
        this.manager = manager;
        
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float deltaTime) {
        if (mitch.getState() != Player.State.FALLEN && mitch.getState() != Player.State.FROZEN) {
            if (Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D)) {
                mitch.setVelX(-2f);
                mitch.setState(Player.State.RUNNING);
            } else if (Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.A)) {
                mitch.setVelX(2f);
                mitch.setState(Player.State.RUNNING);
            } else if (Gdx.input.isButtonPressed(Keys.BUTTON_L1)
                    && mitch.getState() != Player.State.JUMPING
                    && mitch.getState() != Player.State.THROWING
                    && mitch.getState() != Player.State.SLASHING) {
                mitch.setState(Player.State.SLASHING);
                mitch.setVelX(0f);
            }
        }
    }

    @Override
    public void resize(int width, int height) {
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
