package com.github.maazapan.katsuitems.item;

import com.github.maazapan.katsuitems.item.hologram.Hologram;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class ItemNPC {

    private final String id;

    private final UUID entityUUID;
    private final UUID hitBoxUUID;

    private ItemStack itemStack;
    private Hologram hologram;

    public ItemNPC(String id, UUID entityUUID, UUID hitBoxUUID) {
        this.id = id;
        this.entityUUID = entityUUID;
        this.hitBoxUUID = hitBoxUUID;
    }

    public String getId() {
        return id;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public UUID getEntityUUID() {
        return entityUUID;
    }

    public UUID getHitBoxUUID() {
        return hitBoxUUID;
    }

    public Hologram getHologram() {
        return hologram;
    }

    public void setHologram(Hologram hologram) {
        this.hologram = hologram;
    }
}
