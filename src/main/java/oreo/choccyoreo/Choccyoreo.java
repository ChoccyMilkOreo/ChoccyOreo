package oreo.choccyoreo;

import oreo.choccyoreo.commands.*;
import oreo.choccyoreo.events.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Choccyoreo extends JavaPlugin {


    private static Choccyoreo plugin;
    private FileConfiguration config;

    @Override
    public void onEnable() {
        plugin = this;
        System.out.println("Oreo started!");

        getServer().getPluginManager().registerEvents(new onPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new onPlayerLeave(), this);

        getCommand("die").setExecutor(new diecommand());
        getCommand("setspawn").setExecutor(new setspawncommand(this));
        getCommand("spawn").setExecutor(new spawncommand(this));

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        reloadConfig();
        config = getConfig();
    }

    public void sendWebHook(String msg) {
        String webhookURL = "";
        DiscordWebhook webhook = new DiscordWebhook(webhookURL);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription(msg));
        try {
            webhook.execute();
        } catch (java.io.IOException e) {
            getLogger().severe(e.getStackTrace().toString());
        }
    }

    public static Choccyoreo getPlugin() {
        return plugin;
    }
}
