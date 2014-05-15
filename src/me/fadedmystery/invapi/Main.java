package me.fadedmystery.invapi;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private double ver = 1.0;
	
	public void onEnable() {
		System.out.println("[InventoryAPI] Loaded with version " + ver);
	}
	
	public void onDisable() {
		
	}
	
}