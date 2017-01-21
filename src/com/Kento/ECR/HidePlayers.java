/*
 * EULAComplientRanks (c) Kenton Vizdos
 * NOTE: Even though this is Open Source, it is still copywritten, so 
 * you MUST contact EULACompliantRanks@gmail.com to modify code.
 * Have Fun!
 */
package com.Kento.ECR;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;

public class HidePlayers implements Listener {
	static FileConfiguration config = Main.plugin.getConfig();

	public static HidePlayers HidePlayers = new HidePlayers();
	static ArrayList<Player> players = new ArrayList<Player>();

	public static void hidePlayers(Player p) {
		if(players.contains(p)) {
			p.sendMessage(ChatColor.RED + "Succesfully Disabled 'Hidden Players'");
			players.remove(p);
			for(Player pl : Bukkit.getOnlinePlayers()) {
				p.showPlayer(pl);
			}
		} else {
			p.sendMessage(ChatColor.GREEN + "Succesfully Enabled 'Hidden Players'");
			players.add(p);
			for(Player pl : Bukkit.getOnlinePlayers()) {
				p.hidePlayer(pl);
			}
		}
	}
	
}
