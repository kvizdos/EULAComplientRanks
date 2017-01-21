package com.Kento.ECR;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;

public class GivingMoney implements Listener {
	static String pr = ChatColor.GREEN + "ECR >> ";
	static ArrayList<Player> wDonator = new ArrayList<Player>();
	static ArrayList<Player> thankers = new ArrayList<Player>();

	public static void serverMoney(Player donator) {
		donator.sendMessage(pr + "Thank you for donating!");
		wDonator.clear();
		thankers.clear();
		wDonator.add(donator);
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(pr + ChatColor.AQUA + donator.getName() + ChatColor.GREEN + " has given everyone " + ChatColor.AQUA + Main.plugin.getConfig().getInt("WorldWideMoney") + ChatColor.GREEN + ", if you would like to thank the player, please do '/thank' or '/ty'");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + p.getName().toString() + " " + Main.plugin.getConfig().getInt("WorldWideMoney"));
		}
	}
	static String er = ChatColor.RED + "ECR >> ";

	public static void thankYou(Player thanker, Player donator) {
		if(wDonator.isEmpty()) {
			thanker.sendMessage(er + "There is no current donator, feel free to donate here: " + Main.plugin.getConfig().getString("URL.Donate"));
		} else {
		if(!thankers.contains(thanker)) {
				thankers.add(thanker);
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + donator.getName().toString() + " " + Main.plugin.getConfig().getInt("WorldWideMoney"));
				thanker.sendMessage(pr + "Thank you for thanking!");
				donator.sendMessage(pr + thanker.getName() + " has thanked you, so you earned " + Main.plugin.getConfig().getInt("WorldWideMoney"));
			
		} else {
			thanker.sendMessage(er + "You have already thanked this person!");
		}
		}
	}
}
