package oreo.choccyoreo.events;

import oreo.choccyoreo.Choccyoreo;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onPlayerLeave implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.setQuitMessage("[-] " + event.getPlayer().getName() + " Has Left! :(");
        Choccyoreo.getPlugin().sendWebHook("[-] " + event.getPlayer().getName() + " Has Left! :(");;
    }
}
