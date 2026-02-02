package hu.jgj52.amethystCraft.Kit;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static hu.jgj52.amethystCraft.AmethystCraft.plugin;

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
        content = plugin.getKitsConfig().getList(id + ".content").toArray(new ItemStack[0]);
    }

    public String getName() {
        return name;
    }
    public ItemStack[] getContent() {
        return content;
    }/*
    public ItemStack[] getContent(Player player) {

    }*/
}
