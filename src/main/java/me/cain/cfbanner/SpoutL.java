package me.cain.cfbanner;

import org.bukkit.Material;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.event.spout.SpoutListener;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SpoutL extends SpoutListener {
	CFBanner plugin;

	public SpoutL(CFBanner plugin) {
		this.plugin = plugin;
	}

	public void onSpoutCraftEnable(SpoutCraftEnableEvent event) {
		if (!event.getPlayer().isSpoutCraftEnabled()) {
			return;
		} else {
			if (CFBanner.PermissionCheck("cf.allowfly",
					(SpoutPlayer) event.getPlayer())
					|| CFBanner.PermissionCheck("cf.allowcheat",
							(SpoutPlayer) event.getPlayer())) {
				if (CFBanner.config.getBoolean("config.showmessages", true)) {
					final SpoutPlayer splayer = (SpoutPlayer) event.getPlayer();
					addText("FFFFFF", "CFBanner is on!", "bottom-right",
							splayer);
					splayer.sendNotification("CFBanner",
							"You're allowed mods!", Material.DIAMOND);
				} else {
					return;
				}
			}
		}
	}

	public void addText(String color, String text, String position,
			SpoutPlayer sp) {
		GenericLabel spouttext = new GenericLabel("");
		if (position.toString().equals("health")) {
			spouttext.setHexColor(Integer.parseInt(color, 16)).setX(209)
					.setY(211);
		}
		if (position.toString().equals("top-right")) {
			spouttext.setHexColor(Integer.parseInt(color, 16)).setX(300)
					.setY(5);
		}
		if (position.toString().equals("top-left")) {
			spouttext.setHexColor(Integer.parseInt(color, 16)).setX(3).setY(5);
		}
		if (position.toString().equals("bottom-left")) {
			spouttext.setHexColor(Integer.parseInt(color, 16)).setX(3)
					.setY(220);
		}
		if (position.toString().equals("bottom-right")) {
			spouttext.setHexColor(Integer.parseInt(color, 16)).setX(315)
					.setY(230);
		}
		spouttext.setText(text);
		spouttext.setDirty(true);
		sp.getMainScreen().attachWidget(spouttext);
	}
}
