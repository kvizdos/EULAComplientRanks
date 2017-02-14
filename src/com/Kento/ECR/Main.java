/*
 * EULAComplientRanks (c) Kenton Vizdos
 * NOTE: Even though this is Open Source, it is still copywritten, so 
 * you MUST contact EULACompliantRanks@gmail.com to modify code.
 * Have Fun!
 */
package com.Kento.ECR;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.Kento.ECR.addons.Ads;
import com.Kento.ECR.addons.ColorChangingArmor;
import com.Kento.ECR.addons.FireworkLauncher;
import com.Kento.ECR.addons.Fly;
import com.Kento.ECR.addons.HidePlayers;
import com.Kento.ECR.addons.Paintball;
import com.Kento.ECR.addons.SuperJump;
import com.Kento.ECR.executors.ECREx;
import com.Kento.ECR.executors.FollowerEx;
import com.Kento.ECR.executors.GadgetEx;
import com.Kento.ECR.executors.ThankEx;
import com.Kento.ECR.methods.GivingMoney;

public class Main extends JavaPlugin implements Listener {
	
	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new Ads(), this);
		
		Bukkit.getPluginManager().registerEvents(new GUI(), this);
		Bukkit.getPluginManager().registerEvents(new SuperJump(), this);
		Bukkit.getPluginManager().registerEvents(new HidePlayers(), this);
		Bukkit.getPluginManager().registerEvents(new Fly(), this);
		Bukkit.getPluginManager().registerEvents(new FireworkLauncher(), this);
		Bukkit.getPluginManager().registerEvents(new Paintball(), this);
		Bukkit.getPluginManager().registerEvents(new GivingMoney(), this);

		Bukkit.getPluginManager().registerEvents(this, this);
		getCommand("ecr").setExecutor(new ECREx());
		getCommand("thank").setExecutor(new ThankEx());
		getCommand("gadget").setExecutor(new GadgetEx());
		getCommand("follower").setExecutor(new FollowerEx());

		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			Random r = new Random();
			@Override
			public void run() {
				for(Player p : ColorChangingArmor.players) {
					Color c = Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255));
					p.getInventory().setHelmet(getColorArmor(Material.LEATHER_HELMET, c));
					p.getInventory().setChestplate(getColorArmor(Material.LEATHER_CHESTPLATE, c));
					p.getInventory().setLeggings(getColorArmor(Material.LEATHER_LEGGINGS, c));
					p.getInventory().setBoots(getColorArmor(Material.LEATHER_BOOTS, c));
					
				}
				
				for(Player p : Bukkit.getOnlinePlayers()) {
					for(Player pl : HidePlayers.players) {
						pl.hidePlayer(p);
					}
				}
				
			}
			
		}, 0, 1);
	}
	
	private ItemStack getColorArmor(Material m, Color c) {
		ItemStack i = new ItemStack(m, 1);
		LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
		meta.setColor(c);
		i.setItemMeta(meta);
		return i;
	}

	
}
