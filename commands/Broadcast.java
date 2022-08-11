package dxplug.dxplug.commands;

import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                Msg.send(player, args[0]);
            }
        } else {
            Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /bc {message}");
        }

        return true;

    }
}
