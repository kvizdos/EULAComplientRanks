package com.Kento.ECR.addons;

import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.Kento.ECR.Main;

import net.md_5.bungee.api.ChatColor;

public class Fly implements Listener{
	public static Fly Fly = new Fly();
	static ArrayList<Player> players = new ArrayList<Player>();
	
	static FileConfiguration config = Main.plugin.getConfig();

	public static void enableFly(Player p) {
		if(players.contains(p)) {
			players.remove(p);
			p.setFlying(false);
			p.setAllowFlight(false);
			p.sendMessage(ChatColor.RED + "Succesfully Disabled 'Flight'");
		} else {
			p.sendMessage(ChatColor.GREEN + "Succesfully Enabled 'Flight'");

			players.add(p);
			p.setAllowFlight(true);
			p.setFlying(true);
		}
	}
}
