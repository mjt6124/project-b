package com.bigl;

import com.bigl.engine.IGameLogic;
import com.bigl.engine.PeenEngine;
import com.bigl.engine.Scene;
import com.bigl.engine.Window;
import com.bigl.engine.Renderer;

public class Main implements IGameLogic{

	public static void main(String[] args) {
        Main main = new Main();
        PeenEngine pe = new PeenEngine(main);
        pe.start();
    }
	
	@Override
    public void cleanup() {
        // Nothing to be done yet
    }

    @Override
    public void init(Window window, Scene scene, Renderer renderer) {
        // Nothing to be done yet
    }

    @Override
    public void input(Window window, Scene scene, long diffTimeMillis) {
        // Nothing to be done yet
    }

    @Override
    public void update(Window window, Scene scene, long diffTimeMillis) {
        // Nothing to be done yet
    }
}