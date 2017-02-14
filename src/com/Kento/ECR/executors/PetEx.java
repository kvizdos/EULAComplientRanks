package com.Kento.ECR.executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Kento.ECR.addons.Pets;
import com.Kento.ECR.methods.GivingMoney;

import net.md_5.bungee.api.ChatColor;

public class PetEx implements CommandExecutor {
	String pr = ChatColor.GREEN + "ECR >> ";
	String er = ChatColor.RED + "ECR >> ";

	GivingMoney gm;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;

		if(cmd.getName().equalsIgnoreCase("pet") && p.hasPermission("ecr.pet")) {
			if(args.length == 0) {
				p.sendMessage(pr + "To spawn a pet, use /pet <entity>. Available pets: dog, cat, sheep, cow");
				return true;
			} else if(args[0].equalsIgnoreCase("dog")) {
				Pets.spawnPet("dog", p);
			}
			
		} else if(!p.hasPermission("ecr.thank")) {
			p.sendMessage(er + "You Do Not Have Permission! (ecr.thank)");
			return true;
		}
		
		return false;
	}
}

