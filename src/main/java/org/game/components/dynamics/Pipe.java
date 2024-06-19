package org.game.components.dynamics;

import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Quad;
import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;

public class Pipe extends DynamicComponent {
  PercentDimension topDim, botDim;
  PercentPoint topPos, botPos;
  float gapSize = 0.1f;

  public Pipe() {
    setColor(ColorRGBA.GREEN);

    float topHeight = (float)Math.random() * (1.0f - gapSize);
    this.topDim = new PercentDimension(0.15f, topHeight);
    this.botDim = new PercentDimension(0.15f, (1.0f - gapSize) - topHeight);

    this.topPos = new PercentPoint(1.1f, 1.0f - (topHeight * 0.5f));
    this.botPos = new PercentPoint(1.1f, -1.0f + (((1.0f - gapSize) - topHeight) * 0.5f));
  }

  @Override
  public void applyPhysics() {
    if (topPos.getX() - (topDim.getWidth() / 2.0f) >= -1.0f) {
      topPos.setX(topPos.getX() + (getGravity() * -0.0008f));
      botPos.setX(botPos.getX() + (getGravity() * -0.0008f));
      
    } else {
      float topHeight = (float)Math.random() * (1.0f - gapSize);
      this.topDim = new PercentDimension(0.15f, topHeight);
      this.botDim = new PercentDimension(0.15f, (1.0f - gapSize) - topHeight);
  
      this.topPos = new PercentPoint(1.1f, 1.0f - (topHeight * 0.5f));
      this.botPos = new PercentPoint(1.1f, -1.0f + (((1.0f - gapSize) - topHeight) * 0.5f));

    }
  }

  @Override
  public void draw() {
    Quad.drawQuad(topDim, topPos, getColor());
    Quad.drawQuad(botDim, botPos, getColor());
  }
}
