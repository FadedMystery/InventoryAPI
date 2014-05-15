package me.fadedmystery.invapi.example;

import me.fadedmystery.invapi.api.InventoryAPI;
import me.fadedmystery.invapi.api.ItemStackBuilder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ExampleInventory {

	private static InventoryAPI api = new InventoryAPI(ChatColor.BLUE + "Example Inventory", 9);
	
	private static void setup(final Player p) {
		
		api.clear();
		
		ItemStack apple = new ItemStackBuilder(Material.APPLE)
		.setDisplayName(p.isOp() ? (ChatColor.GREEN + "You are op!") : (ChatColor.RED + "You are not op!"))
		.setLores("Depending if you are OP or not the name will change!", ChatColor.RED + (ChatColor.BOLD + "Try it now!"))
		.toItemStack();
		
		api.addItem(apple, new Runnable() {
			
			public void run() {
				p.sendMessage("Cool, huh?");
			}
			
		});
		
		api.setItem(7, new ItemStackBuilder(Material.DIAMOND_BOOTS)
		.setDisplayName("Disable Flight").toItemStack(),
		new Runnable() {
			public void run() {
				p.setAllowFlight(false);
				p.setFlying(false);
			}
		});
		
		api.setItem(8, new ItemStackBuilder(Material.FEATHER)
		.setDisplayName("Enable Flight").toItemStack(),
		new Runnable() {
			
			public void run() {
				p.setAllowFlight(true);
				p.setFlying(true);
			}
			
		});
		
		for(int i = 0; i <= 8; i++) {
			if(api.getInventory().getItem(i) == null) {
				api.setItem(i, new ItemStackBuilder(Material.THIN_GLASS).setDisplayName(" ").done());
			}
		}
		
	}
	
	public static void open(final Player p) {
		
		setup(p);
		api.open(p);
		
	}
	
	public static void register(Plugin pl) {
		api.register(pl);
	}
	
}