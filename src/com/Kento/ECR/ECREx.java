package com.Kento.ECR;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ECREx implements CommandExecutor {
	String pr = ChatColor.GREEN + "ECR >> ";
	String er = ChatColor.RED + "ECR >> ";

	GivingMoney gm;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("ecr") && p.hasPermission("ecr.main")) {
			
			if(args.length == 0) {
				p.sendMessage(pr + "Do /ecr help for help!");
				return true;
			} else if(args[0].equalsIgnoreCase("help")) {
				p.sendMessage(pr + "Commands:");
				p.sendMessage(pr + "/ecr reload -- Reloads the config");
				p.sendMessage(pr + "/ecr swm <donator> -- Activates the Server Wide Donation (Usage is for BuyCraft)");
				return true;
			} else if(args[0].equalsIgnoreCase("reload")) {
				Main.plugin.reloadConfig();
				p.sendMessage(pr + "Done!");
				return true;
			} else if(args[0].equalsIgnoreCase("swm")) {
				if(args.length == 1) {
					p.sendMessage(pr + "Please do '/ecr swm <donator>'!");
					return true;
				} else {
					Player donator = Bukkit.getPlayer(args[1]);
					gm.serverMoney(donator);
					return true;
				}
			}
		} else if(!p.hasPermission("ecr.main")) {
			p.sendMessage(er + "You Do Not Have Permission! (ecr.main)");
			return true;
		}
		
		return false;
	}
}
