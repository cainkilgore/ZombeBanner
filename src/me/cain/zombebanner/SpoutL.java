package me.cain.zombebanner;

import org.bukkit.Material;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.event.spout.SpoutListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SpoutL extends SpoutListener{
	ZombeBanner plugin;
	
    public SpoutL(ZombeBanner plugin) {
        this.plugin = plugin;
    }
	
	public void onSpoutCraftEnable(SpoutCraftEnableEvent event) {
        if(!event.getPlayer().isSpoutCraftEnabled()) {
        	return;
        } else {
        	if(ZombeBanner.permissionHandler.has((SpoutPlayer) event.getPlayer(), "zombe.allowfly") || ZombeBanner.permissionHandler.has((SpoutPlayer) event.getPlayer(), "zombe.allowcheat")) {
		if(ZombeBanner.config.getProperty("config.showmessages").equals("true")) {
			final SpoutPlayer splayer = (SpoutPlayer) event.getPlayer();
				splayer.sendNotification("Zombebanner", ZombeBanner.config.getProperty("config.allowedmodsmessage").toString(), Material.DIAMOND);
		}
		else {
			return;
		}
        	}
        }
	}
	
	
}
