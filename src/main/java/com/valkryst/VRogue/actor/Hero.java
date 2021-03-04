package com.valkryst.VRogue.actor;

import com.valkryst.VRogue.Position;
import com.valkryst.VRogue.interfaces.Describable;
import com.valkryst.VRogue.sprite.ActorSprite;
import com.valkryst.VRogue.sprite.Sprite;
import com.valkryst.VRogue.action.ActionQueue;
import com.valkryst.VTerminal.component.VPanel;
import lombok.NonNull;
import lombok.ToString;

@ToString
public class Hero extends Actor implements Describable {
	private final Sprite sprite = ActorSprite.HERO;

	public Hero(final @NonNull Position position) {
		super(position);
	}

	@Override
	public void displayAt(final int x, final int y, final VPanel panel) {
		sprite.displayAt(x, y, panel);
	}

	@Override
	public void takeTurn(final @NonNull ActionQueue actionQueue) {

	}

	@Override
	public String getDescription() {
		final var color = sprite.getForegroundColor();

		return String.format("""
    			<html>
    				<head>
    					<style type="text/css">
    						i {
    							color: rgb(%d, %d, %d);
    						}
    					</style>
    				</head>
    				<body>
						<p>A <i>Player</i>.</p>
					</body>
				</html>
				""", color.getRed(), color.getGreen(), color.getBlue());
	}
}
