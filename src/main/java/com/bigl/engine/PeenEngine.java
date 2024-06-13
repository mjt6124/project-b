package com.bigl.engine;

public class PeenEngine{

    public static final int TARGET_UPS = 30;
    private final Window window;
    private final IGameLogic gameLogic;
    private final Renderer renderer;
    private Scene scene;
    private int targetFps;
    private int targetUps;
    private boolean running;

    public PeenEngine( IGameLogic gameLogic ){
        this.window = new Window();
        this.gameLogic = gameLogic;
        this.renderer = new Renderer();
        this.scene = new Scene();
        gameLogic.init(this.window, this.scene, this.renderer);
        this.running = true;
    }

    public void cleanup(){
        this.gameLogic.cleanup();
        this.renderer.cleanup();
        this.scene.cleanup();
        this.window.cleanup();
    }

    private void run() {
        long initialTime = System.currentTimeMillis();
        float timeU = 1000.0f / targetUps;
        float timeR = targetFps > 0 ? 1000.0f / targetFps : 0;
        float deltaUpdate = 0;
        float deltaFps = 0;

        long updateTime = initialTime;
        while (running && !window.windowShouldClose()) {
            window.pollEvents();

            long now = System.currentTimeMillis();
            deltaUpdate += (now - initialTime) / timeU;
            deltaFps += (now - initialTime) / timeR;

            if (targetFps <= 0 || deltaFps >= 1) {
                gameLogic.input(window, scene, now - initialTime);
            }

            if (deltaUpdate >= 1) {
                long diffTimeMillis = now - updateTime;
                gameLogic.update(window, scene, diffTimeMillis);
                updateTime = now;
                deltaUpdate--;
            }

            if (targetFps <= 0 || deltaFps >= 1) {
                renderer.render(window, scene);
                deltaFps--;
                window.update();
            }
            initialTime = now;
        }

        cleanup();
    }

    public void start() {
        running = true;
        run();
    }

    public void stop() {
        running = false;
    }

}
