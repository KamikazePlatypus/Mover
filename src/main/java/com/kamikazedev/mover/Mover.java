package com.kamikazedev.mover;

import com.kamikazedev.mover.commands.*;
import com.kamikazedev.mover.entity.CustomArmorStand;
import com.kamikazedev.mover.utils.NMSUtils;
import com.kamikazedev.mover.utils.NMSUtils.Type;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Mover extends JavaPlugin {

  @Override
  public void onEnable() {
    NMSUtils.registerEntity("mover", Type.ARMOR_STAND,
        CustomArmorStand.class, false);
    this.getCommand("mover").setExecutor(new CommandMover());
    System.out.println("Enabled!");
  }

  @Override
  public void onDisable() {
    System.out.println("Disabled!");
  }

  public static WorldEditPlugin getWorldEdit() {
    Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

    if (p instanceof WorldEditPlugin) {
      return (WorldEditPlugin) p;
    } else {
      return null;
    }
  }

}
