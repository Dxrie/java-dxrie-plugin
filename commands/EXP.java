package dxplug.dxplug.commands;

import dxplug.dxplug.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EXP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            Msg.send(sender, "&c[!] | Incorrect argument, 2 arguments needed 0 found. | Usage : /xp {player} {xp_amount}.");
        } else if (args.length > 2) {
            Msg.send(sender, "&c[!] | Incorrect argument, 2 arguments needed " + args.length + " found. | Usage : /xp {player} {xp_amount}.");
        } else {
            try {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target instanceof Player) {
                    int receivedXP = Integer.parseInt(args[1]);

                    target.giveExp(receivedXP * 100);
                    Msg.send(sender, "&b[/] | Successfully gave " + target.getName() + " " + receivedXP * 100 + " EXP.");
                } else {
                    Msg.send(sender, "&c[!] | Please specify a valid user.");
                }
            } catch (IllegalArgumentException e) {
                Msg.send(sender, "&c[!] | Incorrect argument, /xp {player} {xp_amount}.");
            }
        }
        return true;
    }
}
