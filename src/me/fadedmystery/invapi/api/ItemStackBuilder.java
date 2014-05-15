package me.fadedmystery.invapi.api;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemStackBuilder {

	private ItemStack item;
	
	@SuppressWarnings("deprecation")
	public ItemStackBuilder(int id) {
		this(new ItemStack(id));
	}
	
	public ItemStackBuilder(Material m) {
		this(new ItemStack(m));
	}
	
	public ItemStackBuilder(ItemStack is) {
		this.item = is;
	}
 
	/**
	 * Set the ItemStack's display name to
	 * a defined String. 
	 **/
	public ItemStackBuilder setDisplayName(String name) {
		
		ItemMeta im = (ItemMeta) item.getItemMeta();
		im.setDisplayName(name);
		item.setItemMeta(im);
	
		return this;
	}
	
	/**
	 * Sets the ItemStack's lores
	 * to Strings you define.
	 * Put as much Strings as you want.
	 * <br> Example: setLores("lore1", "lore2", "lore3")
	 **/
	public ItemStackBuilder setLores(String... lores) {
		
		List<String> loresList = new ArrayList<String>();
		
		for(String lore : lores) {
			loresList.add(lore);
		}
		
		ItemMeta im = (ItemMeta) item.getItemMeta();
		im.setLore(loresList);
		item.setItemMeta(im);
		
		return this;
	}
	
	/** Set the ItemStack's lores
	 * to a List of Strings.
	 **/
	public ItemStackBuilder setLores(List<String> lores) {
		
		ItemMeta im = (ItemMeta) item.getItemMeta();
		im.setLore(lores);
		item.setItemMeta(im);
		
		return this;
	}
	
	/**
	 * Add an Enchantment to the ItemStack.
	 * <br> Example: addEnchantment(Enchantment.DAMAGE_ALL, 1)
	 **/
	public ItemStackBuilder addEnchantment(Enchantment enchant, int level) {
		
		item.addEnchantment(enchant, level);
		
		return this;
	}
	
	/**
	 * ** Only for Leather Armor **
	 * Set the Color on the ItemStack.
	 * <br> Example: setLeatherArmorColor(Color.BLUE)
	 **/
	public ItemStackBuilder setLeatherArmorColor(Color color) {
		
		LeatherArmorMeta im = (LeatherArmorMeta) item.getItemMeta();	
		im.setColor(color);
		item.setItemMeta(im);
		
		return this;
	}
	
	/**
	 * Convert this class into an ItemStack.
	 **/
	public ItemStack done() {
		return item;
	}
	
	/**
	 * Convert this class into an ItemStack.
	 **/
	public ItemStack toItemStack() {
		return done();
	}
	
	/**
	 * Convert this class into an ItemStack.
	 **/
	public ItemStack finish() {
		return done();
	}
	
	
}