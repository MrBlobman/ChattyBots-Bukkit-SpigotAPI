package io.github.MrBlobman.ChattyBots;

public class BotEntry {
	
	private String key;
	private Bot value;
	
	BotEntry(String key, Bot value){
		this.setTrigger(key);
		this.setBot(value);
	}

	public Bot getBot() {
		return value;
	}

	public void setBot(Bot value) {
		this.value = value;
	}

	public String getTrigger() {
		return key;
	}

	public void setTrigger(String key) {
		this.key = key;
	}
}
