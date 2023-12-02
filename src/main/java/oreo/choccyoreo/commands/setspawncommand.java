package oreo.choccyoreo.commands;

import oreo.choccyoreo.Choccyoreo;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setspawncommand implements CommandExecutor {

    private final Choccyoreo plugin;

    public setspawncommand(Choccyoreo plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("setspawn")) {
            if (commandSender instanceof Player p) {
                Location location = p.getLocation();

                plugin.getConfig().set("spawn", location);
                plugin.saveConfig();

                p.sendMessage("World Spawn Set!");
            } else {
                System.out.println("You need to be on the server silly!");
            }
        }
        return true;
    }
}
