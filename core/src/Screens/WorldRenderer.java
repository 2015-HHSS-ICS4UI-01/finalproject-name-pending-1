/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Model.Floor;
import Model.Player;
import Model.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 *
 * @author janaj4926
 */
public final class WorldRenderer {

    public final int WIDTH = 1280, HEIGHT = 1024;
    private OrthographicCamera camera;
    private OrthographicCamera stationaryCamera;
    private Player player;
    private SpriteBatch batch;
    private Viewport viewport;
    private World world;
    private World floor;

    public WorldRenderer(World w) {

        world = w;
        player = world.getPlayer();


        camera = new OrthographicCamera();
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        stationaryCamera = new OrthographicCamera(WIDTH,HEIGHT);
        stationaryCamera.position.set(WIDTH/2, HEIGHT/2, 0);
        batch = new SpriteBatch();

        camera.position.x = WIDTH / 2;
        camera.position.y = HEIGHT / 2;
        camera.update();
        stationaryCamera.update();

        AssetManager.load();
        camera.update();
    
        batch.setProjectionMatrix(camera.combined);

    }

    public void resize(int width, int height) {
        viewport.update(width, height);
       
    }

    public void render(float deltaTime) {
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.x = Math.max(player.getX(), WIDTH / 2);
        camera.update();

        batch.setProjectionMatrix(stationaryCamera.combined);
        batch.begin();

        batch.draw(AssetManager.background, 0, 0);
        batch.end();
        
        
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        
        for (Floor f : world.getFloor()) {
            batch.draw(AssetManager.dirtFloor, f.getX(), f.getY(), 101, 100);
        }
//        if (player.getState() == Player.State.STANDING) {
            batch.draw(AssetManager.player, player.getX(), player.getY()-5); //draw the singe sprite right now
//        }
        batch.end();
        //System.out.println("I AM DRAWING");
    }
}
