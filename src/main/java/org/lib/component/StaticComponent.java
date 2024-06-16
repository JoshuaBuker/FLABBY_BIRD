package org.lib.component;

import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lib.positioning.PixelPoint;

public abstract class StaticComponent {
  private PixelDimension pixelDim;
  private PercentDimension percentDim;
  private PercentPoint percentLocation;
  private PixelPoint pixelLocation;

  private float scale = 1.0f;

  public PixelDimension getPixelDimension() { return this.pixelDim; }
  public PercentDimension getPercentDimension() { return this.percentDim; }
  public PercentPoint getPercentLocation() { return this.percentLocation; }
  public PixelPoint getPixelLocation() { return this.pixelLocation; }
  public float getScale() { return this.scale; }

  public void setDimensions(PixelDimension pixelDim) { this.pixelDim = pixelDim; }
  public void setDimensions(PercentDimension percentDim) { this.percentDim = percentDim; }
  public void setScale(float scale) { this.scale = scale; }
  public void setLocation(PixelPoint point) { this.pixelLocation = point; }
  public void setLocation(PercentPoint point) { this.percentLocation = point; }

  public void draw() {}

  public void run() {
    draw();
  }
}
