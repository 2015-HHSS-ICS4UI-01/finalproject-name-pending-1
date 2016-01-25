/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;



/**
 *
 * @author janaj4926
 */
 
public class GdxGame extends Game {
 

        MainMenuScreen mainMenuScreen;
        MainGame mainGame;
        PausedGameScreen pausedGameScreen;
 


        public GdxGame() {             
        }
       
        /*
        function to change the current game screen
        */
       public void changeScreen(Screen s){
           this.setScreen(s);
       }

       /*
       creates all of the screens used and sets the mainMenuScreen to be the current one.
       */
    @Override
    public void create() {
        mainMenuScreen = new MainMenuScreen(this);
        mainGame = new MainGame(this);
        pausedGameScreen = new PausedGameScreen(this);
        changeScreen(mainMenuScreen); 
    }
 }
