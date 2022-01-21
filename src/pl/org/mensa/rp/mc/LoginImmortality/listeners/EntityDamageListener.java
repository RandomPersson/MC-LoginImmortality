package pl.org.mensa.rp.mc.LoginImmortality.listeners;

import java.util.UUID;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {
	UUID uuid;
	
	public EntityDamageListener(UUID uuid) {
		this.uuid = uuid;
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onEntityDamage(EntityDamageEvent e) {
		if (e.getEntity().getUniqueId().equals(uuid)) {
			e.setCancelled(true);
		}
	}
}
