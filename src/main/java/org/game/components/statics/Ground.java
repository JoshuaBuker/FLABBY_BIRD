package org.game.components.statics;

import org.lib.color.ColorRGBA;
import org.lib.component.StaticComponent;
import org.lib.draw.Quad;
import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;

public class Ground extends StaticComponent {
  public Ground() {
    this.setDimensions(new PercentDimension(2.0f, 0.05f));
    this.setLocation(new PercentPoint(0.0f, 0.0f));
    this.setColor(ColorRGBA.SANDY_BROWN);
  }

  @Override
  public void draw() {
    Quad.drawQuad(getPercentDimension(), getPercentLocation(), getColor());
  }
}
