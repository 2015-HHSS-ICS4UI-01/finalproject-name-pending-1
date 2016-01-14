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
 * @author NamePending
 */
public class WorldRenderer {

    public final int WIDTH = 1000, HEIGHT = 1000;
    private OrthographicCamera camera;
    private Player player;
    private SpriteBatch batch;
    private Viewport viewport;
    private World world;
    private Floor floor;

    public WorldRenderer(World w) {
        world = w;
        player = world.getPlayer();
        camera = new OrthographicCamera();
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        batch = new SpriteBatch();
        camera.position.x = WIDTH / 2;
        camera.position.y = HEIGHT / 2;
        AssetManager.load();
    }

    public void render(float deltaTime) {
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.x = Math.max(player.getX(), WIDTH / 2);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(AssetManager.background, 0, 1000);
        for (Floor f : world.getFloor()) {
            batch.draw(AssetManager.DirtFloor, f.getX(), f.getY());
        }
        if (player.getState() == Player.State.STANDING) {
            batch.draw(AssetManager.PlayerStand, 500, 500, 25, 25);
        }
        System.out.println("Tries to draw stuff but fails miserably");
        batch.end();
    }
}
