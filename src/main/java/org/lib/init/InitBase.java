package org.lib.init;

import java.util.ArrayList;
import java.util.List;

import org.lib.scene.Scene;

public class InitBase {
  private static final List<Scene> scenes = new ArrayList<>();

  public static void add(Scene scene) {
    scenes.add(scene);
  }

}
