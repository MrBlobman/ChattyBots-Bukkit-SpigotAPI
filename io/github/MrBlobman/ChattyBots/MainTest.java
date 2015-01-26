package io.github.MrBlobman.ChattyBots;

import java.util.Scanner;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public class MainTest {
	public static void main(String[] args) throws Exception {

        ChatterBotFactory factory = new ChatterBotFactory();

        ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
        ChatterBotSession bot1session = bot1.createSession();
        
        ChatterBot Yala = factory.create(ChatterBotType.PANDORABOTS, "8a59af352e346164");
        ChatterBotSession YalaSession = Yala.createSession();
        
        ChatterBot bot2 = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
        ChatterBotSession bot2session = bot2.createSession();
        
        ChatterBot bot3 = factory.create(ChatterBotType.JABBERWACKY);
        ChatterBotSession bot3session = bot3.createSession();
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
        	System.out.print("Me: ");
        	String msg = scanner.nextLine();
        	if (msg.equalsIgnoreCase("stop")){
        		System.out.println("Goodbye!");
        		break;
        	}
        	String bot1Response = bot1session.think(msg);
            System.out.println("CleverBot: " + bot1Response);

            String bot2Response = bot2session.think(msg);
            System.out.println("PandoraBot: " + bot2Response);
        
        	String bot3Response = bot3session.think(msg);
        	System.out.println("Jabberwacky: " + bot3Response);
        	
        	String YalaResponse = YalaSession.think(msg);
        	System.out.println("Yala: " + YalaResponse);
        }
        scanner.close();
    }
}
