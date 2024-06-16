package org.lib.util;

import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lib.positioning.PixelPoint;

public class Util {

  public static int booleanToInt(boolean bool) {
    return !bool ? 1 : 0;
  }

  public static PercentPoint pixelToPercentPoint(PixelDimension window, PixelPoint pixel) {
    return new PercentPoint((float)window.getWidth() / pixel.getX(), (float)window.getHeight() / pixel.getY());
  }

  public static PercentDimension pixelToPercentDimension(PixelDimension window, PixelDimension dim) {
    return new PercentDimension(
      (float)window.getWidth() / dim.getWidth(),
      (float)window.getHeight() / dim.getHeight()
    );
  }
}
