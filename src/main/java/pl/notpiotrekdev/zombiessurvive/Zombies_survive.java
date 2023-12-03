package pl.notpiotrekdev.zombiessurvive;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.notpiotrekdev.zombiessurvive.commands.menu;

public final class Zombies_survive extends JavaPlugin {



    @Override
    public void onEnable() {
        getCommand("zs-settings").setExecutor(new menu());
        getServer().getPluginManager().registerEvents(new menu(), this);
        Bukkit.getServer().getConsoleSender().sendMessage("[ZombiesSurvive] Plugin has been enabled!");

    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage("[ZombiesSurvive] Plugin has been disabled!");
    }
}
