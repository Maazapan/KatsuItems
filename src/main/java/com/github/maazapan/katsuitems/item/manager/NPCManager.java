package com.github.maazapan.katsuitems.item.manager;

import com.github.maazapan.katsuitems.KatsuItems;
import com.github.maazapan.katsuitems.item.team.TeamManager;
import com.github.maazapan.katsuitems.utils.KatsuUtils;
import de.tr7zw.changeme.nbtapi.NBTEntity;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class NPCManager {

    private final KatsuItems plugin;

    public NPCManager(KatsuItems plugin) {
        this.plugin = plugin;
    }

    /**
     * Spawn an itemNPC in front of the player
     *
     * @param player    Player to location
     * @param itemStack Item to spawn
     */
    public void spawnItemNPC(String id, Player player, ItemStack itemStack) {
        Vector distance = player.getEyeLocation().getDirection().multiply(-3.2).setY(0);
        Location location = player.getLocation().add(0, -8.0, 0).add(distance);
        Location playerLocation = player.getLocation();

        Vector rotated = KatsuUtils.rotateAroundY(Math.toRadians(-90), player.getEyeLocation().getDirection().multiply(-1.8)).setY(0);
        location.add(rotated);

        // Spawn giant at player location.
        Giant itemNPC = location.getWorld().spawn(playerLocation, Giant.class, (Giant giant) -> {
            giant.setAI(false);
            giant.setInvulnerable(false);
            giant.setInvisible(true);
            giant.setCollidable(false);
            giant.setPersistent(true);
            giant.setSilent(true);
            giant.setCanPickupItems(false);
            giant.setGravity(false);
            giant.setRemoveWhenFarAway(false);

            giant.getEquipment().setItemInMainHand(itemStack, false);
            giant.teleport(location);

            NBTEntity nbtEntity = new NBTEntity(giant);
            nbtEntity.setString("katsu_entity_id", id);
        });

        // Spawn slime hitBox at player location.
        Location slimeLocation = playerLocation.add(player.getEyeLocation().getDirection().multiply(1.0).setY(0));

        Slime hitNoxEntity = location.getWorld().spawn(slimeLocation, Slime.class, (Slime slime) -> {
            slime.setSize(8);
            slime.setAI(false);
            slime.setInvulnerable(false);
            slime.setCollidable(false);
            slime.setPersistent(true);
            slime.setInvisible(true);
            slime.setSilent(true);
            slime.setGravity(false);
            slime.setRemoveWhenFarAway(false);

            NBTEntity nbtEntity = new NBTEntity(slime);
            nbtEntity.setString("katsu_entity_id", id);
        });

        // Join the team to prevent collision.
        TeamManager teamManager = new TeamManager();

        teamManager.joinTeam(itemNPC.getUniqueId());
        teamManager.joinTeam(hitNoxEntity.getUniqueId());
    }


    /**
     * Get the itemNPC id from an entity.
     *
     * @param entity Entity to get id from
     * @return String
     */
    public String getItemNPCId(Entity entity) {
        return new NBTEntity(entity).getString("katsu_entity_id");
    }

    /**
     * Check if an entity is an itemNPC.
     *
     * @param entity Entity to check
     * @return boolean
     */
    public boolean isItemNPC(Entity entity) {
        return new NBTEntity(entity).hasKey("katsu_entity_id");
    }
}
