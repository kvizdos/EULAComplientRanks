package com.Kento.ECR.addons;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

import net.md_5.bungee.api.ChatColor;

public class Pets {
	
	public static void spawnPet(String pet, Player p) {
		Wolf dog = p.getWorld().spawn(p.getLocation(), Wolf.class);
		dog.setCustomName(ChatColor.GOLD + p.getName() + "'s Pet");
		dog.setTamed(true);
		dog.setSitting(false);
		dog.setTarget(p);
		switch(pet) {
		case "dog":
			p.getWorld().spawnEntity(p.getLocation(), dog.getType());
		}
	}
	
}
