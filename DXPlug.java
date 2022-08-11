package dxplug.dxplug;

import dxplug.dxplug.commands.*;
import dxplug.dxplug.handler.ServerHandler;
import dxplug.dxplug.handler.ShearsHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public final class DXPlug extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[=======================DX-Plugin=====================]");
        Bukkit.getLogger().info("[        [DX-Plugin] | Loading plugin...              ]");
        Bukkit.getLogger().info("[        [DX-Plugin] | Setting Everything Up...       ]");
        Bukkit.getLogger().info("[=====================================================]");

        new ServerHandler(this);
        new ShearsHandler(this);

        getCommand("heal").setExecutor(new Heal());
        getCommand("fly").setExecutor(new Fly());
        getCommand("gmc").setExecutor(new GMC());
        getCommand("gms").setExecutor(new GMS());
        getCommand("gmsp").setExecutor(new GMSP());
        getCommand("opstatus").setExecutor(new OPCheck());
        getCommand("xp").setExecutor(new EXP());
        getCommand("godmode").setExecutor(new GodMode());
        getCommand("switch").setExecutor(new GMSWITCH());
        getCommand("invis").setExecutor(new Invisible());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[=======================DX-Plugin=====================]");
        Bukkit.getLogger().info("[           [DX-Plugin] | Shutting Down...            ]");
        Bukkit.getLogger().info("[=====================================================]");
    }
}
