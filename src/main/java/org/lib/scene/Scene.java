package org.lib.scene;

import java.util.*;

import org.lib.component.DynamicComponent;
import org.lib.component.StaticComponent;

public abstract class Scene {
  private String sceneName;

  Set<DynamicComponent> dynamicComponent = new HashSet<>();
  Set<StaticComponent> staticComponents = new HashSet<>();

  public Scene(String sceneName) {
    this.sceneName = sceneName;
    SceneManager.getInstance().registerScene(this);
  }

  public String getName() { return this.sceneName; }

  public void applyPhysicsAndCollisions() {}
  public void applyEvents() {}

  public void drawFrame() {
    for(StaticComponent comp : staticComponents) {
      comp.run();
    }

    applyEvents();
    applyPhysicsAndCollisions();

    for(DynamicComponent comp : dynamicComponent) {
      comp.run();
    }
  }
}
