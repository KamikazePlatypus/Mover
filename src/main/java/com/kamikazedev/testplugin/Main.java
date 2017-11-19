package com.kamikazedev.testplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        this.getCommand("kit").setExecutor(new CommandKit());
        System.out.println("Enabled!");
    }

    @Override
    public void onDisable()
    {
        System.out.println("Disabled!");
    }
}
