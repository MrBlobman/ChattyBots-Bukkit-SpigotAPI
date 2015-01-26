package io.github.MrBlobman.ChattyBots;

import java.util.ArrayList;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.code.chatterbotapi.ChatterBotType;

public class ChattyBots extends JavaPlugin{
	
	private static ChattyBots plugin;
	//An arraylist of triggerword -> bot entries
	private ArrayList<BotEntry> bots = new ArrayList<BotEntry>();
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new TriggerListeners(this), this);
		this.saveDefaultConfig();
		ChattyBots.plugin = this;
		initBots();
	}
	
	private void initBots(){
		Configuration config = this.getConfig();
		if (config.contains("Bots")){
			for (String key : config.getConfigurationSection("Bots").getKeys(false)){
				if (!config.contains(key)){
					getLogger().warning("[ChattyBots] " +key+ " is defined as a bot but has not been described below. Skipping...");
					continue;
				}if (!config.contains(key+".TriggerWord")){
					getLogger().warning("[ChattyBots] " +key+ " is defined as a bot but has no defined trigger word. Therefore cannot communicate with the bot. Skipping...");
					continue;
				}
				String botId = config.getString("Bots."+key);
				String trigger = config.getString(key+".TriggerWord");
				if (botId.equals("CLEVERBOT")){
					Bot bot = new Bot(ChatterBotType.CLEVERBOT);
					bot.setMsgFormat(config.contains(key+".MessageFormat") ? config.getString(key+".MessageFormat") : "CleverBot > <msg>");
					bot.setName(trigger);
					bots.add(new BotEntry(trigger, bot));
				}else if (botId.equals("JABBERWACKY")){
					Bot bot = new Bot(ChatterBotType.JABBERWACKY);
					bot.setMsgFormat(config.contains(key+".MessageFormat") ? config.getString(key+".MessageFormat") : "JabberWacky > <msg>");
					bot.setName(trigger);
					bots.add(new BotEntry(trigger, bot));
				}else{
					Bot bot = new Bot(botId);
					bot.setMsgFormat(config.contains(key+".MessageFormat") ? config.getString(key+".MessageFormat") : "PandoraBot > <msg>");
					bot.setName(trigger);
					bots.add(new BotEntry(trigger, bot));
				}
			}
		}else{
			getLogger().severe("Config is missing bots! Fix this or remove the config and restart the server to generate a new one!");
			getServer().getPluginManager().disablePlugin(this);
		}
	}
	
	/**
	 * Get a list of all trigger words and their associated Bot
	 */
	public ArrayList<BotEntry> getRegisteredBots(){
		return this.bots;
	}
	
	public static ChattyBots getInstance(){
		return plugin;
	}
}
