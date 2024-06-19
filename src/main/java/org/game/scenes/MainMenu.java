package org.game.scenes;

import org.game.components.dynamics.Bird;
import org.game.components.dynamics.Pipe;
import org.game.components.statics.Ground;
import org.lib.component.DynamicComponent;
import org.lib.listener.KeyListener;
import org.lib.listener.MouseListener;
import org.lib.positioning.PercentPoint;
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
    Bird bird = (Bird)getDynamicMap().get("Bird");
    PercentPoint birdPos = bird.getPercentLocation();
    float birdY = birdPos.getY();

     if (birdPos.getY() - (bird.getPercentDimension().getHeight()) >= -1.0f) {
      getDynamicMap().get("Bird").setYVelocity(bird.getYVelocity() + bird.getGravity());
      }

    if(KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE) && KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE) != bird.isPreviousButtonState()) {
      bird.setYVelocity(bird.getJUMP_HEIGHT());
    }      

    bird.setPreviousButtonState(KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE));
   
    birdY += bird.getYVelocity();

    birdPos.setY(birdY);

    bird.setLocation(birdPos);
  }
}
