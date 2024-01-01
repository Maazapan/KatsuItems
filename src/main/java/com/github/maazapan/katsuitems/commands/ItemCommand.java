package com.github.maazapan.katsuitems.commands;

import com.github.maazapan.katsuitems.KatsuItems;
import com.github.maazapan.katsuitems.item.hologram.Hologram;
import com.github.maazapan.katsuitems.item.manager.NPCManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ItemCommand implements CommandExecutor {

    private KatsuItems plugin;

    public ItemCommand(KatsuItems plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        NPCManager itemManager = new NPCManager(plugin);

        Hologram hologram = new Hologram();

        hologram.createHologram(player.getLocation(), Arrays.asList("Hello", "World", "&e&lKatsuItems"));


        /*
        Location location = player.getLocation().add(0, -8, 0).add(player.getEyeLocation().getDirection().multiply(-3.2));
        location.add(rotateVectorY(Math.toRadians(-90), player.getEyeLocation().getDirection().multiply(-1.8)));

        Giant giant = player.getWorld().spawn(location, Giant.class);

        giant.setAI(false);
        giant.setInvulnerable(false);
        giant.setInvisible(true);
        giant.setCollidable(true);


        giant.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND));

         */

        return false;
    }
}
