package org.game;

import org.lib.color.ColorRGBA;
import org.lib.scene.SceneManager;
import org.lib.window.Window;

public class Main {
  public static void main(String[] args) {
    Init.load();

    Window window = new Window.Builder()
      .title("Flabby Bird")
      .backgroundColor(ColorRGBA.CYAN)
      .windowDimensions(800, 600)
      .build();
    
    SceneManager.getInstance().setActiveScene("Main Menu");
    
    window.run();
  }
}