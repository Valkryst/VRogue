package com.valkryst.VRogue.action;

import com.valkryst.VRogue.actor.Actor;
import com.valkryst.VRogue.use.Use;
import lombok.NonNull;

public class UseAction extends Action {
	private final Use use;

	public UseAction(final @NonNull Actor actor, final @NonNull Use use) {
		super(actor);
		this.use = use;
	}

	@Override
	public void perform() {

	}
}
