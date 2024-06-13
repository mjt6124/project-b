package com.bigl.engine;

import org.lwjgl.glfw.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;



public class Window  {

    private final long window;
    
    /* This is all copied from the init() function of the sample code */
    public Window() {
        // push error info to stderr
        GLFWErrorCallback.createPrint(System.err).set();

        if(!glfwInit()) {
            throw new IllegalStateException("GLFW unable to init");
        }

        // Configure GLFW
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        this.window = glfwCreateWindow(300, 300, "Hello PeenEngine!", NULL, NULL);
        if ( this.window == NULL ) {
			throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwSetKeyCallback(window,(window, key, scancode, action, mods) -> {
            keyCallback(key, action);
        });

        try ( MemoryStack stack = stackPush() ) {
			IntBuffer pWidth = stack.mallocInt(1); // int*
			IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
			glfwGetWindowSize(window, pWidth, pHeight);

			// Get the resolution of the primary monitor
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			// Center the window
			glfwSetWindowPos(
				window,
				(vidmode.width() - pWidth.get(0)) / 2,
				(vidmode.height() - pHeight.get(0)) / 2
			);

            glfwMakeContextCurrent(window);
		    // Enable v-sync
		    glfwSwapInterval(1);

		    // Make the window visible
		    glfwShowWindow(window);
		}
        /* End plagerisim */
    }

    public void cleanup() {
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
        GLFWErrorCallback callback = glfwSetErrorCallback(null);
        if (callback != null) {
            callback.free();
        }
    }

    public boolean windowShouldClose() {
        return glfwWindowShouldClose(window);
    }

    public void pollEvents() {
        glfwPollEvents();
    }

    public void update() {
        glfwSwapBuffers(window);
    }

    public void keyCallback(int key, int action) {
        if(key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
            glfwSetWindowShouldClose(this.window, true);
        }
    }

}
