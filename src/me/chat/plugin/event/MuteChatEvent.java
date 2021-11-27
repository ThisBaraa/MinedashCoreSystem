package me.chat.plugin.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.chat.plugin.ChatControl;

public class MuteChatEvent implements Listener{
	
	private ChatControl plugin;
	public MuteChatEvent(ChatControl plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if(this.plugin.MuteChat) {
			Player p = e.getPlayer();
			if(p.hasPermission("md.core.mc.pass")) {
				e.setCancelled(false);
			}else {
				e.setCancelled(true);
				p.sendMessage("§4§l[⚠] MUTECHAT §cSorry.. §7You canot use chat right now.");
			}
		}else {
			return;
		}
	}

}
