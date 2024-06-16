package org.game;

import org.game.scenes.MainMenu;
import org.lib.color.ColorRGBA;
import org.lib.scene.SceneManager;
import org.lib.window.Window;

public class Main {
  public static void main(String[] args) {
    Window window = new Window.Builder()
      .title("Flabby Bird")
      .backgroundColor(ColorRGBA.CYAN)
      .build();

    MainMenu mainMenu = new MainMenu("Main Menu");

    SceneManager.getInstance().setActiveScene(mainMenu);

    window.run();
  }
}