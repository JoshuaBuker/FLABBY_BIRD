package org.game.components.dynamic;

import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Quad;
import org.lib.listener.KeyListener;
import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;
import org.lib.scene.SceneManager;
import org.lwjgl.glfw.GLFW;

public class Bird extends DynamicComponent {
  private boolean previousButtonState = false;

  public Bird() {
    this.setDimensions(new PercentDimension(0.05f, 0.05f));
    this.setLocation(new PercentPoint(-0.5f, 0.0f));
    this.setColor(ColorRGBA.YELLOW);
  }

  @Override
  public void applyPhysics() {
    PercentPoint temp = getPercentLocation();

    if(KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE) && KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE) != previousButtonState) {
      temp.setY(temp.getY() + 0.2f);
    }      

    this.previousButtonState = KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE);
    
    if (temp.getY() - (getPercentDimension().getHeight() / 2.0f) >= -1.0f) {
      temp.setY(temp.getY() + (getGRAVITY() * -0.0005f));
      this.setLocation(temp);
    } 
  } 

  @Override
  public void draw() {
    Quad.drawQuad(getPercentDimension(), getPercentLocation(), getColor());
  }
}
