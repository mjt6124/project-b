package com.bigl.engine;

public interface IGameLogic {
    
    
    void cleanup();
    
    
    void init(Window window, Scene scene, Renderer renderer);

    
    void input(Window window, Scene scene, long timeDiff);
    
    
    void update(Window window, Scene scene, long timeDiff);

    
}




