package com.valkryst.VRogue;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Position implements Cloneable, Serializable {
	@Serial
	private static final long serialVersionUID = 1;

	/** @serial X-Axis position. */
	@Getter private int x = 0;
	/** @serial Y-Axis position. */
	@Getter private int y = 0;

	/**
	 * Constructs a new instance of {@code Position}.
	 *
	 * @param x X-Axis position.
	 * @param y Y-Axis position.
	 */
	public Position(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	@SneakyThrows
	@Override
	public Object clone() {
		return super.clone();
	}

	/** Decrements the X-axis position. */
	public void decrementX() {
		x--;
	}

	/** Decrements the Y-axis position. */
	public void decrementY() {
		y--;
	}

	/** Increments the X-axis position. */
	public void incrementX() {
		x++;
	}

	/** Increments the Y-axis position. */
	public void incrementY() {
		y++;
	}
}
