package com.arcing.naviaux.borderlandsbot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Lookup {
	
	static ArrayList<String> cmdlist = new ArrayList<String>();
	static HashMap<String, Boolean> commands = new HashMap<String, Boolean>();
	static HashMap<String, String> cmdtext = new HashMap<String, String>();
	
	public Lookup() {
		// BORDERLANDS ONE CMDS
		addCommand("bl1wr", false, "Borderlands 1 Record Charts - http://www.speedrun.com/bl1");
		addCommand("bl1faq", false, "Borderlands 1 FAQ - ");
		addCommand("bl1ia", false, "Borderlands 1 does not have a way to achieve infinite ammo, however you can instantly reload your weapons by dropping it and then force equipping it again.");
		
		// BORDERLANDS TWO CMDS
		addCommand("bl2wr", false, "Borderlands 2 Record Charts - http://www.speedrun.com/bl2");
		addCommand("bl2faq", false, "Borderlands 2 FAQ - http://pastebin.com/u3ASptGx");
		addCommand("vladof", false, "By merging the free shot of vladof launchers, you can make weapons use one less ammo per shot, for example, a quad jakobs shotgun will only be able to go down to 3 ammo per shot instead of four. However, on patch 1.3.x and below you can get every weapon down to 0 ammo per shot");
		addCommand("vladoftut", false, "BL2 IA Tutorials; Post 1.6 - http://goo.gl/rbewYf  --  Current Patch - http://goo.gl/N7hBPv");
		addCommand("esg", false, "");
		addCommand("esgtut", false, "Evil Smasher Glitch Tutorial - http://goo.gl/RSxtRn");
		
		// BORDERLANDS TPS CMDS
		addCommand("tpswr", false, "Borderlands: The Pre-Sequel Record Charts - http://www.speedrun.com/tps");
		addCommand("tpsfaq", false, "Borderlands: The Pre-Sequel FAQ - http://pastebin.com/Tjc89JUN");
		addCommand("buzzaxe", false, "TEST MESSAGE");
		addCommand("buzzaxetut", false, "Borderlands TPS IA - http://goo.gl/rKw9sC");
		loadPresets();
	}
	public static void addCommand(String cmd, boolean enabled, String message) {
		cmd = cmd.toLowerCase();
		commands.put(cmd, enabled);
		cmdlist.add(cmd);
		cmdtext.put(cmd, message);
	}
	public static void toggleCommand (String cmd) {
		cmd = cmd.toLowerCase();
		commands.replace(cmd, !commands.get(cmd));
	}
	public static void setCommand (String cmd, boolean enabled) {
		cmd = cmd.toLowerCase();
		commands.replace(cmd, enabled);
	}
	public static boolean getCommandEnabled(String cmd) {
		cmd = cmd.toLowerCase();
		return commands.get(cmd);
	}
	public static String[] getCommands() {
		return cmdlist.toArray(new String[cmdlist.size()]);
	}
	public static String getText(String cmd) {
		cmd = cmd.toLowerCase();
		return cmdtext.get(cmd);
	}
	public static void loadPresets() {
		try {
			File presetUnit = new File(System.getProperty("user.home") + "/borderlandsbot/presets.config");
			BufferedReader presetReader = new BufferedReader(new FileReader(presetUnit));
			String presets = "";
			while ((presets = presetReader.readLine()) != null) {
				switch(presets.split(":")[0]) {
				case "bl1wr": setCommand("bl1wr", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "bl1faq": setCommand("bl1faq", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "bl1ia": setCommand("bl1ia", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "bl2wr": setCommand("bl2wr", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "bl2faq": setCommand("bl2faq", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "vladof": setCommand("vladof", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "vladoftut": setCommand("vladoftut", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "esg": setCommand("esg", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "esgtut": setCommand("esgtut", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "tpswr": setCommand("tpswr", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "tpsfaq": setCommand("tpsfaq", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "buzzaxe": setCommand("buzzaxe", Boolean.parseBoolean(presets.split(":")[1])); break;
				case "buzzaxetut": setCommand("buzzaxetut", Boolean.parseBoolean(presets.split(":")[1])); break;
				}
			}
			presetReader.close();
		} catch (IOException e) { }
	}
	public static void savePresets() {
		try {
			File presets = new File(System.getProperty("user.home") + "/borderlandsbot/presets.config");
			new File(presets.getParent()).mkdirs();
			presets.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(presets));
			for (int i = 0; i < getCommands().length; i++) {
				writer.append(getCommands()[i] + ":" + getCommandEnabled(getCommands()[i]) + "\n");
			}
			writer.close();
		} catch (IOException e) { e.printStackTrace(); }
	}
}
