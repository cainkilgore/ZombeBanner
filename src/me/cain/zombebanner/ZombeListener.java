package me.cain.zombebanner;

import org.bukkit.Server;
import org.bukkit.entity.Player;
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

        @Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if(!ZombeBanner.PermissionCheck("zombe.allowmods", player)) {
			player.sendMessage("ßf ßf ß1 ß0 ß2 ß4 ßf ßf ß2 ß0 ß4 ß8");
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