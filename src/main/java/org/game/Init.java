package org.game;

import org.game.scenes.MainMenu;

public class Init {
  // ====================== SCENES =========================
  public static final MainMenu mainMenu = new MainMenu("Main Menu");


  // ==================== SINGLETON-ish ========================
  private static Init instance;

  public static synchronized void load() {
    if (Init.instance == null) {
      Init.instance = new Init();
    }
  }
}
