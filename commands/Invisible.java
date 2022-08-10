package dxplug.dxplug.commands;

import dxplug.dxplug.ArgumentGetter;
import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invisible implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                if (player.isInvisible()) {
                    player.setInvisible(false);
                    Msg.send(sender, "&b[/] | Invisible mode has been toggled off.");
                } else {
                    player.setInvisible(true);
                    Msg.send(sender, "&b[/] | Invisible mode has been toggled on.");
                }
            } else if (args.length == 1) {
                Player target = ArgumentGetter.returnTarget(args[0]);

                if (target instanceof Player) {
                    if (target.isInvisible()) {
                        target.setInvisible(false);
                        Msg.send(sender, "&b[/] | Invisible mode has been toggled off.");
                        Msg.send(target, "&6[/] | Your invisible mode has been toggled off.");
                    } else {
                        target.setInvisible(true);
                        Msg.send(sender, "&b[/] | Invisible mode has been toggled on.");
                        Msg.send(target, "&6[/] | Your invisible mode has been toggled on.");
                    }
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
            } else {
                Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /invis {player}");
            }
        } else {
            if (args.length == 0) {
                Msg.send(sender, "&c[!] | A console are unable to toggle invisible mode.");
            } else if (args.length == 1) {
                Player target = ArgumentGetter.returnTarget(args[0]);

                if (target instanceof Player) {
                    if (target.isInvisible()) {
                        target.setInvisible(false);
                        Msg.send(sender, "&b[/] | Invisible mode has been toggled off.");
                        Msg.send(target, "&6[/] | Your invisible mode has been toggled off.");
                    } else {
                        target.setInvisible(true);
                        Msg.send(sender, "&b[/] | Invisible mode has been toggled on.");
                        Msg.send(target, "&6[/] | Your invisible mode has been toggled on.");
                    }
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
            } else {
                Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /invis {player}");
            }
        }
        return true;
    }
}
