package com.github.maazapan.katsuitems.manager;

import com.github.maazapan.katsuitems.KatsuItems;
import com.github.maazapan.katsuitems.commands.ItemCommand;
import com.github.maazapan.katsuitems.listener.PlayerListener;

public class LoaderManager {

    private final KatsuItems plugin;

    public LoaderManager(KatsuItems plugin) {
        this.plugin = plugin;
    }

    public void load() {
        this.loadCommands();
        this.loadListener();
    }

    public void disable() {

    }

    private void loadListener(){
        plugin.getServer().getPluginManager().registerEvents(new PlayerListener(plugin), plugin);
    }

    private void loadCommands() {
        plugin.getCommand("ktitem").setExecutor(new ItemCommand(plugin));
    }
}
