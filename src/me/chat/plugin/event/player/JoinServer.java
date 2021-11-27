package me.chat.plugin.event.player;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import me.chat.plugin.ChatControl;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class JoinServer implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p =e.getPlayer();
		if(!p.hasPlayedBefore()) {
				if(p.hasPermission("md.core.join.owner")) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.f, 100.f);
					p.getWorld().playEffect(p.getLocation(),Effect.EXPLOSION,0);
					fireword1(p);
					fireword2(p);
					fireword3(p);
					e.setJoinMessage("§7[§a§l+§7] §4"+p.getName()+" §aJoined The Game.");
				}
				else if(p.hasPermission("md.core.join.staff")) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.f, 100.f);
					e.setJoinMessage("§7[§a§l+§7] "+String.valueOf(PermissionsEx.getUser(p).getSuffix()).replace("&", "§")+p.getName()+" §7Joined The Game.");
				}
				else if(p.hasPermission("md.core.join.premium")) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.f, 100.f);
					e.setJoinMessage("§7[§a§l+§7] "+String.valueOf(PermissionsEx.getUser(p).getSuffix()).replace("&", "§")+p.getName()+"§7 Connected.");
				}
				else {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.f, 100.f);
					e.setJoinMessage((String)null);
				}
			
		} else {
				if(p.hasPermission("md.core.join.owner")) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.f, 100.f);
					p.getWorld().playEffect(p.getLocation(),Effect.EXPLOSION,0);
					fireword1(p);
					fireword2(p);
					fireword3(p);
					e.setJoinMessage("§7[§a§l+§7] §4"+p.getName()+" §aJoined The Game.");
				}
				else if(p.hasPermission("md.core.join.staff")) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.f, 100.f);
					e.setJoinMessage("§7[§a§l+§7] "+String.valueOf(PermissionsEx.getUser(p).getSuffix()).replace("&", "§")+p.getName()+" §7Joined The Game.");
				}
				else if(p.hasPermission("md.core.join.premium")) {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.f, 100.f);
					e.setJoinMessage("§7[§a§l+§7] "+String.valueOf(PermissionsEx.getUser(p).getSuffix()).replace("&", "§")+p.getName()+"§7 Connected.");
				}
				else {
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 100.f, 100.f);
					e.setJoinMessage((String)null);
				}
		}
		p.getGameMode();
		p.setGameMode(GameMode.SURVIVAL);
	}
	
	public void fireword1(Player p) {
	    Firework fw = (Firework)p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
	    FireworkMeta fwm = fw.getFireworkMeta();
	    Random r = new Random();
	    FireworkEffect.Type type = FireworkEffect.Type.BALL_LARGE;
	    
	      int rt = r.nextInt(5) + 1;
	      if (rt == 1)
	        type = FireworkEffect.Type.BALL; 
	      if (rt == 2)
	        type = FireworkEffect.Type.BALL_LARGE; 
	      if (rt == 3)
	        type = FireworkEffect.Type.BURST; 
	      if (rt == 4)
	        type = FireworkEffect.Type.CREEPER; 
	      if (rt == 5)
	        type = FireworkEffect.Type.STAR; 
	    
	    int a = r.nextInt(256);
	    int b = r.nextInt(256);
	    int g = r.nextInt(256);
	    Color c1 = Color.fromRGB(a, g, b);
	    a = r.nextInt(256);
	    b = r.nextInt(256);
	    g = r.nextInt(256);
	    Color c2 = Color.fromRGB(a, g, b);
	    FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
	    fwm.addEffect(effect);
	    int rp = r.nextInt(2) + 1;
	    fwm.setPower(rp);
	    fw.setFireworkMeta(fwm);
	  }
	public void fireword2(Player p) {
	    Firework fw = (Firework)p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
	    FireworkMeta fwm = fw.getFireworkMeta();
	    Random r = new Random();
	    FireworkEffect.Type type = FireworkEffect.Type.BALL_LARGE;
	    
	      int rt = r.nextInt(5) + 1;
	      if (rt == 1)
	        type = FireworkEffect.Type.BALL; 
	      if (rt == 2)
	        type = FireworkEffect.Type.BALL_LARGE; 
	      if (rt == 3)
	        type = FireworkEffect.Type.BURST; 
	      if (rt == 4)
	        type = FireworkEffect.Type.CREEPER; 
	      if (rt == 5)
	        type = FireworkEffect.Type.STAR; 
	    
	    int a = r.nextInt(256);
	    int b = r.nextInt(150);
	    int g = r.nextInt(150);
	    Color c1 = Color.fromRGB(a, g, b);
	    a = r.nextInt(256);
	    b = r.nextInt(150);
	    g = r.nextInt(150);
	    Color c2 = Color.fromRGB(a, g, b);
	    FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
	    fwm.addEffect(effect);
	    int rp = r.nextInt(2) + 1;
	    fwm.setPower(rp);
	    fw.setFireworkMeta(fwm);
	  }
	public void fireword3(Player p) {
	    Firework fw = (Firework)p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
	    FireworkMeta fwm = fw.getFireworkMeta();
	    Random r = new Random();
	    FireworkEffect.Type type = FireworkEffect.Type.BALL_LARGE;
	    
	      int rt = r.nextInt(5) + 1;
	      if (rt == 1)
	        type = FireworkEffect.Type.BALL; 
	      if (rt == 2)
	        type = FireworkEffect.Type.BALL_LARGE; 
	      if (rt == 3)
	        type = FireworkEffect.Type.BURST; 
	      if (rt == 4)
	        type = FireworkEffect.Type.CREEPER; 
	      if (rt == 5)
	        type = FireworkEffect.Type.STAR; 
	    
	    int a = r.nextInt(150);
	    int b = r.nextInt(150);
	    int g = r.nextInt(256);
	    Color c1 = Color.fromRGB(a, g, b);
	    a = r.nextInt(150);
	    b = r.nextInt(150);
	    g = r.nextInt(256);
	    Color c2 = Color.fromRGB(a, g, b);
	    FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
	    fwm.addEffect(effect);
	    int rp = r.nextInt(2) + 1;
	    fwm.setPower(rp);
	    fw.setFireworkMeta(fwm);
	  }
	
}
