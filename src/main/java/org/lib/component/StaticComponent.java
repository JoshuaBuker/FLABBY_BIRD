package org.lib.component;

import org.lib.color.ColorRGBA;
import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lib.positioning.PixelPoint;
import org.lib.util.Util;
import org.lib.window.Window;

public abstract class StaticComponent {
  private PixelDimension pixelDim;
  private PercentDimension percentDim;
  private PercentPoint percentLocation;
  private PixelPoint pixelLocation;
  private ColorRGBA color;

  private float scale = 1.0f;

//========================== GETTERS ===============================
  public float getScale() { return this.scale; }
  public ColorRGBA getColor() { return this.color; }
  public PixelDimension getPixelDimension() { return this.pixelDim; }
  public PercentDimension getPercentDimension() { return this.percentDim; }
  public PercentPoint getPercentLocation() { return this.percentLocation; }
  public PixelPoint getPixelLocation() { return this.pixelLocation; }


//====================== SETTERS ==================================
  public void setScale(float scale) { this.scale = scale; }
  public void setColor(ColorRGBA color) { this.color = color; }

  public void setDimensions(PixelDimension pixelDim) { 
    this.pixelDim = pixelDim; 
    this.percentDim = Util.pixelToPercentDimension(Window.getSize(), pixelDim);
  }

  public void setDimensions(PercentDimension percentDim) { 
    this.percentDim = percentDim; 
    this.pixelDim = Util.percentToPixelDimension(Window.getSize(), percentDim);
  }

  public void setLocation(PixelPoint point) { 
    this.pixelLocation = point; 
    this.percentLocation = Util.pixelToPercentPoint(Window.getSize(), point);
  }

  public void setLocation(PercentPoint point) { 
    this.percentLocation = point; 
    this.pixelLocation = Util.percentToPixelPoint(Window.getSize(), point);
  }



  public void draw() {}

  public void run() {
    draw();
  }
}
