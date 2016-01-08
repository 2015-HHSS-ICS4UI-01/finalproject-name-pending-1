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
public class GdxGame extends Game{

    @Override
    public void create() {
        setScreen(new MainGame());
    }
}