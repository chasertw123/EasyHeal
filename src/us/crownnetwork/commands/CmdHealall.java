package us.crownnetwork.commands;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.crownnetwork.Main;

public class CmdHealall implements CommandExecutor {

	Main plugin;
	
	public CmdHealall(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("Healall")) {
			
			if (!(sender instanceof Player))
				
				for (Player all : Bukkit.getOnlinePlayers())
					all.setHealth(all.getMaxHealth());
			
			else {
				Player p = (Player) sender;
				
				if (p.hasPermission("easyheal.healall"))
					
					for (Player all : Bukkit.getOnlinePlayers())
						all.setHealth(all.getMaxHealth());
				
				else plugin.noPermission(p);
			}
			
			if (args.length >= 1) {
				
				if (!(sender instanceof Player))
					plugin.sendConsole(Level.INFO, "Invalid arguments!");
				
				else {
					Player p = (Player) sender;
					
					if (p.hasPermission("easyheal.healall"))
						plugin.sendMessage(p, ChatColor.RED + "Invalid arguments!");
					
					else plugin.noPermission(p);
				}
			}
		}
		return false;
	}

}
