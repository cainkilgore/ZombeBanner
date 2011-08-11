package me.cain.cfbanner;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class CFListener extends PlayerListener
{
	CFBanner plugin;
	Server server;
	Player player;
	
	public CFListener(CFBanner instance)
	{
		this.plugin = instance;
	}
	
	public void onPlayerJoin(PlayerJoinEvent Event) {
		Player player = Event.getPlayer();
		if(!CFBanner.PermissionCheck("cf.allowfly", player)) {
				String nofly = "&f &f &1 &0 &2 &4 ";
				nofly = nofly.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				String newfly = "&3 &9 &2 &0 &0 &1 ";
				newfly = newfly.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				player.sendMessage(nofly + newfly);

			} 
		else {
				if(CFBanner.config.getProperty("config.showmessages").equals("true")) {
				player.sendMessage(ChatColor.GREEN + "[CFBanner] " + ChatColor.WHITE + "You are allowed to fly!");
			}
		}
		
			if(!CFBanner.PermissionCheck("cf.allowcheat", player)) {
				String nocheat = "&f &f &2 &0 &4 &8 ";
				nocheat = nocheat.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				String newcheat = "&3 &9 &2 &0 &0 &2 ";
				newcheat = newcheat.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				String noentity = "&3 &9 &2 &0 &0 &3 ";
				noentity = noentity.replaceAll("(&([a-f0-9]))", "\u00A7$2");
				player.sendMessage(nocheat + newcheat + noentity);
			}
			
			else {
				if(CFBanner.config.getProperty("config.showmessages").equals("true")) {
				player.sendMessage(ChatColor.GREEN + "[CFBanner] " + ChatColor.WHITE + "You are allowed to cheat!");
				} else { return; }
				
			
			}
			if(!CFBanner.PermissionCheck("cf.allowfly", player) && !CFBanner.PermissionCheck("cf.allowcheat", player)) {
			if(CFBanner.config.getProperty("config.showmessages").equals("true")) {
			player.sendMessage(ChatColor.DARK_RED + CFBanner.config.getProperty("config.cfdisabledmessage").toString());
			}
		}
}
}