package me.fadedmystery.invapi.example;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		ExampleInventory.register(this);
		getCommand("openinv").setExecutor(new CommandOpenInv());
		
	}
	
}