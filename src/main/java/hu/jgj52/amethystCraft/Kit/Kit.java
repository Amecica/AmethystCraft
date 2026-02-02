package hu.jgj52.amethystCraft.Kit;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hu.jgj52.amethystCraft.Main.plugin;

public class Kit {
    private static final Map<String, Kit> kits = new HashMap<>();
    public static Kit of(String id) {
        if (kits.containsKey(id)) {
            return kits.get(id);
        }

        Kit kit = new Kit(id);
        kits.put(id, kit);
        return kit;
    }

    private String id;
    private String name;
    private ItemStack[] content;

    private Kit (String id) {
        this.id = id;
        name = plugin.getKitsConfig().getString(id + ".name");
        Object obj = plugin.getKitsConfig().get(id + ".content");
        if (obj instanceof List<?> list) this.content = list.toArray(new ItemStack[0]); else this.content = new ItemStack[0];
    }

    public String getName() {
        return name;
    }
    public ItemStack[] getContent() {
        return content.clone();
    }
    public ItemStack[] getContent(Player player) {
        ConfigurationSection custom = plugin.getKitsConfig().getConfigurationSection("custom." + player.getUniqueId() + "." + id);
        if (custom == null) return getContent();
        ItemStack[] content = new ItemStack[getContent().length];
        for (String key : custom.getKeys(false)) {
            int o = Integer.parseInt(key);
            int c = custom.getInt(key);
            content[c] = getContent()[o];
        }
        return content;
    }
}
