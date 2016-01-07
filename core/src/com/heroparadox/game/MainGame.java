/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import Model.Player;
import Model.World;
import Screens.WorldRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;

/**
 *
 * @author janaj4926
 */
public class MainGame implements Screen {

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
        if (mitch.getState() != Player.State.FALLEN && mitch.getState() != Player.State.FROZEN) {
            if (Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isButtonPressed(Keys.BUTTON_L1) && !Gdx.input.isButtonPressed(Keys.BUTTON_R1) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
                mitch.setVelX(-2f);
                mitch.setState(Player.State.RUNNING);
                System.out.println("A");
            }
            if (Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isButtonPressed(Keys.BUTTON_L1) && !Gdx.input.isButtonPressed(Keys.BUTTON_R1) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
                mitch.setVelX(2f);
                mitch.setState(Player.State.RUNNING);
                System.out.println("D");
            }
            if (Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isButtonPressed(Keys.BUTTON_L1) && !Gdx.input.isButtonPressed(Keys.BUTTON_R1) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
                mitch.setState(Player.State.JUMPING);
                mitch.setVelY(4f);
                System.out.println("SPACE");
            }
            if (Gdx.input.isButtonPressed(Keys.BUTTON_L1) && !Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isButtonPressed(Keys.BUTTON_R1) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
                System.out.println("M1");
            }
            if (Gdx.input.isButtonPressed(Keys.BUTTON_R1) && !Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isButtonPressed(Keys.BUTTON_L1) && !Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
                System.out.println("R1");
            }
            if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) && !Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.SPACE) && !Gdx.input.isButtonPressed(Keys.BUTTON_L1) && !Gdx.input.isButtonPressed(Keys.BUTTON_R1)) {
                System.out.println("SHIFT");
            }
        }
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