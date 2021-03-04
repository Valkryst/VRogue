package com.valkryst.VRogue.map.placer;

import com.valkryst.VRogue.map.Map;
import com.valkryst.VRogue.sprite.GroundSprite;

public class GroundPlacer {
	private final Map map;

	public GroundPlacer(final Map map) {
		this.map = map;
	}

	public void placeAt(final int x, final int y, final GroundSprite sprite) {
		if (!map.isValidPosition(x, y)) {
			return;
		}

		map.setTileAt(x, y, sprite.toTile());
	}
}
