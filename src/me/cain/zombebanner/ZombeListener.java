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
				String nofly = "&f &f &1 &0 &2 &4 ";
				nofly = nofly.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				player.sendMessage(nofly);
			}
			if(this.plugin.config.getProperty("config.disablecheat").equals("true")) {
				String nocheat = "&f &f &2 &0 &4 &8";
				nocheat = nocheat.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				player.sendMessage(nocheat);
			}
			if(this.plugin.config.getProperty("config.showmessages").equals("true")) {
			player.sendMessage(ChatColor.DARK_RED + "Zombe has been disabled.");
			} else {
				return;
			}
		} else {
			if(this.plugin.config.getProperty("config.showmessages").equals("true")) {
			player.sendMessage("You are allowed to use Zombe!");
			} else {
				return;
		}
		}
	}
}