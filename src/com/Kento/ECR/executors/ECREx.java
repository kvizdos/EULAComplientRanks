package com.Kento.ECR.executors;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.Kento.ECR.Main;
import com.Kento.ECR.methods.Followers;
import com.Kento.ECR.methods.GivingMoney;

import net.md_5.bungee.api.ChatColor;

public class ECREx implements CommandExecutor {
	String pr = ChatColor.GREEN + "ECR >> ";
	String er = ChatColor.RED + "ECR >> ";

	GivingMoney gm;
	Followers fs;

	ItemStack head = new ItemStack(Material.WOOD);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("ecr") && sender.hasPermission("ecr.main")) {

				if(args.length == 0) {

					sender.sendMessage(pr + "Do /ecr help for help!");
					return true;
				} else if(args[0].equalsIgnoreCase("help")) {

					sender.sendMessage(pr + "Commands:");
					sender.sendMessage(pr + "/ecr reload -- Reloads the config");
					sender.sendMessage(pr + "/ecr sw <donator> <amount> -- Activates the Server Wide Donation (Usage is for BuyCraft)");
					return true;
				} else if(args[0].equalsIgnoreCase("reload")) {
					Main.plugin.reloadConfig();
					sender.sendMessage(pr + "Done!");
					return true;
				} else if(args[0].equalsIgnoreCase("sw")) {
					if(args.length == 1) {
						sender.sendMessage(pr + "Please do '/ecr sw <player> <amount>'!");
						return true; 
					} else {
						Player donator = Bukkit.getPlayer(args[1]);
							if(args.length == 1 || args.length == 2) {
								sender.sendMessage(pr + "Please do '/ecr sw <player> <amount>'!");
							} else {
								if(Bukkit.getOnlinePlayers().contains(donator)) {
									gm.price = Integer.parseInt(args[2]);
									gm.serverMoney(donator, Integer.parseInt(args[2]));
								} else {
									sender.sendMessage(er + "That player is not online.");
								}	
							}
						
						return true;
					}
				}
			} else if(!sender.hasPermission("ecr.main")) {
				sender.sendMessage(er + "You Do Not Have Permission! (ecr.main)");
				return true;
			}
		
		
		return false;
 }
}
