/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

/**
 *
 * @author tituo4996
 */


import Screens.AssetManager;
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
 
public class MainMenuScreen implements Screen {
 

       GdxGame game; // Note it's "MyGame" not "Game"
 
        // my games virtual width and height
        public final int V_WIDTH = 1024;
        public final int V_HEIGHT = 1280;

        private Viewport viewport;
        private OrthographicCamera camera;
        private SpriteBatch batch;
        private Music music;
        float position;

        public MainMenuScreen(GdxGame game){
            this.game = game;
            camera = new OrthographicCamera();
            viewport = new FitViewport(V_WIDTH, V_HEIGHT, camera);
            batch = new SpriteBatch();
            music = Gdx.audio.newMusic(Gdx.files.internal("music/1.mp3"));
            music.setVolume(0.5f);                 // sets the volume to half the maximum volume
            music.setLooping(true);                // will repeat playback until music.stop() is called
            AssetManager.load();
        }
        
        @Override
        public void render(float delta) {
            // clear the screen with black
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
            
        music.play();
        //render the main menu picture
        if (Gdx.input.isButtonPressed(Keys.BUTTON_L1)){ 
            game.setScreen(game.mainGame); 
        }
             
         batch.begin();
         // list of things to draw
         batch.draw(AssetManager.startScreen, 0, 0);
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

