/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

/**
 *
 * @author tituo4996
 */


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
 
public class MainMenuScreen implements Screen {
 

       GdxGame game; // Note it's "MyGame" not "Game"
 
        // my games virtual width and height
        public final int V_WIDTH = 1024;
        public final int V_HEIGHT = 1280;

        private Viewport viewport;
        private OrthographicCamera camera;
        private SpriteBatch batch;
        private Texture image;
    
    

        public MainMenuScreen(GdxGame game){
            this.game = game;
            camera = new OrthographicCamera();
            viewport = new FitViewport(V_WIDTH, V_HEIGHT, camera);
            batch = new SpriteBatch();
            image = new Texture ("startScreen.png");
            
        }
        
        @Override
        public void render(float delta) {
            //render the main menu picture
             if (Gdx.input.isButtonPressed(Keys.BUTTON_L1)) 
                 game.setScreen(game.mainGame);
             
        batch.begin();
        // list of things to draw
        batch.draw(image, 0, 0);
        // finished listing things to draw
        batch.end(); 
                 
        }
 

       @Override
        public void resize(int width, int height) {
            viewport.update(width, height);
        }
 

       @Override
        public void show() {
             // called when this screen is set as the screen with game.setScreen();
        }
 

       @Override
        public void hide() {
             // called when current screen changes from this to a different screen
        }
 

       @Override
        public void pause() {
        }
 

       @Override
        public void resume() {
        }
 

       @Override
        public void dispose() {
                // never called automatically
        }
 }

