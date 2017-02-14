package com.Kento.ECR.addons;

import org.bukkit.Color;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class PlayerColor {
	static String pr = ChatColor.GREEN + "ECR >> ";

	public static void changePlayerTab(Player p, String color) {
		p.sendMessage(pr + "Done!");
		String pn = p.getName();
		String name = pn;
		switch(color) {
		case "black":
			name = ChatColor.BLACK + pn;
			break;
		case "gray":
			name = ChatColor.GRAY + pn;
			break;
		case "blue":
			name = ChatColor.BLUE + pn;
			break;
		case "magenta":
			name = ChatColor.DARK_PURPLE + pn;
			break;
		case "aqua":
			name = ChatColor.AQUA + pn;
			break;
		case "pink":
			name = ChatColor.LIGHT_PURPLE + pn;
			break;
		case "green":
			name = ChatColor.DARK_GREEN + pn;
			break;
		case "gold":
			name = ChatColor.GOLD + pn;
			break;
		case "lime":
			name = ChatColor.GREEN + pn;
			break;
		case "yellow":
			name = ChatColor.YELLOW + pn;
			break;
		case "white":
			name = ChatColor.WHITE + pn;
			break;
		}
		p.setPlayerListName(name);
	}
}
