<<<<<<< HEAD
package com.Kento.ECR;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Paintball implements Listener{

	public static Paintball Paintball = new Paintball();
	static ArrayList<Player> players = new ArrayList<Player>();
	
	static FileConfiguration config = Main.plugin.getConfig();
	
	public static void launchPb(Player p) {
		ItemStack arrow = new ItemStack(Material.BOW);
		ItemMeta im = arrow.getItemMeta();
		im.setDisplayName(ChatColor.BLUE + "Paintball Gun");
		arrow.setItemMeta(im);
		p.getInventory().setItem(config.getInt("GiveItemSlot"), arrow);
		p.updateInventory();
		players.add(p);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand() != null && p.getInventory().getItemInHand().getType() == Material.BOW) {
			if(players.contains(p)) {
				p.launchProjectile(Snowball.class);
			} else {
				return;
			}
			
		}
	}
	
}
=======
package com.Kento.ECR;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Paintball implements Listener{

	public static Paintball Paintball = new Paintball();
	static ArrayList<Player> players = new ArrayList<Player>();
	
	static FileConfiguration config = Main.plugin.getConfig();
	
	public static void launchPb(Player p) {
		ItemStack arrow = new ItemStack(Material.BOW);
		ItemMeta im = arrow.getItemMeta();
		im.setDisplayName(ChatColor.BLUE + "Paintball Gun");
		arrow.setItemMeta(im);
		p.getInventory().setItem(config.getInt("GiveItemSlot"), arrow);
		p.updateInventory();
		players.add(p);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand() != null && p.getInventory().getItemInHand().getType() == Material.BOW) {
			if(players.contains(p)) {
				p.launchProjectile(Snowball.class);
			} else {
				return;
			}
			
		}
	}
	
}
>>>>>>> origin/master
