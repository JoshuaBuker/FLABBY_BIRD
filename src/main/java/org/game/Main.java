package org.game;

import org.lib.color.ColorRGBA;
import org.lib.scene.SceneManager;
import org.lib.window.Window;

public class Main {
  public static void main(String[] args) {
    SceneManager manager = new SceneManager(Constants.SCENES)
      .setActiveScene("Main Menu");

    Window window = new Window.Builder()
      .title("Flabby Bird")
      .backgroundColor(ColorRGBA.CYAN)
      .windowDimensions(800, 600)
      .setSceneManager(manager)
      .build();
    
    window.run();
  }
}