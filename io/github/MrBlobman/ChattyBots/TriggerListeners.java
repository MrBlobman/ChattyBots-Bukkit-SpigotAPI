package io.github.MrBlobman.ChattyBots;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TriggerListeners implements Listener{
	
	private ChattyBots plugin;
	
	TriggerListeners(ChattyBots plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		if (!event.isCancelled()){
			String message = event.getMessage();
			for (BotEntry entry : plugin.getRegisteredBots()){
				if (message.contains(entry.getTrigger())){
					new Question(message.replace(entry.getTrigger(), ""), entry.getBot(), event.getPlayer());
				}
			}
		}
	}
	
}
