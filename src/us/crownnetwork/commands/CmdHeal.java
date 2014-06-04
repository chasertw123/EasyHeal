package us.crownnetwork.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.crownnetwork.Main;

public class CmdHeal implements CommandExecutor {

	Main plugin;
	
	public CmdHeal(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("Heal")) {
			
			if (args.length == 0) {
				
				if (!(sender instanceof Player))
					plugin.sendConsole("You must be a player in order to heal yourself!");
				
				else {
					Player p = (Player) sender;
					
					if (p.hasPermission("easyheal.heal"))
						p.setHealth(p.getMaxHealth());
					
					else plugin.noPermission(p);
				}
				
			} else if (args.length == 1) {
				@SuppressWarnings("deprecation")
				Player other = Bukkit.getPlayerExact(args[0]);
				
				if (!(sender instanceof Player))
					if (other != null)
						other.setHealth(other.getMaxHealth());
				
					else plugin.sendConsole("That player could not be found!");
				
				else {
					Player p = (Player) sender;
					
					if (p.hasPermission("easyheal.heal.others"))
						
						if (other != null)
							other.setHealth(other.getMaxHealth());
					
						else plugin.sendMessage(p, ChatColor.RED + "That player counld not be found!");
					
					else plugin.noPermission(p); 
						
				}
				
			} else {
				if (!(sender instanceof Player)) 
					plugin.sendConsole("Invaild arguments!");
				
				else {
					Player p = (Player) sender;
					
					if (p.hasPermission("easyheal.heal") || p.hasPermission("easyheal.heal.others"))
						plugin.sendMessage(p, ChatColor.RED + "Invalid arguments");
					
					else plugin.noPermission(p);
				}
			}
		}
		
		return false;
	}

}
