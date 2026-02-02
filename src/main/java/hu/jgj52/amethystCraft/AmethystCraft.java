package hu.jgj52.amethystCraft;

import hu.jgj52.amethystCraft.Commands.TestCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class AmethystCraft extends JavaPlugin {

    public static AmethystCraft plugin;
    private File kitFile;
    private FileConfiguration kitsConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveConfig();

        getCommand("test").setExecutor(new TestCommand());

        plugin = this;
        kitFile = new File(plugin.getDataFolder(), "kits.yml");
        kitsConfig = YamlConfiguration.loadConfiguration(kitFile);
        getKitsConfig().options().copyDefaults(true);
        saveKitsConfig();
    }

    public FileConfiguration getKitsConfig() {
        return kitsConfig;
    }

    public void saveKitsConfig() {
        try {
            kitsConfig.save(kitFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reloadKitsConfig() {
        kitsConfig = YamlConfiguration.loadConfiguration(kitFile);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
