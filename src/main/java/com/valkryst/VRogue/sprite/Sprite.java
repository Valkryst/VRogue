package com.valkryst.VRogue.sprite;

import com.valkryst.VRogue.interfaces.Displayable;
import com.valkryst.VRogue.map.Tile;
import com.valkryst.VTerminal.component.VPanel;
import com.valkryst.VTerminal.image.SequentialOp;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class Sprite implements Displayable {
	public static final Sprite NULL = new Sprite(' ');

	@Getter private final int codePoint;
	@Getter private final Color backgroundColor;
	@Getter private final Color foregroundColor;
	@Getter private final SequentialOp sequentialOp;

	public Sprite(final int codePoint) {
		this(codePoint, null, null, null);
	}

	public Sprite(final int codePoint, final Color backgroundColor, final Color foregroundColor) {
		this(codePoint, backgroundColor, foregroundColor, null);
	}

	public Sprite(final int codePoint, final Color backgroundColor, final Color foregroundColor, final SequentialOp sequentialOp) {
		this.codePoint = codePoint;
		this.backgroundColor = backgroundColor == null ? UIManager.getColor("Panel.background") : backgroundColor;
		this.foregroundColor = foregroundColor == null ? UIManager.getColor("Panel.foreground") : foregroundColor;
		this.sequentialOp = sequentialOp;
	}

	@Override
	public void displayAt(final int x, final int y, final VPanel panel) {
		panel.setCodePointAt(x, y, codePoint);
		panel.setBackgroundAt(x, y, backgroundColor);
		panel.setForegroundAt(x, y, foregroundColor);
		panel.setSequentialImageOpAt(x, y, sequentialOp);
	}

	public Tile toTile() {
		return new Tile(this, false);
	}
}
