package pl.org.mensa.rp.mc.LoginImmortality.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import pl.org.mensa.rp.mc.LoginImmortality.LoginImmortalityPlugin;

public class PlayerJoinListener implements Listener {
	LoginImmortalityPlugin plugin;
	
	public PlayerJoinListener(LoginImmortalityPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority=EventPriority.LOWEST)
	public void onPlayerJoin(PlayerJoinEvent e) {
		plugin.addPlayer(e.getPlayer().getUniqueId());
	}
}
