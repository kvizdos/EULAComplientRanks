/*
 * EULAComplientRanks (c) Kenton Vizdos
 * NOTE: Even though this is Open Source, it is still copywritten, so 
 * you MUST contact EULACompliantRanks@gmail.com to modify code.
 * Have Fun!
 */
package com.Kento.ECR.addons;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class ColorChangingArmor {
	public static ColorChangingArmor ColorChangingArmor = new ColorChangingArmor();
	public static ArrayList<Player> players = new ArrayList<Player>();
	
	public static void changeArmor(Player p) {
		if(players.contains(p)) {
			p.sendMessage(ChatColor.RED + "Succesfully Disabled 'Color Changing Armor'");
			players.remove(p);
			
			ItemStack air = new ItemStack(Material.AIR);
			p.getInventory().setHelmet(air);
			p.getInventory().setChestplate(air);
			p.getInventory().setLeggings(air);
			p.getInventory().setBoots(air);

		} else {
			p.sendMessage(ChatColor.GREEN + "Succesfully Enabled 'Color Changing Armor'");
			players.add(p);
		}
	}
}
