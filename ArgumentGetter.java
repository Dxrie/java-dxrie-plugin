package dxplug.dxplug;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ArgumentGetter {
    public static Player returnTarget(String targetedPlayer) {
        Player player = Bukkit.getPlayerExact(targetedPlayer);

        return player;
    }
}
