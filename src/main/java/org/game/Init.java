package org.game;

import org.game.scenes.MainMenu;
import org.lib.init.InitBase;

public class Init extends InitBase{
  public static void load() {

    add(new MainMenu("Main Menu"));
    // add(new MainMenu("GamePlayScene")); // Example
    // add(new MainMenu("Pause Menu"));    // Example
    // add(new MainMenu("GameLostScene")); // Example
  }


}
