package org.game.components.dynamic;

import java.util.Random;

import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Quad;

import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelPoint;

public class GapPipe extends DynamicComponent {
  
    private float gap = 0.5f;

    private final float min_height =  0.15f;
    private final float max_height = 0.7f;

     public Pipe top_pipe, bottom_pipe;

    public GapPipe() {
    this.setDimensions(new PercentDimension(0.1f, 1.0f));
    this.setLocation(new PercentPoint(0.7f, 0.0f));
    this.setColor(ColorRGBA.GREEN);
    
    //these values are for the pipe as a WHOLE
    float pipeY = this.getPercentLocation().getY();
    float pipeX = this.getPercentLocation().getX();

    float pipeWidth = this.getPercentDimension().getWidth();
    float pipeHeight = this.getPercentDimension().getHeight();



       top_pipe = new Pipe();
       bottom_pipe = new Pipe();


        top_pipe.setLocation(new PercentPoint(pipeX, 0));
        top_pipe.setDimensions(new PercentDimension(pipeWidth, 0));
        top_pipe.setColor(getColor());


        bottom_pipe.setLocation(new PercentPoint(pipeX, 0));
        bottom_pipe.setDimensions(new PercentDimension(pipeWidth, 0));
        bottom_pipe.setColor(getColor());

        PercentPoint top_pipe_pos = top_pipe.getPercentLocation();
        PercentDimension top_pipe_dim = top_pipe.getPercentDimension();

        PercentPoint bot_pipe_pos = bottom_pipe.getPercentLocation();
        PercentDimension bot_pipe_dim = bottom_pipe.getPercentDimension();
        

        float randHeight1 = new Random().nextFloat(min_height, max_height - gap);
        float randHeight2 = randHeight1 + gap;

        

        top_pipe_dim.setHeight(randHeight1);
        bot_pipe_dim.setHeight(randHeight2);

        int coinflip = new Random().nextInt(0, 2);

        if(coinflip == 0){
          top_pipe_pos.setY(1.0f - top_pipe.getPercentLocation().getY() + (getPercentDimension().getHeight() / 2));
          bot_pipe_pos.setY(-1.0f + bot_pipe_dim.getHeight());
        }else{
          bot_pipe_pos.setY(1.0f - bottom_pipe.getPercentLocation().getY() + (getPercentDimension().getHeight() / 2));
          top_pipe_pos.setY(-1.0f + top_pipe_dim.getHeight());
        }
  }

  @Override
  public void applyPhysics() {
    

  }

  @Override
  public void draw() {
    Quad.drawQuad(top_pipe);
    Quad.drawQuad(bottom_pipe);
  }
}