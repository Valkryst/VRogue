package com.valkryst.VRogue.sprite;

import java.awt.*;

public class ActorSprite extends Sprite {
	public static final ActorSprite HERO = new ActorSprite('P', new Color(0, 0, 0 ,0), new Color(0x50FA7B));
	public static final ActorSprite GOBLIN = new ActorSprite('G', new Color(0, 0, 0, 0), new Color(0xFF5555));

	public ActorSprite(final int codePoint, final Color backgroundColor, final Color foregroundColor) {
		super(codePoint, backgroundColor, foregroundColor);
	}
}
