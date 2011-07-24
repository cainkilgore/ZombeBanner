package me.cain.zombebanner;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class ZombeBanner extends JavaPlugin
{
	private final ZombeListener TheListener = new ZombeListener(this);	
	Player player;
	public Configuration config;
	Logger log = Logger.getLogger("Minecraft");
	String pluginname = "ZombeBanner";
	public static PermissionHandler permissionHandler;


	public void onDisable() 
	{
		log.info("[" + pluginname + "] " + pluginname + " has been disabled.");
	}

	public void onEnable() 
	{
		config = this.getConfiguration();
			PluginManager pm = getServer().getPluginManager();
		log.info("[" + pluginname + "] " + pluginname + " has been enabled.");
		log.info("[" + pluginname + "] Created by CainFoool");
		pm.registerEvent(Event.Type.PLAYER_INTERACT, new ZombeListener(this), Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, TheListener, Priority.Normal, this);
		setupPermissions();
		ConfigFile();
		config.load();
		ConfigurationCheck();
	}
	
	  public static boolean PermissionCheck(String node, Player player) {
		    if (permissionHandler != null) {
		      return permissionHandler.has(player, node);
		    }
		    return player.hasPermission(node);
		  }
	
	public void ConfigurationCheck() 
	{
		if(config.getProperty("config.showmessages") == null)
		{
		     config.setProperty("config.showmessages", "true");
		     config.save();
		}
	}
	
	 private void ConfigFile() {
		  
		  String file = this.getDataFolder().toString()+"/config.yml";
		  
		  File yml = new File(file);
		  
		  if (!yml.exists()) {
		   new File(this.getDataFolder().toString()).mkdir();
		   
		   try {
		    yml.createNewFile();
		   } catch (IOException e) {
		    e.printStackTrace();
		   }
		  }
		 }
	 
	 private void setupPermissions() {
		    if (permissionHandler != null) {
		        return;
		    }
		    
		    Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
		    
		    if (permissionsPlugin == null) {
		        log.info("Permission system not detected, defaulting to OP");
		        return;
		    }
		    
		    permissionHandler = ((Permissions) permissionsPlugin).getHandler();
		    log.info("Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
		}
}
		
// Created by CainFoool