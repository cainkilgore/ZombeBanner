package me.cain.zombebanner;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class ZombeListener extends PlayerListener
{
	ZombeBanner plugin;
	Server server;
	Player player;
	
	public ZombeListener(ZombeBanner instance)
	{
		this.plugin = instance;
	}

	public void onPlayerJoin(PlayerJoinEvent Event) {
		Player player = Event.getPlayer();
		if(!ZombeBanner.PermissionCheck("zombe.allowmods", player)) {
			if(this.plugin.config.getProperty("config.disablefly").equals("true")) {
				player.sendMessage("no-z-fly");
			}
			if(this.plugin.config.getProperty("config.disablecheat").equals("true")) {
				player.sendMessage("no-z-cheat");
			}
			if(this.plugin.config.getProperty("config.showmessages").equals("true")) {
			player.sendMessage(ChatColor.DARK_RED + "Zombe has been disabled.");
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