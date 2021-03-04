package com.valkryst.VRogue.sprite;

import java.awt.*;

public class WallSprite extends Sprite {
	public static final WallSprite WALL_BOTTOM_LEFT = new WallSprite('╚');
	public static final WallSprite WALL_BOTTOM_RIGHT = new WallSprite('╝');
	public static final WallSprite WALL_CENTER = new WallSprite('╬');
	public static final WallSprite WALL_HORIZONTAL = new WallSprite('═');
	public static final WallSprite WALL_HORIZONTAL_DOWN = new WallSprite('╦');
	public static final WallSprite WALL_HORIZONTAL_UP = new WallSprite('╩');
	public static final WallSprite WALL_TOP_LEFT = new WallSprite('╔');
	public static final WallSprite WALL_TOP_RIGHT = new WallSprite('╗');
	public static final WallSprite WALL_VERTICAL = new WallSprite('║');
	public static final WallSprite WALL_VERTICAL_LEFT = new WallSprite('╣');
	public static final WallSprite WALL_VERTICAL_RIGHT = new WallSprite('╠');

	public WallSprite(final int codePoint) {
		super(codePoint, new Color(0x3C3C3C), new Color(0x494949));
	}

	public boolean connectsNorth() {
		if (this == WALL_HORIZONTAL) {
			return false;
		}

		if (this == WALL_HORIZONTAL_DOWN) {
			return false;
		}

		if (this == WALL_TOP_LEFT) {
			return false;
		}

		return this != WALL_TOP_RIGHT;
	}

	public boolean connectsSouth() {
		if (this == WALL_BOTTOM_LEFT) {
			return false;
		}
		if (this == WALL_BOTTOM_RIGHT) {
			return false;
		}
		if (this == WALL_HORIZONTAL) {
			return false;
		}

		return this != WALL_HORIZONTAL_UP;
	}

	public boolean connectsEast() {
		if (this == WALL_BOTTOM_RIGHT) {
			return false;
		}

		if (this == WALL_TOP_RIGHT) {
			return false;
		}

		if (this == WALL_VERTICAL) {
			return false;
		}

		return this != WALL_VERTICAL_LEFT;
	}

	public boolean connectsWest() {
		if (this == WALL_BOTTOM_LEFT) {
			return false;
		}

		if (this == WALL_TOP_LEFT) {
			return false;
		}

		if (this == WALL_VERTICAL) {
			return false;
		}

		return this != WALL_VERTICAL_RIGHT;
	}
}
