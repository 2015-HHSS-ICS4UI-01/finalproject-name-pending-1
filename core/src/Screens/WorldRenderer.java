/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

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
public class WorldRenderer {

    public final int WIDTH = 1000, HEIGHT = 1000;
    private OrthographicCamera camera;
    private Player mitch;
    private SpriteBatch batch;
    private Viewport viewport;
    private World world;

    public WorldRenderer(World w) {
        batch = new SpriteBatch();
        
        camera = new OrthographicCamera();
        camera.position.x = WIDTH / 2;
        camera.position.y = HEIGHT / 2;
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        
        world = w;
        mitch = world.getPlayer();
    }

    public void render(float deltaTime) {
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.x = Math.max(mitch.getX(), WIDTH / 2);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.end();
    }
}
