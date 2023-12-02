package oreo.choccyoreo.commands;

import oreo.choccyoreo.Choccyoreo;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class spawncommand implements CommandExecutor {

    private final Choccyoreo plugin;

    public spawncommand(Choccyoreo plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("spawn")) {
            if (commandSender instanceof Player p) {
                Location location = plugin.getConfig().getLocation("spawn");

                if (location != null) {
                    p.teleport(location);

                    p.sendMessage("Teleported To Spawn!");
                } else {
                    p.sendMessage("No Spawn Point Set :(");
                }
            }
        }
        return true;
    }
}
