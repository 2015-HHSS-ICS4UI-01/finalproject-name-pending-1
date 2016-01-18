/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 *
 * @author tituo4996
 */
public class PausedGameScreen implements Screen {
GdxGame game; // Note it's "MyGame" not "Game"
 
        public final int WIDTH = 1000, HEIGHT = 1000;
        private Viewport viewport;
        private OrthographicCamera camera;
        private SpriteBatch batch;
        private Texture logo;
    
    

        public PausedGameScreen(GdxGame game){
            this.game = game;
            camera = new OrthographicCamera();
            viewport = new FitViewport(WIDTH, HEIGHT, camera);
            logo = new Texture("pauseScreen.png");
            
            camera.position.x = WIDTH / 2;
            camera.position.y = HEIGHT / 2;
            camera.update();
        }
        
        @Override
        public void render(float delta) {
            //render the main menu picture
            if (Gdx.input.isButtonPressed(Keys.SPACE)) 
                game.setScreen(game.mainGame);
            else if(Gdx.input.isButtonPressed(Keys.ESCAPE))
                game.setScreen(game.mainMenuScreen);
                
                logo = new Texture("pauseScreen.png");
                      
        }
 

       @Override
        public void resize(int width, int height) {
            viewport.update(width, height);
        }
 

       @Override
        public void show() {
        }
 

       @Override
        public void hide() {
        }
 

       @Override
        public void pause() {
        }
 

       @Override
        public void resume() {
        }
 

       @Override
        public void dispose() {
        }
}
