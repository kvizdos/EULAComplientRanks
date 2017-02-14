<<<<<<< HEAD
package com.Kento.ECR;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkLauncher implements Listener {
	public static FireworkLauncher FireworkLauncher = new FireworkLauncher();
	static ArrayList<Player> players = new ArrayList<Player>();
	
	static FileConfiguration config = Main.plugin.getConfig();
	
	public static void launchFw(Player p) {
		Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
		FireworkMeta fm = f.getFireworkMeta();
		
		fm.addEffect(FireworkEffect.builder().
				flicker(false)
				.trail(true)
				.with(Type.STAR)
				.withColor(Color.GREEN)
				.withFade(Color.RED)
				.build());
		f.setFireworkMeta(fm);
	}
}
=======
package com.Kento.ECR;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkLauncher implements Listener {
	public static FireworkLauncher FireworkLauncher = new FireworkLauncher();
	static ArrayList<Player> players = new ArrayList<Player>();
	
	static FileConfiguration config = Main.plugin.getConfig();
	
	public static void launchFw(Player p) {
		Firework f = (Firework) p.getWorld().spawn(p.getLocation(), Firework.class);
		FireworkMeta fm = f.getFireworkMeta();
		
		fm.addEffect(FireworkEffect.builder().
				flicker(false)
				.trail(true)
				.with(Type.STAR)
				.withColor(Color.GREEN)
				.withFade(Color.RED)
				.build());
		f.setFireworkMeta(fm);
	}
}
>>>>>>> origin/master
