package com.valkryst.VRogue.actor;

import com.valkryst.VRogue.Position;
import com.valkryst.VRogue.action.ActionQueue;
import com.valkryst.VRogue.interfaces.Displayable;
import lombok.Getter;
import lombok.NonNull;

public abstract class Actor implements Displayable {
	@Getter private final Position position;

	public Actor(final @NonNull Position position) {
		this.position = position;
	}

	public abstract void takeTurn(final @NonNull ActionQueue actionQueue);
}
