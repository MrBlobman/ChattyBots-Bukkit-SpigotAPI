package io.github.MrBlobman.ChattyBots;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Question implements Runnable{

	private String question;
	private Bot botAsked;
	private Player playerAsking;
	
	Question(String question, Bot botWhoWasAsked, Player playerWhoAsked){
		BotAskedQuestionEvent event = new BotAskedQuestionEvent(question, playerWhoAsked, botWhoWasAsked);
		Bukkit.getServer().getPluginManager().callEvent(event);
		if (!event.isCanceled()){
			this.question = event.getQuestion();
			this.botAsked = event.getBotAsked();
			this.playerAsking = playerWhoAsked;
			Bukkit.getScheduler().runTaskAsynchronously(ChattyBots.getInstance(), this);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		String response = this.botAsked.ask(this.question.replace(this.botAsked.getName(), "you"), this.playerAsking);
		for (Player p : Bukkit.getOnlinePlayers()){
			Message.send(p, response);
		}
	}

}
