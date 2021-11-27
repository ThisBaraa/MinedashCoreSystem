package me.chat.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chat.plugin.ChatControl;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MuteChat implements CommandExecutor{

	private ChatControl plugin;
	public MuteChat(ChatControl plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		if(p.hasPermission("md.core.mc")) {
			if(!this.plugin.MuteChat) {
				this.plugin.MuteChat = true;
				Bukkit.broadcastMessage("§c§l[⚠] MUTECHAT §7Chat has been §cDisabled By "+String.valueOf(PermissionsEx.getUser(p).getSuffix()).replace("&", "§")+p.getName());
			}else {
				this.plugin.MuteChat = false;
				Bukkit.broadcastMessage("§c§l[⚠] MUTECHAT §7Chat has been §aEnabled By "+String.valueOf(PermissionsEx.getUser(p).getSuffix()).replace("&", "§")+p.getName());
			}
		}else {
			p.sendMessage("§c§l[§4§lℹ§c§l] ERROR §7You do not have enough permissions.");
		}
		
		return false;
	}

}
