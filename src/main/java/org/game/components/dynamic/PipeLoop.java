package org.game.components.dynamic;

import java.util.ArrayList;

import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Quad;

import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelPoint;

public class PipeLoop extends DynamicComponent {

     ArrayList<GapPipe> pipes = new ArrayList<>();
     float pipe_distance;
     float pipe_speed = -0.005f;

  public PipeLoop() {
    pipes.add(new GapPipe());
    
  }

  @Override
  public void applyPhysics() {
    //loop through every pipe in the list and add velocity/speed to their x position
    for (GapPipe currentPipe : pipes) {
      
      PercentPoint currentPipe_pos = currentPipe.getPercentLocation();
      float pipe_x = currentPipe_pos.getX();

      currentPipe.setXVelocity(pipe_speed);
      
      pipe_x += currentPipe.getXVelocity();
      currentPipe_pos.setX(pipe_x);

      currentPipe.setLocation(currentPipe_pos);

      currentPipe.top_pipe.getPercentLocation().setX(pipe_x);
      currentPipe.bottom_pipe.getPercentLocation().setX(pipe_x);

      currentPipe.top_pipe.getPercentLocation().setX(pipe_x);
      currentPipe.bottom_pipe.getPercentLocation().setX(pipe_x);

      if(currentPipe.getPercentLocation().getX() + (getPercentDimension().getWidth() / 2.0f) <= -1.0){
         pipes.remove(currentPipe);
         pipes.add(new GapPipe());
      }
    }
  }

  @Override
  public void draw() {
    for(GapPipe current_gap_pipe : pipes){
      Quad.drawQuad(current_gap_pipe.top_pipe);
      Quad.drawQuad(current_gap_pipe.bottom_pipe);
    }
    
  }
}