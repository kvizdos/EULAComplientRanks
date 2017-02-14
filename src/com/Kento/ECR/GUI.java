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
import org.bukkit.Color;
import org.bukkit.DyeColor;
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

import com.Kento.ECR.addons.ColorChangingArmor;
import com.Kento.ECR.addons.FireworkLauncher;
import com.Kento.ECR.addons.Fly;
import com.Kento.ECR.addons.HidePlayers;
import com.Kento.ECR.addons.Paintball;
import com.Kento.ECR.addons.PlayerColor;
import com.Kento.ECR.addons.SuperJump;

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
	static ItemStack co = new ItemStack(Material.WOOL, 1, DyeColor.BLUE.getDyeData());
	static ItemStack tcollist = new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData());
	static ItemStack ccollist = new ItemStack(Material.WOOL, 1, DyeColor.BLUE.getWoolData());

	public static Inventory cmdGUI = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.AttributeGUI.Name")));
	
	public static Inventory tcolGUI = Bukkit.createInventory(null, 18, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Tab.Name")));

	public static Inventory colGUI = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Name")));

	static ItemStack cblack = new ItemStack(Material.WOOL, 1, DyeColor.BLACK.getWoolData());
	static ItemStack cred = new ItemStack(Material.WOOL, 1, DyeColor.RED.getWoolData());
	static ItemStack cgray = new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData());
	static ItemStack cblue = new ItemStack(Material.WOOL, 1, DyeColor.BLUE.getWoolData());
	static ItemStack cmagenta = new ItemStack(Material.WOOL, 1, DyeColor.MAGENTA.getWoolData());
	static ItemStack clblue = new ItemStack(Material.WOOL, 1, DyeColor.LIGHT_BLUE.getWoolData());
	static ItemStack cpink = new ItemStack(Material.WOOL, 1, DyeColor.PINK.getWoolData());
	static ItemStack cgreen = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getWoolData());
	static ItemStack corange = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getWoolData());
	static ItemStack clime = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getWoolData());
	static ItemStack cyellow = new ItemStack(Material.WOOL, 1, DyeColor.YELLOW.getWoolData());
	static ItemStack cwhite = new ItemStack(Material.WOOL, 1, DyeColor.WHITE.getWoolData());

	static {
		cmdGUI.setItem(0, createItem(sj, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.SuperJump.Name")), ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.SuperJump.Lore"))));
		cmdGUI.setItem(1, createItem(cca, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorChangingArmor.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorChangingArmor.Lore"))));
		cmdGUI.setItem(2, createItem(hp, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.HidePlayers.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.HidePlayers.Lore"))));
		cmdGUI.setItem(3, createItem(fl, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Flight.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Flight.Lore"))));
		cmdGUI.setItem(4, createItem(fw, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.FireworkLauncher.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.FireworkLauncher.Lore"))));
		cmdGUI.setItem(5, createItem(pb, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Paintball.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Paintball.Lore"))));
		cmdGUI.setItem(6, createItem(co, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorPicker.Name")), ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorPicker.Lore"))));
		
		colGUI.setItem(0, createItem(tcollist, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Tab.Name")), ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Tab.Lore"))));
		colGUI.setItem(8, createItem(ccollist, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Chat.Name")), ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Tab.Lore"))));

		// LIST NAMING WOOL
		tcolGUI.setItem(0, createItem(cblack, ChatColor.BLACK + "Black", ""));
		tcolGUI.setItem(1, createItem(cred, ChatColor.RED + "Red", ""));
		tcolGUI.setItem(1, createItem(cgray, ChatColor.GRAY + "Gray", ""));
		tcolGUI.setItem(2, createItem(cblue, ChatColor.BLUE + "Blue", ""));
		tcolGUI.setItem(3, createItem(cmagenta, ChatColor.DARK_PURPLE + "Magenta", ""));
		tcolGUI.setItem(4, createItem(clblue, ChatColor.AQUA + "Aqua", ""));
		tcolGUI.setItem(5, createItem(cpink, ChatColor.LIGHT_PURPLE + "Pink", ""));
		tcolGUI.setItem(6, createItem(cgreen, ChatColor.DARK_GREEN + "Green", ""));
		tcolGUI.setItem(7, createItem(corange, ChatColor.GOLD + "Gold", ""));
		tcolGUI.setItem(8, createItem(clime, ChatColor.GREEN + "Lime", ""));
		tcolGUI.setItem(9, createItem(cyellow, ChatColor.YELLOW + "Yellow", ""));
		tcolGUI.setItem(10, createItem(cwhite, ChatColor.WHITE + "White", ""));
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
			// CHANGE COLOR
						if(clicked.getType() == Material.WOOL) {
							if(p.hasPermission("ecr.addons.colorpicker")) {
								e.setCancelled(true);
								p.closeInventory();
								p.openInventory(tcolGUI);
							} else {
								e.setCancelled(true);
								p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.ColorPicker")));
							}
						}
			
		} else if(inv.getName().equals(tcolGUI.getName())) {	
		  if(p.hasPermission("ecr.addons.colorpicker.tab")) {
			e.setCancelled(true);
			p.closeInventory();
			switch(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())) {
			case "Black":
				PlayerColor.changePlayerTab(p, "black");
				break;
			case "Gray":
				PlayerColor.changePlayerTab(p, "gray");
				break;
			case "Blue":
				PlayerColor.changePlayerTab(p, "blue");
				break;
			case "Magenta":
				PlayerColor.changePlayerTab(p, "magenta");
				break;
			case "Aqua":
				PlayerColor.changePlayerTab(p, "aqua");
				break;
			case "Pink":
				PlayerColor.changePlayerTab(p, "pink");
				break;
			case "Green":
				PlayerColor.changePlayerTab(p, "green");
				break;
			case "Gold":
				PlayerColor.changePlayerTab(p, "gold");
				break;
			case "Lime":
				PlayerColor.changePlayerTab(p, "lime");
				break;
			case "Yellow":
				PlayerColor.changePlayerTab(p, "yellow");
				break;
			case "White":
				PlayerColor.changePlayerTab(p, "white");
				break;
			}
			} else {
				e.setCancelled(true);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.Tab")));
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
