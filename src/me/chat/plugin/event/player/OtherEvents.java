package me.chat.plugin.event.player;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import me.chat.plugin.ChatControl;
import me.chat.plugin.commands.BuildCommand;

public class OtherEvents implements Listener{
	
	  @EventHandler
	  public void onFood(FoodLevelChangeEvent e) {
	    e.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void onWeather(WeatherChangeEvent e) {
	    e.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void onAchievement(PlayerAchievementAwardedEvent e) {
		  e.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void onBlockPlace(BlockPlaceEvent e) {
	    Player p = e.getPlayer();
	    if (BuildCommand.build.contains(p) || e.getBlockPlaced().getType().isFlammable()) {
	      e.setCancelled(false);
	    } else {
			e.getBlock().getType();
			if(Material.FLINT_AND_STEEL != null) {
			  e.setCancelled(false);
			} else {
			  e.setCancelled(true);
			}
		}
	  }
	  
	  /*
	  @EventHandler
	  public void onBlockPlace2(BlockPlaceEvent e) {
	    Player p = e.getPlayer();
	    if (BuildCommand.build.contains(p)) {
	      e.setCancelled(false);
	    } else {
	      e.setCancelled(true);
		}
	  }
	  */
	  
	  @EventHandler
	  public void onBlockIgniteEvent(BlockIgniteEvent e) {
		  e.setCancelled(false);
	  }
	  
	  @EventHandler
	  public void onBlockBreak(BlockBreakEvent e) {
	    Player p = e.getPlayer();
	    if (BuildCommand.build.contains(p)) {
	      e.setCancelled(false);
	    } else {
	      e.setCancelled(true);
	    } 
	  }
	  
	  @EventHandler
	  public void onDropItems(PlayerDropItemEvent e) {
	    Player p = e.getPlayer();
	    if (BuildCommand.build.contains(p)) {
	      e.setCancelled(false);
	    } else {
	      e.setCancelled(true);
	    } 
	  }
	  
	  /*
	  @EventHandler
	    public void onRodLand(ProjectileHitEvent e) {
	        if(!(e.getEntityType() == EntityType.FISHING_HOOK)) {
	            return;
	        }
	        for(Entity entity : Bukkit.getWorld(e.getEntity().getLocation().getWorld().getName()).getNearbyEntities(e.getEntity().getLocation(), 0.5, 0.5, 0.5)) {
	            if(!(entity instanceof Player)) {
	                continue;
	            }
	            FishHook hook = (FishHook) e.getEntity();
	            Player rodder = (Player) hook.getShooter();
	            Player player = (Player) entity;
	            if(player.getName().equalsIgnoreCase(rodder.getName())) {
	                continue;
	            }
	            player.damage(0.1);
	            Location loc = player.getLocation().add(0, 1.0, 0);
	            player.teleport(loc);
	            player.setVelocity(rodder.getLocation().getDirection().multiply(+1.4));
	            
	            hook.remove();
	            rodder.updateInventory();
	            return;
	        }
	    }
	  
	  @EventHandler
	  public void onFish(PlayerFishEvent e) {
	      if (e.getState() == PlayerFishEvent.State.CAUGHT_ENTITY) {
	          e.setCancelled(true);
	          e.getHook().remove();
	      }
	  }
	  
	  @EventHandler
	    public void fishingThrow(ProjectileLaunchEvent e){
	        Projectile hook = e.getEntity();
	        if(e.getEntityType().equals(EntityType.FISHING_HOOK)){
	            hook.setVelocity(hook.getVelocity().multiply(1.5));
	            hook.setBounce(false);
	        }
	    }
	  
	  @EventHandler
	    public void fishingHit(ProjectileHitEvent e){
	        Projectile hook = e.getEntity();
	        if(e.getEntityType().equals(EntityType.FISHING_HOOK)){
	        	hook.setBounce(false);
	            hook.getLastDamageCause().setCancelled(true);
	        }
	    }
	  */
	  @EventHandler
	  public void onRespawn(PlayerRespawnEvent e) {
			Player p = e.getPlayer();
			ChatControl.spawnteleport(p);
			p.setLevel(0);
			p.getGameMode();
			p.setGameMode(GameMode.SURVIVAL);
			ChatControl.spawnteleport(p);
		}
	  
	  @EventHandler
	  public void onBlockedCommand(PlayerCommandPreprocessEvent e) {
	    Player p = e.getPlayer();
	    String cmd = e.getMessage();
	    if (cmd.contains("gamemode") || cmd.contains("gmc") || cmd.contains("gms")) {
	      e.setCancelled(true);
	      if (p.hasPermission("md.build.me") || p.hasPermission("md.build")) {
	        p.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §eUsage: §f/build §7or §f/build <player>");
	      } else {
	        p.sendMessage("§c§l[§4§lℹ§c§l] ERROR §7You do not have enough permissions.");
	      } 
	    } 
	  }

}
