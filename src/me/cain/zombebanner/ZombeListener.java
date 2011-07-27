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
		if(!ZombeBanner.PermissionCheck("zombe.allowfly", player)) {
				String nofly = "&f &f &1 &0 &2 &4 ";
				nofly = nofly.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				player.sendMessage(nofly);
			} else {
				player.sendMessage("You are allowed to use Zombe Fly!");
			}
			if(!ZombeBanner.PermissionCheck("zombe.allowcheat", player)) {
				String nocheat = "&f &f &2 &0 &4 &8";
				nocheat = nocheat.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				player.sendMessage(nocheat);
			} else {
				player.sendMessage("You are allowed to use Zombe Cheat!");
			}
			if(this.plugin.config.getProperty("config.showmessages").equals("true")) {
			player.sendMessage(ChatColor.DARK_RED + "Zombe has been disabled.");
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