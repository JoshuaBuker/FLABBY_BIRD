package org.lib.positioning;

import java.util.ArrayList;
import java.util.List;

import org.lib.component.StaticComponent;
import org.lib.util.Util;
import org.lib.window.Window;

public class Edges {
  private List<Line> edges = new ArrayList<>();
  private List<PixelPoint> pixelCorners = new ArrayList<>();
  private List<PercentPoint> percentCorners = new ArrayList<>();

  public Edges(StaticComponent comp) {
    PercentDimension dim = comp.getPercentDimension();
    PercentPoint pos = comp.getPercentLocation();

    this.percentCorners.add(new PercentPoint(pos.getX() - (dim.getWidth() / 2.0f), pos.getY() + (dim.getHeight() / 2.0f)));
    this.percentCorners.add(new PercentPoint(pos.getX() + (dim.getWidth() / 2.0f), pos.getY() + (dim.getHeight() / 2.0f)));
    this.percentCorners.add(new PercentPoint(pos.getX() + (dim.getWidth() / 2.0f), pos.getY() - (dim.getHeight() / 2.0f)));
    this.percentCorners.add(new PercentPoint(pos.getX() - (dim.getWidth() / 2.0f), pos.getY() - (dim.getHeight() / 2.0f)));
    this.pixelCorners.add(Util.percentToPixelPoint(Window.getSize(), percentCorners.get(0)));
    this.pixelCorners.add(Util.percentToPixelPoint(Window.getSize(), percentCorners.get(1)));
    this.pixelCorners.add(Util.percentToPixelPoint(Window.getSize(), percentCorners.get(2)));
    this.pixelCorners.add(Util.percentToPixelPoint(Window.getSize(), percentCorners.get(3)));

    edges.add(new Line(percentCorners.get(0), percentCorners.get(1)));
    edges.add(new Line(percentCorners.get(1), percentCorners.get(2)));
    edges.add(new Line(percentCorners.get(2), percentCorners.get(3)));
    edges.add(new Line(percentCorners.get(3), percentCorners.get(0)));
  }

  public void update(StaticComponent comp) {
    PercentDimension dim = comp.getPercentDimension();
    PercentPoint pos = comp.getPercentLocation();

    this.percentCorners.get(0).setX(pos.getX() - (dim.getWidth() / 2.0f));
    this.percentCorners.get(0).setY(pos.getY() + (dim.getHeight() / 2.0f));
    this.percentCorners.get(1).setX(pos.getX() + (dim.getWidth() / 2.0f));
    this.percentCorners.get(1).setY(pos.getY() + (dim.getHeight() / 2.0f));
    this.percentCorners.get(2).setX(pos.getX() + (dim.getWidth() / 2.0f));
    this.percentCorners.get(2).setY(pos.getY() - (dim.getHeight() / 2.0f));
    this.percentCorners.get(3).setX(pos.getX() - (dim.getWidth() / 2.0f));
    this.percentCorners.get(3).setY(pos.getY() - (dim.getHeight() / 2.0f));

    this.pixelCorners.set(0, (Util.percentToPixelPoint(Window.getSize(), percentCorners.get(0))));
    this.pixelCorners.set(1, (Util.percentToPixelPoint(Window.getSize(), percentCorners.get(1))));
    this.pixelCorners.set(2, (Util.percentToPixelPoint(Window.getSize(), percentCorners.get(2))));
    this.pixelCorners.set(3, (Util.percentToPixelPoint(Window.getSize(), percentCorners.get(3))));

    edges.get(0).setPoint1(percentCorners.get(0));
    edges.get(0).setPoint2(percentCorners.get(1));
    edges.get(1).setPoint1(percentCorners.get(1));
    edges.get(2).setPoint2(percentCorners.get(2));
    edges.get(2).setPoint1(percentCorners.get(2));
    edges.get(3).setPoint2(percentCorners.get(3));
    edges.get(3).setPoint1(percentCorners.get(3));
    edges.get(0).setPoint2(percentCorners.get(0));
  }

  public List<Line> getEdges() { return edges; }
  public List<PixelPoint> getPixelCorners() { return pixelCorners; }
  public List<PercentPoint> getPercentCorners() { return percentCorners; }
}
