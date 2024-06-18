package org.lib.component;

public abstract class DynamicComponent extends StaticComponent {
  private float GRAVITY = 10;
  private float mass = 1;

  public float getGravity() { return GRAVITY; }
  public float getMass() { return mass; }

  public void setGravity(float gRAVITY) { GRAVITY = gRAVITY; }
  public void setMass(float mass) { this.mass = mass; }

  public void applyPhysics() {}

  @Override
  public void run() {
    applyPhysics();
    draw();
  }
}
