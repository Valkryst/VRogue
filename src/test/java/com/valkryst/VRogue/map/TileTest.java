package com.valkryst.VRogue.map;

import com.valkryst.VRogue.sprite.GroundSprite;
import com.valkryst.VRogue.sprite.Sprite;
import com.valkryst.VTerminal.component.VPanel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TileTest {
	@Test
	public void canConstructWithSprite() {
		final var tile = new Tile(GroundSprite.DIRT);
		Assertions.assertEquals(GroundSprite.DIRT, tile.getSprite());
		Assertions.assertTrue(tile.isPassable());
	}

	@Test
	public void canConstructWithNullSprite() {
		final var tile = new Tile(null);
		Assertions.assertEquals(Sprite.NULL, tile.getSprite());
		Assertions.assertTrue(tile.isPassable());
	}

	@Test
	public void canConstructWithSpriteAndPassableBoolean() {
		final var tile = new Tile(GroundSprite.DIRT, false);
		Assertions.assertEquals(GroundSprite.DIRT, tile.getSprite());
		Assertions.assertFalse(tile.isPassable());
	}

	@Test
	public void canDisplayOnVPanel() throws NoSuchFieldException, IllegalAccessException {
		final var panel = new VPanel(1, 1);

		var field = panel.getClass().getDeclaredField("codePoints");
		field.setAccessible(true);
		final var codePoints = (int[][]) field.get(panel);

		field = panel.getClass().getDeclaredField("backgroundColors");
		field.setAccessible(true);
		final var backgroundColors = (Color[][]) field.get(panel);

		field = panel.getClass().getDeclaredField("foregroundColors");
		field.setAccessible(true);
		final var foregroundColors = (Color[][]) field.get(panel);

		Assertions.assertNotEquals(GroundSprite.DIRT.getCodePoint(), codePoints[0][0]);
		Assertions.assertNotEquals(GroundSprite.DIRT.getBackgroundColor(), backgroundColors[0][0]);
		Assertions.assertNotEquals(GroundSprite.DIRT.getForegroundColor(), foregroundColors[0][0]);

		new Tile(GroundSprite.DIRT).displayAt(0, 0, panel);

		Assertions.assertEquals(GroundSprite.DIRT.getCodePoint(), codePoints[0][0]);
		Assertions.assertEquals(GroundSprite.DIRT.getBackgroundColor(), backgroundColors[0][0]);
		Assertions.assertEquals(GroundSprite.DIRT.getForegroundColor(), foregroundColors[0][0]);
	}
}
