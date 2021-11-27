package me.chat.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chat.plugin.ChatControl;


public class SetSpawn implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
	        final Player p = (Player)sender;
	        if (cmd.getName().equalsIgnoreCase("setspawn")) {
	            if (p.hasPermission("md.core.setspawn")) {
	            	ChatControl.spawnset(p);
	                p.sendMessage("§bSuccessfully located spawn location...");
	            }
	            else {
	                p.sendMessage("§c§l[§4§lℹ§c§l] ERROR §7This command is not exist or blocked.");
	            }
	        }
		}
		return false;
	}

}
