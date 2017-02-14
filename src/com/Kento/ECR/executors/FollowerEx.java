package com.Kento.ECR.executors;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.Kento.ECR.methods.Followers;

import net.md_5.bungee.api.ChatColor;

public class FollowerEx implements CommandExecutor {
	
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("follower") && sender.hasPermission("ecr.follower")) {

				if(args.length == 0) {
					p.sendMessage(ChatColor.GREEN + "Please type a block ID!");
					return true;
				}
				else if(args.length == 1 && !args[0].equals("stop")) {
					if(Material.getMaterial(Integer.parseInt(args[0])) == null) {
						p.sendMessage(ChatColor.RED + "Invalid Block. (Please Use ID's!)");
					} else {
						Followers.spawnFollower(p, Material.getMaterial(Integer.parseInt(args[0])));
					}
					return true;
				}
				else if(args[0].equalsIgnoreCase("stop")) {
					Followers.removeFollower(p);
					return true;
				}
		}
		return false;
	}

}
