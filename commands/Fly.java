package dxplug.dxplug.commands;

import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                Msg.send(sender, "&c[!] | A console are unable to fly.");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target instanceof Player) {
                    if (target.getAllowFlight()) {
                        target.setAllowFlight(false);
                        Msg.send(sender, "&b[/] | Player " + target.getName() + " flying mode has been disabled.");
                        Msg.send(target, "&b[/] | Your flying mode has been disabled.");
                    } else {
                        target.setAllowFlight(true);
                        Msg.send(sender, "&b[/] | Player " + target.getName() + " flying mode has been enabled.");
                        Msg.send(target, "&b[/] | Your flying mode has been enabled.");
                    }
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
            } else {
                Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /fly {player}");
            }
        } else {
            Player player = (Player) sender;

            if (args.length == 0) {
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    Msg.send(sender, "&b[/] | Your flying mode has been disabled.");
                } else {
                    player.setAllowFlight(true);
                    Msg.send(sender, "&b[/] | Your flying mode has been enabled.");
                }
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target instanceof Player) {
                    if (target.getAllowFlight()) {
                        target.setAllowFlight(false);
                        Msg.send(sender, "&b[/] | Player " + target.getName() + " flying mode has been disabled.");
                        Msg.send(target, "&b[/] | Your flying mode has been disabled.");
                    } else {
                        target.setAllowFlight(true);
                        Msg.send(sender, "&b[/] | Player " + target.getName() + " flying mode has been enabled.");
                        Msg.send(target, "&b[/] | Your flying mode has been enabled.");
                    }
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
            } else {
                Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /fly {player}");
            }
        }
        return true;
    }
}
