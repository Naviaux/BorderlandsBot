package com.arcing.naviaux.borderlandsbot;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Interface extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static BotHandler bot = null;
	public Interface() {
		Boot.getLookup();
		setSize(215, 435);
		setTitle("Borderlands Bot Control");
		setLocation(screenSize.width / 2 - 300 / 2, screenSize.height / 2 - 300 / 2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		JLabel BLONE = new JLabel("Borderlands 1");
		JCheckBox BLOwr = new JCheckBox("!bl1wr");
		JCheckBox BLOfaq = new JCheckBox("!bl1faq");
		JCheckBox BLOia = new JCheckBox("!bl1ia");
		
		BLONE.setSize(100, 15);
		BLOwr.setSize(100, 15);
		BLOfaq.setSize(100, 15);
		BLOia.setSize(100, 15);
		BLONE.setLocation(10, 10);
		BLOwr.setLocation(20, 30);
		BLOfaq.setLocation(20, 50);
		BLOia.setLocation(20, 70);
		
		BLOwr.setSelected(Lookup.getCommandEnabled(BLOwr.getText().replace("!", "")));
		BLOfaq.setSelected(Lookup.getCommandEnabled(BLOfaq.getText().replace("!", "")));
		BLOia.setSelected(Lookup.getCommandEnabled(BLOia.getText().replace("!", "")));
		
		BLOwr.addChangeListener(createListener(BLOwr.getText().replace("!", "")));
		BLOfaq.addChangeListener(createListener(BLOfaq.getText().replace("!", "")));
		BLOia.addChangeListener(createListener(BLOia.getText().replace("!", "")));
		
		JLabel BLTWO = new JLabel("Borderlands 2");
		JCheckBox BLTwr = new JCheckBox("!bl2wr");
		JCheckBox BLTfaq = new JCheckBox("!bl2faq");
		JCheckBox BLTia = new JCheckBox("!vladof");
		JCheckBox BLTiatut = new JCheckBox("!vladoftut");
		JCheckBox BLTesg = new JCheckBox("!esg");
		JCheckBox BLTesgtut = new JCheckBox("!esgtut");
		
		BLTWO.setSize(100, 15);
		BLTwr.setSize(100, 15);
		BLTfaq.setSize(100, 15);
		BLTia.setSize(100, 15);
		BLTiatut.setSize(100, 15);
		BLTesg.setSize(100, 15);
		BLTesgtut.setSize(100, 15);
		BLTWO.setLocation(10, 100);
		BLTwr.setLocation(20, 120);
		BLTfaq.setLocation(20, 140);
		BLTia.setLocation(20, 160);
		BLTiatut.setLocation(20, 180);
		BLTesg.setLocation(20, 200);
		BLTesgtut.setLocation(20, 220);

		BLTwr.setSelected(Lookup.getCommandEnabled(BLTwr.getText().replace("!", "")));
		BLTfaq.setSelected(Lookup.getCommandEnabled(BLTfaq.getText().replace("!", "")));
		BLTia.setSelected(Lookup.getCommandEnabled(BLTia.getText().replace("!", "")));
		BLTiatut.setSelected(Lookup.getCommandEnabled(BLTia.getText().replace("!", "")));
		BLTesg.setSelected(Lookup.getCommandEnabled(BLTesg.getText().replace("!", "")));
		BLTesgtut.setSelected(Lookup.getCommandEnabled(BLTesgtut.getText().replace("!", "")));

		BLTwr.addChangeListener(createListener(BLTwr.getText().replace("!", "")));
		BLTfaq.addChangeListener(createListener(BLTfaq.getText().replace("!", "")));
		BLTia.addChangeListener(createListener(BLTia.getText().replace("!", "")));
		BLTiatut.addChangeListener(createListener(BLTiatut.getText().replace("!", "")));
		BLTesg.addChangeListener(createListener(BLTesg.getText().replace("!", "")));
		BLTesgtut.addChangeListener(createListener(BLTesgtut.getText().replace("!", "")));
		
		JLabel BLTPS = new JLabel("Borderlands Pre-Sequel");
		JCheckBox BLPwr = new JCheckBox("!tpswr");
		JCheckBox BLPfaq = new JCheckBox("!tpsfaq");
		JCheckBox BLPia = new JCheckBox("!buzzaxe");
		JCheckBox BLPiatut = new JCheckBox("!buzzaxetut");
		
		BLTPS.setSize(150, 15);
		BLPwr.setSize(100, 15);
		BLPfaq.setSize(100, 15);
		BLPia.setSize(100, 15);
		BLPiatut.setSize(100, 15);
		BLTPS.setLocation(10, 250);
		BLPwr.setLocation(20, 270);
		BLPfaq.setLocation(20, 290);
		BLPia.setLocation(20, 310);
		BLPiatut.setLocation(20, 330);

		BLPwr.setSelected(Lookup.getCommandEnabled(BLPwr.getText().replace("!", "")));
		BLOfaq.setSelected(Lookup.getCommandEnabled(BLPfaq.getText().replace("!", "")));
		BLPia.setSelected(Lookup.getCommandEnabled(BLPia.getText().replace("!", "")));
		BLPiatut.setSelected(Lookup.getCommandEnabled(BLPiatut.getText().replace("!", "")));

		BLPwr.addChangeListener(createListener(BLPwr.getText().replace("!", "")));
		BLPfaq.addChangeListener(createListener(BLPfaq.getText().replace("!", "")));
		BLPia.addChangeListener(createListener(BLPia.getText().replace("!", "")));
		BLPiatut.addChangeListener(createListener(BLPiatut.getText().replace("!", "")));
		
		JLabel cLabel = new JLabel("Channel");
		final JTextField channel = new JTextField();
		cLabel.setLocation(10, 350);
		channel.setLocation(60, 350);
		cLabel.setSize(50, 20);
		channel.setSize(140, 20);
		
		final JButton startBot = new JButton("Start Bot");
		final JButton stopBot = new JButton("Stop Bot");
		startBot.setSize(90, 22);
		stopBot.setSize(90, 22);
		startBot.setLocation(10, 375);
		stopBot.setLocation(110, 375);
		stopBot.setEnabled(false);
		
		startBot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bot = new BotHandler(channel.getText());
				startBot.setEnabled(false);
				stopBot.setEnabled(true);
			}
		});
		stopBot.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bot.disBot();
				startBot.setEnabled(true);
				stopBot.setEnabled(false);
			}
		});
		
		add(BLONE);
		add(BLOwr);
		add(BLOfaq);
		add(BLOia);
		add(BLTWO);
		add(BLTwr);
		add(BLTfaq);
		add(BLTia);
		add(BLTiatut);
		add(BLTesg);
		add(BLTesgtut);
		add(BLTPS);
		add(BLPwr);
		add(BLPfaq);
		add(BLPia);
		add(BLPiatut);
		add(cLabel);
		add(channel);
		add(startBot);
		add(stopBot);
		
		setVisible(true);
	}
	
	public static ChangeListener createListener (final String cmd) {
		return new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Boot.getLookup();
				AbstractButton abB = (AbstractButton)e.getSource();
				ButtonModel btnM = abB.getModel();
				Lookup.setCommand(cmd, btnM.isSelected());
				Lookup.savePresets();
			}
		};
	}
}
