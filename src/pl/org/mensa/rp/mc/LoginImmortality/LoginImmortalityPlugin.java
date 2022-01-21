package pl.org.mensa.rp.mc.LoginImmortality;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pl.org.mensa.rp.mc.LoginImmortality.listeners.EntityDamageListener;
import pl.org.mensa.rp.mc.LoginImmortality.listeners.PlayerJoinListener;
import pl.org.mensa.rp.mc.LoginImmortality.listeners.PlayerMoveListener;
import pl.org.mensa.rp.mc.LoginImmortality.listeners.PlayerQuitListener;

public class LoginImmortalityPlugin extends JavaPlugin {
	PluginManager plugin_manager;
	
	Map<UUID, List<Listener>> immortals;
	
	public LoginImmortalityPlugin() {
		immortals = new HashMap<UUID, List<Listener>>();
	}
	
	@Override
	public void onEnable() {
		plugin_manager = getServer().getPluginManager();
		plugin_manager.registerEvents(new PlayerJoinListener(this), this);
	}
	
	public void addPlayer(UUID uuid) {
		if (!immortals.containsKey(uuid)) {
			Listener damage_listener = new EntityDamageListener(uuid);
			Listener move_listener = new PlayerMoveListener(uuid, this);
			Listener quit_listener = new PlayerQuitListener(uuid, this);
			
			List<Listener> listeners = new ArrayList<Listener>();
			listeners.add(damage_listener);
			listeners.add(move_listener);
			listeners.add(quit_listener);
			
			immortals.put(uuid, listeners);
			
			for (Listener listener : listeners) {
				plugin_manager.registerEvents(listener, this);
			}
		}
	}
	public void removePlayer(UUID uuid) {
		for (Listener listener : immortals.remove(uuid)) {
			HandlerList.unregisterAll(listener);
		}
	}
}
