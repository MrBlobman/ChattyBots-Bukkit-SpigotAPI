package io.github.MrBlobman.ChattyBots;

import org.bukkit.entity.Player;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public class Bot {
	
	private ChatterBotSession session;
	private ChatterBot bot;
	private String msgFormat;
	private String errorMessage;
	private String name;
	
	/**
	 * Used to create a pandorabot.
	 * @param botId the PandoraBot id
	 */
	public Bot(String botId){
		ChatterBotFactory factory = new ChatterBotFactory();
		try {
			this.bot = factory.create(ChatterBotType.PANDORABOTS, botId);
		} catch (Exception e) {
			//Wont happen as I'm the one using this and I know how to use it
		}this.session = bot.createSession();
	}
	
	/**
	 * NOT FOR USE WITH PANDORABOT. Use Bot(String botId) for that.
	 * @param botType the type of the bot you want to create
	 */
	public Bot(ChatterBotType botType){
		ChatterBotFactory factory = new ChatterBotFactory();
		try {
			this.bot = factory.create(botType);
		} catch (Exception e) {
			//Wont happen as I'm the one using this and I know how to use it
		}
		this.session = bot.createSession();
	}
	
	/**
	 * Asks the bot a question.
	 * @param msg the question to ask
	 * @param playerAsking the player asking the bot a question
	 * @return the bots answer
	 */
	public String ask(String msg, Player playerAsking) {
		try {
			return formatMessage(this.session.think(msg), playerAsking);
		} catch (Exception e) {
			return errorMessage;
		}
	}
	
	private String formatMessage(String message, Player player){
		return this.msgFormat.replace("<msg>", message).replace("<player>", player.getName()).replace("<botName>", this.name);
	}
	
	/**
	 * <msg> - is replaced with the bots repsonse
	 * <botName> - is replaced with the bots given name
	 * <player> - is replaced with the name of the player that asked the question
	 * @return the blank message template
	 */
	public String getMsgFormat() {
		return msgFormat;
	}

	/**
	 * <msg> - is replaced with the bots repsonse
	 * <botName> - is replaced with the bots given name
	 * <player> - is replaced with the name of the player that asked the question
	 * @param msgFormat the new message format
	 */
	public void setMsgFormat(String msgFormat) {
		this.msgFormat = msgFormat;
	}

	/**
	 * Gets the name of the bot.
	 * @return the bots name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the bot.
	 * @param name the bots new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Refreshes the current chat session.
	 * Can be thought of as saying goodbye to the bot and meeting it again as a new person.
	 */
	public void refreshSession(){
		this.session = this.bot.createSession();
	}
}
