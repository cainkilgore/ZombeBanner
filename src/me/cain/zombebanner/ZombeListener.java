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
			} 
		else {
				if(ZombeBanner.config.getProperty("config.showmessages").equals("true")) {
				player.sendMessage(ChatColor.GREEN + "[ZombeBanner] " + ChatColor.WHITE + "You are allowed to fly!");
			}
		
			if(!ZombeBanner.PermissionCheck("zombe.allowcheat", player)) {
				String nocheat = "&f &f &2 &0 &4 &8 ";
				nocheat = nocheat.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				player.sendMessage(nocheat);
			}
			
			else {
				if(ZombeBanner.config.getProperty("config.showmessages").equals("true")) {
				player.sendMessage(ChatColor.GREEN + "[ZombeBanner] " + ChatColor.WHITE + "You are allowed to cheat!");
				} else { return; }
			}
			if(!ZombeBanner.PermissionCheck("zombe.allowfly", player) && !ZombeBanner.PermissionCheck("zombe.allowcheat", player)) {
			if(ZombeBanner.config.getProperty("config.showmessages").equals("true")) {
			player.sendMessage(ChatColor.DARK_RED + ZombeBanner.config.getProperty("config.zombedisabledmessage").toString());
			}
		}
	}
}
}