package com.valkryst.VRogue.map;

import com.valkryst.VRogue.Position;
import com.valkryst.VRogue.actor.Actor;
import com.valkryst.VRogue.actor.Monster;
import com.valkryst.VRogue.sprite.Sprite;
import com.valkryst.VTerminal.component.VPanel;
import lombok.NonNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Map extends JLayeredPane {
	private final VPanel mapLayer;
	private final VPanel entityLayer;

	private final Tile[][] tiles;
	private final List<Actor> actors = new ArrayList<>();

	public Map(final int width, final int height) {
		mapLayer = new VPanel(width, height);

		entityLayer = new VPanel(width, height);
		entityLayer.setBackground(new Color(0, 0, 0, 0));
		entityLayer.setOpaque(false);

		super.setLayout(new OverlayLayout(this));
		super.add(mapLayer, Integer.valueOf(0));
		super.add(entityLayer, Integer.valueOf(1));

		tiles = new Tile[height][width];

		for (int y = 0 ; y < height ; y++) {
			for (int x = 0 ; x < width ; x++) {
				tiles[y][x] = new Tile(Sprite.NULL);
			}
		}
	}

	@Override
	public void repaint() {
		for (int y = 0 ; y < getHeightInTiles() ; y++) {
			for (int x = 0 ; x < getWidthInTiles() ; x++) {
				tiles[y][x].displayAt(x, y, mapLayer);
				entityLayer.setCodePointAt(x, y, ' ');
			}
		}

		for (final Actor actor : actors) {
			final var position = actor.getPosition();
			actor.displayAt(position.getX(), position.getY(), entityLayer);
		}

		super.repaint();
	}

	public void addActor(final @NonNull Actor actor) {
		actors.add(actor);
	}

	public Optional<Actor> monsterAt(final Position position) {
		return actors.stream()
					 .filter(actor -> actor instanceof Monster)
					 .filter(monster -> monster.getPosition().equals(position)).findFirst();
	}

	public Tile tileAt(final Position position) {
		return tiles[position.getY()][position.getX()];
	}

	public Tile tileAt(final int x, final int y) {
		return tiles[y][x];
	}

	public int getHeightInTiles() {
		return mapLayer.getHeightInTiles();
	}

	public int getWidthInTiles() {
		return mapLayer.getWidthInTiles();
	}

	public boolean isValidPosition(final int x, final int y) {
		return !(x < 0 || this.getWidthInTiles() < x) && !(y < 0 || this.getHeightInTiles() < y);
	}

	public void setTileAt(final int x, final int y, final Tile tile) {
		tiles[y][x] = tile;
	}
}