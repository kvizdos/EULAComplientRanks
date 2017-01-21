/*
 * EULAComplientRanks (c) Kenton Vizdos
 * NOTE: Even though this is Open Source, it is still copywritten, so 
 * you MUST contact EULACompliantRanks@gmail.com to modify code.
 * Have Fun!
 */
package com.Kento.ECR;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Ads implements Listener {
	FileConfiguration config = Main.plugin.getConfig();
	
	ArrayList<String> ads = new ArrayList<String>();

	GivingMoney gm;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		List<String> ads = config.getStringList("Ads.Join");
		Random ran = new Random();
		if(!p.hasPermission("ecr.adfree")) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', ads.get(ran.nextInt(ads.size()))));
			if(config.getBoolean("JoinAdTitle") == true) {
				p.sendTitle(ChatColor.translateAlternateColorCodes('&', ads.get(ran.nextInt(ads.size()))), " ");
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler 
	public void cmdAd(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		List<String> ads = config.getStringList("Ads.Command.Ads");
		List<String> useCmd = config.getStringList("Ads.Command.Commands");

		Random ran = new Random();
		if(!p.hasPermission("ecr.adfree")) {
			if(useCmd.contains("ALL")) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', ads.get(ran.nextInt(ads.size()))));
			} else {
				for(String cmd : useCmd) {
					if(e.getMessage().contains(cmd)) {
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', ads.get(ran.nextInt(ads.size()))));
						if(config.getBoolean("CmdAdTitle") == true) {
							p.sendTitle(ChatColor.translateAlternateColorCodes('&', ads.get(ran.nextInt(ads.size()))), " ");
						}
						
					}
				}
			}
		}
	}
}
