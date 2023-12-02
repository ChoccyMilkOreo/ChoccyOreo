package oreo.choccyoreo.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class diecommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (command.getName().equalsIgnoreCase("die")) {
            if (commandSender instanceof Player p) {
                p.setHealth(0.0);
                p.sendMessage(ChatColor.RED + "You wanted to die.. mahahaha");
            } else if (commandSender instanceof ConsoleCommandSender) {
                System.out.println("Console can't run this command!");
            } else if (commandSender instanceof BlockCommandSender) {
                System.out.println("Command block can't run this command!");
            }
        }

        return true;
    }
}
