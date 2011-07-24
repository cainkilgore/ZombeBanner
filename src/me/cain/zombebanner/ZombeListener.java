package me.cain.zombebanner;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class ZombeListener extends PlayerListener
{
	ZombeBanner plugin;
	Server server;
	
	public ZombeListener(ZombeBanner instance)
	{
		this.plugin = instance;
	}

	public void onPlayerJoin(PlayerJoinEvent Event) {
		Player player = Event.getPlayer();
		if(!ZombeBanner.PermissionCheck("zombe.allowmods", player)) {
			player.sendMessage("no-z-fly no-z-cheat");
			if(this.plugin.config.getProperty("config.showmessages").equals("true")) {
			player.sendMessage("Zombe has been disabled.");
			} else {
				return;
			}
		}
		else {
			if(this.plugin.config.getProperty("config.showmessages").equals("true")) {
			player.sendMessage("You are allowed to use Zombe!");
			} else {
				return;
		}
		}
	}
}