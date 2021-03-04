package com.valkryst.VRogue.sprite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

public class GroundSpriteTest {
	public Color panelBackgroundColor() {
		return UIManager.getColor("Panel.background");
	}

	public Color panelForegroundColor() {
		return UIManager.getColor("Panel.foreground");
	}

	@Test
	public void canConstructWithCodePointAndColors() {
		final var sprite = new GroundSprite('A', Color.RED, Color.BLUE);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(Color.RED, sprite.getBackgroundColor());
		Assertions.assertEquals(Color.BLUE, sprite.getForegroundColor());
	}

	@Test
	public void canConstructWithNullBackgroundColor() {
		final var sprite = new GroundSprite('A', null, Color.RED);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(panelBackgroundColor(), sprite.getBackgroundColor());
		Assertions.assertEquals(Color.RED, sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}

	@Test
	public void canConstructWithNullForegroundColor() {
		final var sprite = new GroundSprite('A', Color.RED, null);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(Color.RED, sprite.getBackgroundColor());
		Assertions.assertEquals(panelForegroundColor(), sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}

	@Test
	public void canConvertToTile() {
		final var sprite = GroundSprite.DIRT;
		final var tile = sprite.toTile();
		Assertions.assertEquals(sprite, tile.getSprite());
		Assertions.assertTrue(tile.isPassable());
	}
}
