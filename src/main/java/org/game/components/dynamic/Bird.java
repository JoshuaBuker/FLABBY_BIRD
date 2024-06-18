package org.game.components.dynamic;

import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Quad;
import org.lib.listener.KeyListener;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lwjgl.glfw.GLFW;

public class Bird extends DynamicComponent {
  private boolean previousButtonState = false;
  //temporarily constant in the future when the player gets fast enough their jump height will increase or decrease to make the game harder
  private final float JUMP_HEIGHT = 0.028f;

   
  public Bird() {
    this.setDimensions(new PixelDimension(50, 50));
    this.setLocation(new PercentPoint(-0.5f, 0.0f));
    this.setColor(ColorRGBA.YELLOW);
    this.setGRAVITY(-0.0025f);
  }
  public static float height = 0.05f;
  @Override
  public void applyPhysics() {
    PercentPoint birdPos = getPercentLocation();
    float birdY = birdPos.getY();

     if (birdPos.getY() - (getPercentDimension().getHeight()) >= -1.0f) {
        setYVelocity(getYVelocity() + getGravity());
      }

    if(KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE) && KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE) != previousButtonState) {
      setYVelocity(JUMP_HEIGHT);
    }      

    this.previousButtonState = KeyListener.isKeyPressed(GLFW.GLFW_KEY_SPACE);
   
    birdY += getYVelocity();

    birdPos.setY(birdY);

    this.setLocation(birdPos);
  } 

  @Override
  public void draw() {
    Quad.drawQuad(getPercentDimension(), getPercentLocation(), getColor());
  }
}
