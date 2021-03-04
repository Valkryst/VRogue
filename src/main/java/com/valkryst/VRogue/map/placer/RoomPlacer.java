package com.valkryst.VRogue.map.placer;

import com.valkryst.VRogue.map.Map;
import com.valkryst.VRogue.sprite.GroundSprite;
import com.valkryst.VRogue.sprite.WallSprite;

public class RoomPlacer {
	private final Map map;

	public RoomPlacer(final Map map) {
		this.map = map;
	}

	public void placeAt(final int roomX, final int roomY, final int roomWidth, final int roomHeight) {
		final var groundPlacer = new GroundPlacer(map);

		for (int y = roomY + 1 ; y < (roomY + roomHeight) ; y++) {
			for (int x = roomX + 1 ; x < (roomX + roomWidth) ; x++) {
				groundPlacer.placeAt(x, y, GroundSprite.DIRT);
			}
		}

		final var wallPlacer = new WallPlacer(map);

		wallPlacer.placeAt(roomX, roomY, WallSprite.WALL_TOP_LEFT);
		wallPlacer.placeAt(roomX + roomWidth, roomY, WallSprite.WALL_TOP_RIGHT);
		wallPlacer.placeAt(roomX, roomY + roomHeight, WallSprite.WALL_BOTTOM_LEFT);
		wallPlacer.placeAt(roomX + roomWidth, roomY + roomHeight, WallSprite.WALL_BOTTOM_RIGHT);

		for (int tileY = roomY + 1 ; tileY < (roomY + roomHeight) ; tileY++) {
			wallPlacer.placeAt(roomX, tileY, WallSprite.WALL_VERTICAL);
			wallPlacer.placeAt(roomX + roomWidth, tileY, WallSprite.WALL_VERTICAL);
		}

		for (int tileX = roomX + 1 ; tileX < (roomX + roomWidth) ; tileX++) {
			wallPlacer.placeAt(tileX, roomY, WallSprite.WALL_HORIZONTAL);
			wallPlacer.placeAt(tileX, roomY + roomHeight, WallSprite.WALL_HORIZONTAL);
		}
	}
}
