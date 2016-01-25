/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import Model.Floor;
import Model.GoldBlock;
import Model.KingBoss;
import Model.Player;
import Model.Sword;
import Model.TurtleBoss;
import Model.World;
import Screens.WorldRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;

/**
 *
 * @author janaj4926
 */
public class MainGame implements Screen {

    private boolean holdingLeft, holdingRight, turtleAlive, turtleFight;
    private World world;
    private Player player;
    private KingBoss king;
    private GoldBlock gold;
    private TurtleBoss turtle;
    private WorldRenderer renderer;
    private Music music;
    private Sword sword;
    private boolean kingAlive;
    private boolean kingFight;
    GdxGame game;

    public MainGame(GdxGame game) {
        this.game = game;
        world = new World();
        player = world.getPlayer();
        sword = world.getSword();
        turtle = world.getTurtle();
        king = world.getKing();
        gold = world.getGold();
        turtle = world.getTurtle();
        renderer = new WorldRenderer(world);
        music = Gdx.audio.newMusic(Gdx.files.internal("music/1.mp3"));
        music.setVolume(0.5f);                 // sets the volume to half the maximum volume
        music.setLooping(true);                // will repeat playback until music.stop() is called
        holdingLeft = false;
        holdingRight = false;
        turtleAlive = true;
        turtleFight = false;
        kingFight = false;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float deltaTime) {

        //plays specified music
        music.play();

        //pauses game
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            game.changeScreen(game.pausedGameScreen);
        }

        //PLAYER CODE
        //PLAYER CODE
        //PLAYER CODE
        //PLAYER CODE
        //PLAYER CODE
        //PLAYER CODE
        //PLAYER CODE
        //PLAYER CODE
        //PLAYER CODE
        //PLAYER CODE

        //limits player to attack or block time of 0.5 seconds
        if (player.getStateTime() >= 1 && (player.getState() == Player.State.ATTACKING || player.getState() == Player.State.BLOCKING)) {
            player.setState(Player.State.STANDING);

            //player may attack only once per click
            if (Gdx.input.isButtonPressed(Buttons.LEFT)) {
                holdingLeft = true;
            }

            //player may block only once per click
            if (Gdx.input.isButtonPressed(Buttons.RIGHT)) {
                holdingRight = true;
            }
        }

        //resets click if player releases right button
        if (holdingRight && !Gdx.input.isButtonPressed(Buttons.RIGHT)) {
            holdingRight = false;
        }

        //resets click if player releases left button
        if (holdingLeft && !Gdx.input.isButtonPressed(Buttons.LEFT)) {
            holdingLeft = false;
        }
        //allows player to perform actions if they aren't frozen
        if (player.getState() != Player.State.FROZEN) {

            //allows player to run if they aren't running other way, attacking, and blocking
            if (Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && player.getState() != Player.State.ATTACKING && player.getState() != Player.State.BLOCKING) {
                player.setVelX(-player.MAX_VELOCITY);
                player.setState(Player.State.RUNNING);
            }

            //allows player to run left if they aren't running other way, attacking, and blocking
            if (Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isKeyPressed(Keys.A) && player.getState() != Player.State.ATTACKING && player.getState() != Player.State.BLOCKING) {
                player.setVelX(player.MAX_VELOCITY);
                player.setState(Player.State.RUNNING);
            }

            //allows player to jump if they aren't attacking, blocking, and have pegasus boots
            if (Gdx.input.isKeyPressed(Keys.SPACE) && !player.hasPegasusBoots() && player.getState() != Player.State.ATTACKING && player.getState() != Player.State.BLOCKING) {
                player.jump();
            }

            //allows player to attack if they aren't blocking, jumping, and holding attack button too long
            if (Gdx.input.isButtonPressed(Buttons.LEFT) && !Gdx.input.isButtonPressed(Buttons.RIGHT) && player.getState() != Player.State.JUMPING && !holdingLeft) {
                player.setState(Player.State.ATTACKING);
            }

            //allows player to block if they aren't attacking, jumping, and holding block button too long
            if (Gdx.input.isButtonPressed(Buttons.RIGHT) && !Gdx.input.isButtonPressed(Buttons.LEFT) && player.getState() != Player.State.JUMPING && !holdingRight) {
                player.setState(Player.State.BLOCKING);
            }

            //resets players state to standing if no keys are pressed and player isn't jumping
            if (!Gdx.input.isKeyPressed(Keys.A) && !Gdx.input.isKeyPressed(Keys.D) && !Gdx.input.isButtonPressed(Buttons.LEFT) && !Gdx.input.isButtonPressed(Buttons.RIGHT) && player.getState() != Player.State.JUMPING) {
                player.setState(Player.State.STANDING);
            }
        player.update(deltaTime);
        }

        //corrects players x so they don't fall off edge of map
        if (player.getX() < 0) {
            player.addToPosition(Math.abs(player.getX()), 0);
        }

        //updates player
        player.update(deltaTime);

        //go through each block
        for (Floor b : world.getFloor()) {

            //if player is hitting block
            if (player.isColliding(b)) {
                float overX = player.getOverlapX(b);
                float overY = player.getOverlapY(b);

                //fixing y if not moving
                if (player.getVelX() == 0f) {

                    //player is above block
                    if (player.getY() > b.getY()) {
                        player.addToPosition(0f, overY);
                    } else {
                        player.addToPosition(0f, -overY);
                    }

                    //fix smallest overlap
                    player.setVelY(0f);
                } else {

                    //fix smallest overlap
                    if (overX < overY) {

                        //left of block
                        if (player.getX() < b.getX()) {
                            player.addToPosition(-overX, 0f);
                        } else {
                            player.addToPosition(overX, 0f);
                        }
                    } else {

                        //player is above block
                        if (player.getY() > b.getY()) {
                            player.addToPosition(0, overY);
                            if (player.getState() == Player.State.JUMPING) {
                                player.setState(Player.State.STANDING);
                            }
                        } else {
                            player.addToPosition(0, -overY);

                        }
                        player.setVelY(0f);
                    }

                }
            }
        }
        
        //TURTLE CODE
        //TURTLE CODE
        //initialize the turtle boss fight
        if (player.getX() >= renderer.WIDTH * 2 && turtleAlive) {
            turtleFight = true;
        }
        
        //make the player stay within the bounds of the fight
        if (turtleFight) {
            if (player.getX() < 2560) {
                player.addToPosition(2560 - player.getX(), 0);
            } else if (player.getX() > 3840) {
                player.addToPosition(3840 - player.getX(), 0);
            }
        
        
            //turtle waits for three seconds before attacking
            if (turtle.getStateTime() >= 3f && turtle.getState() == TurtleBoss.State.STANDING) {
                turtle.setState(TurtleBoss.State.SPINNING);
                deltaTime = 0;
            }

            //moves the turtle
            if (turtle.getState() == TurtleBoss.State.SPINNING) {
                if(turtle.getX()<player.getX())
                    turtle.setVelX(12);
                else
                    turtle.setVelX(-12);
            }

            if (turtle.getX() <= renderer.WIDTH * 2 + 140) {
                turtle.addToPosition(renderer.WIDTH * 2 + 140 - turtle.getX(), 0);
                turtle.setVelX(0);
                turtle.setState(TurtleBoss.State.DIZZY);
                deltaTime=0;
            } else if (turtle.getX() + 320 >= renderer.WIDTH * 3) {
                turtle.addToPosition(renderer.WIDTH * 3 - turtle.getX(), 0);
                turtle.setVelX(0);
                turtle.setState(TurtleBoss.State.DIZZY);
                deltaTime=0;
            }
            System.out.println(turtleFight);
        }
            turtle.update(deltaTime);
        //KING CODE
        //KING CODE
        //KING CODE
        //KING CODE
        //KING CODE
        //KING CODE
        //KING CODE
        //KING CODE
        //KING CODE
        //KING CODE

        if (player.getX() >= renderer.WIDTH * 5) {
            
            king.setState(KingBoss.State.STANDING);
            
            //if king has been standing for too long, throw gold block
            if (king.getStateTime() >= 3 && king.getState() == KingBoss.State.STANDING) {
                king.setState(KingBoss.State.THROWING);
            }
            
            //throws gold block
            if (king.getState() == KingBoss.State.THROWING) {
                
            }
        }
        king.update(deltaTime);
        
        renderer.render(deltaTime);
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(renderer.WIDTH, renderer.HEIGHT);
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
