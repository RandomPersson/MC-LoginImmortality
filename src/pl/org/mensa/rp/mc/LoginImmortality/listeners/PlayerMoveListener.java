package pl.org.mensa.rp.mc.LoginImmortality.listeners;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import pl.org.mensa.rp.mc.LoginImmortality.LoginImmortalityPlugin;

public class PlayerMoveListener implements Listener {
	UUID uuid;
	LoginImmortalityPlugin plugin;
	
	public PlayerMoveListener(UUID uuid, LoginImmortalityPlugin plugin) {
		this.uuid = uuid;
		this.plugin = plugin;
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlayerMove(PlayerMoveEvent e) {
		if (e.getPlayer().getUniqueId().equals(uuid)) {
			plugin.removePlayer(uuid);
		}
	}
}
