package com.arcing.naviaux.borderlandsbot;

import java.io.IOException;

import org.jibble.pircbot.*;

public class BotHandler extends PircBot {

	public BotHandler(String channel) {
		setName("BorderlandsBot");
		setVerbose(true);
		try {
			connect("irc.twitch.tv", 6667, "oauth:ud2flviov0ylpw1gg66pdwcsbmihb9");
			joinChannel("#" + channel.toLowerCase());
		} catch (IOException | IrcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		
		if (message.startsWith("!")) {
			Boot.getLookup();
			String[] commands = Lookup.getCommands();
			for (int i = 0; i < commands.length; i++) {
				if (message.equalsIgnoreCase("!" + commands[i])) {
					if (Lookup.getCommandEnabled(commands[i])){
						sendMessage(channel, Lookup.getText(commands[i]));
						break;
					}
				}
			}
		}
	}
	public void disBot () {
		disconnect();
	}

}
