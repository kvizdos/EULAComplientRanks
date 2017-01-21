/*
 * EULAComplientRanks (c) Kenton Vizdos
 * NOTE: Even though this is Open Source, it is still copywritten, so 
 * you MUST contact EULACompliantRanks@gmail.com to modify code.
 * Have Fun!
 */
package com.Kento.ECR;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class GUI implements Listener {

	static FileConfiguration config = Main.plugin.getConfig();

	static ItemStack createItem(ItemStack item, String name, String lore) {
		List<String> cil = new ArrayList<String>();
		cil.add(lore);
		ItemStack is = item;
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		im.setLore(cil);
		is.setItemMeta(im);
		return is;
	}	
	
	static ItemStack sj = new ItemStack(Material.DIAMOND_BOOTS);
	static ItemStack cca = new ItemStack(Material.LEATHER_CHESTPLATE);
	static ItemStack hp = new ItemStack(Material.DEAD_BUSH);
	static ItemStack fl = new ItemStack(Material.GLOWSTONE_DUST);
	static ItemStack fw = new ItemStack(Material.FIREWORK);
	static ItemStack pb = new ItemStack(Material.ARROW);

	public static Inventory cmdGUI = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.AttributeGUI.Name")));
	static {
		cmdGUI.setItem(0, createItem(sj, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.SuperJump.Name")), ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.SuperJump.Lore"))));
		cmdGUI.setItem(1, createItem(cca, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorChangingArmor.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorChangingArmor.Lore"))));
		cmdGUI.setItem(2, createItem(hp, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.HidePlayers.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.HidePlayers.Lore"))));
		cmdGUI.setItem(3, createItem(fl, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Flight.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Flight.Lore"))));
		cmdGUI.setItem(4, createItem(fw, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.FireworkLauncher.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.FireworkLauncher.Lore"))));
		cmdGUI.setItem(5, createItem(pb, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Paintball.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Paintball.Lore"))));

	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		@SuppressWarnings("deprecation")
		ItemStack AC = new ItemStack(Material.getMaterial(config.getInt("GUI.AttributeGUI.Item")));
		ItemMeta ACM = AC.getItemMeta();
		ACM.setDisplayName(ChatColor.translateAlternateColorCodes('&', config.getString("GUI.AttributeGUI.Name")));
		AC.setItemMeta(ACM);
		p.getInventory().setItem(config.getInt("GUI.AttributeGUI.Slot"), AC);
	}
	

	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack clicked = e.getCurrentItem();
		Inventory inv = e.getInventory();
		if(inv == null) {
			e.setCancelled(true);
		}
		else if(inv.getName().equals(cmdGUI.getName())) {
			// SUPER JUMP
			if(e.getCurrentItem().getType() == Material.DIAMOND_BOOTS && inv != null) {
				if(p.hasPermission("ecr.addons.superjump")) {
					e.setCancelled(true);
					SuperJump.superJump(p);
				} else {
					e.setCancelled(true);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.SuperJump")));
				}
			}
			// COLOR CHANGING ARMOR
			if(clicked.getType() == Material.LEATHER_CHESTPLATE) {
				if(p.hasPermission("ecr.addons.changingarmor")) {
					e.setCancelled(true);
					ColorChangingArmor.changeArmor(p);
				} else {
					e.setCancelled(true);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.ColorChangingArmor")));
				}
			}
			// HIDING PLAYERS
			if(clicked.getType() == Material.DEAD_BUSH) {
				if(p.hasPermission("ecr.addons.hideplayers")) {
					e.setCancelled(true);
					HidePlayers.hidePlayers(p);
				} else {
					e.setCancelled(true);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.HidePlayers")));
				}
			}
			// Flight
			if(clicked.getType() == Material.GLOWSTONE_DUST) {
				if(p.hasPermission("ecr.addons.flight")) {
					e.setCancelled(true);
					Fly.enableFly(p);
				} else {
					e.setCancelled(true);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.Flight")));
				}
			}
			// FIREWORK
			if(clicked.getType() == Material.FIREWORK) {
				if(p.hasPermission("ecr.addons.firework")) {
					e.setCancelled(true);
					FireworkLauncher.launchFw(p);
				} else {
					e.setCancelled(true);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.FireworkLauncher")));
				}
			}
			// PAINTBALL
						if(clicked.getType() == Material.ARROW) {
							if(p.hasPermission("ecr.addons.paintball")) {
								e.setCancelled(true);
								Paintball.launchPb(p);
							} else {
								e.setCancelled(true);
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.Paintball")));
							}
						}
			
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() == Material.getMaterial(config.getInt("GUI.AttributeGUI.Item")) && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', config.getString("GUI.AttributeGUI.Name")))) {
			if(p.hasPermission("ecr.addonspicker")) {
				p.openInventory(cmdGUI);
				e.setCancelled(true);
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.AddonsPicker")));
			}
			
		}
	}

}
