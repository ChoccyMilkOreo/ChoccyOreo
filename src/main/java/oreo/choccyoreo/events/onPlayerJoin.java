package oreo.choccyoreo.events;

import oreo.choccyoreo.Choccyoreo;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoin implements Listener  {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage("[+] " + event.getPlayer().getName() + " Has Joined! :3");
        Choccyoreo.getPlugin().sendWebHook("[+] " + event.getPlayer().getName() + " Has Joined! :3");
    }
}
