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
		ItemStack itemStack = item;
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(name);
		
		List<String> lores = new ArrayList<String>();
		lores.add(lore);
		itemMeta.setLore(lores);
		
		itemStack.setItemMeta(itemMeta);
		return itrmStack;
	}	
	
	/*
	* Items
	*/
	ItemStack superJumpItem = new ItemStack(Material.DIAMOND_BOOTS);
	ItemStack colorChangingItem = new ItemStack(Material.LEATHER_CHESTPLATE);
	ItemStack hidePlayersItem = new ItemStack(Material.DEAD_BUSH);
	ItemStack flightItem = new ItemStack(Material.GLOWSTONE_DUST);
	ItemStack fireworkLauncherItem = new ItemStack(Material.FIREWORK);
	ItemStack paintballItem = new ItemStack(Material.ARROW);
	ItemStack colorPickerItem = new ItemStack(Material.WOOL, 1, DyeColor.BLUE.getDyeData());
	ItemStack tabColor = new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData());
	ItemStack chatColor = new ItemStack(Material.WOOL, 1, DyeColor.BLUE.getWoolData());

	/*
	* GUIs (Inventories)
	*/
	public static Inventory cmdGUI = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.AttributeGUI.Name")));
	public static Inventory tcolGUI = Bukkit.createInventory(null, 18, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Tab.Name")));
	public static Inventory colGUI = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Name")));

	/*
	* Colors
	*/
	ItemStack colorBlack = new ItemStack(Material.WOOL, 1, DyeColor.BLACK.getWoolData());
	ItemStack colorRed = new ItemStack(Material.WOOL, 1, DyeColor.RED.getWoolData());
	ItemStack colorGray = new ItemStack(Material.WOOL, 1, DyeColor.GRAY.getWoolData());
	ItemStack colorBlue = new ItemStack(Material.WOOL, 1, DyeColor.BLUE.getWoolData());
	ItemStack colorMagenta = new ItemStack(Material.WOOL, 1, DyeColor.MAGENTA.getWoolData());
	ItemStack colorAqua = new ItemStack(Material.WOOL, 1, DyeColor.LIGHT_BLUE.getWoolData());
	ItemStack colorPink = new ItemStack(Material.WOOL, 1, DyeColor.PINK.getWoolData());
	ItemStack colorGreen = new ItemStack(Material.WOOL, 1, DyeColor.GREEN.getWoolData());
	ItemStack colorOrange = new ItemStack(Material.WOOL, 1, DyeColor.ORANGE.getWoolData());
	ItemStack colorLime = new ItemStack(Material.WOOL, 1, DyeColor.LIME.getWoolData());
	ItemStack colorYellow = new ItemStack(Material.WOOL, 1, DyeColor.YELLOW.getWoolData());
	ItemStack colorWhite = new ItemStack(Material.WOOL, 1, DyeColor.WHITE.getWoolData());

	static {
		cmdGUI.setItem(0, createItem(superJumpItem, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.SuperJump.Name")), ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.SuperJump.Lore"))));
		cmdGUI.setItem(1, createItem(colorChangingItem, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorChangingArmor.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorChangingArmor.Lore"))));
		cmdGUI.setItem(2, createItem(hidePlayersItem, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.HidePlayers.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.HidePlayers.Lore"))));
		cmdGUI.setItem(3, createItem(flightItems, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Flight.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Flight.Lore"))));
		cmdGUI.setItem(4, createItem(fireworkLauncherItem, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.FireworkLauncher.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.FireworkLauncher.Lore"))));
		cmdGUI.setItem(5, createItem(paintballItem, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Paintball.Name")),  ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.Paintball.Lore"))));
		cmdGUI.setItem(6, createItem(colorPickerItem, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorPicker.Name")), ChatColor.translateAlternateColorCodes('&', config.getString("GUI.Addons.ColorPicker.Lore"))));
		
		colGUI.setItem(0, createItem(tabColor, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Tab.Name")), ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Tab.Lore"))));
		colGUI.setItem(8, createItem(chatColor, ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Chat.Name")), ChatColor.translateAlternateColorCodes('&', config.getString("GUI.ColorGUI.Tab.Lore"))));

		// LIST NAMING WOOL
		tcolGUI.setItem(0, createItem(colorBlack, ChatColor.BLACK + "Black", ""));
		tcolGUI.setItem(1, createItem(colorRed, ChatColor.RED + "Red", ""));
		tcolGUI.setItem(1, createItem(colorGray, ChatColor.GRAY + "Gray", ""));
		tcolGUI.setItem(2, createItem(colorBlue, ChatColor.BLUE + "Blue", ""));
		tcolGUI.setItem(3, createItem(colorMagenta, ChatColor.DARK_PURPLE + "Magenta", ""));
		tcolGUI.setItem(4, createItem(colorAqua, ChatColor.AQUA + "Aqua", ""));
		tcolGUI.setItem(5, createItem(colorPink, ChatColor.LIGHT_PURPLE + "Pink", ""));
		tcolGUI.setItem(6, createItem(colorGreen, ChatColor.DARK_GREEN + "Green", ""));
		tcolGUI.setItem(7, createItem(colorGold, ChatColor.GOLD + "Gold", ""));
		tcolGUI.setItem(8, createItem(colorLime, ChatColor.GREEN + "Lime", ""));
		tcolGUI.setItem(9, createItem(colorYellow, ChatColor.YELLOW + "Yellow", ""));
		tcolGUI.setItem(10, createItem(colorWhite, ChatColor.WHITE + "White", ""));
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		@SuppressWarnings("deprecation")
		ItemStack AC = new ItemStack(Material.getMaterial(config.getInt("GUI.AttributeGUI.Item")));
		ItemMeta ACM = AC.getItemMeta();
		ACM.setDisplayName(ChatColor.translateAlternateColorCodes('&', config.getString("GUI.AttributeGUI.Name")));
		AC.setItemMeta(ACM);
		player.getInventory().setItem(config.getInt("GUI.AttributeGUI.Slot"), AC);
	}
	

	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		Player player = (Player) e.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inventor = event.getInventory();
		if(inventory == null) {
			e.setCancelled(true);
		}
		else if(inventory.getName().equals(cmdGUI.getName())) {
			// SUPER JUMP
			if(event.getCurrentItem().getType() == Material.DIAMOND_BOOTS && inventory != null) {
				if(player.hasPermission("ecr.addons.superjump")) {
					event.setCancelled(true);
					SuperJump.superJump(player);
				} else {
					event.setCancelled(true);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.SuperJump")));
				}
			}
			// COLOR CHANGING ARMOR
			if(clicked.getType() == Material.LEATHER_CHESTPLATE) {
				if(player.hasPermission("ecr.addons.changingarmor")) {
					event.setCancelled(true);
					ColorChangingArmor.changeArmor(player);
				} else {
					event.setCancelled(true);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.ColorChangingArmor")));
				}
			}
			// HIDING PLAYERS
			if(clicked.getType() == Material.DEAD_BUSH) {
				if(player.hasPermission("ecr.addons.hideplayers")) {
					e.setCancelled(true);
					HidePlayers.hidePlayers(player);
				} else {
					event.setCancelled(true);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.HidePlayers")));
				}
			}
			// Flight
			if(clicked.getType() == Material.GLOWSTONE_DUST) {
				if(player.hasPermission("ecr.addons.flight")) {
					event.setCancelled(true);
					Fly.enableFly(player);
				} else {
					event.setCancelled(true);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.Flight")));
				}
			}
			// FIREWORK
			if(clicked.getType() == Material.FIREWORK) {
				if(p.hasPermission("ecr.addons.firework")) {
					event.setCancelled(true);
					FireworkLauncher.launchFw(player);
				} else {
					event.setCancelled(true);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.FireworkLauncher")));
				}
			}
			// PAINTBALL
						if(clicked.getType() == Material.ARROW) {
							if(player.hasPermission("ecr.addons.paintball")) {
								event.setCancelled(true);
								Paintball.launchPb(player);
							} else {
								event.setCancelled(true);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.Paintball")));
							}
						}
			// CHANGE COLOR
						if(clicked.getType() == Material.WOOL) {
							if(player.hasPermission("ecr.addons.colorpicker")) {
								event.setCancelled(true);
								player.closeInventory();
								player.openInventory(tcolGUI);
							} else {
								event.setCancelled(true);
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.ColorPicker")));
							}
						}
			
		} else if(inventory.getName().equals(tcolGUI.getName())) {	
		  if(player.hasPermission("ecr.addons.colorpicker.tab")) {
			event.setCancelled(true);
			player.closeInventory();
			switch(ChatColor.stripColor(evebt.getCurrentItem().getItemMeta().getDisplayName())) {
			case "Black":
				PlayerColor.changePlayerTab(player, "black");
				break;
			case "Gray":
				PlayerColor.changePlayerTab(player, "gray");
				break;
			case "Blue":
				PlayerColor.changePlayerTab(pplayer "blue");
				break;
			case "Magenta":
				PlayerColor.changePlayerTab(pplayer "magenta");
				break;
			case "Aqua":
				PlayerColor.changePlayerTab(player, "aqua");
				break;
			case "Pink":
				PlayerColor.changePlayerTab(player, "pink");
				break;
			case "Green":
				PlayerColor.changePlayerTab(player, "green");
				break;
			case "Gold":
				PlayerColor.changePlayerTab(player, "gold");
				break;
			case "Lime":
				PlayerColor.changePlayerTab(player, "lime");
				break;
			case "Yellow":
				PlayerColor.changePlayerTab(player, "yellow");
				break;
			case "White":
				PlayerColor.changePlayerTab(player, "white");
				break;
			}
			} else {
				event.setCancelled(true);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.Tab")));
			}
		  }
		}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(player.getItemInHand().getType() == Material.getMaterial(config.getInt("GUI.AttributeGUI.Item")) && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', config.getString("GUI.AttributeGUI.Name")))) {
			if(player.hasPermission("ecr.addonspicker")) {
				player.openInventory(cmdGUI);
				event.setCancelled(true);
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("NoPermissions.AddonsPicker")));
			}
			
		}
	}

}
