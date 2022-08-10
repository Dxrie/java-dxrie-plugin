package dxplug.dxplug.commands;

import dxplug.dxplug.Msg;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GMSWITCH implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Msg.send(sender, "&c[!] | A console are unable to switch gamemodes.");
        } else {
            Player player = (Player) sender;

            GameMode mode = player.getPreviousGameMode();
            if (mode != null) {
                player.setGameMode(mode);
                Msg.send(sender, "&b[/] | You have been given " + mode.name() + " mode.");
            } else {
                player.setGameMode(GameMode.CREATIVE);
                Msg.send(sender, "&b[/] | You have been given creative mode.");
            }
        }
        return true;
    }
}
