package org.lib.component;

public abstract class DynamicComponent extends StaticComponent {
  private float GRAVITY = 10;
  private float mass = 1;

  public float getGRAVITY() { return GRAVITY; }
  public float getMass() { return mass; }

  public void setGRAVITY(float gRAVITY) { GRAVITY = gRAVITY; }
  public void setMass(float mass) { this.mass = mass; }

  private void applyPhysics() {}

  public void run() {
    applyPhysics();
    draw();
  }
}
