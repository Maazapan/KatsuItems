package com.github.maazapan.katsuitems.listener;

import com.github.maazapan.katsuitems.KatsuItems;
import com.github.maazapan.katsuitems.item.manager.NPCManager;
import com.github.maazapan.katsuitems.item.team.TeamManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerListener implements Listener {

    private final KatsuItems plugin;

    public PlayerListener(KatsuItems plugin) {
        this.plugin = plugin;
    }

    /**
     * When a player joins the server, check if they are a team member.
     * If not, add them to the team.
     *
     * @param event PlayerJoinEvent
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        TeamManager teamManager = new TeamManager();
        UUID uuid = event.getPlayer().getUniqueId();

        if (!teamManager.isTeamMember(uuid)) {
            teamManager.joinTeam(uuid);
        }
    }

    /**
     * Check player is interacting with an itemNPC
     *
     * @param event PlayerInteractAtEntityEvent
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractAtEntityEvent event) {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();

        if (entity.getType() == EntityType.SLIME) {
            NPCManager npcManager = new NPCManager(plugin);

            if (!npcManager.isItemNPC(entity)) return;
            String itemId = npcManager.getItemNPCId(entity);

        }
    }
}
