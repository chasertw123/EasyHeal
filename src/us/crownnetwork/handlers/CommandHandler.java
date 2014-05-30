package us.crownnetwork.handlers;

import us.crownnetwork.Main;
import us.crownnetwork.commands.CmdHeal;
import us.crownnetwork.commands.CmdHealall;

public class CommandHandler {

	Main plugin;
	
	public CommandHandler(Main plugin) {
		this.plugin = plugin;
	}
	
	public void init() {
		plugin.getCommand("heal").setExecutor(new CmdHeal(plugin));
		plugin.getCommand("healall").setExecutor(new CmdHealall(plugin));
	}
}
