package hu.jgj52.amethystCraft;

import org.bukkit.plugin.java.JavaPlugin;

public final class AmethystCraft extends JavaPlugin {

    public static AmethystCraft plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveConfig();

        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
