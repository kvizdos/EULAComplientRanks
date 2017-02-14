package com.Kento.ECR.methods;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.Kento.ECR.Main;

import net.md_5.bungee.api.ChatColor;

public class GivingMoney implements Listener {
	static String pr = ChatColor.GREEN + "ECR >> ";
	public static ArrayList<Player> wDonator = new ArrayList<Player>();
	static ArrayList<Player> thankers = new ArrayList<Player>();
	public static int price = 0;

	public static void serverMoney(Player donator, Integer amount) {
		donator.sendMessage(pr + "Thank you for donating!");
		wDonator.clear();
		thankers.clear();
		wDonator.add(donator);
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(pr + ChatColor.AQUA + donator.getName() + ChatColor.GREEN + " has given everyone " + ChatColor.AQUA + Main.plugin.getConfig().getInt("WorldWideMoney") + ChatColor.GREEN + ", if you would like to thank the player and earn "+price+", please do '/thank' or '/ty'");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + p.getName().toString() + " " + amount);
		}
	}
	static String er = ChatColor.RED + "ECR >> ";

	public static void thankYou(Player thanker, Player donator) {
		if(wDonator.isEmpty()) {
			thanker.sendMessage(er + "There is no current donator, feel free to donate here: " + Main.plugin.getConfig().getString("URL.Donate"));
		} else {
		if(!thankers.contains(thanker)) {
				thankers.add(thanker);
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + donator.getName().toString() + " " + price);
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + thanker.getName().toString() + " " + price);

				thanker.sendMessage(pr + "Thank you! Your award is: " + price);
				donator.sendMessage(pr + thanker.getName() + " has thanked you, so you earned " + price);
			
		} else {
			thanker.sendMessage(er + "You have already thanked this person!");
		}
		}
	}
}
