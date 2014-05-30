package us.crownnetwork;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import us.crownnetwork.handlers.CommandHandler;

public class Main extends JavaPlugin {
	
	/** Classes **/
	private CommandHandler ch = new CommandHandler(this);
	
	public void onEnable() {
		/** Configuration Management **/
		//TODO - Add message managment
		
		/** Inits **/
		ch.init();
		
		/** Enable Message **/
		this.sendConsole(Level.INFO, "[EasyHeal] EasyHeal V" + this.getDescription().getVersion() + " has been enabled!");
	}
	
	public void onDisable() {
		/** Disable Message **/
		this.sendConsole(Level.INFO, "[EasyHeal] EasyHeal V" + this.getDescription().getVersion() + " has been disabled!");
	}
	
	/************************************************
	 * 												*
	 *					Messages					*
	 * 												*
	 ************************************************/
	
	String prefix = ChatColor.WHITE + "[" + ChatColor.AQUA + "" 
			+ ChatColor.ITALIC + "CrownPvP" + ChatColor.WHITE + "] "; 
	
	public void sendMessage(Player p, String message) {
		p.sendMessage(prefix + message);
	}
	
	public void sendConsole(Level level, String message) {
		this.getLogger().log(level, message);
	}

	public void noPermission(Player p) {
		p.sendMessage(ChatColor.RED + "You do not have permission to do that!");
	}
	
	/************************************************
	 * 												*
	 *				Getters and Setters				*
	 * 												*
	 ************************************************/
}
