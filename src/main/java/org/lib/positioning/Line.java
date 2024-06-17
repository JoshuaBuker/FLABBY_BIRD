package org.lib.positioning;

import org.lib.util.Util;
import org.lib.window.Window;

public class Line {
  private PixelPoint pointPixel1, pointPixel2;
  private PercentPoint pointPercent1, pointPercent2;

  public Line(PixelPoint pt1, PixelPoint pt2) {
    this.pointPixel1 = pt1;
    this.pointPixel2 = pt2;
    this.pointPercent1 = Util.pixelToPercentPoint(Window.getSize(), pt1);
    this.pointPercent2 = Util.pixelToPercentPoint(Window.getSize(), pt2);
  }

  public Line(PercentPoint pt1, PercentPoint pt2) {
    this.pointPercent1 = pt1;
    this.pointPercent2 = pt2;
    this.pointPixel1 = Util.percentToPixelPoint(Window.getSize(), pt1);
    this.pointPixel2 = Util.percentToPixelPoint(Window.getSize(), pt2);
  }

  public PixelPoint getPixelPoint1() { return pointPixel1; }
  public PixelPoint getPixelPoint2() { return pointPixel2; }
  public PercentPoint getPercentPoint1() { return pointPercent1; }
  public PercentPoint getPercentPoint2() { return pointPercent2; }

  public void setPoint1(PixelPoint pt) { 
    this.pointPixel1 = pt; 
    this.pointPercent1 = Util.pixelToPercentPoint(Window.getSize(), pt);
  }

  public void setPoint2(PixelPoint pt) { 
    this.pointPixel2 = pt; 
    this.pointPercent2 = Util.pixelToPercentPoint(Window.getSize(), pt);
  }

  public void setPoint1(PercentPoint pt) { 
    this.pointPercent1 = pt; 
    this.pointPixel1 = Util.percentToPixelPoint(Window.getSize(), pt);
  }

  public void setPoint2(PercentPoint pt) { 
    this.pointPercent2 = pt;
    this.pointPixel2 = Util.percentToPixelPoint(Window.getSize(), pt);
  }

  public void update(PixelPoint pt1, PixelPoint pt2) {
    this.pointPixel1 = pt1;
    this.pointPixel2 = pt2;
    this.pointPercent1 = Util.pixelToPercentPoint(Window.getSize(), pt1);
    this.pointPercent2 = Util.pixelToPercentPoint(Window.getSize(), pt2);
  }

  public void update(PercentPoint pt1, PercentPoint pt2) {
    this.pointPercent1 = pt1;
    this.pointPercent2 = pt2;
    this.pointPixel1 = Util.percentToPixelPoint(Window.getSize(), pt1);
    this.pointPixel2 = Util.percentToPixelPoint(Window.getSize(), pt2);
  }

}
