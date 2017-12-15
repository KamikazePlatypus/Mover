package com.kamikazedev.mover.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minecraft.server.v1_12_R1.EntityLiving;
import net.minecraft.server.v1_12_R1.EntityTypes;

public class NMSUtils {

  public void registerEntity(String name, int id, Class<? extends EntityLiving> nmsClass,
      Class<? extends EntityLiving> customClass) {
    try {
      List<Map<?, ?>> dataMap = new ArrayList<>();

      for (Field f : EntityTypes.class.getDeclaredFields()) {
        if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
          f.setAccessible(true);
          dataMap.add((Map<?, ?>) f.get(null));
        }
      }

      if (dataMap.get(2).containsKey(id)) {
        dataMap.get(0).remove(name);
        dataMap.get(2).remove(id);
      }

      Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class,
          int.class);
      method.setAccessible(true);
      method.invoke(null, customClass, name, id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}