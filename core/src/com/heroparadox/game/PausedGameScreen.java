/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
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
 
        // my games virtual width and height
        public final int V_WIDTH = 1024;
        public final int V_HEIGHT = 1280;

        private Viewport viewport;
        private OrthographicCamera camera;
        private SpriteBatch batch;
        private Texture image;
        Music music;
    
    

        public PausedGameScreen(GdxGame game){
            this.game = game;
            camera = new OrthographicCamera();
            viewport = new FitViewport(V_WIDTH, V_HEIGHT, camera);
            batch = new SpriteBatch();
            image = new Texture ("pauseScreen.png");
            music = Gdx.audio.newMusic(Gdx.files.internal("music/1.mp3"));
            music.setVolume(0.5f);                 // sets the volume to half the maximum volume
            music.setLooping(true);                // will repeat playback until music.stop() is called
        }
        
        @Override
        public void render(float delta) {
            // clear the screen with black
            Gdx.gl20.glClearColor(0, 0, 0, 1);
            Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
            
            music.play();
            //render the main menu picture
            if (Gdx.input.isKeyPressed(Keys.SPACE)) 
                game.setScreen(game.mainGame);
            else if(Gdx.input.isKeyPressed(Keys.ENTER))
                game.setScreen(game.mainMenuScreen);
                
            batch.begin();
        
            batch.draw(logo, delta, delta);
       
            batch.end();
                      
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
