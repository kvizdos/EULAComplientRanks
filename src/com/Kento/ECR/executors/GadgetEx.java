package com.Kento.ECR.executors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Kento.ECR.GUI;

public class GadgetEx implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(cmd.getName().equalsIgnoreCase("gadget") && sender.hasPermission("ecr.addonspicker")) {
			Player p = (Player) sender;
			p.openInventory(GUI.cmdGUI);
			return true;
		}
		return false;
	}
}
