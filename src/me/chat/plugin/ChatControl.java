package me.chat.plugin;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.chat.plugin.commands.BuildCommand;
import me.chat.plugin.commands.CC;
import me.chat.plugin.event.MuteChatEvent;
import me.chat.plugin.event.player.JoinServer;
import me.chat.plugin.event.player.OtherEvents;
import me.chat.plugin.event.player.QuitSever;


public class ChatControl extends JavaPlugin{
	
	public boolean MuteChat;
	public static Permission perms;
	static String oneffect;
	
	////////////////////////-------> config.yml FILE <-------////////////////////////
	public static File configf = new File("plugins/MinedashCore", "config.yml");
	public static FileConfiguration config = YamlConfiguration.loadConfiguration(configf);
	////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage("§9--------------------------");
		Bukkit.getServer().getConsoleSender().sendMessage("§6MinedashCore is §aEnabled");
		Bukkit.getServer().getConsoleSender().sendMessage("§6This Plugin by: §4Kayjiin");
		Bukkit.getServer().getConsoleSender().sendMessage("§9--------------------------");
	    
		Bukkit.getPluginManager().registerEvents(new MuteChatEvent(this), (Plugin)this);
		Bukkit.getPluginManager().registerEvents(new JoinServer(), (Plugin)this);
		Bukkit.getPluginManager().registerEvents(new QuitSever(), (Plugin)this);
		Bukkit.getPluginManager().registerEvents(new OtherEvents(), (Plugin)this);
	    
	    getCommand("cc").setExecutor(new CC());
	    getCommand("mc").setExecutor(new me.chat.plugin.commands.MuteChat(this));
	    getCommand("build").setExecutor(new BuildCommand());
	    
	  }
	
	@Override
	public void onDisable() {
		
	}
	
	public static void spawnset(final Player p) {
        final Location loc = p.getLocation();
        ChatControl.config.set("Spawn.X", (Object)loc.getX());
        ChatControl.config.set("Spawn.Y", (Object)loc.getY());
        ChatControl.config.set("Spawn.Z", (Object)loc.getZ());
        ChatControl.config.set("Spawn.Yaw", (Object)loc.getYaw());
        ChatControl.config.set("Spawn.Pitch", (Object)loc.getPitch());
        ChatControl.config.set("Spawn.World", (Object)loc.getWorld().getName());
        try {
        	ChatControl.config.save(ChatControl.configf);
        }
        catch (IOException ex) {}
    }
    
    public static void spawnteleport(final Player p) {
        try {
            final Location loc = p.getLocation();
            loc.setX(ChatControl.config.getDouble("Spawn.X"));
            loc.setY(ChatControl.config.getDouble("Spawn.Y"));
            loc.setZ(ChatControl.config.getDouble("Spawn.Z"));
            loc.setYaw((float)ChatControl.config.getDouble("Spawn.Yaw"));
            loc.setPitch((float)ChatControl.config.getDouble("Spawn.Pitch"));
            loc.setWorld(Bukkit.getWorld(ChatControl.config.getString("Spawn.World")));
            p.teleport(loc);
            if (ChatControl.oneffect.equalsIgnoreCase("true")) {
            }
        }
        catch (Exception e) {
        }
    }
	
	private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
}
