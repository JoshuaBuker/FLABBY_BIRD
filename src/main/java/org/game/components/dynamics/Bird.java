package org.game.components.dynamics;

import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Quad;
import org.lib.listener.KeyListener;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lwjgl.glfw.GLFW;

public class Bird extends DynamicComponent {
  private boolean previousButtonState = false;

  public Bird() {
    this.setDimensions(new PixelDimension(50, 50));
    this.setLocation(new PercentPoint(0.0f, 0.0f));
    this.setColor(ColorRGBA.YELLOW);
  }

  @Override
  public void applyPhysics() {
    PercentPoint temp = this.getPercentLocation();
    temp.setY(temp.getY() + 0.1f);

    // this.setLocation(temp);
  } 

  @Override
  public void draw() {
    Quad.drawQuad(getPercentDimension(), getPercentLocation(), getColor());
  }
}
