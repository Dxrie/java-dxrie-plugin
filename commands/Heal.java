package dxplug.dxplug.commands;

import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                Msg.send(sender, "&c[!] | A console are unable to heal.");
                return true;
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target instanceof Player) {
                    target.setHealth(20.0d);
                    target.setFoodLevel(20);
                    Msg.send(sender, "&b[/] | Successfully Healed " + target.getName() + ".");
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
                return true;
            } else {
                Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /heal {player}");
                return true;
            }
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            Msg.send(sender, "&b[/] | Healed " + sender.getName());
            player.setHealth(20.0d);
            player.setFoodLevel(20);
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);

            if (target instanceof Player) {
                Msg.send(sender, "&b[/] | Healed " + target.getName());
                target.setHealth(20.0d);
                target.setFoodLevel(20);
            } else {
                Msg.send(sender, "&c[!] | Please specify a valid user.");
            }
        } else {
            Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /heal {player}");
        }

        return true;
    }
}
