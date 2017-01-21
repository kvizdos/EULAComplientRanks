/*
 * EULAComplientRanks (c) Kenton Vizdos
 * NOTE: Even though this is Open Source, it is still copywritten, so 
 * you MUST contact EULACompliantRanks@gmail.com to modify code.
 * Have Fun!
 */
package com.Kento.ECR;

import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class SuperJump implements Listener {
	static FileConfiguration config = Main.plugin.getConfig();

	public static SuperJump SuperJump = new SuperJump();
	static ArrayList<Player> players = new ArrayList<Player>();
	
	public static void superJump(Player p) {
		if(players.contains(p)) {
			p.sendMessage(ChatColor.RED + "Succesfully Disabled 'Super Jump'");
			players.remove(p);
			p.removePotionEffect(PotionEffectType.JUMP);
		} else {
			p.sendMessage(ChatColor.GREEN + "Succesfully Enabled 'Super Jump'");
			players.add(p);
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, config.getInt("Effects.SuperJumpEffect")));
		}
	}
}

