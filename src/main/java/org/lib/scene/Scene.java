package org.lib.scene;

import java.util.*;

import org.lib.component.DynamicComponent;
import org.lib.component.StaticComponent;

public abstract class Scene {
  private String sceneName;

  private final Set<DynamicComponent> DYNAMIC_COMPONENTS = new HashSet<>();
  private final Set<StaticComponent> STATIC_COMPONENTS = new HashSet<>();

  public Scene(String sceneName) {
    this.sceneName = sceneName;
    SceneManager.getInstance().registerScene(this);
  }

  public void addStatic(StaticComponent comp) {
    this.STATIC_COMPONENTS.add(comp);
  }

  public void addStatic(List<StaticComponent> comps) {
    this.STATIC_COMPONENTS.addAll(comps);
  }

  public void addDynamic(DynamicComponent comp) {
    this.STATIC_COMPONENTS.add(comp);
  }

  public void addDynamic(List<DynamicComponent> comps) {
    this.STATIC_COMPONENTS.addAll(comps);
  }

  public String getName() { return this.sceneName; }

  protected void applyPhysicsAndCollisions() {}
  protected void applyEvents() {}

  public void drawFrame() {
    for(StaticComponent comp : this.STATIC_COMPONENTS) {
      comp.run();
    }

    applyEvents();
    applyPhysicsAndCollisions();

    for(DynamicComponent comp : this.DYNAMIC_COMPONENTS) {
      comp.run();
    }
  }
}
