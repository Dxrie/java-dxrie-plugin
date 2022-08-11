package dxplug.dxplug.handler;

import dxplug.dxplug.DXPlug;
import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearsHandler implements Listener {
    public ShearsHandler(DXPlug plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityShear(PlayerShearEntityEvent event) {

        Entity entity = event.getEntity();
        Player player = event.getPlayer();

        if (entity.getType() != EntityType.SHEEP) {
            return;
        } else {
            event.setCancelled(true);
            Msg.send(player, "&c[!] | You are not allowed to shear any sheep in this server.");
        }
    }
}
