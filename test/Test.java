package package;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin implements Listener {

	public void onEnable() {
		PlayerKillPlayerEvent.register(this);
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onPlayerKillPlayer(PlayerKillPlayerEvent event) {
		Bukkit.broadcastMessage(event.getKiller().getName() + " Killed " + event.getVictim().getName());
	}

}