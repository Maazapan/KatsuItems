package com.github.maazapan.katsuitems.item.hologram;

import com.github.maazapan.katsuitems.utils.KatsuUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

import java.util.ArrayList;
import java.util.List;

public class Hologram {

    private final List<ArmorStand> hologramList = new ArrayList<>();
    private final double DISTANCE = 0.25;

    /**
     * Create a hologram at a location with a list of lines.
     * Each line is a new armor stand.
     *
     * @param location      Location to spawn hologram.
     * @param hologramLines List of lines to display.
     */
    public void createHologram(Location location, List<String> hologramLines) {
        double y = 0;

        for (String line : hologramLines) {
            y -= DISTANCE;

            // Spawn armor stand.
            ArmorStand hologram = location.getWorld().spawn(location.add(0, y, 0), ArmorStand.class, (ArmorStand armorStand) -> {
                armorStand.setCustomNameVisible(true);
                armorStand.setCustomName(KatsuUtils.hex(line));
                armorStand.setGravity(false);
                armorStand.setVisible(false);
                armorStand.setSmall(true);
                armorStand.setMarker(true);
            });
            hologramList.add(hologram);
        }
    }

    /**
     * Teleport hologram to a location.
     *
     * @param location Location to teleport hologram to.
     */
    public void teleport(Location location) {
        double y = 0;

        for (ArmorStand hologram : hologramList) {
            y -= DISTANCE;
            hologram.teleport(location.add(0, y, 0));
        }
    }
}
