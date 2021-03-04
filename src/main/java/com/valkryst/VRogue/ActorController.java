package com.valkryst.VRogue;

import com.valkryst.VRogue.action.ActionQueue;
import com.valkryst.VRogue.action.WalkAction;
import com.valkryst.VRogue.actor.Actor;
import com.valkryst.VRogue.map.Map;
import lombok.NonNull;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class ActorController extends KeyAdapter {
	private final Actor actor;
	private final ActionQueue actionQueue;
	private final Map map;

	private long timeOfLastAcceptedPress = 0;
	private static final long TIME_BETWEEN_ACCEPTED_PRESSES = TimeUnit.MILLISECONDS.toNanos(100);

	public ActorController(final @NonNull Actor actor, final @NonNull ActionQueue actionQueue, final @NonNull Map map) {
		this.actor = actor;
		this.actionQueue = actionQueue;
		this.map = map;
	}

	@Override
	public void keyReleased(final KeyEvent e) {
		if (!shouldAcceptKeyPress()) {
			return;
		}

		switch (e.getExtendedKeyCode()) {
			case KeyEvent.VK_W, KeyEvent.VK_UP, KeyEvent.VK_NUMPAD8 -> {
				actionQueue.addLast(new WalkAction(actor, map, Direction.NORTH));
			}
			case KeyEvent.VK_S, KeyEvent.VK_DOWN, KeyEvent.VK_NUMPAD2 -> {
				actionQueue.addLast(new WalkAction(actor, map, Direction.SOUTH));
			}
			case KeyEvent.VK_A, KeyEvent.VK_LEFT, KeyEvent.VK_NUMPAD4 -> {
				actionQueue.addLast(new WalkAction(actor, map, Direction.WEST));
			}
			case KeyEvent.VK_D, KeyEvent.VK_RIGHT, KeyEvent.VK_NUMPAD6 -> {
				actionQueue.addLast(new WalkAction(actor, map, Direction.EAST));
			}
		}
	}

	private boolean shouldAcceptKeyPress() {
		final long currentTime = System.nanoTime();
		final long timeSinceLastAcceptedPress = currentTime - timeOfLastAcceptedPress;

		if (timeSinceLastAcceptedPress >= TIME_BETWEEN_ACCEPTED_PRESSES) {
			timeOfLastAcceptedPress = currentTime;
			return true;
		} else {
			return false;
		}
	}
}
