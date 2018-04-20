package com.valeon.core.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerKilledPlayerEvent extends Event implements Listener {

	private static final HandlerList handlers = new HandlerList();
	private static final PlayerKilledPlayerEvent listener = new PlayerKilledPlayerEvent();

	private Player killer;
	private Player victim;

	public PlayerKilledPlayerEvent() {
		// For register
	}

	public PlayerKilledPlayerEvent(Player killer, Player victim) {
		this.killer = killer;
		this.victim = victim;
	}

	public Player getKiller() {
		return this.killer;
	}

	public Player getVictim() {
		return this.victim;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	@EventHandler(ignoreCancelled = true)
	public void pl(PlayerDeathEvent event) {
		Entity killer = event.getEntity().getKiller();

		if (killer == null)
			return;

		if (!(killer instanceof Player))
			return;

		Player playerKiller = (Player) event.getEntity().getKiller();

		Bukkit.getPluginManager().callEvent(new PlayerKilledPlayerEvent(playerKiller, event.getEntity()));

	}

	public static void register(JavaPlugin plugin) {
		Bukkit.getPluginManager().registerEvents(listener, plugin);
	}
}