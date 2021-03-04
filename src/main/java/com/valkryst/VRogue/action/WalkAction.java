package com.valkryst.VRogue.action;

import com.valkryst.VRogue.Direction;
import com.valkryst.VRogue.map.Map;
import com.valkryst.VRogue.Position;
import com.valkryst.VRogue.actor.Actor;
import lombok.NonNull;

public class WalkAction extends Action {
	private final Map map;
	private final Direction direction;

	public WalkAction(final @NonNull Actor actor, final @NonNull Map map, final @NonNull Direction direction) {
		super(actor);
		this.map = map;
		this.direction = direction;
	}

	@Override
	public void perform() {
		final var positionIfMoved = positionIfMoved();

		if (map.tileAt(positionIfMoved).isPassable()) {
			final var monster = map.monsterAt(positionIfMoved);

			if (monster.isPresent()) {
				// todo Attack
				System.out.println("Attacked " + monster.get());
			} else {
				move(super.actor.getPosition());
			}
		}
	}

	private void move(final @NonNull Position position) {
		switch (direction) {
			case NORTH -> { position.decrementY(); }
			case SOUTH -> { position.incrementY(); }
			case EAST -> { position.incrementX(); }
			case WEST -> { position.decrementX(); }
		}
	}

	private Position positionIfMoved() {
		final var position = (Position) super.actor.getPosition().clone();
		move(position);
		return position;
	}
}
