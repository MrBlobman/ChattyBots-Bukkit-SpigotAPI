package io.github.MrBlobman.ChattyBots;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;

public class Message {
	
	public static void send(Player player, String msg){
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
}
