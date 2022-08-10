package dxplug.dxplug.commands;

import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OPCheck implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            Msg.send(sender, "&c[!] | Missing 1 required argument. | Usage : /opstatus {player}");
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);

            if (target instanceof Player) {
                Msg.send(sender, target.getName() + " OP Status : " + target.isOp());
            } else {
                Msg.send(sender, "&c[!] | Please specify a valid user.");
            }
        } else {
            Msg.send(sender, "&c[!] | Only 1 argument are allowed in this command. | Usage : /opstatus {player}");
        }

        return true;
    }
}
