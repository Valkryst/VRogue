package com.valkryst.VRogue.action;

import com.valkryst.VRogue.actor.Actor;

public abstract class Action {
	protected final Actor actor;

	public Action(final Actor actor) {
		this.actor = actor;
	}

	public abstract void perform();
}
