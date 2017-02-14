package com.Kento.ECR.executors;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Kento.ECR.methods.GivingMoney;

import net.md_5.bungee.api.ChatColor;

public class ThankEx implements CommandExecutor {
	String pr = ChatColor.GREEN + "ECR >> ";
	String er = ChatColor.RED + "ECR >> ";

	GivingMoney gm;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;

		if(cmd.getName().equalsIgnoreCase("thank") && p.hasPermission("ecr.thank")) {
			if(args.length == 0) {
				Player dona = gm.wDonator.get(0);
				gm.thankYou(p, dona);
				return true;
			}
			
		} else if(!p.hasPermission("ecr.thank")) {
			p.sendMessage(er + "You Do Not Have Permission! (ecr.thank)");
			return true;
		}
		
		return false;
	}
}
