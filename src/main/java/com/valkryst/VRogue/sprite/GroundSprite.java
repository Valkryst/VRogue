package com.valkryst.VRogue.sprite;

import com.valkryst.VRogue.map.Tile;

import java.awt.*;

public class GroundSprite extends Sprite {
	public static final GroundSprite DIRT = new GroundSprite('·', new Color(0x452F09), new Color(0x372507));

	public GroundSprite(final int codePoint, final Color backgroundColor, final Color foregroundColor) {
		super(codePoint, backgroundColor, foregroundColor);
	}

	@Override
	public Tile toTile() {
		return new Tile(this, true);
	}
}
