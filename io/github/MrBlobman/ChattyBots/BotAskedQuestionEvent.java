package io.github.MrBlobman.ChattyBots;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BotAskedQuestionEvent extends Event{
	
	private static final HandlerList handlers = new HandlerList();
    private String question;
    private Player player;
    private Bot botAsked;
    private boolean isCanceled = false;
 
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
    BotAskedQuestionEvent(String question, Player playerWhoAsked, Bot botAsked){
    	this.question = question;
    	this.player = playerWhoAsked;
    	this.botAsked = botAsked;
    }
    
    /**
     * @return the question the Bot is being asked
     */
    public String getQuestion(){
    	return this.question;
    }
    
    /**
     * @param question the question to ask the Bot
     */
    public void setQuestion(String question){
    	this.question = question;
    }
    
    /**
     * @return the player who asked the bot a question
     */
    public Player getWhoAsked(){
    	return this.player;
    }
    
    /**
     * @return the bot who was asked a question
     */
    public Bot getBotAsked(){
    	return this.botAsked;
    }
    
    /**
     * @return true if the event is canceled
     */
    public boolean isCanceled(){
    	return this.isCanceled;
    }
    
    /**
     * Sets the event as canceled
     * @param cancel
     */
    public void setCanceled(boolean cancel){
    	this.isCanceled = cancel;
    }
}
