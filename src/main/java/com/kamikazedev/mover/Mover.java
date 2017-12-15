package com.kamikazedev.mover;

import com.kamikazedev.mover.commands.CommandMover;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Mover extends JavaPlugin
{
    private CommandExecutor mover = new CommandMover();

    @Override
    public void onEnable()
    {
        this.getCommand("mover").setExecutor(mover);
        System.out.println("Enabled!");
    }

    @Override
    public void onDisable()
    {
        System.out.println("Disabled!");
    }

    public static WorldEditPlugin getWorldEdit()
    {
        Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

        if (p instanceof WorldEditPlugin)
        {
            return (WorldEditPlugin) p;
        }
        else
        {
            return null;
        }
    }
}
