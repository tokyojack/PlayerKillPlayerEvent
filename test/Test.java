package me.tokyojack.spigot.airdrop;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.valeon.core.events.PlayerKillPlayerEvent;

public class Test extends JavaPlugin implements Listener {

	public void onEnable() {
		PlayerKillPlayerEvent.register(this);
	}

	@EventHandler
	public void onPlayerKillPlayer(PlayerKillPlayerEvent event) {
		Bukkit.broadcastMessage(event.getKiller().getName() + " Killed " + event.getVictim().getName());
	}

}