package com.valkryst.VRogue.actor;

import com.valkryst.VRogue.Position;
import com.valkryst.VRogue.action.ActionQueue;
import com.valkryst.VRogue.interfaces.Describable;
import com.valkryst.VTerminal.component.VPanel;
import lombok.NonNull;
import lombok.ToString;

@ToString
public class Monster extends Actor implements Describable {
	private final Breed breed;

	public Monster(final Position position, final Breed breed) {
		super(position);
		this.breed = breed;
	}

	@Override
	public void displayAt(final int x, final int y, final VPanel panel) {
		breed.displayAt(x, y, panel);
	}

	@Override
	public void takeTurn(final @NonNull ActionQueue actionQueue) {

	}

	@Override
	public String getDescription() {
		return breed.getDescription();
	}
}
