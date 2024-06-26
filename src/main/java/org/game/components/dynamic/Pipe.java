package org.game.components.dynamic;

import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Quad;
import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;

public class Pipe extends DynamicComponent {
  public Pipe() {
    this.setDimensions(new PercentDimension(0.1f, 1.0f));
    this.setLocation(new PercentPoint(1.0f, 0.0f));
    this.setColor(ColorRGBA.GREEN);
  }

  @Override
  public void applyPhysics() {
    PercentPoint temp = getPercentLocation();
    
    if (temp.getX() - (getPercentDimension().getWidth() / 2.0f) >= -1.0f) {
      temp.setX(temp.getX() + (getGRAVITY() * -0.0008f));
      
    } else {
      temp.setX(1.0f);
    }
    this.setLocation(temp);
  }

  @Override
  public void draw() {
    Quad.drawQuad(getPercentDimension(), getPercentLocation(), getColor());
  }
}
