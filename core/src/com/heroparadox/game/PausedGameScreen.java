/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

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

/**
 *
 * @author tituo4996
 */
public class PausedGameScreen implements Screen {

    //create the variables used
    GdxGame game; // Note it's "MyGame" not "Game"

    // the width and the height of the game
    public final int V_WIDTH = 1280;
    public final int V_HEIGHT = 1024;

    private Viewport viewport;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    Music music;


    /*
    sets the varibles values
    */
    public PausedGameScreen(GdxGame game){
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(V_WIDTH, V_HEIGHT, camera);
        batch = new SpriteBatch();
        music = Gdx.audio.newMusic(Gdx.files.internal("music/1.mp3"));
        music.setVolume(0.5f);                 // sets the volume to half the maximum volume
        music.setLooping(true);                // will repeat playback until music.stop() is called
        AssetManager.load();
        camera.position.set(V_WIDTH/2, V_HEIGHT/2, 0);
        camera.update();
    }

    @Override
    public void render(float delta) {
        // clear the screen with black
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        music.play();
        //changes the screen to the main game if space is pressed, the main menu if enter is pressed
        if (Gdx.input.isKeyPressed(Keys.SPACE)) 
            game.setScreen(game.mainGame);
        else if(Gdx.input.isKeyPressed(Keys.ENTER))
            game.setScreen(game.mainMenuScreen);
        
        //set the camera to be used with the the drawing
        batch.setProjectionMatrix(camera.combined);
        //start drawing
        batch.begin();
        
        //draw the paused screen picture
        batch.draw(AssetManager.pauseScreen, 0, 0);

        batch.end();
    }
 
        /*
        resize the screens size to the new widthe and height
        */
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
