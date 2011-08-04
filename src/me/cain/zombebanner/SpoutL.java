package me.cain.zombebanner;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.CustomEventListener;
import org.bukkit.event.Event;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.event.spout.SpoutListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SpoutL extends SpoutListener{

	SpoutPlayer player;
	ZombeBanner plugin;
	
    public SpoutL(ZombeBanner plugin) {
        this.plugin = plugin;
    }
	
	public void onSpoutCraftEnable(SpoutCraftEnableEvent event) {
        if(!event.getPlayer().isSpoutCraftEnabled()) {
        	player.sendMessage("Spout please!");
        } else {
		if(ZombeBanner.config.getProperty("config.showmessages").equals("true")) {
			final SpoutPlayer splayer = (SpoutPlayer) player;
				splayer.sendNotification("Zombebanner", "You can use ZombeFly!", Material.GRASS);
		}
        }
		
	}
	
	
}
