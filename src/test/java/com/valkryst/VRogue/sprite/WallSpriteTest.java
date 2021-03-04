package com.valkryst.VRogue.sprite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class WallSpriteTest {
	@Test
	public void canConstructWithCodePoint() {
		final var sprite = new WallSprite('A');
		Assertions.assertEquals('A', sprite.getCodePoint());
		Assertions.assertEquals(new Color(0x3C3C3C), sprite.getBackgroundColor());
		Assertions.assertEquals(new Color(0x494949), sprite.getForegroundColor());
		Assertions.assertNull(sprite.getSequentialOp());
	}

	@Test
	public void canCheckIfWallSpriteConnectsToTheNorth() {
		Assertions.assertTrue(WallSprite.WALL_BOTTOM_LEFT.connectsNorth());
		Assertions.assertTrue(WallSprite.WALL_BOTTOM_RIGHT.connectsNorth());
		Assertions.assertTrue(WallSprite.WALL_CENTER.connectsNorth());
		Assertions.assertFalse(WallSprite.WALL_HORIZONTAL.connectsNorth());
		Assertions.assertFalse(WallSprite.WALL_HORIZONTAL_DOWN.connectsNorth());
		Assertions.assertTrue(WallSprite.WALL_HORIZONTAL_UP.connectsNorth());
		Assertions.assertFalse(WallSprite.WALL_TOP_LEFT.connectsNorth());
		Assertions.assertFalse(WallSprite.WALL_TOP_RIGHT.connectsNorth());
		Assertions.assertTrue(WallSprite.WALL_VERTICAL.connectsNorth());
		Assertions.assertTrue(WallSprite.WALL_VERTICAL_LEFT.connectsNorth());
		Assertions.assertTrue(WallSprite.WALL_VERTICAL_RIGHT.connectsNorth());
	}

	@Test
	public void canCheckIfWallSpriteConnectsToTheSouth() {
		Assertions.assertFalse(WallSprite.WALL_BOTTOM_LEFT.connectsSouth());
		Assertions.assertFalse(WallSprite.WALL_BOTTOM_RIGHT.connectsSouth());
		Assertions.assertTrue(WallSprite.WALL_CENTER.connectsSouth());
		Assertions.assertFalse(WallSprite.WALL_HORIZONTAL.connectsSouth());
		Assertions.assertTrue(WallSprite.WALL_HORIZONTAL_DOWN.connectsSouth());
		Assertions.assertFalse(WallSprite.WALL_HORIZONTAL_UP.connectsSouth());
		Assertions.assertTrue(WallSprite.WALL_TOP_LEFT.connectsSouth());
		Assertions.assertTrue(WallSprite.WALL_TOP_RIGHT.connectsSouth());
		Assertions.assertTrue(WallSprite.WALL_VERTICAL.connectsSouth());
		Assertions.assertTrue(WallSprite.WALL_VERTICAL_LEFT.connectsSouth());
		Assertions.assertTrue(WallSprite.WALL_VERTICAL_RIGHT.connectsSouth());
	}

	@Test
	public void canCheckIfWallSpriteConnectsToTheEast() {
		Assertions.assertTrue(WallSprite.WALL_BOTTOM_LEFT.connectsEast());
		Assertions.assertFalse(WallSprite.WALL_BOTTOM_RIGHT.connectsEast());
		Assertions.assertTrue(WallSprite.WALL_CENTER.connectsEast());
		Assertions.assertTrue(WallSprite.WALL_HORIZONTAL.connectsEast());
		Assertions.assertTrue(WallSprite.WALL_HORIZONTAL_DOWN.connectsEast());
		Assertions.assertTrue(WallSprite.WALL_HORIZONTAL_UP.connectsEast());
		Assertions.assertTrue(WallSprite.WALL_TOP_LEFT.connectsEast());
		Assertions.assertFalse(WallSprite.WALL_TOP_RIGHT.connectsEast());
		Assertions.assertFalse(WallSprite.WALL_VERTICAL.connectsEast());
		Assertions.assertFalse(WallSprite.WALL_VERTICAL_LEFT.connectsEast());
		Assertions.assertTrue(WallSprite.WALL_VERTICAL_RIGHT.connectsEast());
	}

	@Test
	public void canCheckIfWallSpriteConnectsToTheWest() {
		Assertions.assertFalse(WallSprite.WALL_BOTTOM_LEFT.connectsWest());
		Assertions.assertTrue(WallSprite.WALL_BOTTOM_RIGHT.connectsWest());
		Assertions.assertTrue(WallSprite.WALL_CENTER.connectsWest());
		Assertions.assertTrue(WallSprite.WALL_HORIZONTAL.connectsWest());
		Assertions.assertTrue(WallSprite.WALL_HORIZONTAL_DOWN.connectsWest());
		Assertions.assertTrue(WallSprite.WALL_HORIZONTAL_UP.connectsWest());
		Assertions.assertFalse(WallSprite.WALL_TOP_LEFT.connectsWest());
		Assertions.assertTrue(WallSprite.WALL_TOP_RIGHT.connectsWest());
		Assertions.assertFalse(WallSprite.WALL_VERTICAL.connectsWest());
		Assertions.assertTrue(WallSprite.WALL_VERTICAL_LEFT.connectsWest());
		Assertions.assertFalse(WallSprite.WALL_VERTICAL_RIGHT.connectsWest());
	}
}
