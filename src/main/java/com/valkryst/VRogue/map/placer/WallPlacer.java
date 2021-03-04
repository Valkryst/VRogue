package com.valkryst.VRogue.map.placer;

import com.valkryst.VRogue.Direction;
import com.valkryst.VRogue.map.Map;
import com.valkryst.VRogue.sprite.Sprite;
import com.valkryst.VRogue.sprite.WallSprite;

import java.util.Optional;

public class WallPlacer {
	private final Map map;

	public WallPlacer(final Map map) {
		this.map = map;
	}

	public void placeAt(final int x, final int y, final WallSprite sprite) {
		if (!map.isValidPosition(x, y)) {
			return;
		}

		/*
		 * Only empty space uses the NULL sprite which should not exist within
		 * the playable area. By only allowing walls to be added in NULL areas,
		 * we allow playable areas to "merge" together when they overlap.
		 */
		if (map.tileAt(x, y).getSprite() == Sprite.NULL) {
			map.setTileAt(x, y, sprite.toTile());
		}

		updateWallAt(x, y - 1);
		updateWallAt(x, y + 1);
		updateWallAt(x - 1, y);
		updateWallAt(x + 1, y);
		updateWallAt(x, y);
	}

	private void updateWallAt(final int x, final int y) {
		if (!map.isValidPosition(x, y)) {
			return;
		}

		Sprite sprite = null;
		switch (getWangValueAt(x, y)) {
			case 3 -> sprite = WallSprite.WALL_VERTICAL;
			case 5 -> sprite = WallSprite.WALL_BOTTOM_RIGHT;
			case 6 -> sprite = WallSprite.WALL_TOP_RIGHT;
			case 7 -> sprite = WallSprite.WALL_VERTICAL_LEFT;
			case 9 -> sprite = WallSprite.WALL_BOTTOM_LEFT;
			case 10 -> sprite = WallSprite.WALL_TOP_LEFT;
			case 11 -> sprite = WallSprite.WALL_VERTICAL_RIGHT;
			case 12 -> sprite = WallSprite.WALL_HORIZONTAL;
			case 13 -> sprite = WallSprite.WALL_HORIZONTAL_UP;
			case 14 -> sprite = WallSprite.WALL_HORIZONTAL_DOWN;
			case 15 -> sprite = WallSprite.WALL_CENTER;
		}

		if (sprite != null) {
			map.setTileAt(x, y, sprite.toTile());
		}
	}

	private byte getWangValueAt(final int x, final int y) {
		byte wangValue = 0;

		Optional<WallSprite> neighbour = getNeighbourAt(x, y, Direction.NORTH);
		if (neighbour.isPresent() && neighbour.get().connectsSouth()) {
			wangValue += 1;
		}

		neighbour = getNeighbourAt(x, y, Direction.SOUTH);
		if (neighbour.isPresent() && neighbour.get().connectsNorth()) {
			wangValue += 2;
		}

		neighbour = getNeighbourAt(x, y, Direction.WEST);
		if (neighbour.isPresent() && neighbour.get().connectsEast()) {
			wangValue += 4;
		}

		neighbour = getNeighbourAt(x, y, Direction.EAST);
		if (neighbour.isPresent() && neighbour.get().connectsWest()) {
			wangValue += 8;
		}

		return wangValue;
	}

	private Optional<WallSprite> getNeighbourAt(final int x, final int y, final Direction direction) {
		boolean positionOutsideMapBounds = (y - 1) < 0;
		positionOutsideMapBounds |= (x - 1) < 0;
		positionOutsideMapBounds |= map.getHeightInTiles() < (y + 1);
		positionOutsideMapBounds |= map.getWidthInTiles() < (x + 1);

		if (positionOutsideMapBounds) {
			return Optional.empty();
		}

		Sprite sprite = null;

		switch (direction) {
			case NORTH -> sprite = map.tileAt(x, y - 1).getSprite();
			case SOUTH -> sprite = map.tileAt(x, y + 1).getSprite();
			case EAST -> sprite = map.tileAt(x + 1, y).getSprite();
			case WEST -> sprite = map.tileAt(x - 1, y).getSprite();
		}

		return Optional.ofNullable(sprite instanceof WallSprite ? ((WallSprite) sprite) : null);
	}
}
