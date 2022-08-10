package dxplug.dxplug.commands;

import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                Msg.send(sender, "&c[!] | A console are unable to switch gamemodes.");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target instanceof Player) {
                    target.setGameMode(GameMode.CREATIVE);
                    Msg.send(sender, "&b[/] | Player " + target.getName() + " has been set to Creative Mode.");
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
            } else {
                Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /gmc {player}");
            }
        } else {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.setGameMode(GameMode.CREATIVE);
                Msg.send(sender, "&b[/] | You have been set to Creative Mode.");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target instanceof Player) {
                    target.setGameMode(GameMode.CREATIVE);
                    Msg.send(sender, "&b[/] | Player " + target.getName() + " has been set to Creative Mode.");
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
            } else {
                Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /gmc {player}");
            }
        }

        return true;
    }
}
