/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import Model.Player;
import Screens.WorldRenderer;
import com.badlogic.gdx.Screen;

/**
 *
 * @author janaj4926
 */
public class MainGame implements Screen{

    private World world;
    private Player mitch;
    private WorldRenderer renderer;
    
    public MainGame() {
        world = new World();
        mitch = world.getPlayer();
        renderer = new WorldRenderer(world);
    }
    
    @Override
    public void show() {
    }

    @Override
    public void render(float deltaTime) {
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