package com.arcing.naviaux.borderlandsbot;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

//import java.io.IOException;
//
//import org.jibble.pircbot.*;

public class Boot {
	
	public static Lookup lookup;
	private static final String VERSION_NUMBER = "v1.0";
	public static void main (String[] args) {
//		new Boot("#piguy3014");
		try {
			URL url = new URL ("http://naviaux.github.io/versions/BLB");
			Scanner s = new Scanner(url.openStream());
			String version = s.nextLine();
			if (version != null) {
				if (!version.split(">")[0].equals(VERSION_NUMBER)) {
					final String uri = version.split(">")[1];
					JEditorPane jep = new JEditorPane("text/html", "<html><body>New Version Available!<br><a href\"" + uri + "\">Download</a></body></html>");
					jep.addHyperlinkListener(new HyperlinkListener() {
						@Override
						public void hyperlinkUpdate(HyperlinkEvent e) {
							if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
								if (Desktop.isDesktopSupported())
									try {
										Desktop.getDesktop().browse(new URI(uri));
									} catch (IOException | URISyntaxException ex) { ex.printStackTrace();}
						}
					});
					jep.setBackground(new JLabel().getBackground());
					jep.setEditable(false);
					JOptionPane.showMessageDialog(null, jep);
				}
			}
			s.close();
		} catch (IOException e) { e.printStackTrace(); }
		lookup = new Lookup();
		new Interface();
	}
	public static Lookup getLookup() {
		return lookup;
	}
	
//	public Boot(String channel) {
//		setName("BorderlandsBot");
//		try {
//			setVerbose(true);
//			connect("irc.twitch.tv", 6667, "oauth:ud2flviov0ylpw1gg66pdwcsbmihb9");
//			joinChannel(channel);
//		} catch (IOException | IrcException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	@Override
//	public void onMessage(String channel, String sender, String login, String hostname, String message) {
//		if (message.equalsIgnoreCase("!confirmation")) {
//			sendMessage(channel, "BorderlandsBot has successfully joined the channel.");
//		}
//	}
	
}
