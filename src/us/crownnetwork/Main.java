package us.crownnetwork;

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
		this.sendConsole("[EasyHeal] EasyHeal V" + this.getDescription().getVersion() + " has been enabled!");
	}
	
	public void onDisable() {
		
		/** Disable Message **/
		this.sendConsole("[EasyHeal] EasyHeal V" + this.getDescription().getVersion() + " has been disabled!");
	}
	
	/************************************************
	 * 												*
	 *					Messages					*
	 * 												*
	 ************************************************/
	
	String prefix = ChatColor.WHITE + "[" + ChatColor.AQUA + "" 
			+ ChatColor.ITALIC + "EasyHeal" + ChatColor.WHITE + "] "; 
	
	public void sendMessage(Player p, String message) {
		p.sendMessage(prefix + message);
	}
	
	public void sendConsole(String message) {
		this.getLogger().info(message);
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
