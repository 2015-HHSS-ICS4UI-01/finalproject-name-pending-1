/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;

/**
 *
 * @author tituo4996
 */
public class PausedGameScreen implements Screen {

    GdxGame game;
    
    public PausedGameScreen(GdxGame game){
        this.game = game;
    }
    
    @Override
    public void render(float delta) {
        //render the paused screen picture
        if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
            game.setScreen(game.mainMenuScreen);
        }else if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
            game.setScreen(game.mainGame);
        }
        
    }

    @Override
    public void resize(int i, int i1) {
        
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

    @Override
    public void show() {
    }
    
}
