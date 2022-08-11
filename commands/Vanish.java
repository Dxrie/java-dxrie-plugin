package dxplug.dxplug.commands;

import dxplug.dxplug.DXPlug;
import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Vanish implements CommandExecutor {

    DXPlug plugin;

    public Vanish(DXPlug plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (DXPlug.invisiblePlayers.contains(player)) {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.showPlayer(plugin, player);
                    Msg.send(people, ChatColor.AQUA + "[ :) ] | Welcome " + player.getName() + " to " + Bukkit.getServer().getName() + ".");
                }

                DXPlug.invisiblePlayers.remove(player);
                Msg.send(sender, "&b[/] | You are now visible to the whole server player.");
            } else {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    if (!(people.isOp())) {
                        people.hidePlayer(plugin, player);
                    }
                    Msg.send(people, ChatColor.DARK_AQUA + "[ :( ] | " + player.getName() + " Has left the server.");
                }

                DXPlug.invisiblePlayers.add(player);
                Msg.send(sender, "&b[/] | You have vanished and no server player are able to see you");
            }
        } else {
            Msg.send(sender, "&c[!] | A console are unable to toggle vanish for anyone including the console itself.");
        }

        return true;

    }
}
