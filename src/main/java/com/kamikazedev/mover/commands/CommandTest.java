package com.kamikazedev.mover.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player) sender;


    }

  return true;
  }

}
