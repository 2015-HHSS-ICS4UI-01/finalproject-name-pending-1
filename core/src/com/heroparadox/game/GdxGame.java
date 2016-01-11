/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroparadox.game;

import com.badlogic.gdx.Game;



/**
 *
 * @author NamePending
 */
 
public class GdxGame extends Game {
 

        MainMenuScreen mainMenuScreen;
        MainGame mainGame;
 


        public GdxGame() {
                mainMenuScreen = new MainMenuScreen(this);
                mainGame = new MainGame(this);
                setScreen(mainMenuScreen);              
        }
       
       public void setScreen(Screen s){
           setScreen(s);
       }

    @Override
    public void create() {
        
    }
 }
