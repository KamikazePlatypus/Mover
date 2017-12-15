package com.kamikazedev.mover.commands;

import com.kamikazedev.mover.Mover;
import com.kamikazedev.mover.utils.Utils;
import com.sk89q.worldedit.bukkit.selections.CuboidSelection;
import com.sk89q.worldedit.bukkit.selections.Selection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class CommandMover implements CommandExecutor {

  private Selection s;
  private World world = Bukkit.getWorlds().get(0);

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    double[] params;

    try {
      params = Utils.toDoubleArray(args);
    } catch (Exception e) {
      sender.sendMessage("Invalid arguments.");
      return true;
    }

    if (sender instanceof BlockCommandSender) {
      if (params.length == 13) {
        Location pt1 = new Location(world, params[7], params[8], params[9]);
        Location pt2 = new Location(world, params[10], params[11], params[12]);
        s = new CuboidSelection(world, pt1, pt2);
      } else {
        sender.sendMessage("Invalid arguments.");
      }
    } else if (sender instanceof Player) {
      if (params.length == 7) {
        Player p = (Player) sender;

        try {
          s = Mover.getWorldEdit().getSelection(p);
        } catch (Exception e) {
          sender.sendMessage("Invalid WorldEdit selection");
          return true;
        }
      } else {
        sender.sendMessage("Invalid arguments.");
      }
    } else {
      sender.sendMessage("Command execution not supported from console.");
    }

    return true;
  }
}
