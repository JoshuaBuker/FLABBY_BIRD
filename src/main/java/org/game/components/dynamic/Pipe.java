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

  public Pipe(PercentDimension d, PercentPoint p, ColorRGBA c) {
    this.setDimensions(d);
    this.setLocation(p);
    this.setColor(c);
  }

  @Override
  public void applyPhysics() {
    
  }

  @Override
  public void draw() {
   
  }
}
