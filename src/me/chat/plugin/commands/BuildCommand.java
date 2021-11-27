package me.chat.plugin.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chat.plugin.ChatControl;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class BuildCommand  implements CommandExecutor{
	
	public static ArrayList<Player> build = new ArrayList<>();
	public ChatControl plugin;
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		boolean consle = args.length == 1;
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("build")) {
			if(sender instanceof Player) {
				if(p.hasPermission("md.build.me")) {
						if(args.length == 0) {
							if(build.contains(p)) {
								p.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §cBuild mode is turned off.");
								p.setGameMode(GameMode.ADVENTURE);
								p.playSound(p.getLocation(), Sound.BAT_DEATH, 100.0f, 100.0f);
								p.getInventory().clear();
							    p.getInventory().setArmorContents(null);
								build.remove(p);
							} else {
								p.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §aBuild mode is turned on.");
								p.setGameMode(GameMode.CREATIVE);
								p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 100.0f, 100.0f);
								p.getInventory().clear();
							    p.getInventory().setArmorContents(null);
								build.add(p);
							}
						} else if(args.length == 1) {
							if(p.hasPermission("md.build")) {
							Player user = Bukkit.getPlayer(args[0]);
							if(user != null) {
								if(build.contains(user)) {
									p.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §aBuild mode is §c§lTurned OFF §afor "+String.valueOf(PermissionsEx.getUser(user).getSuffix()).replace("&", "§")+user.getName());
									user.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §aBuild mode is §c§lTurned OFF §aBy "+String.valueOf(PermissionsEx.getUser(p).getSuffix()).replace("&", "§")+p.getName());
									user.setGameMode(GameMode.ADVENTURE);
									user.playSound(p.getLocation(), Sound.BAT_DEATH, 100.0f, 100.0f);
									p.playSound(p.getLocation(), Sound.BAT_DEATH, 100.0f, 100.0f);
									user.getInventory().clear();
								    user.getInventory().setArmorContents(null);
								    build.remove(user);
								} else {
									p.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §aBuild mode is §2§lTurned ON §afor "+String.valueOf(PermissionsEx.getUser(user).getSuffix()).replace("&", "§")+user.getName());
									user.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §aBuild mode is §2§lTurned ON §aBy "+String.valueOf(PermissionsEx.getUser(p).getSuffix()).replace("&", "§")+p.getName());
									user.setGameMode(GameMode.CREATIVE);
									user.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 100.0f, 100.0f);
									p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 100.0f, 100.0f);
									user.getInventory().clear();
								    user.getInventory().setArmorContents(null);
								    build.add(user);
								}
							} else {
								p.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §cThis player is offline.");
							}
						} else {
							p.sendMessage("§c§l[§4§lℹ§c§l] ERROR §7You do not have enough permissions.");
						}
					} else {
						p.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD &eUsage: §f/build §7or §f/build <player>");
					}
				} else {
					p.sendMessage("§c§l[§4§lℹ§c§l] ERROR §7You do not have enough permissions.");
				}
			}
			else if (sender.equals(consle)) {
				Player user = Bukkit.getPlayer(args[0]);
				if(user != null) {
					if(build.contains(user)) {
						sender.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §aBuild mode is §c§lTurned OFF §afor "+String.valueOf(PermissionsEx.getUser(user).getSuffix()).replace("&", "§")+user.getName());
						user.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §aBuild mode is §c§lTurned ON §aBy §4§oCONSOLE");
						user.setGameMode(GameMode.ADVENTURE);
						user.playSound(p.getLocation(), Sound.BAT_DEATH, 100.0f, 100.0f);
						user.getInventory().clear();
						build.remove(user);
					} else {
						sender.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §aBuild mode is §2§lTurned ON §afor "+String.valueOf(PermissionsEx.getUser(user).getSuffix()).replace("&", "§")+user.getName());
						user.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD §7§l➤ §aBuild mode is §2§lTurned ON §aBy §4§oCONSOLE");
						user.setGameMode(GameMode.CREATIVE);
						user.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 100.0f, 100.0f);
						user.getInventory().clear();
						build.add(user);
					}
				} else {
					p.sendMessage("§2§l[§a§l⚒§2§l] §a§lBUILD &cThis player is offline.");
				}
			} else {
				sender.sendMessage("§c§l[§4§lℹ§c§l] ERROR §7You cannot do this command in consle.");
			}
		}
		return false;
	}
	

}
