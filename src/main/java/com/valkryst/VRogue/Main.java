package com.valkryst.VRogue;

import com.valkryst.VRogue.action.ActionQueue;
import com.valkryst.VRogue.actor.Breed;
import com.valkryst.VRogue.actor.Hero;
import com.valkryst.VRogue.actor.Monster;
import com.valkryst.VRogue.map.Map;
import com.valkryst.VRogue.map.placer.RoomPlacer;
import com.valkryst.VTerminal.component.VEditorPane;
import com.valkryst.VTerminal.component.VFrame;
import com.valkryst.VTerminal.plaf.VTerminalLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
	public static void main(final String[] args) throws UnsupportedLookAndFeelException {
		final var laf = VTerminalLookAndFeel.getInstance(18);
		UIManager.setLookAndFeel(laf);

		final var map = new Map(40, 20);
		final var hero = new Hero(new Position(1, 1));
		map.addActor(hero);
		final var monster = new Monster(new Position(5, 5), Breed.GOBLIN);
		map.addActor(monster);

		final var monsterDescriptionPane = new VEditorPane();
		monsterDescriptionPane.setContentType("text/html");
		monsterDescriptionPane.setEditable(false);
		monsterDescriptionPane.setFocusable(false);
		monsterDescriptionPane.setText(monster.getDescription());

		final var heroDescriptionPane = new JEditorPane();
		heroDescriptionPane.setContentType("text/html");
		heroDescriptionPane.setEditable(false);
		heroDescriptionPane.setFocusable(false);
		heroDescriptionPane.setText(monster.getDescription());

		final var roomPlacer = new RoomPlacer(map);
		roomPlacer.placeAt(0, 0, 10, 10);

		SwingUtilities.invokeLater(() -> {
			final var frame = new VFrame(40, 24);
			frame.setLayout(new BorderLayout());
			frame.add(map);
			frame.setName("VRogue");
			frame.setResizable(false);
			frame.setVisible(true);
			frame.pack();
			frame.setLocationRelativeTo(null);

			final var actionQueue = new ActionQueue();
			final var actorController = new ActorController(hero, actionQueue, map);
			frame.addKeyListener(actorController);

			frame.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(final KeyEvent e) {
					actionQueue.process();
					map.repaint();
				}
			});
		});
	}
}
