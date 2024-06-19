package org.game.scenes;

import org.game.components.dynamics.Bird;
import org.game.components.dynamics.Pipe;
import org.game.components.statics.Ground;
import org.lib.listener.MouseListener;
import org.lib.positioning.PixelPoint;
import org.lib.scene.Scene;
import org.lwjgl.glfw.GLFW;

public class MainMenu extends Scene {

  public MainMenu(String sceneName) {
    super(sceneName);

    addDynamic(new Bird(), "Bird");
    addDynamic(new Pipe(), "Pipe");
    addStatic(new Ground(), "Ground");
  }

  @Override
  protected void applyEvents() {
    if (MouseListener.mouseButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) {
      this.getDynamicMap().get("Bird").setLocation(new PixelPoint((short)MouseListener.getX(), -(short)MouseListener.getY()));
    }
  }
}
