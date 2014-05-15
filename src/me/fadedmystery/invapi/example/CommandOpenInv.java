package me.fadedmystery.invapi.example;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandOpenInv implements CommandExecutor {

	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if(!(cs instanceof Player)) {
			cs.sendMessage(ChatColor.RED + "Only Players have access to this awesome command!");
			return true;
		}
		
		Player p = (Player) cs;
		
		ExampleInventory.open(p);
		
		return true;
	}
	
}