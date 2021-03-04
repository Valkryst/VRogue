package com.valkryst.VRogue.sprite;

import com.valkryst.VTerminal.component.VPanel;
import com.valkryst.VTerminal.image.SequentialOp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

public class SpriteTest {
	public Color panelBackgroundColor() {
		return UIManager.getColor("Panel.background");
	}

	public Color panelForegroundColor() {
		return UIManager.getColor("Panel.foreground");
	}

	@Test
	public void canConstructWithCodePoint() {
		final var sprite = new Sprite('A');
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(panelBackgroundColor(), sprite.getBackgroundColor());
		Assertions.assertEquals(panelForegroundColor(), sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}

	@Test
	public void canConstructWithCodePointAndColors() {
		final var sprite = new Sprite('A', Color.RED, Color.BLUE);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(Color.RED, sprite.getBackgroundColor());
		Assertions.assertEquals(Color.BLUE, sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}

	@Test
	public void canConstructWithNullBackgroundColor() {
		final var sprite = new Sprite('A', null, Color.RED);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(panelBackgroundColor(), sprite.getBackgroundColor());
		Assertions.assertEquals(Color.RED, sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}

	@Test
	public void canConstructWithNullForegroundColor() {
		final var sprite = new Sprite('A', Color.RED, null);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(Color.RED, sprite.getBackgroundColor());
		Assertions.assertEquals(panelForegroundColor(), sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}

	@Test
	public void canConstructWithCodePointAndColorsAndSequentialOp() {
		final var affineTransformOp = new AffineTransformOp(AffineTransform.getScaleInstance(1, 1), AffineTransformOp.TYPE_BICUBIC);
		final var sequentialOp = new SequentialOp(affineTransformOp);

		final var sprite = new Sprite('A', Color.RED, Color.BLUE, sequentialOp);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(Color.RED, sprite.getBackgroundColor());
		Assertions.assertEquals(Color.BLUE, sprite.getForegroundColor());
		// No .equals method exists for SequentialImageOp, so unable to test.
	}

	@Test
	public void canConstructWithNullSequentialOp() {
		final var sprite = new Sprite('A', Color.RED, Color.BLUE, null);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(Color.RED, sprite.getBackgroundColor());
		Assertions.assertEquals(Color.BLUE, sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}

	@Test
	public void canDisplayOnVPanel() throws NoSuchFieldException, IllegalAccessException {
		final var affineTransformOp = new AffineTransformOp(AffineTransform.getScaleInstance(1, 1), AffineTransformOp.TYPE_BICUBIC);
		final var sequentialOp = new SequentialOp(affineTransformOp);
		final var sprite = new Sprite('A', Color.RED, Color.BLUE, sequentialOp);


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

		Assertions.assertNotEquals('A', codePoints[0][0]);
		Assertions.assertNotEquals(Color.RED, backgroundColors[0][0]);
		Assertions.assertNotEquals(Color.BLUE, foregroundColors[0][0]);
		// No .equals method exists for SequentialImageOp, so unable to test.

		sprite.displayAt(0, 0, panel);

		Assertions.assertEquals('A', codePoints[0][0]);
		Assertions.assertEquals(Color.RED, backgroundColors[0][0]);
		Assertions.assertEquals(Color.BLUE, foregroundColors[0][0]);
		// No .equals method exists for SequentialImageOp, so unable to test.
	}

	@Test
	public void canConvertToTile() {
		final var sprite = Sprite.NULL;
		final var tile = sprite.toTile();
		Assertions.assertEquals(sprite, tile.getSprite());
		Assertions.assertFalse(tile.isPassable());
	}
}
