package me.fadedmystery.invapi.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class InventoryAPI implements Listener {
	
	/* Public Data */
	private static ArrayList<String> invIDs = new ArrayList<String>();
	private static HashMap<ItemStack, Runnable> actions = new HashMap<ItemStack, Runnable>();
	private static ArrayList<Inventory> registered = new ArrayList<Inventory>();
	
	/* Class Data */
	private Inventory inv;
	private String id;
	
	public InventoryAPI() {
		
		Random rand = new Random();
		
		do {
			
			id = rand.nextInt(1000) + "";
			
		} while(invIDs.contains(id));
		
		this.inv = Bukkit.createInventory(null, 9,
			"Inventory (" + id + ")" + " created by InventoryAPI"
		);
		
	}
	
	public InventoryAPI(String title) {
		this(title, InventorySize.NINE);
	}
	
	public InventoryAPI(InventorySize size) {
		
		int sizeInt = 0;
		
		try {
			
			sizeInt = size.getValue();
			
		} catch (Exception ex) {
		
			switch(size) {
			
			case EIGHTEEN:
				sizeInt = 18;
				break;
			case FORTY_FIVE:
				sizeInt = 48;
				break;
			case NINE:
				sizeInt = 9;
				break;
			case THIRTY_SIX:
				sizeInt = 36;
				break;
			case TWENTY_SEVEN:
				sizeInt = 18;
				break;
			default:
				break;
			
			}
			
		}
		
		Random rand = new Random();
		
		do {
			
			id = rand.nextInt(1000) + "";
			
		} while(invIDs.contains(id));
		
		this.inv = Bukkit.createInventory(null, sizeInt,
			"Inventory (" + id + ")" + " created by InventoryAPI"
		);
		
	}
	
	public InventoryAPI(int size) {
		
		Random rand = new Random();
		
		do {
			
			id = rand.nextInt(1000) + "";
			
		} while(invIDs.contains(id));
		
		this.inv = Bukkit.createInventory(null, size,
			"Inventory (" + id + ")" + " created by InventoryAPI"
		);
		
	}
	
	public InventoryAPI(String title, int size) {
		
		Random rand = new Random();
		
		do {
			
			id = rand.nextInt(1000) + "";
			
		} while(invIDs.contains(id));
		
		this.inv = Bukkit.createInventory(null, size, title);
		
	}
	
	public InventoryAPI(String title, InventorySize size) {
		
		int sizeInt = 0;
		
		try {
			
			sizeInt = size.getValue();
			
		} catch (Exception ex) {
		
			switch(size) {
			
			case EIGHTEEN:
				sizeInt = 18;
				break;
			case FORTY_FIVE:
				sizeInt = 48;
				break;
			case NINE:
				sizeInt = 9;
				break;
			case THIRTY_SIX:
				sizeInt = 36;
				break;
			case TWENTY_SEVEN:
				sizeInt = 18;
				break;
			default:
				break;
			
			}
			
		}
		
		this.inv = Bukkit.createInventory(null, sizeInt, title);
		
		Random rand = new Random();
		
		do {
			
			id = rand.nextInt(1000) + "";
			
		} while(invIDs.contains(id));
		
	}
	
	/**
	 * Set a ItemStack in the Inventory with an index and a runnable.
	 * <br> <b> Index: </b> 0-(your inventory size - 1)
	 * <br> <b> Runnable: </b> When the item is clicked.
	 **/
	public void setItem(int index, ItemStack item, Runnable run) {
	
		if(run != null) {
			if(!actions.containsKey(item)) {
				actions.put(item, run);
			}
		}
		
		inv.setItem(index, item);
		
	}
	
	/**
	 * Add an ItemStack into the Inventory with a runnable.
	 * <br> <b> Runnable: </b> When the item is clicked.
	 **/
	public void addItem(ItemStack item, Runnable run) {
		
		if(run != null) {
			if(!actions.containsKey(item)) {
				actions.put(item, run);
			}
		}
		
		inv.addItem(item);
		
	}
	
	/**
	 * Set a ItemStack in the Inventory with an index.
	 * <br> <b> Index: </b> 0-(your inventory size - 1)
	 **/
	public void setItem(int index, ItemStack item) {
		
		setItem(index, item, null);
		
	}
	
	/**
	 * Add an ItemStack into the Inventory.
	 **/
	public void addItem(ItemStack item) {
		
		addItem(item, null);
		
	}

	/**
	 * Clear the Inventory.
	 * <br> Use instead of <b> getInventory().clear() </b> because this one cleans up class data of the ItemStacks.
	 **/
	public void clear() {
		inv.clear();
		actions.clear();
	}
	
	/**
	 * Get the Inventory.
	 **/
	public Inventory getInventory() {
		return inv;
	}
	
	/**
	 * Gets the Unique ID of the Inventory.
	 **/
	public String getID() {
		return id;
	}
	
	/**
	 * Open the Inventory for a Player.
	 **/
	public void open(Player p) {
		p.openInventory(inv);
	}
	
	/**
	 * Register this Inventory.
	 * <br> (So Events work)
	 **/
	public void register(Plugin pl) {
		
		if(registered.contains(inv)) return;
		
		pl.getServer().getPluginManager().registerEvents(this, pl);
		
		registered.add(inv);
		
	}
	
	/**
	 * Get the public data.
	 **/
	public static Object[] getData() {
		Object[] objects = new Object[] {
				invIDs,
				actions,
				registered
		};
		return objects;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(e.getInventory().getName() == inv.getName()) {
			
			e.setCancelled(true);
			
			if(actions.containsKey(e.getCurrentItem())) {
				
				actions.get(e.getCurrentItem()).run();
				
			}
			
		}
		
	}
	
}