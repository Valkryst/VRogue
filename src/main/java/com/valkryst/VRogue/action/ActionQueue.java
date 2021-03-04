package com.valkryst.VRogue.action;

import java.util.ArrayDeque;

public class ActionQueue {
	private final ArrayDeque<Action> queue = new ArrayDeque<>();

	/**
	 * Inserts the specified action at the front of this queue.
	 *
	 * @param action The action to add.
	 */
	public void addFirst(final Action action) {
		if (action != null) {
			synchronized (queue) {
				queue.addFirst(action);
			}
		}
	}

	/**
	 * Inserts the specified action at the back of this queue.
	 *
	 * @param action The action to add.
	 */
	public void addLast(final Action action) {
		if (action != null) {
			synchronized (queue) {
				queue.addLast(action);
			}
		}
	}

	/** Processes and performs every action in the queue. */
	public synchronized void process() {
		Action action;
		while ((action = queue.pollFirst()) != null) {
			action.perform();
		}
	}
}
