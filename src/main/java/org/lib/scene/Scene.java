package org.lib.scene;

import java.util.*;

import org.lib.component.DynamicComponent;
import org.lib.component.StaticComponent;

public abstract class Scene {
  private String sceneName;

  private final Map<String, DynamicComponent> DYNAMIC_COMPONENTS = new HashMap<>();
  private final Map<String, StaticComponent> STATIC_COMPONENTS = new HashMap<>();

  public Scene(String sceneName) {
    this.sceneName = sceneName;
  }

  public void addStatic(StaticComponent comp, String id) {
    this.STATIC_COMPONENTS.put(id, comp);
  }

  public void addDynamic(DynamicComponent comp, String id) {
    this.STATIC_COMPONENTS.put(id, comp);
  }

  public void addStatic(StaticComponent comp) {
    this.STATIC_COMPONENTS.put(String.valueOf(STATIC_COMPONENTS.size()), comp);
  }

  public void addDynamic(DynamicComponent comp) {
    this.STATIC_COMPONENTS.put(String.valueOf(DYNAMIC_COMPONENTS.size()), comp);
  }
  
  public String getName() { return this.sceneName; }

  protected void applyPhysicsAndCollisions() {}
  protected void applyEvents() {}

  public void drawFrame() {
    for(StaticComponent comp : this.STATIC_COMPONENTS.values()) {
      comp.run();
    }

    applyEvents();
    applyPhysicsAndCollisions();

    for(DynamicComponent comp : this.DYNAMIC_COMPONENTS.values()) {
      comp.run();
    }
  }
}
