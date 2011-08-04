package me.cain.zombebanner;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.CustomEventListener;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SpoutListener extends CustomEventListener{

	Player player;
	
	public void onSpoutCraftEnable(SpoutCraftEnableEvent event) {
		if(ZombeBanner.config.getProperty("config.showmessages").equals("true")) {
			final SpoutPlayer splayer = (SpoutPlayer) player;
				splayer.sendNotification("Zombebanner", "You can use ZombeFly!", Material.GRASS);
		}
	}
	
	
}
