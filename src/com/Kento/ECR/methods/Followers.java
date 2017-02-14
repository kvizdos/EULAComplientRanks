package com.Kento.ECR.methods;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;


public class Followers implements Listener{
	static HashMap<Player, String> flrs = new HashMap<Player, String>();

	public static void spawnFollower(Player p, Material block) {
		ItemStack is = new ItemStack(block);
		
		if(!flrs.containsKey(p)) {
			Location l = new Location(p.getLocation().getWorld(), p.getLocation().getX(), p.getLocation().getY()+3, p.getLocation().getZ());
			ArmorStand as = p.getWorld().spawn(l, ArmorStand.class);
			as.setHelmet(is);
			as.setVisible(false);
			as.setGravity(false);
			as.setSmall(true);
			as.setCustomName(p.getName()+"flw");
			p.setPassenger(as);
			flrs.put(p, p.getName()+"flw");
			p.sendMessage(ChatColor.GREEN + "Spawned a " + block.toString().toLowerCase() .replace("_", " ")+ " follower!");
		} else {
			p.sendMessage(ChatColor.RED + "You already have a follower! Please do '/flr stop' to stop it!");
		}
	}
	
	public static void removeFollower(Player p) {
		p.eject();
		p.leaveVehicle();
		if(flrs.containsKey(p)) {

		for(Entity e : p.getNearbyEntities(0, 1, 0)) {
			if(e.getCustomName().equals(p.getName()+"flw")) {
				e.remove();
				flrs.remove(p, p.getName()+"flw");
				p.sendMessage(ChatColor.GREEN + "Your Follower Has Been Removed!");
			} else {
				p.sendMessage(ChatColor.RED + "That is not your follower!");
				}
			}
		}
		else {
			p.sendMessage(ChatColor.RED + "You do not have a follower.");
		}
	}
	
	
}
