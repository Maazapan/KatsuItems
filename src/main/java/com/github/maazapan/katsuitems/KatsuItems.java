package com.github.maazapan.katsuitems;

import com.github.maazapan.katsuitems.item.ItemNPC;
import com.github.maazapan.katsuitems.manager.LoaderManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class KatsuItems extends JavaPlugin {

    private Map<String, ItemNPC> npcMap;
    private LoaderManager loaderManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.loaderManager = new LoaderManager(this);
        this.loaderManager.load();

        this.npcMap = new HashMap<>();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.loaderManager.disable();
    }

    public Map<String, ItemNPC> getNpcMap() {
        return npcMap;
    }
}
