package dxplug.dxplug.handler;

import dxplug.dxplug.DXPlug;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ServerHandler implements Listener {

    DXPlug plugin;

    public ServerHandler(DXPlug plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);

        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        for (int i = 0; i < DXPlug.invisiblePlayers.size(); i++) {
            player.hidePlayer(plugin, DXPlug.invisiblePlayers.get(i));
        }

        event.setJoinMessage(ChatColor.AQUA + "[ :) ] | Welcome " + player.getName() + " to " + Bukkit.getServer().getName() + ".");
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        for (int i = 0; i < DXPlug.invisiblePlayers.size(); i++) {
            player.showPlayer(plugin, DXPlug.invisiblePlayers.get(i));
        }

        event.setQuitMessage(ChatColor.DARK_AQUA + "[ :( ] | " + player.getName() + " Has left the server.");
    }
}
