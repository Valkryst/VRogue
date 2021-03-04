package com.valkryst.VRogue.map;

import com.valkryst.VRogue.interfaces.Displayable;
import com.valkryst.VRogue.sprite.Sprite;
import com.valkryst.VTerminal.component.VPanel;
import lombok.Getter;

public class Tile implements Displayable {
	@Getter private final Sprite sprite;
	@Getter private final boolean passable;

	public Tile(final Sprite sprite) {
		this(sprite, true);
	}

	public Tile(final Sprite sprite, final boolean passable) {
		this.sprite = sprite == null ? Sprite.NULL : sprite;
		this.passable = passable;
	}

	@Override
	public void displayAt(final int x, final int y, final VPanel panel) {
		sprite.displayAt(x, y, panel);
	}
}
