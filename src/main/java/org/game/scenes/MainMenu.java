package org.game.scenes;

import org.game.components.dynamic.Bird;
import org.game.components.dynamic.GapPipe;
import org.game.components.dynamic.Pipe;
import org.game.components.dynamic.PipeLoop;
import org.lib.scene.Scene;

public class MainMenu extends Scene {

  public MainMenu(String sceneName) {
    super(sceneName);

    addDynamic(new Bird(), "Bird");
    addDynamic(new PipeLoop(), "PipeLoop");
  }
}
