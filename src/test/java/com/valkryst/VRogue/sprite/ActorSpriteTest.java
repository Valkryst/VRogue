package com.valkryst.VRogue.sprite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

public class ActorSpriteTest {
	public Color panelBackgroundColor() {
		return UIManager.getColor("Panel.background");
	}

	public Color panelForegroundColor() {
		return UIManager.getColor("Panel.foreground");
	}

	@Test
	public void canConstructWithCodePointAndColors() {
		final var sprite = new ActorSprite('A', Color.RED, Color.BLUE);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(Color.RED, sprite.getBackgroundColor());
		Assertions.assertEquals(Color.BLUE, sprite.getForegroundColor());
	}

	@Test
	public void canConstructWithNullBackgroundColor() {
		final var sprite = new ActorSprite('A', null, Color.RED);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(panelBackgroundColor(), sprite.getBackgroundColor());
		Assertions.assertEquals(Color.RED, sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}

	@Test
	public void canConstructWithNullForegroundColor() {
		final var sprite = new ActorSprite('A', Color.RED, null);
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(Color.RED, sprite.getBackgroundColor());
		Assertions.assertEquals(panelForegroundColor(), sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}
}
