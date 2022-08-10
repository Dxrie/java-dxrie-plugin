package dxplug.dxplug.commands;

import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodMode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                Msg.send(sender, "&c[!] | A console are unable to enable or disable godmode.");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target instanceof Player) {
                    if (target.isInvulnerable()) {
                        target.setInvulnerable(false);
                        Msg.send(sender, "&b[/] | Player " + target.getName() + " have no longer access to God Mode.");
                    } else {
                        target.setInvulnerable(true);
                        Msg.send(sender, "&b[/] | Player " + target.getName() + " now have access to God Mode.");
                    }
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
            } else {
                Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /god {player}");
            }
        } else {
            Player player = (Player) sender;

            if (args.length == 0) {
                if (player.isInvulnerable()) {
                    player.setInvulnerable(false);
                    Msg.send(sender, "&b[/] | You now have no longer access to God Mode.");
                } else {
                    player.setInvulnerable(true);
                    Msg.send(sender, "&b[/] | You now have access to God Mode.");
                }
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target instanceof Player) {
                    if (target.isInvulnerable()) {
                        target.setInvulnerable(false);
                        Msg.send(sender, "&b[/] | Player " + target.getName() + " have no longer access to God Mode.");
                    } else {
                        target.setInvulnerable(true);
                        Msg.send(sender, "&b[/] | Player " + target.getName() + " now have access to God Mode.");
                    }
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
            } else {
                Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /god {player}");
            }
        }

        return true;
    }
}